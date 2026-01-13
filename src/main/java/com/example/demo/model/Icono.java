package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "icono")
public class Icono {

	@Id
	@Column(length = 5)
	private String id_icono;
	
	private String url_icono;
	
	
	public Icono() {
		super();
	}

	public Icono(String url_icono) {
		super();
		this.url_icono = url_icono;
	}

	public String getId_icono() {
		return id_icono;
	}

	public void setId_icono(String id_icono) {
		this.id_icono = id_icono;
	}

	public String getUrl_icono() {
		return url_icono;
	}

	public void setUrl_icono(String url_icono) {
		this.url_icono = url_icono;
	}
	
}
