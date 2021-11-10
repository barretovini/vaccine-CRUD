package com.gft.vacina.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gft.vacina.entities.Lote;

@Repository
public interface LoteRepository extends JpaRepository<Lote, Long>{

	
	 @Query("select a from Lote a where a.validade >= :validade and a.quantidadeRestante > :quantidadeRestante")
	    List<Lote> findByLote( @Param("validade") Date validade, @Param ("quantidadeRestante")Integer quantidadeRestante );
}
