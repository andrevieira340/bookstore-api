package com.andre.bookstore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andre.bookstore.domain.Livro;
import com.andre.bookstore.repository.LivroRepository;
import com.andre.bookstore.service.exceptions.ObjectNotFoundException;

@Service
public class LivroService {

	@Autowired private LivroRepository repository;
	public Livro findById(Integer id) {
		Optional<Livro> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado" + id + "Tipo: " + Livro.class.getName()));
	}
}
