package com.gft.vacina.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Pessoa {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;

	@Column(nullable = false, unique = true)
	@CPF(message = "O CPF inválido")
	private String cpf;

	@NotEmpty(message = "Nome não pode ser vazio")
	private String nome;

	@NotEmpty(message = "Sobrenome não pode ser vazio")
	private String sobrenome;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date nascimento;

	@Embedded
	private Endereco enderecoPessoa;

	private int vacinado;

	private boolean segundaDose;
	
	@ManyToOne
	private Vacina vacina;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;

	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public Endereco getEnderecoPessoa() {
		return enderecoPessoa;
	}

	public void setEnderecoPessoa(Endereco enderecoPessoa) {
		this.enderecoPessoa = enderecoPessoa;
	}

	public int getVacinado() {
		return vacinado;
	}

	public void setVacinado(int vacinado) {
		this.vacinado = vacinado;
	}

	public boolean isSegundaDose() {
		return segundaDose;
	}

	public void setSegundaDose(boolean segundaDose) {
		this.segundaDose = segundaDose;
	}

	public Vacina getVacina() {
		return vacina;
	}

	public void setVacina(Vacina vacina) {
		this.vacina = vacina;
	}

}