package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Pessoa;
import com.example.demo.service.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;

	@GetMapping
	public List<Pessoa> obterTodos() {
		return this.pessoaService.obterTodos();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> obterPorId(@PathVariable String id) {
		try {
			Pessoa pessoa = this.pessoaService.obterPorId(id);
			return ResponseEntity.ok(pessoa);
		} catch (Exception e) {
			return new ResponseEntity<>("{\r\n" + "   \"message\":\"Desculpa mas não conseguimos encontrar\",\r\n"
					+ "   \"codigo\":404\r\n" + "}", HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping("documento/{documento}")
	public ResponseEntity<?> obterPorDocumento(@PathVariable String documento) throws Exception{
		try {
			Pessoa pessoa = this.pessoaService.obterPorDocumento(documento);
			return ResponseEntity.ok(pessoa);
		} catch (Exception e) {
			return new ResponseEntity<>("{\r\n" + "   \"message\":\"Desculpa mas não conseguimos encontrar o documento\",\r\n"
					+ "   \"codigo\":404\r\n" + "}", HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public ResponseEntity<?> criar(@RequestBody Pessoa pessoa) {
		Pessoa pessoaResult = null;
		try {
			pessoaResult = this.pessoaService.criar(pessoa);
			return ResponseEntity.ok(pessoaResult);
		} catch (Exception e) {
			return new ResponseEntity<>(
					"{\r\n" + "   \"message\":\"Cep invalido\",\r\n" + "   \"codigo\":400\r\n" + "}",
					HttpStatus.BAD_REQUEST);
		}

	}

	@DeleteMapping
	public void deletar(@PathVariable String id) {
		this.pessoaService.deletar(id);
	}

}
