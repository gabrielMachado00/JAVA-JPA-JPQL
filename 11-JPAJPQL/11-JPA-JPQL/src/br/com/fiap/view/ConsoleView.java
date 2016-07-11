package br.com.fiap.view;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.PacoteDAO;
import br.com.fiap.dao.ReservaDAO;
import br.com.fiap.dao.TransporteDAO;
import br.com.fiap.dao.impl.ClienteDAOImpl;
import br.com.fiap.dao.impl.PacoteDAOImpl;
import br.com.fiap.dao.impl.ReservaDAOImpl;
import br.com.fiap.dao.impl.TransporteDAOImpl;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Reserva;
import br.com.fiap.entity.Transporte;
import br.com.fiap.singleton.EMFactorySingleton;

public class ConsoleView {

	public static void main(String[] args) {
		//Instanciar o DAO
		EntityManager em = EMFactorySingleton
					.getInstance().createEntityManager();
		ReservaDAO reservaDao = new ReservaDAOImpl(em);
		//Listar as reservas
		
		List<Reserva> reservas = reservaDao.listar();
		for (Reserva reserva : reservas) {
			System.out.println("DIAS: " + reserva.getNumeroDias());
			System.out.println("NOME: " + 
							reserva.getCliente().getNome());
			System.out.println("*************************");
		}
		
		//Buscar Reserva pelo nome do cliente
		System.out.println("BUSCAR POR NOME CLIENTE");
		reservas = reservaDao.buscarPorNomeCliente("Leandro");
		for (Reserva reserva : reservas) {
			System.out.println("NOME: " +
					reserva.getCliente().getNome());			
		}
		
		//Busca de clientes
		ClienteDAO clienteDao = new ClienteDAOImpl(em);
		List<Cliente> clientes = clienteDao.list();
		System.out.println("LISTA DE CLIENTES");
		for (Cliente cliente : clientes) {
			System.out.println(cliente.getNome());
		}
		
		//Busca de Pacote por Transporte
		PacoteDAO pacoteDao = new PacoteDAOImpl(em);
		TransporteDAO tDao = new TransporteDAOImpl(em);
		
		Transporte transporte = tDao.findById(1);
		List<Pacote> pacotes = 
				pacoteDao.listarPorTransporte(transporte);
		for (Pacote pacote : pacotes) {
			System.out.println(pacote.getDescricao());
		}
		
		//Buscar Cliente por Estado
		System.out.println("BUSCAR POR ESTADO");
		clientes = clienteDao.listarPorEstado("SP");
		for (Cliente cliente : clientes){
			System.out.println(cliente.getNome());
		}
		
		//Buscar Clientes por dias de reserva
		System.out.println("BUSCAR POR DIAS DE RESERVA");
		clientes = clienteDao.listarPorDiasReserva(10);
		for (Cliente cliente : clientes){
			System.out.println(cliente.getNome());
		}
		
		//Listar Cliente recuperando somente o nome e cpf
		System.out.println("LISTAR NOME E CPF");
		List<Object[]> cli = clienteDao.listarNomeCPF();
		for (Object[] objects : cli) {
			System.out.println("Nome: " + objects[0]);
			System.out.println("CPF: " + objects[1]);
		}
		
		//Contar a quantidade de clientes cadastrado
		long qtd = clienteDao.contarTotal();
		System.out.println("TOTAL CLIENTES: " + qtd);
		
		System.exit(0);
	}

}







