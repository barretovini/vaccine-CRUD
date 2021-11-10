package com.gft.vacina.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Vacinacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date aplicacao;

	@JoinColumn(unique=true)
	@ManyToOne
	private Vacina vacina;

	@ManyToOne
	private Lote lote;

	@ManyToOne
	private Posto posto;

	@JoinColumn(unique=true)
	@ManyToOne
	private Pessoa pessoa;
	
	private String vacinadoTexto;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getAplicacao() {
		return aplicacao;
	}

	public void setAplicacao(Date aplicacao) {
		this.aplicacao = aplicacao;
	}

	public Vacina getVacina() {
		return vacina;
	}

	public void setVacina(Vacina vacina) {
		this.vacina = vacina;
	}

	public Lote getLote() {
		return lote;
	}

	public void setLote(Lote lote) {
		this.lote = lote;
	}

	public Posto getPosto() {
		return posto;
	}

	public void setPosto(Posto posto) {
		this.posto = posto;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getVacinadoTexto() {
		if (getPessoa().getVacinado() == 1) {
			setVacinadoTexto("Primeria dose aplicada");
		} else if (getPessoa().getVacinado() == 2) {
			setVacinadoTexto("Imunização completa!");
		} else {
			setVacinadoTexto("Erro");
		}
		return vacinadoTexto;
	}

	public void setVacinadoTexto(String vacinadoTexto) {
		this.vacinadoTexto = vacinadoTexto;
	}


	
	
}