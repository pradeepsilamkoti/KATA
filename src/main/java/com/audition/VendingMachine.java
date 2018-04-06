package com.audition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendingMachine implements IVendingMachine{

	CoinBox<Coins,Integer> coinbox =  new CoinBox<Coins, Integer>();
	ProductStock<IProduct, Integer> stock =  new ProductStock<IProduct, Integer>();
	
	private IProduct productSelected;
    private int coinsValue;
	public int getCoinsValue() {
		return coinsValue;
	}

	private boolean productDisbursed = false;
    
	public <T extends Enum<T> & IProduct> VendingMachine(Class<T> clazz) {

		
		for (Coins coin : Coins.values()) {
			coinbox.put(coin, 3);
		}
		
		for (IProduct prod : clazz.getEnumConstants()) {
			stock.put(prod, 10);
		}
	}
	

	
	public String getPriceForProduct (IProduct product) {
		if (!stock.isEmpty()) {
			this.productSelected = product;
			return "Price of "+ product.getName() +" is: " +product.getPrice();
		} else {
			return  product.getName() + " is not available";
		}
	}
	
	private List<Coins> calculateChange() {
		
		int changeValue = this.coinsValue - this.productSelected.getPrice();
		
		List<Coins> changeCoins = this.getChangeCoins(changeValue);
		
		this.coinsValue = 0;
		//this.productSelected = null;
		
		return changeCoins;
	}
	
	private List<Coins> getChangeCoins(int changeValue) {
		List<Coins> changeCoins = new ArrayList<Coins>();
		
		if (changeValue > 0) {
			int balance = changeValue;
			while (balance >0) {
				if (balance >= Coins.QUARTER.getCoinValue() && coinbox.hasCoins(Coins.QUARTER)) {
					balance = balance - Coins.QUARTER.getCoinValue();
					changeCoins.add(Coins.QUARTER);
					continue;
				} else if (balance >= Coins.DIME.getCoinValue() && coinbox.hasCoins(Coins.DIME)) {
					balance = balance - Coins.DIME.getCoinValue();
					changeCoins.add(Coins.DIME);
					continue;
				} else if (balance >= Coins.NICKLE.getCoinValue() && coinbox.hasCoins(Coins.NICKLE)) {
					balance = balance - Coins.NICKLE.getCoinValue();
					changeCoins.add(Coins.NICKLE);
					continue;
				} else if (balance >= Coins.PENNY.getCoinValue() && coinbox.hasCoins(Coins.PENNY)) {
					balance = balance - Coins.PENNY.getCoinValue();
					changeCoins.add(Coins.PENNY);
					continue;
				} else {
					System.out.println("Coins not available...");
				}
			}
		}
		
		return changeCoins;
	}
	
	
	public void insertCoin(Coins coin) {
		coinsValue = coinsValue + coin.getCoinValue();
		int coinCount = coinbox.get(coin);
		coinbox.put(coin, coinCount+1);
	}
	
	private void removeProduct(IProduct prod) {
		int prodCount = stock.get(prod);
		stock.put(prod, prodCount-1);
	}
 	
	public Map<IProduct, List<Coins>> getProductAndChange(IProduct prod) {
		Map<IProduct, List<Coins>> output = new HashMap<IProduct, List<Coins>>();
		if (coinsValue >= prod.getPrice()) {
			List<Coins> changeCoins = this.calculateChange();
			output.put(productSelected, changeCoins);
			
		} else {
			System.out.println("Please insert coins for: " + (prod.getPrice()-coinsValue) + " cents." ); 
		}
		
		return output;
	}
}
