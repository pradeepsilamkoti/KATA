package com.audition;

public enum Product {
	A1("PEPSI", 75), B1("COKE", 80), C1("DIET_COKE", 125), D1("SPRITE", 50);
	private String name;
	private int price;

	private Product(String name, int price) {
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
