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

import com.example.demo.model.Proyecto;
import com.example.demo.service.ProyectoService;

@RestController
@RequestMapping("/proyecto/")
public class ProyectoREST {

	@Autowired
	private ProyectoService proyectoService;

	@GetMapping
	private ResponseEntity<List<Proyecto>> getAllProyecto() {
		return ResponseEntity.ok(proyectoService.findAll());
	}

	@PostMapping
	private ResponseEntity<Proyecto> saveProyecto(@RequestBody Proyecto proyecto) {
		try {
			Proyecto guardado = proyectoService.save(proyecto);
			return ResponseEntity.created(new URI("/proyecto/" + guardado.getId_proyecto())).body(guardado);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@DeleteMapping(value = "deleted/{id}")
	private ResponseEntity<Boolean> deletedProyecto(@PathVariable("id") String id){
		try {
			proyectoService.deleteById(id);
			return ResponseEntity.ok(!(proyectoService.findById(id)!=null));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@PutMapping(value = "update/{id}")
	private ResponseEntity<Proyecto> updateProyecto(@PathVariable("id") String id_proyecto,
			@RequestBody Proyecto proyecto) {
		try {
			Optional<Proyecto> existenteant = proyectoService.findById(id_proyecto);

			if (!existenteant.isPresent()) {
				return ResponseEntity.notFound().build();
			}

			Proyecto existente = existenteant.get();
			existente.setCod_proyecto(proyecto.getCod_proyecto());
			existente.setNom_proyecto(proyecto.getNom_proyecto());
			existente.setDescripcion(proyecto.getDescripcion());
			existente.setFecha_inicio(proyecto.getFecha_inicio());
			existente.setFecha_fin(proyecto.getFecha_fin());
			existente.setEstado(proyecto.getEstado());
			existente.setIcono(proyecto.getIcono());
			existente.setCategoria(proyecto.getCategoria());
			Proyecto actualizado = proyectoService.save(existente);
			return ResponseEntity.ok(actualizado);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

}
