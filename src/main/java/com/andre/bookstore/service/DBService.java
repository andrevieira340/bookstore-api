package com.andre.bookstore.service;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andre.bookstore.domain.Categoria;
import com.andre.bookstore.domain.Livro;
import com.andre.bookstore.repository.CategoriaRepository;
import com.andre.bookstore.repository.LivroRepository;

@Service
public class DBService {

	@Autowired private CategoriaRepository categoriaRepository;
	@Autowired private LivroRepository livroRepository;
	
	@PostConstruct
	public void instanciaBaseDeDados() {
		Categoria categoria1 = new Categoria(null,"Terror","Stephen King");
		Categoria categoria2 = new Categoria(null,"Comedia", "Adam");
		Livro livro1 = new Livro(null,"Sem saida", "Stephen King", "Onde os fracos nao sobrevivem", categoria1);
	    Livro livro2 = new Livro(null, "Jackass", "Adam", "So Fazem merda", categoria2);
	    
		categoria1.getLivros().addAll(Arrays.asList(livro1));
		categoria2.getLivros().addAll(Arrays.asList(livro2));
		
		this.categoriaRepository.saveAll(Arrays.asList(categoria1,categoria2));
		this.livroRepository.saveAll(Arrays.asList(livro1,livro2));
	}
	
}
