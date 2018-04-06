package com.audition;

public enum Coins {
	PENNY(1), NICKLE(5), DIME(10), QUARTER(25);
	private int value;

	private Coins(int value) {
		this.value = value;
	}

	public int getCoinValue() {
		return value;
	}

}
