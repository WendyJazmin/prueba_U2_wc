package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Doctor;
import com.example.demo.repository.IDoctorRepository;

@Service
public class DoctorServiceImpl implements IDoctorService {

	@Autowired
	private IDoctorRepository iDoctorRepository;
	
	@Override
	public void insertar(Doctor doctor) {
		// TODO Auto-generated method stub
		this.iDoctorRepository.insertar(doctor);
	}

	@Override
	public Doctor buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.iDoctorRepository.buscar(id);
	}

	@Override
	public void actualizar(Doctor doctor) {
		// TODO Auto-generated method stub
		this.iDoctorRepository.actualizar(doctor);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.iDoctorRepository.eliminar(id);
	}

	@Override
	public List<Doctor> buscarTodos() {
		// TODO Auto-generated method stub
		return this.iDoctorRepository.buscarTodos();
	}

}
