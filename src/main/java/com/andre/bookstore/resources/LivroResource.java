package com.andre.bookstore.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.andre.bookstore.domain.Livro;
import com.andre.bookstore.dtos.LivroDTO;
import com.andre.bookstore.service.LivroService;

@RestController
@RequestMapping(value = "/livros")
public class LivroResource {
	
	 @Autowired private LivroService livroService; 
	
	 @GetMapping(value = "/{id}")
     public ResponseEntity<Livro> findById(@PathVariable Integer id){
    	 Livro obj = livroService.findById(id);
    	 return ResponseEntity.ok().body(obj);
     }
	 
	 @GetMapping
	 public ResponseEntity<List<LivroDTO>> findAll(@RequestParam(value="categoria", defaultValue = "0") Integer id_cat){
		 List<Livro> list = livroService.findAll(id_cat);
		 List<LivroDTO> listDTO = list.stream().map(obj -> new LivroDTO(obj)).collect(Collectors.toList());
		 return ResponseEntity.ok().body(listDTO);
	 }
	
}
