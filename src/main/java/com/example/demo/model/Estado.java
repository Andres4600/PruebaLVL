package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "estado")
public class Estado {
	@Id
	@Column(length = 5)
	private String id_estado;
	
	private String nom_estado;
	
	

	public Estado() {
		super();
	}

	public Estado(String nom_estado) {
		super();
		this.nom_estado = nom_estado;
	}

	public String getId_estado() {
		return id_estado;
	}

	public void setId_estado(String id_estado) {
		this.id_estado = id_estado;
	}

	public String getNom_estado() {
		return nom_estado;
	}

	public void setNom_estado(String nom_estado) {
		this.nom_estado = nom_estado;
	}
	
}
