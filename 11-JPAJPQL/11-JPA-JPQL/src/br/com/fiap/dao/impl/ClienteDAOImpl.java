package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.entity.Cliente;

public class ClienteDAOImpl extends DAOImpl<Cliente,Integer> implements ClienteDAO{

	public ClienteDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Cliente> listar() {
		TypedQuery<Cliente> query =
			em.createQuery("from Cliente",Cliente.class);
		return query.getResultList();
	}

	@Override
	public List<Cliente> listarPorEstado(String estado) {
		TypedQuery<Cliente> query = em.createQuery(
			"from Cliente c where c.endereco.cidade.uf = :D",Cliente.class);
		query.setParameter("D", estado);
		return query.getResultList();
	}

	@Override
	public List<Cliente> listarPorDiasReserva(int dias) {
		TypedQuery<Cliente> query = em.createQuery(
			"select r.cliente from Reserva r where r.numeroDias = :P",
			Cliente.class);
		query.setParameter("P", dias);
		return query.getResultList();
	}

	@Override
	public List<Object[]> listarNomeCPF() {
		Query query = em.createQuery(
			"select c.nome, c.cpf from Cliente c");
		query.setMaxResults(10);
		return query.getResultList();
	}

	@Override
	public Long contarTotal() {
		TypedQuery<Long> query = em.createQuery(
			"select count(c) from Cliente c",Long.class);
		return query.getSingleResult();
	}

}





