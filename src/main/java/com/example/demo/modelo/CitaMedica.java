package com.example.demo.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="cita_medica")
public class CitaMedica {
	
	@Id
	@Column(name ="cime_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cime_id_seq")
	@SequenceGenerator(name="cime_id_seq", sequenceName = "cime_id_seq", allocationSize = 1)
	private Integer id;

	@Column(name ="cime_numero_turno")
	private String numeroTurno;

	@Column(name ="cime_fecha_cita", columnDefinition = "TIMESTAMP")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime fechaCita;
	
	@Column(name ="cime_costo_cita")
	private BigDecimal costoCita;
	
	@Column(name ="cime_lugar_cita")
	private String lugarCita;
	
	@Column(name ="cime_diagnostico")
	private String diagnostico;
	
	@Column(name ="cime_receta")
	private String receta;
	
	@Column(name ="cime_fechaControl", columnDefinition = "TIMESTAMP")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime fechaControl;
	
	@ManyToOne
	@JoinColumn(name = "cime_doct_id")
	private Doctor doctor;
	
	@ManyToOne
	@JoinColumn(name = "cime_paci_id")
	private Paciente paciente;

	@Override
	public String toString() {
		return "CitaMedica [id=" + id + ", numeroTurno=" + numeroTurno + ", fechaCita=" + fechaCita + ", costoCita="
				+ costoCita + ", lugarCita=" + lugarCita + ", diagnostico=" + diagnostico + ", receta=" + receta
				+ ", fechaControl=" + fechaControl + "]";
	}

	
	//get y set
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumeroTurno() {
		return numeroTurno;
	}

	public void setNumeroTurno(String numeroTurno) {
		this.numeroTurno = numeroTurno;
	}

	public LocalDateTime getFechaCita() {
		return fechaCita;
	}

	public void setFechaCita(LocalDateTime fechaCita) {
		this.fechaCita = fechaCita;
	}

	public BigDecimal getCostoCita() {
		return costoCita;
	}

	public void setCostoCita(BigDecimal costoCita) {
		this.costoCita = costoCita;
	}

	public String getLugarCita() {
		return lugarCita;
	}

	public void setLugarCita(String lugarCita) {
		this.lugarCita = lugarCita;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public String getReceta() {
		return receta;
	}

	public void setReceta(String receta) {
		this.receta = receta;
	}

	public LocalDateTime getFechaControl() {
		return fechaControl;
	}

	public void setFechaControl(LocalDateTime fechaControl) {
		this.fechaControl = fechaControl;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	

}
