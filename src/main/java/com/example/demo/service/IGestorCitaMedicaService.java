package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface IGestorCitaMedicaService {

	public void insertar(String turno, LocalDateTime fechaCita, BigDecimal costoCita, String lugarCita,
	String cedulaDoctor, String cedulaPaciente);
	
	public void actualizar(String numeroCita, String diagnostico, String receta, LocalDateTime fehaControl);

	public void reporteCitas(LocalDateTime fecha, BigDecimal Costo);

}
