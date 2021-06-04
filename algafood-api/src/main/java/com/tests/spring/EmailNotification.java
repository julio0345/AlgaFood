package com.tests.spring;

import org.springframework.stereotype.Component;

@MyAnnotation(PriorityEnum.CURRENT)
@Component
public class EmailNotification implements Notification{

	@Override
	public String sendMessage() {
		return ("Notified by Email");
	}
}