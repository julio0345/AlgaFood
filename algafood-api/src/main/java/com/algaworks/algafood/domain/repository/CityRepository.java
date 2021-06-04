package com.algaworks.algafood.domain.repository;

import java.util.List;

import com.algaworks.algafood.domain.model.City;

public interface CityRepository {

	List<City> getAll();
	
	City get(Long id);
	
	City save(City city);
	
	void delete	(Long id);
	
	void delete(City city);
}