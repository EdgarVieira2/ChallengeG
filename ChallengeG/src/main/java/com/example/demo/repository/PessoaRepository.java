package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Pessoa;

@Repository
public interface PessoaRepository extends MongoRepository<Pessoa, String> {

}
