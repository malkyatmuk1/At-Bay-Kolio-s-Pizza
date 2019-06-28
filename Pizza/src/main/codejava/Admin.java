package main.codejava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import products.codejava.Dessert;
import products.codejava.Drink;
import products.codejava.Pizza;

public class Admin {

	
	public Admin() {
		// TODO Auto-generated constructor stub
	}
	public void addProduct(int typeProduct) throws IOException {
	int numberInteger;
		if(typeProduct==1){
			 sizePizza size;
		     double price,salePrice;
		     String name,description;
		     int quantity;
		System.out.print("Name:");
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		name=br.readLine();
		String infoString4="Size:\n 1. Thin \n 2.	Thick \n 3.	Italian \n";
		System.out.print(infoString4);
		
		numberInteger=Global.checkIfTheLineIsCorrect(infoString4,3);
	    if(numberInteger==1)size=sizePizza.Thin;
	    else if (numberInteger==2)size=sizePizza.Thick;
	    else size=sizePizza.Italian;
		System.out.print("Price:");
	    price=Double.parseDouble(br.readLine());
	    System.out.print("Sale Price:");
	    salePrice=Double.parseDouble(br.readLine());
	    System.out.print("Description:");
	    description=br.readLine();
	    System.out.print("Quantity:");
	    quantity=Integer.parseInt(br.readLine());
		Pizza pizza=new Pizza(name, size, price, salePrice, quantity, description);
		Global.pizzaList.add(pizza);
		pizza.buy();
		
		}
		else if (typeProduct==2)
		{
			double price,salePrice;
		     String name,description;
		     int quantity;
		
		     System.out.print("Name:");
		     InputStreamReader isr = new InputStreamReader(System.in);
		     BufferedReader br=new BufferedReader(isr);
		     name=br.readLine();
		     System.out.print("Price:");
	         price=Double.parseDouble(br.readLine());
	         System.out.print("Sale Price:");
	         salePrice=Double.parseDouble(br.readLine());
	         System.out.print("Description:");
	         description=br.readLine();
	         System.out.print("Quantity:");
	         quantity=Integer.parseInt(br.readLine());
		     Dessert dessert=new Dessert(name, price, salePrice, quantity, description);
		     Global.dessertList.add(dessert);
		     Global.moneyBuy+=dessert.getPrice()*dessert.getQuantity();
		     dessert.buy();
		     
		}
		else if (typeProduct==3) {
			 sizeDrink size;
		     double price,salePrice;
		     String name,description;
		     int quantity;
		System.out.print("Name:");
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		name=br.readLine();
		String infoString4="Size:\n 1. Small \n 2.	Big \n 3.	Bottle \n";
		System.out.print(infoString4);
		
		numberInteger=Global.checkIfTheLineIsCorrect(infoString4,3);
	    if(numberInteger==1)size=sizeDrink.Small;
	    else if (numberInteger==2)size=sizeDrink.Big;
	    else size=sizeDrink.Bottle;
		System.out.print("Price:");
	    price=Double.parseDouble(br.readLine());
	    System.out.print("Sale Price:");
	    salePrice=Double.parseDouble(br.readLine());
	    System.out.print("Description:");
	    description=br.readLine();
	    System.out.print("Quantity:");
	    quantity=Integer.parseInt(br.readLine());
		Drink drink=new Drink(name, size, price, salePrice, quantity, description);
		Global.drinkList.add(drink);
		drink.buy();
		}
		
		
	}
	public void changeProduct () {
		
	}
	public void getMoney() {
		System.out.println(Global.moneyBuy);
	}
	
}
