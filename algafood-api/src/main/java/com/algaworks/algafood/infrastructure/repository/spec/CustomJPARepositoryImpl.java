package com.algaworks.algafood.infrastructure.repository.spec;

import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import com.algaworks.algafood.domain.repository.CustomJPARepository;

public class CustomJPARepositoryImpl<T, ID> extends SimpleJpaRepository<T, ID> implements CustomJPARepository<T, ID>{
	
	private EntityManager manager;
	
	public CustomJPARepositoryImpl(JpaEntityInformation<T, ?> entityInformation, 
			EntityManager entityManager){
		super(entityInformation, entityManager);
		
		this.manager = entityManager;
	}

	@Override
	public Optional<T> getFirst() {
		var jpql = "from " + getDomainClass().getName();
		
		T entity = manager.createQuery(jpql, getDomainClass())
				.setMaxResults(1)
				.getSingleResult();
		return Optional.ofNullable(entity);
	}
}