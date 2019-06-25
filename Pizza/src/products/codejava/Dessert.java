package products.codejava;



public class Dessert implements Product {

    private double price,priceForSell;
    private String name,description;
    private int quantity;
    
    
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
	public void buy(double price, int quantity, String name, String description) {
				
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


	}
