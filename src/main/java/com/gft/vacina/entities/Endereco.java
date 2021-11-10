package com.gft.vacina.entities;

import javax.persistence.Embeddable;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Embeddable
public class Endereco {

	@Pattern(regexp="\\d{5}-\\d{3}")
	@NotEmpty(message = "O CEP não deve ficar em branco")
	private String cep;
	
	@NotEmpty(message = "A rua não deve ficar em branco")
	private String rua;
	
	@Min(1)
	@Max(9999)
	private int numero;
	
	@NotNull
	private String complemento;
	
	@NotEmpty(message = "O municipio não deve ficar em branco")
	private String municipio;
	
	@NotEmpty(message = "O estado não deve ficar em branco")
	private String estado;

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	
}
