package io;

import java.io.Serializable;

public class Cat implements Serializable {

	private String name;
	private int age;
	// 表示该属性不用序列化
	private transient String color;

	public Cat() {
		super();
	}

	public Cat(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Cat [age: " + age + ", " + "name: " + name + "]";
	}
}
