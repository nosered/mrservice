package br.eti.esabreu.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;

import br.eti.esabreu.mrservice.model.Cliente;
import br.eti.esabreu.mrservice.model.Maquina;
import br.eti.esabreu.mrservice.service.MaquinaService;

@DatabaseSetup(MaquinaServiceTest.DATASET)
@DatabaseTearDown(type = DatabaseOperation.DELETE_ALL, value = {MaquinaServiceTest.DATASET})
public class MaquinaServiceTest extends AbstractServiceTest{

	protected static final String DATASET = "/dbtest-maquina.xml";
	@Autowired
	private MaquinaService maquinaService;
	
	@Test
	public void testBuscarTudo() {
		List<Maquina> maquinas = maquinaService.buscar();
		assertEquals(3, maquinas.size());
	}
	
	@Test
	public void testBuscarUm() {
		Maquina maquina;
		
		maquina = maquinaService.buscar(1);
		assertEquals("modelo um", maquina.getModelo());
		
		maquina = maquinaService.buscar(4);
		assertEquals(null, maquina);
	}
	
	@Test
	public void testSalvar() {
		Maquina maquina = new Maquina();
		Cliente cliente = new Cliente();
		
		cliente.setId(1);
		maquina.setCliente(cliente);
		maquina.setModelo("modelo four");
		maquinaService.salvar(maquina);
		assertEquals(maquina, maquinaService.buscar(4));
		
		maquina.setModelo("modelo quatro");
		maquinaService.salvar(maquina);
		assertEquals(maquina.getModelo(), maquinaService.buscar(4).getModelo());
	}
	
	@Test
	public void testRemover() {
		maquinaService.remover(1);
		assertEquals(null, maquinaService.buscar(1));
	}
	
}
