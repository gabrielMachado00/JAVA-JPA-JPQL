package br.com.fiap.dao;

import java.util.List;
import br.com.fiap.entity.Reserva;

public interface ReservaDAO extends DAO<Reserva,Integer>{

	List<Reserva> listar();
	
	List<Reserva> buscarPorNomeCliente(String nome);
	
}
