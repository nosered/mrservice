package br.eti.esabreu.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;

import br.eti.esabreu.mrservice.model.Entrada;
import br.eti.esabreu.mrservice.model.Item;
import br.eti.esabreu.mrservice.service.EntradaService;

import static org.junit.Assert.*;

import java.math.BigDecimal;

@DatabaseSetup(EntradaServiceTest.DATASET)
@DatabaseTearDown(type = DatabaseOperation.DELETE_ALL, value = {EntradaServiceTest.DATASET})
public class EntradaServiceTest extends AbstractServiceTest {
	
	protected static final String DATASET = "/dbtest-entrada.xml";
	
	@Autowired
	private EntradaService entradaService;
	
	@Test
	public void buscarUmTest() {
		//Entrada existente
		Entrada entrada = entradaService.buscar(1);
		assertEquals(true, entrada.getCusto().compareTo(new BigDecimal(200)) == 0 && entrada.getQtd()==10);
		
		//Entrada inexistente
		assertEquals(null, entradaService.buscar(5));
	}
	
	@Test
	public void buscarTudoTest() {
		assertEquals(3, entradaService.buscar().size());
	}
	
	@Test
	public void salvarTest() {
		//Salvando uma nova entrada
		Item item = new Item();
		item.setId(2);
		Entrada entrada = new Entrada();
		entrada.setItem(item);
		entrada.setCusto(new BigDecimal(500));
		entrada.setQtd(5);
		entradaService.salvar(entrada);
		assertEquals(0, entradaService.buscar(4).getCusto().compareTo(new BigDecimal(500)));
		
		//Atualizando entrada existente
		entrada.setCusto(new BigDecimal(600));
		entradaService.salvar(entrada);
		assertEquals(0, entradaService.buscar(4).getCusto().compareTo(new BigDecimal(600)));
	}
	
	@Test
	public void removerTest() {
		entradaService.remover(1);
		assertEquals(null, entradaService.buscar(1));
	}
}