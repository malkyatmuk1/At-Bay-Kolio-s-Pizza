package main.codejava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import products.codejava.Dessert;
import products.codejava.Drink;
import products.codejava.Pizza;

public class Global {

	static ArrayList<Pizza> pizzaList=new ArrayList<Pizza>();
	static ArrayList<Dessert> dessertList=new ArrayList<Dessert>();
	static ArrayList<Drink> drinkList=new ArrayList<Drink>();
	public static int checkIfTheLineIsCorrect(String infoString,int index) throws IOException {
		String number;
		Integer numberInteger;
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		String s=br.readLine();
	    numberInteger= Integer.parseInt(s);
				while(numberInteger<1 && numberInteger>index) {
			System.out.println("Invalid command!");
			System.out.println(infoString);
			numberInteger = Integer.parseInt(br.readLine());
		}
		 
		return numberInteger;
	}
    public static double moneySale;
    public static double moneyBuy;
   
}
