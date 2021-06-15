package com.algaworks.algafood.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.exception.EntityNotFoundPersonalException;
import com.algaworks.algafood.domain.model.Product;
import com.algaworks.algafood.domain.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired	
	private ProductRepository repository;
	
	public Product get(Long id) {
		return repository.findById(id).orElse(null);
	}
	
	public List<Product> getAll(){
		return repository.findAll();
	}
	
	public void delete(Long id) {
		Optional<Product> product = repository.findById(id);
		
		if(product.isPresent()) {		
			repository.deleteById(id);	
		}
		else {
			throw new EntityNotFoundPersonalException(String.format("Product [ %d ] not found", id));
		}
	}
}