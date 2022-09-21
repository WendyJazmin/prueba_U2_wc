package com.example.demo.service;

import java.util.List;

import com.example.demo.modelo.CitaMedica;

public interface ICitaMedicaService {

	public void insertar (CitaMedica cita);
	
	public List<CitaMedica> buscarTodos();

	public CitaMedica buscar(Integer id);
	
	public CitaMedica buscarPorNumero(String numero);
}
