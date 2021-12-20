package com.andre.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andre.bookstore.domain.Categoria;
import com.andre.bookstore.repository.CategoriaRepository;
import com.andre.bookstore.service.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
    
	@Autowired private CategoriaRepository repository;
	
	public Categoria findById(Integer id) {
		Optional<Categoria> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"objeto não encontrado" + id + " Tipo: " + Categoria.class.getName()));
	}
	
	public List<Categoria> findAll(){
		return repository.findAll();
	}
}
