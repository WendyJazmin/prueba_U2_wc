package com.example.demo.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.modelo.CitaMedica;
import com.example.demo.modelo.CitaMedicaDTO;
import com.example.demo.modelo.Paciente;

public interface ICitaMedicaRepository {
	
	public void ingresar(CitaMedica cita);
	
	public CitaMedica buscar(Integer id);
	
	public void actualizar(CitaMedica cita);
	
	public List<CitaMedica> buscarTodos();

	public CitaMedica buscarPorNumero(String numero);
	
	public List<CitaMedicaDTO> buscarPorFechaCosto(LocalDateTime fecha, BigDecimal costo);
}
