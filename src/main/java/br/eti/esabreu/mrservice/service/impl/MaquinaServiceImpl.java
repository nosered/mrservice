package br.eti.esabreu.mrservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.eti.esabreu.mrservice.model.Maquina;
import br.eti.esabreu.mrservice.repository.MaquinaRepository;
import br.eti.esabreu.mrservice.service.MaquinaService;

@Service
public class MaquinaServiceImpl implements MaquinaService{
	
	@Autowired
	private MaquinaRepository maquinaRepository;
	
	@Override
	public void salvar(Maquina maquina){
		maquinaRepository.save(maquina);
	}
	public void remover(Integer idMaquina){
		maquinaRepository.delete(idMaquina);
	}
	public Maquina buscar(Integer idMaquina){
		return maquinaRepository.findOne(idMaquina);
	}
	public List<Maquina> buscar(){
		return maquinaRepository.findAll();
	}
}
