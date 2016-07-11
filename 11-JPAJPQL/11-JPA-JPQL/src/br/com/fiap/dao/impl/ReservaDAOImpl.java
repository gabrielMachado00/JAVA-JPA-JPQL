package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.ReservaDAO;
import br.com.fiap.entity.Reserva;

public class ReservaDAOImpl extends DAOImpl<Reserva,Integer> implements ReservaDAO {

	public ReservaDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Reserva> listar() {
		//Criar a query
		TypedQuery<Reserva> query = 
			em.createQuery("from Reserva",Reserva.class);
		//Executar a query
		return query.getResultList();
	}

	@Override
	public List<Reserva> buscarPorNomeCliente(String nome) {
		//Criar a query
		TypedQuery<Reserva> query = em.createQuery(
			"from Reserva r where r.cliente.nome = :pipoca",Reserva.class);
		//Passar o parametro
		query.setParameter("pipoca", nome);
		//Executar
		return query.getResultList();
	}

}







