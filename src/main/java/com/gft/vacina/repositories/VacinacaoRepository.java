package com.gft.vacina.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gft.vacina.entities.Vacinacao;

@Repository
public interface VacinacaoRepository extends JpaRepository<Vacinacao, Long>{

	List<Vacinacao> findByPessoa_vacinado(int vacinado);
}
