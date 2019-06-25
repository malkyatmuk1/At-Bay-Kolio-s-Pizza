package products.codejava;

public interface Product {
	public double getPrice ();
	public int getQuantity();
	public String stringBuilder();
	public void setPrice(double price) ;
	public void setQuantity(int quantity);
	public void buy(double price, int quantity, String name, String description);
	public void sale(int quantity, String name);
	public void wastage();
	public String getName();
	
	
}
