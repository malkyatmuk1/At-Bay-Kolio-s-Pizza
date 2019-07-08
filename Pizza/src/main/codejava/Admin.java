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
	
		SQLiteJDBC sqlite= new SQLiteJDBC();
		String name=commands[2];
		String description=commands[3];
		double priceBuy=Double.parseDouble(commands[4]);
		double priceSale=Double.parseDouble(commands[5]);
		int quantity=Integer.parseInt(commands[6]);
		String productType=commands[7];
		for(int i=0;i<8;i++)
		{
			System.out.println(commands[i]);
		}
		Product product=new Product(name,description,priceBuy,priceSale,quantity,productType);
		sqlite.insertProduct(name, description, priceBuy, priceSale, quantity, productType);
		
	}
	public void changeProduct () {
		
	}
	public void getMoney() {
		System.out.println(Global.moneyBuy);
	}
	
}
