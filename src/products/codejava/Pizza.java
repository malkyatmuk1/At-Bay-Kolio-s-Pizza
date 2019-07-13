package products.codejava;

import main.codejava.Global;
import main.codejava.sizePizza;

public class Pizza extends Product {

	private sizePizza size;

 	
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
	public String stringBuilder() {		
		return null;
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
	public void buy() {
		Global.moneyBuy+=this.price*this.quantity;
		
	}

	@Override
	public void sale(int quantity, String name) {
		// TODO Auto-generated method stub
		
	}

	
}
