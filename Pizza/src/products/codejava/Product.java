package products.codejava;

import main.codejava.sizePizza;

public abstract class Product {
	private sizePizza size;
    private double price,salePrice;
    private String name,description;
    private int quantity;
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
		return null;
	}
	
	
}
