package com.example.demo.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "proyecto")
public class Proyecto {
	
	@Id
	@Column(length = 5)
	private String id_proyecto;
	
	private String cod_proyecto;
	
	private String nom_proyecto;
	
	private String descripcion;
	
	private Date fecha_inicio;
	
	private Date fecha_fin;
	
	@ManyToOne
	@JoinColumn(name = "id_estado")
	private Estado estado;
	
	@ManyToOne
	@JoinColumn(name = "id_icono")
	private Icono icono;
	
	@ManyToOne
	@JoinColumn(name = "id_categoria")
	private Categoria categoria;
	

	public Proyecto() {
		super();
	}

	public Proyecto(String cod_proyecto, String nom_proyecto, String descripcion, Date fecha_inicio, Date fecha_fin,
			Estado estado, Icono icono, Categoria categoria) {
		super();
		this.cod_proyecto = cod_proyecto;
		this.nom_proyecto = nom_proyecto;
		this.descripcion = descripcion;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.estado = estado;
		this.icono = icono;
		this.categoria = categoria;
	}

	public String getId_proyecto() {
		return id_proyecto;
	}

	public void setId_proyecto(String id_proyecto) {
		this.id_proyecto = id_proyecto;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Icono getIcono() {
		return icono;
	}

	public void setIcono(Icono icono) {
		this.icono = icono;
	}

	public String getCod_proyecto() {
		return cod_proyecto;
	}

	public void setCod_proyecto(String cod_proyecto) {
		this.cod_proyecto = cod_proyecto;
	}

	public String getNom_proyecto() {
		return nom_proyecto;
	}

	public void setNom_proyecto(String nom_proyecto) {
		this.nom_proyecto = nom_proyecto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public Date getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}
	
	

}
