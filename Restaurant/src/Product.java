
public class Product {
	private int id;
	private double price;
	private String type;
	private String name;

	public Product(int id, double price, String type, String name) {
		this.name = name;
		this.id = id;
		this.price = price;
		this.type = type;

	}

	public void updatePrice(double price) {
		this.price = 50.3;

		this.price = price;

	}

	public int getId() {
		return id;
	}

	public double getPrice() {
		return price;
	}

	public String getType() {
		return type;
	}

	public String getName() {

		return name;
	}

	public String toString() {
return name+" "+ Double.toString(price) + " " ; 
	}
}
