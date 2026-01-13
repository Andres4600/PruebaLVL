package com.example.demo.model;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="usuario_proyecto")
public class Usuario_proyecto {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@JoinColumn(name = "id_usuario_proyecto")
    private int idUsuarioProyecto;
	
	@ManyToOne
	@JoinColumn(name = "id_usu")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "id_proyecto")
	private Proyecto proyecto;
	
	private Timestamp fecha_creacion;
	

	public Usuario_proyecto() {
		super();
	}

	public Usuario_proyecto(Usuario usuario, Proyecto proyecto, Timestamp fecha_creacion) {
		super();
		this.usuario = usuario;
		this.proyecto = proyecto;
		this.fecha_creacion = fecha_creacion;
	}

	public int getIdUsuarioProyecto() {
		return idUsuarioProyecto;
	}

	public void setIdUsuarioProyecto(int idUsuarioProyecto) {
		this.idUsuarioProyecto = idUsuarioProyecto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	public Timestamp getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(Timestamp fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}
	
}
