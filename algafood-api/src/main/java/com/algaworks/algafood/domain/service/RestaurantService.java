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
		Kitchen kitchen = repositoryKitchen.get(idKitchen);
		
		if(kitchen == null) {
			throw new EntityNotFoundPersonalException(String.format("Kitchen [ %d ] not found.", idKitchen));
		}
		
		restaurant.setKitchen(kitchen);
		return repository.save(restaurant);
	}

	public List<Restaurant> getAll() {
		return repository.getAll();
	}
	
	public Restaurant get(Long id){
		return repository.get(id);
	}
	
	public void delete(Long id) {
		try {
			repository.delete(id);
		} catch (EmptyResultDataAccessException ex1) {
			throw new EntityNotFoundPersonalException(
					String.format("This Restaurant [ %d ] not found", id));
		}// catch (DataIntegrityViolationException ex) {
//			throw new EntityInUseException(
//					String.format("This Restaurant [ %d ] can't be deleted because it is used in a restaurant", id));
//		}
	}
}