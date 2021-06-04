package com.tests.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello")
public class FirstController {

	@MyAnnotation(PriorityEnum.CURRENT)
	@Autowired
	public Notification notification;
	
	@Autowired
	public ApplicationEventPublisher event;
	
	@GetMapping
	@ResponseBody
	public String hello() {
		
		event.publishEvent(new People("Joao", 15, "macho"));
		return notification.sendMessage();
	}
	
	@EventListener
	public void listeningPeople(People people) {
		System.out.println(people.getName() + " tem " + people.getAge() + " anos e é " + people.getSex());
	}
	
	@EventListener
	public void listeningPeople(Object obj) {
		
		People people = null;
		if(obj instanceof People) {
			people = (People)obj;
			System.out.println(people.getName() + " converte-se aos " + people.getAge() + " anos e seu irmão é  " + people.getSex());	
		}
	}
}