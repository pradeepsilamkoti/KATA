package com.audition;

public enum Snacks implements IProduct{
	
	A1("LAYS", 75), B1("TRAIL MIX", 80), C1("OREO", 125), D1("COOKIES", 50);
	private String name;
	private int price;

	private Snacks(String name, int price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}


}
