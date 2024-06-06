package com.api.crud.models;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.*;

@Entity
@Table(name = "Salidas")
public class SalidasModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long salida_id;
	
	private Long barco_id;
	private Date fecha_salida;
	private Time hora_salida;
	private String destino;
	private Long patron_id;
	
	
	public Long getSalida_id() {
		return salida_id;
	}
	public void setSalida_id(Long salida_id) {
		this.salida_id = salida_id;
	}
	public Long getBarco_id() {
		return barco_id;
	}
	public void setBarco_id(Long barco_id) {
		this.barco_id = barco_id;
	}
	public Date getFecha_salida() {
		return fecha_salida;
	}
	public void setFecha_salida(Date fecha_salida) {
		this.fecha_salida = fecha_salida;
	}
	public Time getHora_salida() {
		return hora_salida;
	}
	public void setHora_salida(Time hora_salida) {
		this.hora_salida = hora_salida;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public long getPatron_id() {
		return patron_id;
	}
	public void setPatron_id(Long patron_id) {
		this.patron_id = patron_id;
	}
	
	
}
