//package com.algaworks.algafood.infrastructure.repository;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.transaction.Transactional;
//
//import org.springframework.dao.EmptyResultDataAccessException;
//import org.springframework.stereotype.Component;
//
//import com.algaworks.algafood.domain.model.Restaurant;
//import com.algaworks.algafood.domain.repository.RestaurantRepository;
//
//@Component
//public class RestaurantRepositoryImpl implements RestaurantRepository{
//
//	@PersistenceContext
//	private EntityManager manager;
//
//	@Override
//	public List<Restaurant> getAll(){
//		return manager.createQuery("from Restaurant", Restaurant.class).getResultList();
//	}
//	
//	@Override
//	@Transactional
//	public Restaurant save(Restaurant restaurant) {
//		return manager.merge(restaurant);
//	}
//	
//	@Override
//	public Restaurant get(Long id) {
//		 return manager.find(Restaurant.class, id);
//	}
//	
//	@Override
//	@Transactional
//	public void delete(Long id) {
//		Restaurant restaurant = manager.find(Restaurant.class, id); 
//		
//		if(restaurant != null) {
//			manager.remove(restaurant);
//		}
//		else {
//			throw new EmptyResultDataAccessException(1);
//		}
//	}
//}