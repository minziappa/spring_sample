package io.sample.bean.model;

import java.io.Serializable;

public class UserModel implements Serializable {

	private static final long serialVersionUID = -2535179337713336941L;

	private String id;
	private String name;
	private int age;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

}