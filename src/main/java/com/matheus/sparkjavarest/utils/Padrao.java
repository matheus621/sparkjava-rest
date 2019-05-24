package com.matheus.sparkjavarest.utils;

import com.google.gson.JsonElement;

import lombok.*;

@Getter @Setter
public class Padrao {

	private Status status;
	private String mensagem;
	private JsonElement carro;
	
	public Padrao(Status status) {
		this.status = status;
	}
	
	public Padrao(Status status, String mensagem) {
		this.status = status;
		this.mensagem = mensagem;
	}
	
	public Padrao(Status status, JsonElement carro) {
		this.status = status;
		this.carro = carro;
	}

}
