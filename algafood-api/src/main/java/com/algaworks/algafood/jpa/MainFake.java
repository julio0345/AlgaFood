package com.algaworks.algafood.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Kitchen;
import com.algaworks.algafood.domain.repository.KitchenRepository;

public class MainFake {
	
	public static void main(String[] args) {
		
		//Just to Simulate a Main Class like AlgafoodApiApplication
		ApplicationContext context = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		KitchenRepository kitchenManager = context.getBean(KitchenRepository.class);
		
		Kitchen k1 = new Kitchen();
		k1.setName("Brasileira");		
		kitchenManager.save(k1);
		
		k1 = new Kitchen();
		k1.setName("Portuguesa");
		kitchenManager.save(k1);
		
		List<Kitchen> listKitchen = kitchenManager.getAll();
		
		for(Kitchen item : listKitchen) {
			System.out.printf("%d - %s \n", item.getId(), item.getName());
		}
		
		k1 = new Kitchen();
		k1.setId(1L);
		k1.setName("Italiana");
		kitchenManager.save(k1);
		System.out.printf("%d - %s \n", k1.getId(), k1.getName());
		
		k1 = kitchenManager.get(4L);
		System.out.printf("%d - %s \n", k1.getId(), k1.getName());
		
		kitchenManager.delete(4L);
		
		listKitchen = kitchenManager.getAll();
		
		for(Kitchen item : listKitchen) {
			System.out.printf("%d - %s \n", item.getId(), item.getName());
		}
	}
}