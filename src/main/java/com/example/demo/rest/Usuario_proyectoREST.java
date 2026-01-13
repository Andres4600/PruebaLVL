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

import com.example.demo.model.Usuario_proyecto;
import com.example.demo.service.Usuario_proyectoService;

@RestController
@RequestMapping("/usuario_proyecto/")
public class Usuario_proyectoREST {

	@Autowired
	private Usuario_proyectoService usuario_proyectoService;

	@GetMapping
	private ResponseEntity<List<Usuario_proyecto>> getAllUsuario() {
		return ResponseEntity.ok(usuario_proyectoService.findAll());
	}

	@PostMapping
	private ResponseEntity<Usuario_proyecto> saveUsuario_Proyecto(@RequestBody Usuario_proyecto usuario_proyecto) {
		try {
			Usuario_proyecto guardado = usuario_proyectoService.save(usuario_proyecto);
			return ResponseEntity.created(new URI("/usuario_proyecto/" + guardado.getIdUsuarioProyecto()))
					.body(guardado);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@DeleteMapping(value = "deleted/{id}")
	private ResponseEntity<Boolean> deletedUsuario_Proyecto(@PathVariable("id") int id) {
		try {
			usuario_proyectoService.deleteById(id);
			return ResponseEntity.ok(!(usuario_proyectoService.findById(id) != null));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@PutMapping(value = "update/{id}")
	private ResponseEntity<Usuario_proyecto> updateUsuario_Proyecto(@PathVariable("id") int id,
			@RequestBody Usuario_proyecto usuario_proyecto) {
		try {
			Optional<Usuario_proyecto> existenteant = usuario_proyectoService.findById(id);
			
			if (!existenteant.isPresent()) {
				return ResponseEntity.notFound().build();
			}
			
			Usuario_proyecto existente = existenteant.get();
			existente.setProyecto(usuario_proyecto.getProyecto());
			existente.setUsuario(usuario_proyecto.getUsuario());
			Usuario_proyecto actualizado = usuario_proyectoService.save(existente);
			return ResponseEntity.ok(actualizado);
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

}
