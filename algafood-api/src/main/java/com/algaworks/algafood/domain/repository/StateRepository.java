package com.algaworks.algafood.domain.repository;

import java.util.List;

import com.algaworks.algafood.domain.model.State;

public interface StateRepository {

	List<State> getAll();
	
	State get(Long id);
	
	State save(State state);
	
	void delete	(Long id);
	
	void delete(State state);
}