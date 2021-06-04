package com.algaworks.algafood.api.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.exception.EntityInUseException;
import com.algaworks.algafood.domain.exception.EntityNotFoundPersonalException;
import com.algaworks.algafood.domain.model.Kitchen;
import com.algaworks.algafood.domain.service.KitchenService;

@RestController
@RequestMapping("/kitchens")
public class KitchenController {

	@Autowired
	private KitchenService service;

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public List<Kitchen> getAll() {
		return service.getAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> get(@PathVariable Long id) {
		Kitchen kitchen = service.get(id);
		
		if(kitchen == null) {
			return ResponseEntity.notFound().build();
		}		
		return ResponseEntity.ok(kitchen); 
	}

	@PostMapping
	public ResponseEntity<Kitchen> add(@RequestBody Kitchen kitchen) {
		kitchen = service.save(kitchen);
		return ResponseEntity.status(HttpStatus.CREATED).body(kitchen);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Kitchen> put(@PathVariable Long id, @RequestBody Kitchen kitchen) {
		Kitchen currenty = service.get(id);

		if (currenty != null) {
			BeanUtils.copyProperties(kitchen, currenty, "id");
			currenty = service.save(currenty);
			return ResponseEntity.ok(currenty);
		} else {
			return ResponseEntity.notFound().build();
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