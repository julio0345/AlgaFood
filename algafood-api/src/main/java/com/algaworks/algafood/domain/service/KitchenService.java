package com.algaworks.algafood.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.exception.EntityInUseException;
import com.algaworks.algafood.domain.exception.EntityNotFoundPersonalException;
import com.algaworks.algafood.domain.model.Kitchen;
import com.algaworks.algafood.domain.repository.KitchenRepository;

@Service
public class KitchenService {

	@Autowired
	private KitchenRepository repository;

	public Kitchen save(Kitchen kitchen) {
		return repository.save(kitchen);
	}

	public List<Kitchen> getAll() {
		return repository.findAll();
	}

	public Kitchen get(Long id) {
		Optional<Kitchen> kitchen = repository.findById(id);
		return kitchen.orElse(null);
	}

	public void delete(Kitchen kitchen) {
		try {
			repository.delete(kitchen);
		} catch (DataIntegrityViolationException ex) {
			throw new EntityInUseException(String.format(
					"This kitchen [ %d ] can't be deleted because it is used in a restaurant", kitchen.getId()));
		}

	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException ex1) {
			throw new EntityNotFoundPersonalException(
					String.format("This kitchen [ %d ] not found", id));
		} catch (DataIntegrityViolationException ex) {
			throw new EntityInUseException(
					String.format("This kitchen [ %d ] can't be deleted because it is used in a restaurant", id));
		}
	}
}