package com.example.demo.repository;

import java.util.List;

import com.example.demo.modelo.Doctor;
import com.example.demo.modelo.Paciente;

public interface IDoctorRepository {

	//CRUD
	public void insertar(Doctor doctor);
	
	public Doctor buscar(Integer id);
	
	public void actualizar(Doctor doctor);
	
	public void eliminar(Integer id);
	
	//
	public Doctor buscaPorDoctor(String cedula);
	
	public List<Doctor> buscarTodos();
}
