package com.audition;

import java.util.HashMap;

public class CoinBox<K,V> extends HashMap<Coins, Integer> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public boolean hasCoins (Coins coin) {
		int coinsCount = this.get(coin);
		
		if (coinsCount > 0) {
			return true;
		} else { 
			return false;
		}
	}
	
	public void removeCoin(Coins coin) {
		this.put(coin, this.get(coin)-1);
	}
	
	public void addCoin(Coins coin) {
		this.put(coin, this.get(coin)+1);
	}
}
