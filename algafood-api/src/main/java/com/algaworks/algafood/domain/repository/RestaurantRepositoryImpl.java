package com.algaworks.algafood.domain.repository;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.algaworks.algafood.domain.model.Restaurant;

@Repository
public class RestaurantRepositoryImpl {

	@PersistenceContext
	private EntityManager manager;
	
	public List<Restaurant> buscarTudo(String name, BigDecimal inicial, BigDecimal finalV){
		
		var jpql = "from Restaurant where name like :name and priceDelivery between :inicial and :finalV";
		
		return manager.createQuery(jpql, Restaurant.class)
		.setParameter("name", name)
		.setParameter("inicial", inicial)
		.setParameter("finalV", finalV)
		.getResultList();
	}
}