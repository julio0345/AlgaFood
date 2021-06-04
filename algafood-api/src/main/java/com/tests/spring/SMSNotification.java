package com.tests.spring;

import org.springframework.stereotype.Component;

@MyAnnotation(PriorityEnum.SECUNDARY)
@Component
public class SMSNotification implements Notification{

	@Override
	public String sendMessage() {
		return "Notified by SMS";
	}
}