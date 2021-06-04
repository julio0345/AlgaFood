package com.tests.spring;

public class People {
	private String name;
	private Integer age;
	private String sex;
	
	public People(String name, Integer age, String sex) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
	}

	public String getName() {
		return name;
	}

	public Integer getAge() {
		return age;
	}

	public String getSex() {
		return sex;
	}
}