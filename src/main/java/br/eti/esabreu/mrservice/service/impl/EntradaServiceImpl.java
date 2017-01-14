package br.eti.esabreu.mrservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.eti.esabreu.mrservice.model.Entrada;
import br.eti.esabreu.mrservice.repository.EntradaRepository;
import br.eti.esabreu.mrservice.service.EntradaService;

@Service
public class EntradaServiceImpl implements EntradaService {

	@Autowired
	private EntradaRepository entradaRepository;
	
	@Override
	public void salvar(Entrada entrada) {
		entradaRepository.save(entrada);
	}

	@Override
	public void remover(Integer idEntrada) {
		entradaRepository.delete(idEntrada);
	}

	@Override
	public Entrada buscar(Integer idEntrada) {
		return entradaRepository.findOne(idEntrada);
	}

	@Override
	public List<Entrada> buscar() {
		return entradaRepository.findAll();
	}

}
