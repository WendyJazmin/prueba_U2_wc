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

import com.example.demo.modelo.Doctor;
import com.example.demo.service.IDoctorService;

@Controller
@RequestMapping("/doctores")
public class DoctorController {
	@Autowired
	private IDoctorService iDoctorService;

	//para ingresar un doctor
	//insertar - post
	@PostMapping("/insertar")//paso 1 , aqui muestra la lista de doctore, y el boton para ingresar un doctor
	public String insertar(Doctor doctor) {
		this.iDoctorService.insertar(doctor);
		return "redirect:/doctores/buscar";
	}
	
	//
	@GetMapping("/nuevoDoctor")// Paso 2, muestra la vista para ingresar todos los datos del doctor
	public String insertarNuevoDoctor(Doctor doctor) {
		return "vistaInsertarNuevoDoctor";
	}
	//para ingresar un doctor
	
	
	
	//buscar todos los docotores
	//buscar -get
	@GetMapping("/buscar")
	public String buscarDoctores(Model modelo) {
		List<Doctor> lista = this.iDoctorService.buscarTodos();
		modelo.addAttribute("doctores",lista);
		return "vistaListaDoctores";
	}
	
	//buscar solo uno por el id
	@GetMapping("/buscarUno/{idDoctor}")
	public String buscarPersonaPorId(@PathVariable("idDoctor")Integer id,Model modelo) {
		Doctor doctor = this.iDoctorService.buscar(id);
		modelo.addAttribute("doctor",doctor);
		return "vistaActualizarDoctor";
	}
	
	
	//Actualizar
	@PutMapping("/actualizar/{idDoctor}")
		public String actualizarDoctor(@PathVariable("idDoctor")Integer id, Doctor doctor) {
			doctor.setId(id);
			this.iDoctorService.actualizar(doctor);
			return "redirect:/doctores/buscar";
	}
	
	
	@DeleteMapping("/eliminar/{idDoctor}")
	public String eliminarDoctor(@PathVariable("idDoctor")Integer id) {
		this.iDoctorService.eliminar(id);
		return "redirect:/doctores/buscar";
		
	}
}
