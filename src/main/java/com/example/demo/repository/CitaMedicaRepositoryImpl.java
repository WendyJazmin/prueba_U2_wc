package com.example.demo.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.CitaMedica;
import com.example.demo.modelo.CitaMedicaDTO;

@Repository
@Transactional
public class CitaMedicaRepositoryImpl implements ICitaMedicaRepository{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	//@Transactional(value = TxType.MANDATORY)
	public void ingresar(CitaMedica cita) {
		// TODO Auto-generated method stub
		this.entityManager.persist(cita);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public CitaMedica buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(CitaMedica.class, id);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void actualizar(CitaMedica cita) {
		// TODO Auto-generated method stub
		this.entityManager.merge(cita);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public CitaMedica buscarPorNumero(String numero) {
		// TODO Auto-generated method stub
		TypedQuery<CitaMedica> myQuery = this.entityManager.createQuery("SELECT c FROM CitaMedica c WHERE c.numeroTurno =: datoNumero",CitaMedica.class);
		myQuery.setParameter("datoNumero", numero);
		return myQuery.getSingleResult();
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<CitaMedicaDTO> buscarPorFechaCosto(LocalDateTime fecha, BigDecimal costo) {
		// TODO Auto-generated method stub
		TypedQuery<CitaMedicaDTO> myQuery = this.entityManager.createQuery(
				"SELECT NEW com.example.demo.modelo.CitaMedicaDTO"
				+ "(c.numeroCita, c.fechaCita, c.costo, c.fechaControl) "
				+ "FROM CitaMedica c WHERE c.fechaCita >: datoFecha AND c.costoCita >:datoCosto", CitaMedicaDTO.class);
		myQuery.setParameter("datoFecha", fecha);
		myQuery.setParameter("datoCosto", costo);
		return myQuery.getResultList();
	}

	@Override
	public List<CitaMedica> buscarTodos() {
		// TODO Auto-generated method stub
		TypedQuery<CitaMedica> myQuery = this.entityManager.createQuery("SELECT c FROM CitaMedica c", CitaMedica.class);
		return myQuery.getResultList();
	}

}
