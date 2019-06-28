package products.codejava;

public interface Product {
	public double getPrice ();
	public int getQuantity();
	public String stringBuilder();
	public void setPrice(double price) ;
	public void setQuantity(int quantity);
	public void buy();
	public void sale(int quantity, String name);
	public void wastage();
	public String getName();
	
	
}
