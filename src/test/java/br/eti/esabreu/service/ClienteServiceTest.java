package br.eti.esabreu.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;

import static org.junit.Assert.*;

import br.eti.esabreu.mrservice.model.Cliente;
import br.eti.esabreu.mrservice.service.ClienteService;

@DatabaseSetup(ClienteServiceTest.DATASET)
@DatabaseTearDown(type = DatabaseOperation.DELETE_ALL, value = {ClienteServiceTest.DATASET})
public class ClienteServiceTest extends AbstractServiceTest {
	
	protected static final String DATASET = "/dbtest-cliente.xml";
	
	@Autowired
	private ClienteService clienteService;
	
	@Test
	public void testBuscarTudo() {
		List<Cliente> clientes = clienteService.buscar();
		assertEquals(3, clientes.size());
	}
	
	@Test
	public void testBuscarUm() {
		Cliente cliente;
		
		//Cliente existente
		cliente = clienteService.buscar(1);
		assertEquals("cliente um", cliente.getNome());
		
		//Cliente inexistente
		cliente = clienteService.buscar(4);
		assertEquals(null, cliente);
	}
	
	@Test
	public void testSalvar() {
		Cliente cliente = new Cliente();
		
		//Salvando um novo cliente
		cliente.setNome("cliente four");
		clienteService.salvar(cliente);
		assertEquals(cliente, clienteService.buscar(4));
		
		//Atualizando cliente existente
		cliente.setNome("cliente quatro");
		clienteService.salvar(cliente);
		assertEquals(cliente.getNome(), clienteService.buscar(4).getNome());
	}
	
	@Test
	public void testRemover() {
		clienteService.remover(1);
		assertEquals(null, clienteService.buscar(1));
	}
}
