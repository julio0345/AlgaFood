package com.algaworks.algafood.api.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.exception.EntityNotFoundPersonalException;
import com.algaworks.algafood.domain.model.City;
import com.algaworks.algafood.domain.service.CityService;

@RestController
@RequestMapping("/cities")
public class CityController {

	@Autowired
	private CityService service;

	@GetMapping
	public List<City> getAll() {
		return service.getAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<City> get(@PathVariable Long id) {
		try {
			City city = service.get(id);
			return ResponseEntity.ok(city);
		} catch (EntityNotFoundPersonalException ex) {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	public ResponseEntity<?> add(@RequestBody City city) {
		try {
			city = service.save(city);
			return ResponseEntity.status(HttpStatus.OK).body(city);
		} catch (EntityNotFoundPersonalException ex) {
			return ResponseEntity.badRequest().body(ex.getMessage());
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<City> update(@PathVariable Long id, @RequestBody City city) {
		try {
			City current = service.get(id);
			BeanUtils.copyProperties(city, current, "id");
			current = service.save(current);
			return ResponseEntity.status(HttpStatus.OK).body(current);
		} catch (EntityNotFoundPersonalException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		try {
			City current = service.get(id);
			service.delete(id);
			return ResponseEntity.noContent().build();
		} catch (EntityNotFoundPersonalException ex) {
			return ResponseEntity.notFound().build();
		}
	}
}