package main.codejava;

import java.util.*; 

import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import products.codejava.Dessert;
import products.codejava.Drink;
import products.codejava.Pizza;

public class Menu {



	public static void main(String[] args) throws IOException {

		String infoString="Sign in: \n"
				+ "1. Bai Kolio"
				+ "\n"+ "2. Worker"
				+ "\n Please select an option: "
				;
		String number;
		int numberInteger;
	
		System.out.println(infoString);
		numberInteger=Global.checkIfTheLineIsCorrect(infoString,2);
		
		//Bai Kolio
	    if (numberInteger==1) {
	    	Admin admin= new Admin();
	    	String infoString2="Hi Bai Kolio!:\n"
					+ "What do you want to do?:"
					+ "1. Add product \n 2. Change product \n 3. Check money\n1";
	    	System.out.println(infoString2);
	    	
	    	numberInteger=Global.checkIfTheLineIsCorrect(infoString2,3);
	    	//Add product
	    	if(numberInteger==1) {		
	    		String infoString3="What kind of a product do you want to add:\n"
						+ "1. Pizza \n 2. Dessert \n 3. Drink";
	    		System.out.println(infoString3);
	    		numberInteger=Global.checkIfTheLineIsCorrect(infoString3,3);
	    	admin.addProduct(numberInteger);
	    	
	    	 
	    	}
	    	else if (numberInteger==2) {
	    		
	        }
	    	else {
	    		admin.getMoney();
	    	}
	    	admin.getMoney();
		}
	    //Worker
	    else  {
	    	new Worker();
	    }
	 
		
	}

}
