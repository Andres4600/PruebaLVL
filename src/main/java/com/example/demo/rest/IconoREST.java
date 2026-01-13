package com.example.demo.rest;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Icono;
import com.example.demo.service.IconoService;

@RestController
@RequestMapping("/icono/")
public class IconoREST {

	@Autowired
	private IconoService iconoService;
	
	@GetMapping
	private ResponseEntity<List<Icono>> getAllIcono(){
		return ResponseEntity.ok(iconoService.findAll());
	}
	
	@PostMapping
	private ResponseEntity<Icono> saveIcono(@RequestBody Icono icono){
		try {
			Icono guardado = iconoService.save(icono);
			return ResponseEntity.created(new URI("/icono/"+guardado.getId_icono())).body(guardado);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@DeleteMapping(value= "deleted/{id}")
	private ResponseEntity<Boolean> deletedIcono(@PathVariable("id") String id){
		try {
			iconoService.deleteById(id);
			return ResponseEntity.ok(!(iconoService.findById(id)!=null));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@PutMapping(value="update/{id}")
	private ResponseEntity<Icono> updateIcono(@PathVariable("id") String id_icono, @RequestBody Icono icono){
		try {
			Optional<Icono> existenteant = iconoService.findById(id_icono);
			
			if(!existenteant.isPresent()) {
				return ResponseEntity.notFound().build();
			}
			
			Icono existente = existenteant.get();
			existente.setUrl_icono(icono.getUrl_icono());
			Icono actualizado = iconoService.save(existente);
			return ResponseEntity.ok(actualizado);
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
}
