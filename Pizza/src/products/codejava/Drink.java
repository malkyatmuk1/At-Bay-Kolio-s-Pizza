package products.codejava;

import main.codejava.sizeDrink;
import main.codejava.sizePizza;


public class Drink implements Product {

	private sizeDrink size;
    private double price,salePrice;
    private String name,description;
    private int quantity;
    
    public Drink(String name, sizeDrink size, double price, double salePrice,
    		int quantity, String description) {
		this.name=name;
		this.size=size;
		this.price=price;
		this.salePrice=salePrice;
		this.quantity=quantity;
		this.description=description;
	}
    @Override
	public String getName() {
    	return this.name;
	}
    
	@Override
	public String stringBuilder() {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public void wastage() {
		// TODO Auto-generated method stub
	}

	@Override
	public double getPrice() {
		return this.price;
	}
	@Override
	public void setPrice(double price) {
		this.price=price;
		
	}


	@Override
	public int getQuantity() {

		return this.quantity;
	}

	@Override
	public void setQuantity(int quantity) {
		this.quantity=quantity;
		
	}

	@Override
	public void buy(double price, int quantity, String name, String description) {
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public void sale(int quantity, String name) {
		// TODO Auto-generated method stub
		
	}

}
