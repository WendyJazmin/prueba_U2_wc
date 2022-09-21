package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.CitaMedica;
import com.example.demo.repository.ICitaMedicaRepository;
import com.example.demo.repository.IDoctorRepository;

@Service
public class CitaMedicaServiceImpl implements ICitaMedicaService{

	@Autowired
	private ICitaMedicaRepository iCitaRepository;
	
	@Override
	public void insertar(CitaMedica cita) {
		// TODO Auto-generated method stub
		this.iCitaRepository.ingresar(cita);
	}

	@Override
	public List<CitaMedica> buscarTodos() {
		// TODO Auto-generated method stub
		return this.iCitaRepository.buscarTodos();
	}

	@Override
	public CitaMedica buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.iCitaRepository.buscar(id);
	}

	@Override
	public CitaMedica buscarPorNumero(String numero) {
		// TODO Auto-generated method stub
		return this.iCitaRepository.buscarPorNumero(numero);
	}

}
