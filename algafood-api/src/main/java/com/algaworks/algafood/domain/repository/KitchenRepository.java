package com.algaworks.algafood.domain.repository;

import java.util.List;

import com.algaworks.algafood.domain.model.Kitchen;

public interface KitchenRepository {
	
	List<Kitchen> getAll();
	
	Kitchen get(Long id);
	
	Kitchen save(Kitchen kitchen);
	
	void delete	(Long id);
	
	void delete(Kitchen kitchen);
}