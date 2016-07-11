package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Cliente;

public interface ClienteDAO extends DAO<Cliente,Integer>{

	List<Cliente> listar();
	
	List<Cliente> listarPorEstado(String estado);
	
	List<Cliente> listarPorDiasReserva(int dias);
	
	List<Object[]> listarNomeCPF();
	
	Long contarTotal();
	
}
