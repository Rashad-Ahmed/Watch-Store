package com.mindtree.store.entity;

public class Type {
	private int id;
	private String name;

	public Type(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Type(int id) {
		super();
		this.id = id;
	}

	public Type() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Type id=" + id + " " + "name=" + name + "\n";
	}

}
