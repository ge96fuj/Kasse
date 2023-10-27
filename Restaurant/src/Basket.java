import java.util.ArrayList;

import javax.swing.JTable;

public class Basket {
	private double totalPrice;
	private ArrayList<Product> productInBasket;
	private JTable table;

	public Basket(JTable table) {
		productInBasket = new ArrayList<>();
		this.table = table;

	}

	public void calculateSum() {
		totalPrice = 0;
		for (Product p : productInBasket) {
			totalPrice += p.getPrice();

		}

	}

	public void addItem(Product p) {

		productInBasket.add(p);
		calculateSum();

	}

	public void deleteItem(int index) {
		productInBasket.remove(index);
		calculateSum();

	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public ArrayList<Product> getProductInBasket() {
		return productInBasket;
	}

	public double getSumFromTable(JTable table) {
		int length = table.getModel().getRowCount();
		int col = 3;
		int sum = 0;
		for (int i = 0; i < length; i++) {
			
			Double quantity = Double.valueOf((String) table.getModel().getValueAt(i, 1)) ;
			double price = Double.valueOf((String) table.getModel().getValueAt(i, 2)) ; 

			sum += price * quantity;

		}
	

		return sum;

	}

}
