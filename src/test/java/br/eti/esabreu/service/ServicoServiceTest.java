package br.eti.esabreu.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;

import br.eti.esabreu.mrservice.model.Servico;
import br.eti.esabreu.mrservice.service.ServicoService;

@DatabaseSetup(ServicoServiceTest.DATASET)
@DatabaseTearDown(type = DatabaseOperation.DELETE_ALL, value = {ServicoServiceTest.DATASET})
public class ServicoServiceTest extends AbstractServiceTest{
	
	protected static final String DATASET = "/dbtest-servico.xml";
	
	@Autowired
	private ServicoService servicoService;
	
	@Test
	public void testBuscarTudo() {
		List<Servico> servicos = servicoService.buscar();
		assertEquals(3, servicos.size());
	}
	
	
	@Test
	public void testBuscarUm() {
		Servico servico;
		
		//Servico existente
		servico = servicoService.buscar(1);
		assertEquals("servico um", servico.getDescricao());
		
		//Servico inexistente
		servico = servicoService.buscar(4);
		assertEquals(null, servico);
	}
	
	@Test
	public void testSalvar() {
		Servico servico = new Servico();
		
		//Salvando um novo servico
		servico.setDescricao("servico quatro");
		servicoService.salvar(servico);
		assertEquals(servico, servicoService.buscar(4));
		
		//Atualizando servico existente
		servico.setDescricao("servico four");
		servicoService.salvar(servico);
		assertEquals(servico.getDescricao(), servicoService.buscar(4).getDescricao());
	}
	
	@Test
	public void testRemover() {
		servicoService.remover(1);
		assertEquals(null, servicoService.buscar(1));
	}
}
