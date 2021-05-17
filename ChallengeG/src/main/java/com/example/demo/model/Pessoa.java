package com.example.demo.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.Data;

@Data
@Document(collection = "Pessoa")
public class Pessoa {

	@Id
	private String id;
	private String nome;
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING, locale = "pt-BR", timezone = "Brazil/East")
	private Date dataNascimento;
	private String cep;
	private String documento;
	private String bairro;
	private String localidade;
	private String uf;
}
