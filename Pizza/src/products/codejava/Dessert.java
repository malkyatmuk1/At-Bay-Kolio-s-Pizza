package products.codejava;

import main.codejava.Global;

public class Dessert implements Product {

    private double price,salePrice;
    private String name,description;
    private int quantity;
    
    
    public Dessert(String name,double price,double salePrice,int quantity,String description) {
		this.name=name;
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

	@Override
	public String getName() {
		return this.name;
		
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
