package com.api.crud.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Barcos")
public class BarcosModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long barco_id;
	
	private Long socio_id;
	private String numero_matricula;
	private String nombre_barco;
	private int numero_amarre;
	private double cuota_amarre;
	
	
	public Long getBarco_id() {
		return barco_id;
	}
	public void setBarco_id(Long barco_id) {
		this.barco_id = barco_id;
	}
	public Long getSocio_id() {
		return socio_id;
	}
	public void setSocio_id(Long socio_id) {
		this.socio_id = socio_id;
	}
	public String getNumero_matricula() {
		return numero_matricula;
	}
	public void setNumero_matricula(String numero_matricula) {
		this.numero_matricula = numero_matricula;
	}
	public String getNombre_barco() {
		return nombre_barco;
	}
	public void setNombre_barco(String nombre_barco) {
		this.nombre_barco = nombre_barco;
	}
	public int getNumero_amarre() {
		return numero_amarre;
	}
	public void setNumero_amarre(int numero_amarre) {
		this.numero_amarre = numero_amarre;
	}
	public double getCuota_amarre() {
		return cuota_amarre;
	}
	public void setCuota_amarre(double cuota_amarre) {
		this.cuota_amarre = cuota_amarre;
	}
	
	
}
