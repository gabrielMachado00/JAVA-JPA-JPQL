package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;

public interface PacoteDAO extends DAO<Pacote,Integer>{

	List<Pacote> listarPorTransporte(Transporte transporte);
	
}
