package br.eti.esabreu.mrservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.eti.esabreu.mrservice.model.OrdemServico;
import br.eti.esabreu.mrservice.repository.OrdemServicoRepository;
import br.eti.esabreu.mrservice.service.OrdemServicoService;

@Service
public class OrdemServicoImpl implements OrdemServicoService{
	
	@Autowired
	private OrdemServicoRepository ordemServicoRepository;

	@Override
	public void salvar(OrdemServico ordemServico) {
		ordemServicoRepository.save(ordemServico);
	}
	
	@Override
	public void remover(Integer idOrdemServico) {
		ordemServicoRepository.delete(idOrdemServico);
	}
	
	@Override
	public OrdemServico buscar(Integer idOrdemServico) {
		return ordemServicoRepository.findOne(idOrdemServico);
	}

	@Override
	public List<OrdemServico> buscar() {
		return ordemServicoRepository.findAll();
	}


}
