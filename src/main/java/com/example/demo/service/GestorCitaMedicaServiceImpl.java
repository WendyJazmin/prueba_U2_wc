package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.CitaMedica;
import com.example.demo.modelo.Doctor;
import com.example.demo.modelo.Paciente;
import com.example.demo.repository.ICitaMedicaRepository;
import com.example.demo.repository.IDoctorRepository;
import com.example.demo.repository.IPacienteRepository;

@Service
public class GestorCitaMedicaServiceImpl implements IGestorCitaMedicaService {

	@Autowired
	private ICitaMedicaService citaMedicaService;
	
	
	@Autowired
	private IDoctorRepository iDoctorRepository;
	
	@Autowired
	private IPacienteRepository iPacienteRepository;

	@Autowired
	private ICitaMedicaRepository iCitaMedicaRepository;
	
	@Override
	public void insertar(String turno, LocalDateTime fechaCita, BigDecimal costoCita, String lugarCita,
			String cedulaDoctor, String cedulaPaciente) {
		// TODO Auto-generated method stub
		Doctor doctor = this.iDoctorRepository.buscaPorDoctor(cedulaDoctor);
		Paciente paciente = this.iPacienteRepository.buscaPorCedula(cedulaPaciente);
		
		CitaMedica cita = new CitaMedica();
		cita.setNumeroTurno(turno);
		cita.setFechaCita(fechaCita);
		cita.setCostoCita(costoCita);
		cita.setLugarCita(lugarCita);
		
		//cita.setDiagnostico("enfermo");
		//cita.setReceta("paracetamol");
		//cita.setFechaControl(LocalDateTime.now());
		cita.setPaciente(paciente);
		cita.setDoctor(doctor);
		
		this.iCitaMedicaRepository.ingresar(cita);
		
		
	}
	
	@Override
	public void actualizar(String numeroCita, String diagnostico, String receta, LocalDateTime fehaControl) {
		// TODO Auto-generated method stub
		CitaMedica cita = this.iCitaMedicaRepository.buscarPorNumero(numeroCita);
		cita.setDiagnostico(diagnostico);
		cita.setReceta(receta);
		cita.setFechaControl(fehaControl);
		
		this.iCitaMedicaRepository.actualizar(cita);
	}

	@Override
	public void reporteCitas(LocalDateTime fecha, BigDecimal Costo) {
		// TODO Auto-generated method stub
		this.iCitaMedicaRepository.buscarPorFechaCosto(fecha, Costo);
	}
	
	
	
}
