//package com.algaworks.algafood.infrastructure.repository;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.transaction.Transactional;
//
//import org.springframework.stereotype.Component;
//
//import com.algaworks.algafood.domain.model.City;
//import com.algaworks.algafood.domain.repository.CityRepository;
//
//@Component
//public class CityRepositoryImpl implements CityRepository{
//
//	@PersistenceContext
//	private EntityManager manager;
//
//	@Override
//	public List<City> getAll(){
//		return manager.createQuery("from City", City.class).getResultList();
//	}
//	
//	@Override
//	@Transactional
//	public City save(City city) {
//		return manager.merge(city);
//	}
//	
//	@Override
//	public City get(Long id) {
//		return manager.find(City.class, id);
//	}
//	
//	@Override
//	@Transactional
//	public void delete(Long id) {
//		manager.remove(manager.find(City.class, id));
//	}
//	
//	@Override
//	@Transactional
//	public void delete(City city) {
//		manager.remove(city);
//	}
//
//}
