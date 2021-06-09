package com.algaworks.algafood.domain.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.algaworks.algafood.domain.model.Restaurant;

@Repository
public interface RestaurantRepository  extends CustomJPARepository<Restaurant, Long>, JpaSpecificationExecutor<Restaurant>{
	
	List<Restaurant> buscarTudo(String name, BigDecimal inicial, BigDecimal finalV);
}