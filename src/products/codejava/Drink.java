package products.codejava;

import main.codejava.Global;
import main.codejava.sizeDrink;
import main.codejava.sizePizza;


public class Drink extends Product {


    private sizeDrink sizeDrink;
    public Drink(String name, sizeDrink size, double price, double salePrice,
    		int quantity, String description) {
		this.name=name;
		this.sizeDrink=size;
		this.price=price;
		this.salePrice=salePrice;
		this.quantity=quantity;
		this.description=description;
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
	public void buy() {
		Global.moneyBuy+=this.price*this.quantity;
		
	}

	

	@Override
	public void sale(int quantity, String name) {
		// TODO Auto-generated method stub
		
	}
	
}
