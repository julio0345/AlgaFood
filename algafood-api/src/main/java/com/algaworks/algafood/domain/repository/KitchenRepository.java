package com.algaworks.algafood.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.algaworks.algafood.domain.model.Kitchen;

@Repository
public interface KitchenRepository extends JpaRepository<Kitchen, Long>{
		
	List<Kitchen> findByName(String name);
	
	Optional<Kitchen> findQualquerCoisadoMundoById(Long id);
	
	//@Query("from Kitchen where name like :cozinha") // Foi enviado pro orm.xml
	List<Kitchen> meuMetodo(@Param("cozinha") String lerolero); // Parsin cozinha to lerolero
	
	List<Kitchen> getKitchensByNameContaining(String name);//Utiliza o Like
	//List<Kitchen> findByName(String name);
}