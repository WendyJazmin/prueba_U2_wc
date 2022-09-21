package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Doctor;
import com.example.demo.modelo.Paciente;

@Repository
@Transactional
public class DoctorRepositoryImpl implements IDoctorRepository{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	//@Transactional(value = TxType.MANDATORY)
	public void insertar(Doctor doctor) {
		// TODO Auto-generated method stub
		this.entityManager.persist(doctor);
	}

	@Override
	//@Transactional(value = TxType.NOT_SUPPORTED)
	public Doctor buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Doctor.class, id);
	}

	@Override
	//@Transactional(value = TxType.MANDATORY)
	public void actualizar(Doctor doctor) {
		// TODO Auto-generated method stub
		this.entityManager.merge(doctor);
	}

	@Override
	//@Transactional(value = TxType.MANDATORY)
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Doctor doctor1 = this.buscar(id);
		this.entityManager.remove(doctor1);
	}

	@Override
	//@Transactional(value = TxType.NOT_SUPPORTED)
	public Doctor buscaPorDoctor(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Doctor> myQuery = this.entityManager.createQuery("SELECT d FROM Doctor d WHERE d.cedula =: datoCedula",Doctor.class);
		myQuery.setParameter("datoCedula", cedula);
		return myQuery.getSingleResult();
		
	}

	@Override
	public List<Doctor> buscarTodos() {
		// TODO Auto-generated method stub
		TypedQuery<Doctor> myQuery = this.entityManager.createQuery("select d from Doctor d", Doctor.class);
		
		return myQuery.getResultList();
	}

}
