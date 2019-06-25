package main.codejava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import products.codejava.Dessert;
import products.codejava.Drink;
import products.codejava.Pizza;

public class Menu {

	public static int checkIfTheLineIsCorrect(String infoString) throws IOException {
		String number;
		Integer numberInteger;
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		String s=br.readLine();
	    numberInteger= Integer.parseInt(s);
				while(numberInteger!=1 &&  numberInteger!=2) {
			System.out.println("Invalid command!");
			System.out.println(infoString);
			numberInteger = Integer.parseInt(br.readLine());
		}
		 
		return numberInteger;
	}

	public static void main(String[] args) throws IOException {

		String infoString="Sign in: \n"
				+ "1. Bai Kolio"
				+ "\n"+ "2. Worker"
				+ "\n Please select an option: "
				;
		String number;
		int numberInteger;
		System.out.println(infoString);
		numberInteger=checkIfTheLineIsCorrect(infoString);
		
		//Bai Kolio
	    if (numberInteger==1) {
	    	Admin admin= new Admin();
	    	String infoString2="Hi Bai Kolio!:\n"
					+ "What do you want to do?:"
					+ "1. Add product \n 2. Change product \n 3. Check money\n1";
	    	System.out.println(infoString2);
	    	
	    	numberInteger=checkIfTheLineIsCorrect(infoString2);
	    	//Add product
	    	if(numberInteger==1) {		
	    		String infoString3="What kind of a product do you want to add:\n"
						+ "1. Pizza \n 2. Dessert \n 3. Drink";
	    	
	    		System.out.println(infoString3);
	    		numberInteger=checkIfTheLineIsCorrect(infoString3);
	    	   //Pizza
	    	   if (numberInteger==1) {
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
	    		
	    		numberInteger=checkIfTheLineIsCorrect(infoString4);
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
			   }
	    	   //Dessert
	    	   else if(numberInteger==2) {
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
	    	   }
	           //Drink
	    	   else {
	    		   
	    		   sizeDrink size;
	    		     double price,salePrice;
	    		     String name,description;
	    		     int quantity;
	    		System.out.print("Name:");
	    		InputStreamReader isr = new InputStreamReader(System.in);
	    		BufferedReader br=new BufferedReader(isr);
	    		name=br.readLine();
	    		String infoString4="Size:\n 1. Thin \n 2.	Thick \n 3.	Italian \n";
	    		System.out.print(infoString4);
	    		
	    		numberInteger=checkIfTheLineIsCorrect(infoString4);
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
	    		Drink pizza=new Drink(name, size, price, salePrice, quantity, description);
	    	   }
	    	 
	    	}
	    	else if (numberInteger==2) {
	    		
	        }
	    	else {
	    		
	    	}
	    
		}
	    //Worker
	    else  {
	    	new Worker();
	    }
	 
		
	}

}
