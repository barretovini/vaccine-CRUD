package com.gft.vacina.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.vacina.entities.Lote;
import com.gft.vacina.repositories.LoteRepository;
	
@Service
public class LoteService {
		
	@Autowired
	private LoteRepository loteRepository;
	
	public Lote salvarLote(Lote lote) {
		return loteRepository.save(lote);
		
	}
	
	public List<Lote> listarLote(Date validade, Integer quantidadeRestante){
		if(validade != null && quantidadeRestante !=0)
			return findByLote(validade, quantidadeRestante);
			return listarLotesValidos();
	}
	
	public List<Lote> listarTodosLote(){
		return loteRepository.findAll();
	}

	public List<Lote> findByLote(Date validade, Integer quantidadeRestante){
		return loteRepository.findByLote(validade, quantidadeRestante);
	}

	public List<Lote> listarLotesValidos(){
		return loteRepository.findByLote(new Date(), 0);
	}
	
	public Lote obterLote(Long id) throws Exception{
		
		Optional<Lote> lote = loteRepository.findById(id);
		
		if(lote.isEmpty()) {
			throw new Exception("Lote não encontrado");
		}
		
		return lote.get();

	}
	
	public void excluirLote(Long id) {
		
		loteRepository.deleteById(id);
		
	}

}