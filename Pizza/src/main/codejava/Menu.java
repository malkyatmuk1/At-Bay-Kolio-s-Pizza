package main.codejava;

import java.util.Scanner;


public class Menu {
	public static void main(String[] args) {

		String infoString="Sign in: \n"
				+ "1. Bai Kolio"
				+ "\n"+ "2. Worker"
				+ "\n Please select an option: "
				;
		String number;
		int numberInteger;
		System.out.println(infoString);
		Scanner scanner = new Scanner(System.in);
		number = scanner.nextLine();
		numberInteger=Integer.valueOf(number);
		while(numberInteger!=1 &&  numberInteger!=2) {
			System.out.println("Invalid command!");
			System.out.println(infoString);
			number = scanner.nextLine();
			numberInteger=Integer.valueOf(number);
		}
		
		
	    if (numberInteger==1) {
	    	new Admin();
		}
	    else  {
	    	new Worker();
	    }
	    scanner.close();
		
	}
}
