package com.mindtree.store.entity;

public class Watch {
	private int watch_id;
	private int modelNumber;
	private float price;
	private Type t;

	public Watch(int watch_id, int modelNumber, float price, Type t) {
		super();
		this.watch_id = watch_id;
		this.modelNumber = modelNumber;
		this.price = price;
		this.t = t;
	}

	public int getWatch_id() {
		return watch_id;
	}

	public void setWatch_id(int watch_id) {
		this.watch_id = watch_id;
	}

	public int getModelNumber() {
		return modelNumber;
	}

	public void setModelNumber(int modelNumber) {
		this.modelNumber = modelNumber;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Type getT() {
		return t;
	}

	public void setT(Type t) {
		this.t = t;
	}

	@Override
	public String toString() {
		return "Watch [watch_id=" + watch_id + ", modelNumber=" + modelNumber + ", price=" + price + ", type id="
				+ t.getId() + "]";
	}

}
