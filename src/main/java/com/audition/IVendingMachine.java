package com.audition;

import java.util.List;
import java.util.Map;

public interface IVendingMachine {

	public String getPriceForProduct(IProduct product);
	
	public Map<IProduct, List<Coins>> getProductAndChange(IProduct prod) ;
	public void insertCoin(Coins coin);
	public int getCoinsValue();
}
