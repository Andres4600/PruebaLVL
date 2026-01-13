package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name="categoria")
public class Categoria {
	
	@Id
	@Column(length = 5)
	private String id_categoria;
	
	private String nom_categoria;
	

	public Categoria() {
		super();
	}

	public Categoria(String nom_categoria) {
		super();
		this.nom_categoria = nom_categoria;
	}

	public String getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(String id_categoria) {
		this.id_categoria = id_categoria;
	}

	public String getNom_categoria() {
		return nom_categoria;
	}

	public void setNom_categoria(String nom_categoria) {
		this.nom_categoria = nom_categoria;
	}

}
