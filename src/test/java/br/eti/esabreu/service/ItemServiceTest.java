package br.eti.esabreu.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;

import br.eti.esabreu.mrservice.model.Item;
import br.eti.esabreu.mrservice.service.ItemService;

import static org.junit.Assert.*;

@DatabaseSetup(ItemServiceTest.DATASET)
@DatabaseTearDown(type = DatabaseOperation.DELETE_ALL, value = {ItemServiceTest.DATASET})
public class ItemServiceTest extends AbstractServiceTest {

	protected static final String DATASET = "/dbtest-item.xml";
	
	@Autowired
	private ItemService itemService;
	
	@Test
	public void buscarUmTest() {
		//Item existe
		assertEquals("Item dois", itemService.buscar(2).getNome());
		
		//Item não existe
		assertEquals(null, itemService.buscar(4));
	}
	
	@Test
	public void buscarTudoTest() {
		assertEquals(3, itemService.buscar().size());
	}
	
	@Test
	public void salvarTest() {
		Item item = new Item();
		
		//Salvando um novo item
		item.setNome("Item four");
		itemService.salvar(item);
		assertEquals(item, itemService.buscar(4));
		
		//Atualizando um item existente
		item.setNome("Item quatro");
		itemService.salvar(item);
		assertEquals("Item quatro", itemService.buscar(4).getNome());
	}
	
	@Test
	public void removerTest() {
		itemService.remover(1);
		assertEquals(null, itemService.buscar(1));
	}
}
