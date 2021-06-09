package com.algaworks.algafood.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.exception.EntityNotFoundPersonalException;
import com.algaworks.algafood.domain.model.City;
import com.algaworks.algafood.domain.model.State;
import com.algaworks.algafood.domain.repository.CityRepository;
import com.algaworks.algafood.domain.repository.StateRepository;

@Service
public class CityService {

	@Autowired
	private CityRepository repository;

	@Autowired
	private StateRepository repositoryState;

	public City get(Long id) {
		City city = repository.findById(id).orElse(null);

		if (city == null) {
			throw new EntityNotFoundPersonalException(String.format("City [ %d ] not found", id));
		}
		return city;
	}

	public List<City> getAll() {
		return repository.findAll();
	}

	public void delete(Long id) {
		City city = get(id);
		repository.delete(city);
	}

	public City save(City city) {
		Long idState = city.getState().getId();
		State state = repositoryState.findById(idState).orElseThrow(
				() -> new EntityNotFoundPersonalException(String.format("Not exists the State [%d ]", idState)));

		city.setState(state);
		city = repository.save(city);
		return city;
	}
}