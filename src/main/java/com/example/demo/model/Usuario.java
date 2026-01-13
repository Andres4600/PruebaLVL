package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {
	
	@Id
	@Column(length = 5)
	private String id_usu;
	
	private String nombre;
	
	private String apellido;
	
	private String nom_empresa;
	
	private String cargo;
	
	private String telefono;
	
	private String foto_url;
	
	private String correo;
	
	private String password;


	public Usuario() {
		super();
	}

	public Usuario(String nombre, String apellido, String nom_empresa, String cargo, String telefono, String foto_url,
			String correo, String password) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.nom_empresa = nom_empresa;
		this.cargo = cargo;
		this.telefono = telefono;
		this.foto_url = foto_url;
		this.correo = correo;
		this.password = password;
	}

	public String getId_usu() {
		return id_usu;
	}

	public void setId_usu(String id_usu) {
		this.id_usu = id_usu;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNom_empresa() {
		return nom_empresa;
	}

	public void setNom_empresa(String nom_empresa) {
		this.nom_empresa = nom_empresa;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getFoto_url() {
		return foto_url;
	}

	public void setFoto_url(String foto_url) {
		this.foto_url = foto_url;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

}
