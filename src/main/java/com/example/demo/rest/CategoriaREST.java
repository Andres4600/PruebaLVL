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
import com.example.demo.model.Categoria;
import com.example.demo.service.CategoriaService;


@RestController
@RequestMapping("/categoria/")
public class CategoriaREST {

	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping
	private ResponseEntity<List<Categoria>> getAllCategoria(){
		return ResponseEntity.ok(categoriaService.findAll());
	}
	
	@PostMapping
	private ResponseEntity<Categoria> saveCategoria(@RequestBody Categoria categoria){
		try {
			Categoria guardado = categoriaService.save(categoria);
			return ResponseEntity.created(new URI("/categoria/"+guardado.getId_categoria())).body(guardado);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@DeleteMapping(value = "deleted/{id}")
	private ResponseEntity<Boolean> deletedCategeria (@PathVariable("id") String id){
		try {
			categoriaService.deleteById(id);
			return ResponseEntity.ok(!(categoriaService.findById(id)!=null));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@PutMapping(value = "update/{id}")
	private ResponseEntity<Categoria> updateCategoria(@PathVariable("id") String id_categoria, @RequestBody Categoria categoria) {
	    try {
	    	Optional<Categoria> existenteant = categoriaService.findById(id_categoria);

	    	if (!existenteant.isPresent()) {
	    	    return ResponseEntity.notFound().build();
	    	}
	    	
	        Categoria existente = existenteant.get();
	        existente.setNom_categoria(categoria.getNom_categoria());

	        Categoria actualizado = categoriaService.save(existente);
	        return ResponseEntity.ok(actualizado);

	    } catch (Exception e) {
	    	return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	    }
	}

	
}
