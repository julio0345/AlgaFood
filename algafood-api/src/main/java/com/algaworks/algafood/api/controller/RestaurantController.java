package com.algaworks.algafood.api.controller;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.exception.EntityInUseException;
import com.algaworks.algafood.domain.exception.EntityNotFoundPersonalException;
import com.algaworks.algafood.domain.model.Restaurant;
import com.algaworks.algafood.domain.service.RestaurantService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

	@Autowired
	private RestaurantService service;

	@GetMapping
	public List<Restaurant> getAll() {
		return service.getAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Restaurant> get(@PathVariable Long id) {
		Restaurant restaurant = service.get(id);

		if (restaurant == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(service.get(id));
		}
	}
	
	@PostMapping
	public ResponseEntity<?> add(@RequestBody Restaurant restaurant) {
		try {
			restaurant = service.save(restaurant);
			return ResponseEntity.status(HttpStatus.CREATED).body(restaurant);
		}
		catch(EntityNotFoundPersonalException ex) {
			return	ResponseEntity.badRequest().body(ex.getMessage());
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Restaurant restaurant) {
		Restaurant current = service.get(id);
		
		if(current != null) {
			try {
				restaurant = service.save(restaurant);
				return ResponseEntity.ok().body(restaurant);
			}
			catch(EntityNotFoundPersonalException ex) {
				return	ResponseEntity.badRequest().body(ex.getMessage());
			}	
		}
		else {
			return	ResponseEntity.notFound().build();
		}
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<?> parcialUpdate(@PathVariable Long id, @RequestBody Map<String, Object> fields){		
		Restaurant restaurantToSave =  service.get(id);
		
		ObjectMapper objectMapper = new ObjectMapper();
		Restaurant restaurant = objectMapper.convertValue(fields, Restaurant.class);
		
		if(restaurantToSave != null) {
			fields.forEach((property, value) -> {
				Field field = ReflectionUtils.findField(Restaurant.class, property);
				field.setAccessible(true);
				Object newValue = ReflectionUtils.getField(field, restaurant);
				ReflectionUtils.setField(field, restaurantToSave, newValue);
			});
			
			return update(id, restaurantToSave);
		}
		else {
			return	ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		try {
			service.delete(id);
			return ResponseEntity.noContent().build();
			
		} catch (EntityInUseException ex) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
			
		} catch (EntityNotFoundPersonalException ex) {
			return ResponseEntity.notFound().build();
		}
	}
}