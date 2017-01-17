package br.eti.esabreu.mrservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.eti.esabreu.mrservice.model.Saida;
import br.eti.esabreu.mrservice.repository.SaidaRepository;
import br.eti.esabreu.mrservice.service.SaidaService;

@Service
public class SaidaServiceImpl implements SaidaService {

	@Autowired
	private SaidaRepository saidaRepository;
	
	@Override
	public void salvar(Saida saida) {
		saidaRepository.save(saida);
	}

	@Override
	public void remover(Integer idSaida) {
		saidaRepository.delete(idSaida);
	}

	@Override
	public Saida buscar(Integer idSaida) {
		return saidaRepository.findOne(idSaida);
	}

	@Override
	public List<Saida> buscar() {
		return saidaRepository.findAll();
	}

}
