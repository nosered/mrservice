package br.eti.esabreu.mrservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.eti.esabreu.mrservice.model.Tecnico;
import br.eti.esabreu.mrservice.repository.TecnicoRepository;
import br.eti.esabreu.mrservice.service.TecnicoService;

@Service
public class TecnicoServiceImpl implements TecnicoService{
	
	@Autowired
	private TecnicoRepository tecnicoRepository;

	@Override
	public void salvar(Tecnico tecnico) {
		tecnicoRepository.save(tecnico);
	}
	
	@Override
	public void remover(Integer idCliente) {
		tecnicoRepository.delete(idCliente);
	}
	
	@Override
	public Tecnico buscar(Integer idTecnico) {
		return tecnicoRepository.findOne(idTecnico);
	}

	@Override
	public List<Tecnico> buscar() {
		return tecnicoRepository.findAll();
	}
}
