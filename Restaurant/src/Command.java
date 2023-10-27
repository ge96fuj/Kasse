import java.util.ArrayList;

public class Command {
	private int id;
	private float totalPrice;
	private ArrayList<Product> listOfProduct = new ArrayList<>();

	private Basket basket;

	public Command(Basket basket) {

		this.basket = basket;

	}

	public Command(int id, float price, ArrayList list) {
		this.id = id;
		totalPrice = price;
		listOfProduct = list;

	}

}
