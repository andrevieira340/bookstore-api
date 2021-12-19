package com.andre.bookstore;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.andre.bookstore.domain.Categoria;
import com.andre.bookstore.domain.Livro;
import com.andre.bookstore.repository.CategoriaRepository;
import com.andre.bookstore.repository.LivroRepository;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner{

	@Autowired private CategoriaRepository categoriaRepository;
	@Autowired private LivroRepository livroRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria categoria1 = new Categoria(null,"Terror","Stephen King");
		Livro livro1 = new Livro(null,"Sem saida", "Stephen King", "Onde os fracos nao sobrevivem", categoria1);
	    
		categoria1.getLivros().addAll(Arrays.asList(livro1));
		
		this.categoriaRepository.saveAll(Arrays.asList(categoria1));
		this.livroRepository.saveAll(Arrays.asList(livro1));
		
	}

}
