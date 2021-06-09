package com.algaworks.algafood.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.exception.EntityInUseException;
import com.algaworks.algafood.domain.exception.EntityNotFoundPersonalException;
import com.algaworks.algafood.domain.model.State;
import com.algaworks.algafood.domain.repository.StateRepository;

@Service
public class StateService {

	@Autowired
	private StateRepository repository;

	public State get(Long id) {
		State state = repository.findById(id).get();

		if (state == null) {
			throw new EntityNotFoundPersonalException(String.format("State [ %d ] not found", id));
		}
		return state;
	}

	public List<State> getAll() {
		return repository.findAll();
	}

	public void delete(Long id) {
		try {
			State state = get(id);
			repository.delete(state);
		} catch (DataIntegrityViolationException ex) {
			throw new EntityInUseException(
					String.format("The State [ %d ] can't be deleted because it is used in a City", id));
		}
	}

	public State save(State state) {
		state = repository.save(state);
		return state;
	}
}