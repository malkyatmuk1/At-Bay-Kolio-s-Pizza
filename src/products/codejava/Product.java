package products.codejava;

import main.codejava.sizePizza;

public abstract class Product {

    protected double price,salePrice;
    protected String name;
	protected String description;
    protected int quantity;
    
   
	
	public double getPrice () {
		return this.price;
	}
	public int getQuantity() {
		return this.quantity;
	}
	public String stringBuilder() {
		return null;
	}
	public void setPrice(double price) {
		this.price=price;
	}
	public void setQuantity(int quantity) {
		this.quantity=quantity;
	}
	public void buy() {
		
	}
	public void sale(int quantity, String name) {
		
	}
	public void wastage() {
	}
	public String getName() {
		return this.name;
	}
	public String getDescription() {
		return this.description;
	}

	public double getSalePrice() {
		return this.salePrice;
	}
	
}
