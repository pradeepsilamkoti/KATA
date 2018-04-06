package com.audition;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;


public class VendingMachineTest {
	IVendingMachine brevarages;
	IVendingMachine snacks;
	@Before
	public void init() {
		brevarages = new VendingMachine(Brevarages.class);
		snacks = new VendingMachine(Snacks.class);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testPriceForProduct() {
		
		System.out.println("Sufficient funds brevarages ********************************");	
		String abc = brevarages.getPriceForProduct(Brevarages.B1);
		System.out.println(abc);
		brevarages.insertCoin(Coins.QUARTER);
		brevarages.insertCoin(Coins.QUARTER);
		brevarages.insertCoin(Coins.QUARTER);
		brevarages.insertCoin(Coins.QUARTER);
		brevarages.insertCoin(Coins.QUARTER);
		brevarages.insertCoin(Coins.DIME);
		
		System.out.println("Conis inserted for the value: " + brevarages.getCoinsValue());
		Map<IProduct, List<Coins>> prodAndChange =  brevarages.getProductAndChange(Brevarages.B1);
		System.out.println(abc);
		
		if (prodAndChange != null && !prodAndChange.isEmpty()) {
			
			prodAndChange.forEach((K, V)->{
				System.out.println("Product disbursed: " + K.getName());
				
				List<Coins> coins = V;
				
				for(Coins coin : coins){
					System.out.println("Change given: " + coin.toString());
				}
				
			});
			
			System.out.println("********************************");	
		} else {
			System.out.println("Test failed");
		}
		
		Assert.assertNotNull(prodAndChange);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testInSufficientPriceForProduct() {
		
		System.out.println("In Sufficient funds brevarages ********************************");	
		String abc = brevarages.getPriceForProduct(Brevarages.B1);
		System.out.println(abc);
		brevarages.insertCoin(Coins.QUARTER);
		brevarages.insertCoin(Coins.QUARTER);
		//brevarages.insertCoin(Coins.QUARTER);
		brevarages.insertCoin(Coins.DIME);
		System.out.println("Conis inserted for the value: " + brevarages.getCoinsValue());
		Map<IProduct, List<Coins>> prodAndChange =  brevarages.getProductAndChange(Brevarages.B1);
		
		if (prodAndChange != null && !prodAndChange.isEmpty()) {
			
			prodAndChange.forEach((K, V)->{
				System.out.println("Product disbursed: " + K.getName());
				
				List<Coins> coins = V;
				if (!coins.isEmpty()) {
				for(Coins coin : coins){
					System.out.println("Change given: " + coin.toString());
				}
				} else {
					System.out.println("No change.");
				}
				
			});
			
			
		} else {
			System.out.println("Test failed");
		}
		
		Assert.assertNotNull(prodAndChange);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testExactPriceForProduct() {
		
		System.out.println("Exact change brevarages ********************************");	
		String abc = brevarages.getPriceForProduct(Brevarages.A1);
		System.out.println(abc);
		brevarages.insertCoin(Coins.QUARTER);
		brevarages.insertCoin(Coins.QUARTER);
		brevarages.insertCoin(Coins.QUARTER);
		//brevarages.insertCoin(Coins.DIME);
		System.out.println("Conis inserted for the value: " + brevarages.getCoinsValue());
		Map<IProduct, List<Coins>> prodAndChange =  brevarages.getProductAndChange(Brevarages.A1);
		
		if (prodAndChange != null && !prodAndChange.isEmpty()) {
			
			prodAndChange.forEach((K, V)->{
				System.out.println("Product disbursed: " + K.getName());
				
				List<Coins> coins = V;
				if (!coins.isEmpty()) {
				for(Coins coin : coins){
					System.out.println("Change given: " + coin.toString());
				}
				} else {
					System.out.println("No change.");
				}
				
			});
			
			
		} else {
			System.out.println("Test failed");
		}
		
		Assert.assertNotNull(prodAndChange);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testSufficientPriceForSnacks() {
		
		System.out.println("Sufficient funds for snacks ********************************");	
		String abc = brevarages.getPriceForProduct(Snacks.B1);
		System.out.println(abc);
		brevarages.insertCoin(Coins.QUARTER);
		brevarages.insertCoin(Coins.QUARTER);
		brevarages.insertCoin(Coins.QUARTER);
		snacks.insertCoin(Coins.DIME);
		System.out.println("Conis inserted for the value: " + snacks.getCoinsValue());
		Map<IProduct, List<Coins>> prodAndChange =  snacks.getProductAndChange(Snacks.B1);
		
		if (prodAndChange != null && !prodAndChange.isEmpty()) {
			
			prodAndChange.forEach((K, V)->{
				System.out.println("Product disbursed: " + K.getName());
				
				List<Coins> coins = V;
				if (!coins.isEmpty()) {
				for(Coins coin : coins){
					System.out.println("Change given: " + coin.toString());
				}
				} else {
					System.out.println("No change.");
				}
				
			});
			
			
		} else {
			System.out.println("Test failed");
		}
		
		Assert.assertNotNull(prodAndChange);
	}

}
