package com.algaworks.algafood.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.model.Kitchen;
import com.algaworks.algafood.domain.repository.KitchenRepository;

@RestController
@RequestMapping("/testes")
public class TesteController {

	@Autowired
	private KitchenRepository repository;
	
//	@GetMapping
//	public List<Kitchen> findByName(@RequestParam String name){
//		return repository.findByName(name);
//	}
	
}
