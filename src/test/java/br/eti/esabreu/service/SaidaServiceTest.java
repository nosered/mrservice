package br.eti.esabreu.service;

import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;

import br.eti.esabreu.mrservice.model.Item;
import br.eti.esabreu.mrservice.model.Saida;
import br.eti.esabreu.mrservice.service.SaidaService;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

@DatabaseSetup(SaidaServiceTest.DATASET)
@DatabaseTearDown(type = DatabaseOperation.DELETE_ALL, value = {SaidaServiceTest.DATASET})
public class SaidaServiceTest extends AbstractServiceTest {
	
	protected static final String DATASET = "/dbtest-saida.xml";
	
	@Autowired
	private SaidaService saidaService;
	
	@Test
	public void buscarUmTest() {
		//Entrada existente
		Saida saida = saidaService.buscar(1);
		assertEquals(true, saida.getCusto()==200 && saida.getQtd()==10);
		
		//Entrada inexistente
		assertEquals(null, saidaService.buscar(5));
	}
	
	@Test
	public void buscarTudoTest() {
		assertEquals(3, saidaService.buscar().size());
	}
	
	@Test
	public void salvarTest() {
		//Salvando uma nova saida
		Item item = new Item();
		item.setId(2);
		Saida saida = new Saida();
		saida.setItem(item);
		saida.setCusto(500.0);
		saida.setQtd(5);
		saidaService.salvar(saida);
		assertEquals(true, saidaService.buscar(4).getCusto() == 500.0);
		
		//Atualizando saida existente
		saida.setCusto(600.0);
		saidaService.salvar(saida);
		assertEquals(true, saidaService.buscar(4).getCusto() == 600.0);
	}
	
	@Test
	public void removerTest() {
		saidaService.remover(1);
		assertEquals(null, saidaService.buscar(1));
	}

}
