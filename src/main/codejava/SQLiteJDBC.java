package main.codejava;

import java.sql.*;

import products.codejava.Pizza;
import products.codejava.Product;

public class SQLiteJDBC {
	public static void main( String args[] ) {
		connectDB();
		createTable();
		Product product=new Pizza("Piza", sizePizza.Italian, 136.6, 167.6, 15,"mn qko");
	//insertType();
    //selectDB();
		//buyProduct(product,2);
		
       // insertProduct(product,"pizza");  
    //System.out.println(checkCostsMoney());
	       

	     
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
                      " INCOME           REAL  DEFAULT 0  NOT NULL, " + 
                      " COSTS            REAL  DEFAULT 0    NOT NULL )" ; 
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
	public static void insertProduct(Product product,String productType)
	{
		Boolean flag=false;
		Connection c = null;
		try {
			c = DriverManager.getConnection("jdbc:sqlite:product.sqlite");
		
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		  
		try { 
			
		String sqlSelect= "SELECT * FROM PRODUCTS WHERE NAME=?1";
		  PreparedStatement pstmtSelect = c.prepareStatement(sqlSelect);
 
		  ResultSet rs;
		  pstmtSelect.setString(1, product.getName());
		  rs=pstmtSelect.executeQuery();
		  while(rs.next()){
	 
			  if(rs.getString("NAME").equals(product.getName()))
			  {
				  String sqlUpdateString="UPDATE PRODUCTS set QUANTITY = ?1 WHERE NAME=?2";
				 PreparedStatement pstmt = c.prepareStatement(sqlUpdateString);
				  pstmt.setInt(1, rs.getInt("QUANTITY")+product.getQuantity());
				  pstmt.setString(2, rs.getString("NAME"));
				 pstmt.executeUpdate();
				 flag=true;
			  }
		  }
	
		} catch (SQLException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(!flag) {
		  
		
	     String sql = "INSERT INTO PRODUCTS(name,description, priceBuy, priceSale, quantity, Type) VALUES(?1,?2,?3,?4,?5,?6)";
	     
	        try  {
	                PreparedStatement pstmt = c.prepareStatement(sql);
	            pstmt.setString(1, product.getName());
	            pstmt.setString(2, product.getDescription());
	            pstmt.setDouble(3,product.getPrice());
	            pstmt.setDouble(4,product.getSalePrice());
	            pstmt.setInt(5, product.getQuantity());
	            pstmt.setString(6, productType);
	            pstmt.executeUpdate();
	            
	            c.close();
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	        System.out.println("Records created successfully");
	        
		}    
		moneyUpdateBuy(product.getQuantity(), product.getPrice());
		
		
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
	public static void buyProduct(Product product, int quantityForSale)

	{
		Connection c = null;
	    Statement stmt = null;
	    
	      try {
			Class.forName("org.sqlite.JDBC");
			  c = DriverManager.getConnection("jdbc:sqlite:product.sqlite");
		
			  System.out.println("Opened database successfully");
			  String sql= "SELECT IDPRODUCT,quantity FROM PRODUCTS WHERE NAME=?1 ;";
			  stmt = c.createStatement();
			  PreparedStatement pstmt = c.prepareStatement(sql);
			  pstmt.setString(1, product.getName());
			  ResultSet rs;
			  rs=pstmt.executeQuery();
			  
			pstmt.clearBatch();
			int id=rs.getInt(1);
			         int quantity=rs.getInt(2);
			      
			     sql="UPDATE PRODUCTS set QUANTITY = ?1 where IDPRODUCT=?2 ";
			     pstmt = c.prepareStatement(sql);
				  pstmt.setInt(1, quantity-quantityForSale);
				  pstmt.setInt(2, id);
				 pstmt.executeUpdate();
				 
				  sql= "SELECT * FROM PRODUCTS WHERE NAME=?1;";
				  stmt = c.createStatement();
				  pstmt = c.prepareStatement(sql);
				  pstmt.setString(1, product.getName());
				 rs=pstmt.executeQuery();
				  while ( rs.next() ) {
				         
				         String  nameString = rs.getString("NAME");
				         String description= rs.getString("DESCRIPTION");
				         Double priceBuy=rs.getDouble(4);
				         Double priceSale=rs.getDouble(5);
				         int quantityInt=rs.getInt(6);
				         String productType= rs.getString("TYPE");
				     
				         System.out.println( "Name : " + nameString );
				         System.out.println( "Description : " + description );
				         System.out.println( "priceB : " + priceBuy);
				         System.out.println( "priseS : " + priceSale );
				         System.out.println( "Quant : " + quantityInt );
				         System.out.println( "Type : " + productType );
				         System.out.println();
				         
				      }
				  c.close();
				  moneyUpdateSale(quantityForSale, product.getSalePrice());
				  
			         			  
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    
	    
	    	
	    }
	public static void moneyUpdateBuy(int quantity,double priceBuy) {
		Connection c=null;
		Statement stmt= null;
		try {
	      Class.forName("org.sqlite.JDBC"); 
		  c = DriverManager.getConnection("jdbc:sqlite:product.sqlite");
		  System.out.println("Opened database successfully");
		  stmt = c.createStatement();
	      ResultSet rs = stmt.executeQuery( "SELECT COSTS FROM MONEY;" );
	      double costs=0;
	      while(rs.next()) costs=rs.getDouble(1);
	      System.out.println(costs+quantity*priceBuy);
	     rs.close();
	     stmt.close();
		 String sql="UPDATE MONEY set COSTS = ?1 ";
	     PreparedStatement pstmt = c.prepareStatement(sql);
	     costs+=quantity*priceBuy;
		 pstmt.setDouble(1, costs);
		 pstmt.executeUpdate();
		 pstmt.close();
		 c.close();
		 
		}catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void moneyUpdateSale(int quantity,double priceSale) {
		Connection c=null;
		Statement stmt= null;
		try {
	      Class.forName("org.sqlite.JDBC"); 
		  c = DriverManager.getConnection("jdbc:sqlite:product.sqlite");
		  System.out.println("Opened database successfully");
		  stmt = c.createStatement();
	      ResultSet rs = stmt.executeQuery( "SELECT INCOME FROM MONEY;" );
	      double income=0;
	      income=rs.getDouble(1);
	     rs.close();
	     stmt.close();
		 String sql="UPDATE MONEY set INCOME = ?1 ";
	     PreparedStatement pstmt = c.prepareStatement(sql);
		 pstmt.setDouble(1, income+quantity*priceSale);
		 pstmt.executeUpdate();
		 c.close();
		}catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static double checkCostsMoney()
	{
		Connection c=null;
		Statement stmt=null;
		ResultSet rs;
		double costs=0;
		try {
			Class.forName("org.sqlite.JDBC");
			 c = DriverManager.getConnection("jdbc:sqlite:product.sqlite");
			  System.out.println("Opened database successfully");
			  stmt = c.createStatement();
			  rs = stmt.executeQuery( "SELECT COSTS FROM MONEY" );
			  while(rs.next()) costs=rs.getDouble("1");
			  
			  rs.close();
			  stmt.close();
			  c.close();
		} 
		 catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return costs;
		
	}
	public static double checkIncomeMoney()
	{
		Connection c=null;
		Statement stmt=null;
		double income=0;
		try {
			Class.forName("org.sqlite.JDBC");
			 c = DriverManager.getConnection("jdbc:sqlite:product.sqlite");
			  System.out.println("Opened database successfully");
			  stmt = c.createStatement();
			  ResultSet rs = stmt.executeQuery( "SELECT INCOME FROM MONEY;" );
			  income=rs.getDouble("INCOME");
			  rs.close();
		} 
		 catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return income;
		
	}
}
