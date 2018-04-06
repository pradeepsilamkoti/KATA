package com.audition;

import java.util.HashMap;

public class ProductStock<K,V> extends HashMap<IProduct, Integer>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public boolean hasProduct (IProduct product) {
		int productCount = this.get(product);
		
		if (productCount > 0) {
			return true;
		} else { 
			return false;
		}
	}
	
	public void removeProduct (IProduct product) {
		this.put(product, this.get(product)-1);
	}

}
