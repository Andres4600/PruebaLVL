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

import com.example.demo.model.Estado;
import com.example.demo.service.EstadoService;

@RestController
@RequestMapping("/estado/")
public class EstadoREST {

	@Autowired
	private EstadoService estadoService;
	
	@GetMapping
	private ResponseEntity<List<Estado>> getAllEstado(){
		return ResponseEntity.ok(estadoService.findAll());
	}
	
	@PostMapping
	private ResponseEntity<Estado> saveEstado(@RequestBody Estado estado){
		try {
			Estado guardado = estadoService.save(estado);
			return ResponseEntity.created(new URI("/estado/"+guardado.getId_estado())).body(guardado);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@DeleteMapping(value = "deleted/{id}")
	private ResponseEntity<Boolean> deletedEstado(@PathVariable("id") String id){
		try {
			estadoService.deleteById(id);
			return ResponseEntity.ok(!(estadoService.findById(id)!=null));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@PutMapping(value = "update/{id}")
	private ResponseEntity<Estado> updateEstado(@PathVariable("id") String id_estado, @RequestBody Estado estado){
		try {
			Optional<Estado> existenteant = estadoService.findById(id_estado);
			
			if(!existenteant.isPresent()) {
				return ResponseEntity.notFound().build();
			}
			
			Estado existente = existenteant.get();
			existente.setNom_estado(estado.getNom_estado());
			Estado actualizado = estadoService.save(existente);
			return ResponseEntity.ok(actualizado);
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
}
