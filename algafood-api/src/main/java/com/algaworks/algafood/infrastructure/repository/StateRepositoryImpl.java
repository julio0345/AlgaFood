package com.algaworks.algafood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.algaworks.algafood.domain.model.State;
import com.algaworks.algafood.domain.repository.StateRepository;

@Component
public class StateRepositoryImpl implements StateRepository{

	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<State> getAll(){
		return manager.createQuery("from State", State.class).getResultList();
	}
	
	@Override
	@Transactional
	public State save(State state) {
		return manager.merge(state);
	}
	
	@Override
	public State get(Long id) {
		return manager.find(State.class, id);
	}
	
	@Override
	@Transactional
	public void delete(Long id) {
		manager.remove(manager.find(State.class, id));
	}
	
	@Override
	@Transactional
	public void delete(State state) {
		manager.remove(state);
	}
}