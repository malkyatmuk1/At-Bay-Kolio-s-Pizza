package products.codejava;

import main.codejava.Global;

public class Dessert extends Product {

    
    
    
    public Dessert(String name,double price,double salePrice,int quantity,String description) {
		this.name=name;
		this.price=price;
		this.salePrice=salePrice;
		this.quantity=quantity;
		this.description=description;
	}
	

	@Override
	public void buy() {
		Global.moneyBuy+=this.price*this.quantity;
	}

	@Override
	public void sale(int quantity, String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void wastage() {
		// TODO Auto-generated method stub
		
	}

	

	}
