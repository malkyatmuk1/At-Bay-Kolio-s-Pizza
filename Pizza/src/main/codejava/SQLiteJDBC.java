package main.codejava;

import java.sql.*;

public class SQLiteJDBC {
	public static void main( String args[] ) {
		connectDB();
		createTable();
		insertType();
		selectDB();
	   
	       

	     
	   }
	public static void createTable() {
		  Connection c = null;
	        Statement stmt = null;
	        try {
	          Class.forName("org.sqlite.JDBC");
	          c = DriverManager.getConnection("jdbc:sqlite:product.sqlite");
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
	          		+ "(IDTYPE INTEGER PRIMARY KEY autoincrement,"
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
	public static void insertType()
	  {
	      Connection c = null;
	        Statement stmt = null;
	        try {
	          Class.forName("org.sqlite.JDBC");
	          c = DriverManager.getConnection("jdbc:sqlite:product.sqlite");
	          c.setAutoCommit(false);
	          System.out.println("Opened database successfully");
	 
	          stmt = c.createStatement();
	          String sql = "INSERT INTO TYPE (NAME) " +
	                       "VALUES ('drink')," +
	                       " ('pizza'),"
	                       + "('dessert');"; 
	          stmt.executeUpdate(sql);
	          stmt.close();
	          c.commit();
	          c.close();
	        } catch ( Exception e ) {
	          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	          System.exit(0);
	        }
	        System.out.println("Records created successfully");
	  }
	 public static void selectDB()
	  {
    Connection c = null;
    Statement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:product.sqlite");
      c.setAutoCommit(false);
      System.out.println("Opened database successfully");

      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery( "SELECT * FROM TYPE;" );
      while ( rs.next() ) {
         int id = rs.getInt("IDTYPE");
         String  name = rs.getString("NAME");
         System.out.println( "ID : " + id );
         System.out.println( "Name : " + name );
         
         System.out.println();
      }
      rs.close();
      stmt.close();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
    System.out.println("Operation done successfully");  
	  }
} 