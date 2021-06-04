package com.algaworks.algafood.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.exception.EntityNotFoundPersonalException;
import com.algaworks.algafood.domain.model.State;
import com.algaworks.algafood.domain.repository.StateRepository;

@Service
public class StateService {

	@Autowired
	private StateRepository repository;
	
	public State get(Long id) { 
		State state = repository.get(id);
		
		if(state == null) {
			throw new EntityNotFoundPersonalException(String.format("State [ %d ] not found", id));
		}
		return state;
	}
	
	public List<State> getAll(){
		return repository.getAll();
	}
	
	public void delete(Long id) {
		State state = get(id);
		repository.delete(state);
	}
	
	public State save(State state) { 
		state = repository.save(state);
		return state;
	}
}