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

import com.example.demo.dto.LoginC;
import com.example.demo.model.Usuario;
import com.example.demo.service.UsuarioService;

@RestController
@RequestMapping("/usuario/")
public class UsuarioREST {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping
	private ResponseEntity<List<Usuario>> getAllUsuario() {
		return ResponseEntity.ok(usuarioService.findAll());
	}

	@PostMapping
	private ResponseEntity<Usuario> saveUsuario(@RequestBody Usuario usuario) {
		try {
			Usuario guardado = usuarioService.save(usuario);
			return ResponseEntity.created(new URI("/usuario/" + guardado.getId_usu())).body(guardado);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@DeleteMapping(value = "deleted/{id}")
	private ResponseEntity<Boolean> deletedUsuario(@PathVariable("id") String id) {
		try {
			usuarioService.deleteById(id);
			return ResponseEntity.ok(!(usuarioService.findById(id) != null));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@PutMapping(value = "update/{id}")
	private ResponseEntity<Usuario> updateusuario(@PathVariable("id") String id_usuario, @RequestBody Usuario usuario) {
		try {
			Optional<Usuario> existenteant = usuarioService.findById(id_usuario);

			if (!existenteant.isPresent()) {
				return ResponseEntity.notFound().build();
			}

			Usuario existente = existenteant.get();
			existente.setNombre(usuario.getNombre());
			existente.setPassword(usuario.getPassword());
			existente.setCorreo(usuario.getCorreo());
			existente.setApellido(usuario.getApellido());
			existente.setCargo(usuario.getCargo());
			existente.setFoto_url(usuario.getFoto_url());
			existente.setNom_empresa(usuario.getNom_empresa());
			existente.setTelefono(usuario.getTelefono());
			Usuario actualizado = usuarioService.save(existente);
			return ResponseEntity.ok(actualizado);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@PostMapping("login/")
	private ResponseEntity<?> login(@RequestBody LoginC request){
		Optional<Usuario> usuarioOpt =
                usuarioService.findByCorreo(request.getCorreo());

        if (!usuarioOpt.isPresent()) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("Correo no registrado");
        }

        Usuario usuario = usuarioOpt.get();

        if (!usuario.getPassword().equals(request.getPassword())) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("Contraseña incorrecta");
        }

        return ResponseEntity.ok(usuario);	
	}

}
