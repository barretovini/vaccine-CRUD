package com.gft.vacina.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gft.vacina.entities.Vacina;

@Repository
public interface VacinaRepository extends JpaRepository<Vacina, Long> {

	public List<Vacina> findByLotes_Id(Long id);
	
}
