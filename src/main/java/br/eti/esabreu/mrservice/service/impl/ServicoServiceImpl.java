package br.eti.esabreu.mrservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.eti.esabreu.mrservice.model.Servico;
import br.eti.esabreu.mrservice.repository.ServicoRepository;
import br.eti.esabreu.mrservice.service.ServicoService;

@Service
public class ServicoServiceImpl implements ServicoService{
	@Autowired
	private ServicoRepository servicoRepository;
	
	@Override
	public void salvar(Servico servico){
		servicoRepository.save(servico);
	}
	
	@Override
	public void remover(Integer idServico){
		servicoRepository.delete(idServico);
	}
	
	@Override
	public Servico buscar(Integer idServico){
		return servicoRepository.findOne(idServico);
	}
	
	@Override
	public List<Servico> buscar(){
		return servicoRepository.findAll();
	}
}
