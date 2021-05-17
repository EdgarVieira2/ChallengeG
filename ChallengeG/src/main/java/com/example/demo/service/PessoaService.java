package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Pessoa;

public interface PessoaService {

	public List<Pessoa> obterTodos();

	public Pessoa obterPorId(String id) throws Exception;

	public Pessoa criar(Pessoa pessoa);
	
	public void deletar(String id);

	public Pessoa obterPorDocumento(String documento) throws Exception;
}
