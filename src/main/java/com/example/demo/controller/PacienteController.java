package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.modelo.Paciente;
import com.example.demo.service.IPacienteService;

@Controller
@RequestMapping("/pacientes")
public class PacienteController {

	@Autowired
	private IPacienteService IPacienteService;
	
	//buscar todos los paciente
	@GetMapping("/listaPacientes")
	public String buscarPacientes(Model modelo) {
		List<Paciente> lista = this.IPacienteService.buscarTodos();
		modelo.addAttribute("pacientes",lista);
		return "vistaListaPacientes";
	}
	
	//buscar un solo paciente por id
	@GetMapping("/buscarUno/{idPaciente}")
	public String buscarPorId(@PathVariable("idPaciente")Integer id, Model modelo) {
		Paciente paciente = this.IPacienteService.buscar(id);
		modelo.addAttribute(paciente);
		return "vistaActualizarPaciente";
	}
	
	
	//INSERTAR UN PACIENTE
	@PostMapping("/insertar")
	public String insertarPaciente(Paciente paciente) {
		this.IPacienteService.insertar(paciente);
		return "redirect:/pacientes/listaPacientes";//cuando se inserta el paciente se direcciona a la lista de pacientes
		
	}
	
	@GetMapping("/nuevoPaciente")
	public String insertarNuevoPaciente(Paciente paciente) {
		return "vistainsertarNuevoPaciente";
	}
	//
	
	
	//actualizar paciente
	@PutMapping("/actualizar/{idPaciente}")
	public String actualizar(@PathVariable("idPaciente")Integer id,Paciente paciente) {
		paciente.setId(id);
		this.IPacienteService.actualizar(paciente);
		return "redirect:/pacientes/listaPacientes";
	}
	
	//eliminar Paciente
	@DeleteMapping("/eliminar/{idPaciente}")
	public String eliminarPaciente(@PathVariable("idPaciente")Integer id){
		this.IPacienteService.eliminar(id);
		return "redirect:/pacientes/listaPacientes";
	}
}
