package com.api.crud.models;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.*;

@Entity
@Table(name = "Socios")
public class SociosModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long socio_id;
	
	private String nombre;
	private String apellido;
	private String direccion;
	private String telefono;
	private String email;
	
	
	public Long getSocio_id() {
		return socio_id;
	}
	public void setSocio_id(Long socio_id) {
		this.socio_id = socio_id;
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
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
