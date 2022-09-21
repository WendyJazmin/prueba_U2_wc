package com.example.demo.repository;

import java.util.List;

import com.example.demo.modelo.Paciente;

public interface IPacienteRepository {

	//CRUD
		public void insertar(Paciente paciente);
		
		public Paciente buscar(Integer id);
		
		public void actualizar(Paciente paciente);
		
		public void eliminar(Integer id);
		
		
		//
		public Paciente buscaPorCedula(String cedula);
		
		public List<Paciente> buscarTodos();
		
}
