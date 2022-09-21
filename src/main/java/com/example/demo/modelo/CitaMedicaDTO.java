package com.example.demo.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CitaMedicaDTO {

	private String numeroCita;
	
	private LocalDateTime fechaCita;
	
	private BigDecimal costo;
	
	private LocalDateTime fechaControl;
	
	
	
	public CitaMedicaDTO() {
		
	}

	public CitaMedicaDTO(String numeroCita, LocalDateTime fechaCita, BigDecimal costo, LocalDateTime fechaControl) {
		
		this.numeroCita = numeroCita;
		this.fechaCita = fechaCita;
		this.costo = costo;
		this.fechaControl = fechaControl;
	}
	

	//get y set
	public String getNumeroCita() {
		return numeroCita;
	}

	public void setNumeroCita(String numeroCita) {
		this.numeroCita = numeroCita;
	}

	public LocalDateTime getFechaCita() {
		return fechaCita;
	}

	public void setFechaCita(LocalDateTime fechaCita) {
		this.fechaCita = fechaCita;
	}

	public BigDecimal getCosto() {
		return costo;
	}

	public void setCosto(BigDecimal costo) {
		this.costo = costo;
	}

	public LocalDateTime getFechaControl() {
		return fechaControl;
	}

	public void setFechaControl(LocalDateTime fechaControl) {
		this.fechaControl = fechaControl;
	}
	
	
	
}
