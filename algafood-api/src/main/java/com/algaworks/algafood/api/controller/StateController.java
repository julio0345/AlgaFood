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
import com.algaworks.algafood.domain.model.State;
import com.algaworks.algafood.domain.service.StateService;

@RestController
@RequestMapping("/states")
public class StateController {

	@Autowired
	private StateService service;
	
	@GetMapping
	public List<State> getAll(){
		return service.getAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<State> get(@PathVariable Long id){
		try {
			State state = service.get(id);			
			return ResponseEntity.ok(state);
		}
		catch (EntityNotFoundPersonalException ex) {
			return ResponseEntity.notFound().build();
		} 
	}
	
	@PostMapping
	public ResponseEntity<State> add(@RequestBody State state){
		state = service.save(state);
		return ResponseEntity.status(HttpStatus.OK).body(state);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<State> update(@PathVariable Long id,  @RequestBody State state){
		try {
			State current = service.get(id);
			BeanUtils.copyProperties(state, current, "id");
			current = service.save(current);
			return ResponseEntity.status(HttpStatus.OK).body(current);
		}
		catch (EntityNotFoundPersonalException e) {
			return ResponseEntity.notFound().build();
		} 
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		try {
			State current = service.get(id);
			service.delete(id);
			return ResponseEntity.noContent().build();
		}
		catch (EntityNotFoundPersonalException ex) {
			return ResponseEntity.notFound().build();
		}
	}
}