package com.algaworks.algafood.api.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.model.Kitchen;
import com.algaworks.algafood.domain.model.Restaurant;
import com.algaworks.algafood.domain.repository.KitchenRepository;
import com.algaworks.algafood.domain.repository.RestaurantRepository;
import com.algaworks.algafood.infrastructure.repository.spec.RestaurantFreeDelivery;
import com.algaworks.algafood.infrastructure.repository.spec.RestaurantSimilarName;

@RestController
@RequestMapping("/testes")
public class TesteController {

	@Autowired
	private KitchenRepository repository;
	
	@Autowired
	private RestaurantRepository repositoryRestaurant;
	
	@GetMapping
	public List<Kitchen> findByName(@RequestParam String name, @RequestParam BigDecimal inicial, @RequestParam BigDecimal finalV){
		 
		List<Kitchen> listKitchens = repository.findByName(name);
		 
		 Optional<Kitchen> opKitchen = repository.findById(2L);
		 
		 listKitchens = repository.meuMetodo("Japonesa");
		 
		 listKitchens = repository.getKitchensByNameContaining("a");
		 
		 List<Restaurant> listRestaurants = repositoryRestaurant.buscarTudo("Japonesa", inicial ,finalV);
		 
		 var freeDevilery = new RestaurantFreeDelivery();
		 var similarA = new RestaurantSimilarName("a");
		 
		 listRestaurants = repositoryRestaurant.findAll(freeDevilery.and(similarA));
		 
		 Optional<Restaurant> rest = repositoryRestaurant.getFirst();
		 
		 
		 
		return null;
	}
}