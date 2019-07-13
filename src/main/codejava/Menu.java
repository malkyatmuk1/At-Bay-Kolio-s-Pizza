package main.codejava;

import java.io.IOException;
import java.util.Scanner;


public class Menu {



	@SuppressWarnings("static-access")
	public static void main(String[] args) throws IOException{
		Admin admin=new Admin();
		Worker worker=new Worker();
	 while(true)
	 {
		 Scanner sc = new Scanner(System.in);
		 String command=sc.nextLine();
		 
		 String[] commands=command.split(";",9);
	
				 if(commands[0].equals("admin"))
				 {
					if(commands[1].equals("add")) 
					{
						
						admin.addProduct(commands);
					}
					else if(commands[1].equals("checkCosts"))
					{
						System.out.println(admin.checkCostsMoney());
					}
				 }
				 else if(commands[0]=="worker") {
					 
				 }
				 else if(commands[0]=="exit"){
					 break;
				 }
	 }
		
	}

}
//admin;add;pi;dhsj hfjs;87;89;98;pizza
//admin;add;pizza;mn qka pizza;12.5;13;6;pizza;Thin
//admin;checkCosts

