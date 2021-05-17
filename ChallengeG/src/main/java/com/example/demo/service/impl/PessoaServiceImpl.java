package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.Cep;
import com.example.demo.model.Pessoa;
import com.example.demo.repository.PessoaRepository;
import com.example.demo.service.PessoaService;

@Service
public class PessoaServiceImpl implements PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;

	@Override
	public List<Pessoa> obterTodos() {
		return this.pessoaRepository.findAll();
	}

	@Override
	public Pessoa criar(Pessoa pessoa) {
		RestTemplate restTemplate = new RestTemplate();
		String cepData = pessoa.getCep();
		Pessoa pessoaResult = null;
		try {
			Cep cep = restTemplate.getForObject("http://viacep.com.br/ws/" + cepData + "/json", Cep.class);
			pessoa.setBairro(cep.getBairro());
			pessoa.setLocalidade(cep.getLocalidade());
			pessoa.setUf(cep.getUf());
			pessoaResult = this.pessoaRepository.save(pessoa);
		} catch (Exception e) {
			throw e;
		}

		return pessoaResult;
	}

	@Override
	public Pessoa obterPorId(String id) throws Exception {
		return this.pessoaRepository.findById(id).orElseThrow(() -> new Exception("Não existe."));
	}
	@Override
	public List<Pessoa> obterPorDocumento(String documento) throws Exception  {
		return this.pessoaRepository.findByDocumento(documento).orElseThrow(() -> new Exception("Não existe."));
	}
	

	@Override
	public void deletar(String id) {
		this.pessoaRepository.deleteById(id);
	}
}
