package com.example.demo.service;

import java.util.List;

import com.example.demo.modelo.Paciente;

public interface IPacienteService {

	//CRUD
			public void insertar(Paciente paciente);
			
			public Paciente buscar(Integer id);
			
			public void actualizar(Paciente paciente);
			
			public void eliminar(Integer id);
			
			public List<Paciente> buscarTodos();

}
