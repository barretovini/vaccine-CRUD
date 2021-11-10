package com.gft.vacina.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.vacina.entities.Posto;
import com.gft.vacina.repositories.PostoRepository;

@Service
public class PostoService {
	
	@Autowired
	private PostoRepository postoRepository;
	
	public Posto salvarPosto(Posto posto) {
		
		return postoRepository.save(posto);
		
	}
	
	public List<Posto> listarPosto(){
		
		return postoRepository.findAll();
		
	}
	
	public Posto obterPosto(Long id) throws Exception {
		
		Optional<Posto> posto = postoRepository.findById(id);
		
		if(posto.isEmpty()) {
			throw new Exception("Posto não encontrado.");
		}
		
		return posto.get();
		
	}

	public void excluirPosto(Long id) {
		postoRepository.deleteById(id);
	}

}
