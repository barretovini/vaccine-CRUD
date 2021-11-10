package com.gft.vacina.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.vacina.entities.Pessoa;
import com.gft.vacina.repositories.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Pessoa salvarPessoa(Pessoa pessoa) {
		
		return pessoaRepository.save(pessoa);
		
	}
	
	public List<Pessoa> listarPessoa(){
		
		return pessoaRepository.findAll();
		
	}
	
	public Pessoa obterPessoa(Long id) throws Exception {
		
		Optional<Pessoa> pessoa = pessoaRepository.findById(id);
		
		if(pessoa.isEmpty()) {
			throw new Exception("Pessoa não encontrada.");
		}
		
		return pessoa.get();
		
	}

	public void excluirPessoa(Long id) {
		pessoaRepository.deleteById(id);
	}

}
