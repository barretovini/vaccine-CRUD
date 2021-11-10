package com.gft.vacina.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gft.vacina.entities.Posto;

@Repository
public interface PostoRepository extends JpaRepository<Posto, Long> {

}
