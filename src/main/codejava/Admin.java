package main.codejava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import products.codejava.Dessert;
import products.codejava.Drink;
import products.codejava.Pizza;
import products.codejava.Product;

public class Admin {

	
	public Admin() {
		// TODO Auto-generated constructor stub
	}
	public void addProduct(String[] commands)  {
		//name;description;priceBuy;priceSale;quantity;productType;size
	
		Product product=null;
		SQLiteJDBC sqlite= new SQLiteJDBC();
		String name=commands[2];
		String description=commands[3];
		double priceBuy=Double.parseDouble(commands[4]);
		double priceSale=Double.parseDouble(commands[5]);
		int quantity=Integer.parseInt(commands[6]);
		String productType=commands[7];

		if(productType.equals("pizza")) {
			sizePizza size=sizePizza.valueOf(commands[8]);
			
			product=new Pizza(name, size, priceBuy, priceSale, quantity, description);
			System.out.println(product.getName());
		}
		else if(productType.equals("dessert")) {
			product=new Dessert(name, priceBuy, priceSale, quantity, description);
		}
		else if(productType.equals("drink")) {
			sizeDrink size=sizeDrink.valueOf(commands[8]);
			product=new Drink(name, size, priceBuy, priceSale, quantity, description);
		}
		
		sqlite.insertProduct(product,productType);
		
	}
	public void changeProduct () {
		
	}
	public double checkIncomeMoney() {
		SQLiteJDBC sqlite= new SQLiteJDBC();
		return sqlite.checkIncomeMoney();
		
	}
	public double checkCostsMoney() {
		SQLiteJDBC sqlite= new SQLiteJDBC();
		return sqlite.checkCostsMoney();
		
	}
	
	
}
