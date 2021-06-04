package com.algaworks.algafood.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.exception.EntityNotFoundPersonalException;
import com.algaworks.algafood.domain.model.Kitchen;
import com.algaworks.algafood.domain.model.Restaurant;
import com.algaworks.algafood.domain.repository.KitchenRepository;
import com.algaworks.algafood.domain.repository.RestaurantRepository;

@Service
public class RestaurantService {

	@Autowired
	private RestaurantRepository repository;
	
	@Autowired
	private KitchenRepository repositoryKitchen;
	
	public Restaurant save(Restaurant restaurant) {		
		Long idKitchen = restaurant.getKitchen().getId();
		Kitchen kitchen = repositoryKitchen.findById(idKitchen)
				.orElseThrow( () -> new EntityNotFoundPersonalException(String.format("Kitchen [ %d ] not found.", idKitchen)));
		
		restaurant.setKitchen(kitchen);
		return repository.save(restaurant);
	}

	public List<Restaurant> getAll() {
		return repository.findAll();
	}
	
	public Restaurant get(Long id){
		return repository.findById(id).orElse(null);
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException ex1) {
			throw new EntityNotFoundPersonalException(
					String.format("This Restaurant [ %d ] not found", id));
		}
	}
}