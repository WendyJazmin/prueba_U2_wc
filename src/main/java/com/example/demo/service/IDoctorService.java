package com.example.demo.service;

import java.util.List;

import com.example.demo.modelo.Doctor;

public interface IDoctorService {

	//CRUD
		public void insertar(Doctor doctor);
		
		public Doctor buscar(Integer id);
		
		public void actualizar(Doctor doctor);
		
		public void eliminar(Integer id);
		
		public List<Doctor> buscarTodos();
}
