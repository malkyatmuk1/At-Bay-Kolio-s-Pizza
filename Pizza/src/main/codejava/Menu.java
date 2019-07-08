package main.codejava;

import java.io.IOException;
import java.util.Scanner;

import com.sun.org.apache.xalan.internal.xsltc.compiler.Pattern;

public class Menu {



	@SuppressWarnings("static-access")
	public static void main(String[] args) throws IOException{
		Admin admin=new Admin();
		Worker worker=new Worker();
	 while(true)
	 {
		 Scanner sc = new Scanner(System.in);
		 String command=sc.nextLine();
		 System.out.println(command);
		 String[] commands=command.split(";",8);
		 for(int i=0;i<8;i++)
			{
				System.out.println(commands[i]);
			}
				 if(commands[0].equals("admin"))
				 {
					if(commands[1].equals("add")) 
					{
						
						admin.addProduct(commands);
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
