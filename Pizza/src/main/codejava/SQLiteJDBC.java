package main.codejava;

import java.sql.*;

public class SQLiteJDBC {
	public static void main( String args[] ) {
		connectDB();
		createTable();
	   
	       

	     
	   }
	public static void createTable() {
		  Connection c = null;
	        Statement stmt = null;
	        try {
	          Class.forName("org.sqlite.JDBC");
	          c = DriverManager.getConnection("jdbc:sqlite:myBlog.sqlite");
	          System.out.println("Opened database successfully");
	 
	          stmt = c.createStatement();
	          String moneyTable = "CREATE TABLE IF NOT EXISTS MONEY " +
                      "(ID INT PRIMARY KEY     NOT NULL," +
                      " INCOME           REAL    NOT NULL, " + 
                      " COSTS            REAL     NOT NULL )" ; 
	          String productsTable="CREATE TABLE IF NOT EXISTS PRODUCTS "
	          		+ "(IDPRODUCT INT PRIMARY KEY,"
	          		+ "NAME TEXT NOT NULL,"
	          		+ "DESCRIPTION TEXT NOT NULL,"
	          		+ "PRICEBUY REAL NOT NULL,"
	          		+ "PRICESALE REAL NOT NULL,"
	          		+ "QUANTITY INT NOT NULL,"
	          		+ "IDTYPE INT NOT NULL,"
	          		+ "     FOREIGN KEY(IDTYPE) REFERENCES PRODUCTS(IDTYPE))";
	          String typeTable= "CREATE TABLE IF NOT EXISTS TYPE"
	          		+ "(IDTYPE INT PRIMARY KEY,"
	          		+ "NAME TEXT NOT NULL)";
	          
	          stmt.executeUpdate(moneyTable);
	          stmt.executeUpdate(typeTable);
	          stmt.executeUpdate(productsTable);
	          stmt.close();
	          c.close();
	        } catch ( Exception e ) {
	          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	          System.exit(0);
	        }
	        System.out.println("Table created successfully");
	}
	  public static void connectDB()
	  {
	      Connection c = null;
	        try {
	          Class.forName("org.sqlite.JDBC");
	          c = DriverManager.getConnection("jdbc:sqlite:product.sqlite");
	        } catch ( Exception e ) {
	          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	          System.exit(0);
	        }
	        System.out.println("Opened database successfully");
	  }
} 