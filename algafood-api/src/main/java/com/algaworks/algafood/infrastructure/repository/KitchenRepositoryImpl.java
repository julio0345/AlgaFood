package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.domain.exception.EntityInUseException;
import com.algaworks.algafood.domain.model.Kitchen;
import com.algaworks.algafood.domain.repository.KitchenRepository;

@Component
public class KitchenRepositoryImpl implements KitchenRepository{

	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Kitchen> getAll(){
		return manager.createQuery("from Kitchen", Kitchen.class).getResultList();
	}
	
	@Override
	@Transactional
	public Kitchen save(Kitchen kitchen) {
		return manager.merge(kitchen);
	}
	
	@Override
	public Kitchen get(Long id) {
		return manager.find(Kitchen.class, id);
	}
	
	@Override
	@Transactional
	public void delete(Long id) {
		Kitchen kitchen = manager.find(Kitchen.class, id);
		
		if(kitchen != null) {
			manager.remove(kitchen);	
		}
		else {
			throw new EmptyResultDataAccessException(1);
		}
	}
	
	@Override
	@Transactional
	public void delete(Kitchen kitchen) {
		kitchen = manager.find(Kitchen.class, kitchen.getId());
		
		if(kitchen != null) {
			manager.remove(kitchen);
		}
		else {
			throw new EmptyResultDataAccessException(1);
		}
	}
}