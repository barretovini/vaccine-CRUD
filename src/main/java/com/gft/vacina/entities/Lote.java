package com.gft.vacina.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Lote {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne	
	private Vacina vacina;
	
	@Column(nullable = false, unique = true)
	@Digits(fraction = 0, integer = 6, message = "A identificação do lote deve conter 6 digitos")
	private int identificacao;
	
	@Min(1)
	@Max(9999)
	private int quantidadeRecebida;
	
	@Min(1)
	@Max(9999)
	private int quantidadeRestante;
	
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date recebimento;	
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date validade;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Vacina getVacina() {
		return vacina;
	}

	public void setVacina(Vacina vacina) {
		this.vacina = vacina;
	}

	public int getIdentificacao() {
		return identificacao;
	}

	public void setIdentificacao(int identificacao) {
		this.identificacao = identificacao;
	}

	public int getQuantidadeRecebida() {
		return quantidadeRecebida;
	}

	public void setQuantidadeRecebida(int quantidadeRecebida) {
		this.quantidadeRecebida = quantidadeRecebida;
	}

	public int getQuantidadeRestante() {
		return quantidadeRestante;
	}

	public void setQuantidadeRestante(int quantidadeRestante) {
		this.quantidadeRestante = quantidadeRestante;
	}

	public Date getRecebimento() {
		return recebimento;
	}

	public void setRecebimento(Date recebimento) {
		this.recebimento = recebimento;
	}

	public Date getValidade() {
		return validade;
	}

	public void setValidade(Date validade) {
		this.validade = validade;
	}	
}
