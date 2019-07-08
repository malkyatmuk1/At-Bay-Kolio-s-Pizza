package main.codejava;

import java.sql.*;

public class SQLiteJDBC {
	public static void main( String args[] ) {
		connectDB();
		createTable();
	//insertType();
		selectDB();
	 //insertProduct("Pizza","mn qko", 134.6,167.6, 15,"pizza");  
	       

	     
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
                      "(ID INTEGER PRIMARY KEY  autoincrement   NOT NULL," +
                      " INCOME           REAL    NOT NULL, " + 
                      " COSTS            REAL     NOT NULL )" ; 
	          String productsTable="CREATE TABLE IF NOT EXISTS PRODUCTS "
	          		+ "(IDPRODUCT INTEGER PRIMARY KEY autoincrement,"
	          		+ "NAME TEXT NOT NULL,"
	          		+ "DESCRIPTION TEXT NOT NULL,"
	          		+ "PRICEBUY REAL NOT NULL,"
	          		+ "PRICESALE REAL NOT NULL,"
	          		+ "QUANTITY INT NOT NULL,"
	          		+ "TYPE INT NOT NULL,"
	          		+ "     FOREIGN KEY(TYPE) REFERENCES TYPE(NAMETYPE))";
	          String typeTable= "CREATE TABLE IF NOT EXISTS TYPE("
	          		+ "NAMETYPE TEXT PRIMARY KEY NOT NULL);";
	          
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
	public static void insertProduct(String name, String description,
			double priceBuy, double priceSale, int quatntity, String productType)
	{
	     String sql = "INSERT INTO PRODUCTS(name,description, priceBuy, priceSale, quantity, Type) VALUES(?1,?2,?3,?4,?5,?6)";
	     
	        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:product.sqlite");
	                PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setString(1, name);
	            pstmt.setString(2, description);
	            pstmt.setDouble(3,priceBuy);
	            pstmt.setDouble(4,priceSale);
	            pstmt.setInt(5, quatntity);
	            pstmt.setString(6, productType);
	            pstmt.executeUpdate();
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	        System.out.println("Records created successfully");
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
	          String sql = "INSERT INTO TYPE (NAMETYPE) " +
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
      ResultSet rs = stmt.executeQuery( "SELECT * FROM PRODUCTS;" );
      while ( rs.next() ) {
         
         String  name = rs.getString("NAME");
         String description= rs.getString("DESCRIPTION");
         Double priceBuy=rs.getDouble(4);
         Double priceSale=rs.getDouble(5);
         int quantity=rs.getInt(6);
         String productType= rs.getString("TYPE");
     
         System.out.println( "Name : " + name );
         System.out.println( "Description : " + description );
         System.out.println( "priceB : " + priceBuy);
         System.out.println( "priseS : " + priceSale );
         System.out.println( "Quant : " + quantity );
         System.out.println( "Type : " + productType );
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
	public void buyProduct(String name)
	{
		Connection c = null;
	    Statement stmt = null;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection("jdbc:sqlite:product.sqlite");
	      c.setAutoCommit(false);
	      System.out.println("Opened database successfully");
	      String sql= "SELECT * FROM PRODUCTS WHERE NAME=?1;";
	      stmt = c.createStatement();
	      PreparedStatement pstmt = c.prepareStatement(sql);
	      pstmt.setString(1, name);
	      pstmt.executeUpdate();
	      
	      while ( rs.next() ) {}
	    }
	    catch{}
	    
	    	
	    }
	}
} 