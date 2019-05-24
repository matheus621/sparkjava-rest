package com.matheus.sparkjavarest.entities;

import java.util.Date;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Carro {
	
	private int id;
	private String nome;
	private String modelo;
	private Date fabricacao;

}
