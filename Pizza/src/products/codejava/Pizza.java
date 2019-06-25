package products.codejava;

import main.codejava.sizePizza;

public class Pizza implements Product {

	private sizePizza size;
    private double price,salePrice;
    private String name,description;
    private int quantity;
	
    public Pizza(String name, sizePizza size, double price, double salePrice,
    		int quantity, String description) {
		this.name=name;
		this.size=size;;
		this.price=price;
		this.salePrice=salePrice;
		this.quantity=quantity;
		this.description=description;
	}
	@Override
	public double getPrice() {
		return this.price;		
	}

	@Override
	public int getQuantity() {
		return this.quantity;		
	}

	@Override
	public String stringBuilder() {		
		return null;
	}

	@Override
	public void setPrice(double price) {
        this.price=price;	
	}

	@Override
	public void setQuantity(int quantity) {
		this.quantity=quantity;	
	}
	@Override
	public void wastage() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buy(double price, int quantity, String name, String description) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sale(int quantity, String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {
		return this.name;
	}
	public sizePizza getSize() {
		return size;
	}
	public void setSize(sizePizza size) {
		this.size = size;
	}
	public double getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
