package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.modelo.CitaMedica;
import com.example.demo.modelo.Doctor;
import com.example.demo.modelo.Paciente;
import com.example.demo.service.ICitaMedicaService;
import com.example.demo.service.IGestorCitaMedicaService;

@Controller
@RequestMapping("/citasMedicas")
public class CitaMedicaController {

	@Autowired
	private ICitaMedicaService iCitaMedicaService;
	
	@Autowired
	private IGestorCitaMedicaService gestorCitaMedicaService;
	
	
	//buscar las citas medicas
	//get
	@GetMapping("/listaCitasMedicas")
	public String listaCitasMedicas(Model modelo) {
		List<CitaMedica> lista = this.iCitaMedicaService.buscarTodos();
		modelo.addAttribute("citasMedicas",lista);
		return "vistaListaCitasMedicas";
		
	}
	
	//buscar una cita medica por id
	@GetMapping("/buscarUno/{idCitaMedica}")
	public String buscarPorId(@PathVariable("idCitaMedica")Integer id,Model modelo) {
		CitaMedica citaM = this.iCitaMedicaService.buscar(id);
		modelo.addAttribute("cita",citaM);
		return "vistaActualizarCitaMedica";
	}
	
	///////////////////////
	//insertar una cita
	@PostMapping("/insertar")
	public String insertarCitaMedica(CitaMedica cita, Doctor doctor, Paciente paciente
			) {
		this.gestorCitaMedicaService.insertar(cita.getNumeroTurno(), cita.getFechaCita(), cita.getCostoCita(), cita.getLugarCita(), doctor.getCedula(), paciente.getCedula());
		return "redirect:/citasMedicas/listaCitasMedicas";
	}
	
	@GetMapping("/nuevaCitaMedica")
	public String nuevaCitaMedica(CitaMedica cita) {
		return "vistanuevaCitaMedica";
	}
	
	//***************************************************************
	
	//vista donde se pedira que ingrese el numero de turno para que pueda actualizar
	@GetMapping("/actualizarCitaMedica")
	public String buscarPorNumeroCita(CitaMedica cita) {
		return "vistaActualizarCitaMedica";
	}
	
	
	//actualizar cita medica
	@PutMapping("/actualizar/{numeroTurno}")
	public String actualizarPorCedula(@PathVariable("numeroTurno")String numero,CitaMedica cita) {
		cita.setNumeroTurno(numero);
		CitaMedica cita2 = this.iCitaMedicaService.buscarPorNumero(numero);
		
		return "viscta";
	}
}
