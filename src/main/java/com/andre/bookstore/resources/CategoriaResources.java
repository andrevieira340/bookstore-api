package com.andre.bookstore.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andre.bookstore.domain.Categoria;
import com.andre.bookstore.dtos.CategoriaDTO;
import com.andre.bookstore.service.CategoriaService;

@RestController
@RequestMapping(value = "/categoria")
public class CategoriaResources {

	@Autowired private CategoriaService categoriaService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Integer id){
		Categoria categoria = categoriaService.findById(id);
		return ResponseEntity.ok().body(categoria);
	}
	@GetMapping
	public ResponseEntity<List<CategoriaDTO>> findAll(){
		List<Categoria> list = categoriaService.findAll();
		List<CategoriaDTO> listdto = list.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
	    return ResponseEntity.ok().body(listdto);
	}
}
