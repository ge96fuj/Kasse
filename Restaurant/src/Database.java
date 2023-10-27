
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.table.DefaultTableModel;

public class Database {
	public static void main(String args[]) {

//		createType("Pizza");

	}

	public static ArrayList<String> loadTypes() {
		ArrayList<String> result = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/resto", "root", "");
			System.out.println("Connected");

			PreparedStatement stmt = con.prepareStatement("select * from types ");

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				String name = rs.getString(1);
				result.add(name);

			}

			con.close();

		} catch (Exception e) {

//			System.out.println(e);

		}
		return result;
	}

	public static void createType(String name) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/resto", "root", "");
			System.out.println("Connected");

			PreparedStatement stmt = con.prepareStatement("INSERT INTO types(name) VALUES (?)");
			stmt.setString(1, name);

			stmt.executeUpdate();

			con.close();

		} catch (Exception e) {

		}

	}

	public static void deleteType(Object type) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/resto", "root", "");
			System.out.println("Connected");

			PreparedStatement stmt = con.prepareStatement("Delete from types where name = ?");
			stmt.setString(1, (String) type);

			stmt.executeUpdate();

			con.close();

		} catch (Exception e) {

		}

	}

	public static boolean checkType(String nameGiven) {

		// Return true when doesnt exist , false when exist

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/resto", "root", "");
			System.out.println("Connected");

			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery("select * from types");
			boolean find = true;

			String name = "";

			while (find && rs.next()) {

				name = rs.getString(1);

				if (nameGiven.equals(name))
					return false;

			}

			con.close();
			return find;
		} catch (Exception e) {

			System.out.println(e);
			return false;
		}

	}

	public static boolean check(String idgiven, String passgiven) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/resto", "root", "");
			System.out.println("Connected");

			PreparedStatement stmt = con.prepareStatement("select id , pass from user where id=? and pass=?");
			stmt.setString(1, idgiven);
			stmt.setString(2, passgiven);
			ResultSet rs = stmt.executeQuery();
			rs.next();

			String id = rs.getString(1);
			String pass = rs.getString(2);

			con.close();

			return (idgiven.equals(id) && passgiven.equals(pass));

		} catch (Exception e) {

//			System.out.println(e);
			return false;
		}

	}

	public static boolean checkifexist(String idgiven) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/resto", "root", "");
			System.out.println("Connected");

			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery("select * from user");
			boolean find = true;

			String id = "";

			while (find && rs.next()) {

				id = rs.getString(1);

				if (idgiven.equals(id))
					return false;

			}

			con.close();
			return find;
		} catch (Exception e) {

			System.out.println(e);
			return false;
		}

	}

	public static String register(String id, String pass) {

//		if (!checkifexist(id)) return "ID EXIST" ; 

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/resto", "root", "");
			System.out.println("Connected");

//			Statement stmt = con.createStatement();
			PreparedStatement stmt = con.prepareStatement("INSERT INTO user(id, pass) VALUES (?, ?)");
			stmt.setString(1, id);
			stmt.setString(2, pass);
			stmt.executeUpdate();

//			stmt.executeUpdate("INSERT INTO user(id,pass) " + "VALUES (?,?)");

//			stmt.executeUpdate("INSERT INTO user" + "VALUES ("+id+","+pass+")");
			con.close();

		} catch (Exception e) {

			System.out.println(e);

		}

		return null;
	}

	public static boolean addProduct(Product prod) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/resto", "root", "");

			PreparedStatement stmt = con
					.prepareStatement("INSERT INTO products(id, type , price , 	name) VALUES (?, ?,?,?)");
//int randomNum =  (int)(Math.random() );


Random ran = new Random();
int randomNum = ran.nextInt(100) + 5;
System.out.println(randomNum);

stmt.setInt(1, randomNum);
//			stmt.setInt(1, prod.getId());
			stmt.setString(2, prod.getType());
			stmt.setDouble(3, prod.getPrice());
			stmt.setString(4, prod.getName());

			stmt.executeUpdate();

			con.close();
			return true;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			return false;
		}

//		return false;

	}
	
	
	
	public static void removeProduct(Product p) {

		DefaultTableModel model = new DefaultTableModel(new String[][] {

		}, new String[] { "User", "PWD" });

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/resto", "root", "");
			PreparedStatement stmt = con.prepareStatement("DELETE FROM products WHERE name=?;");
			stmt.setString(1, p.getName());

			stmt.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void removeProduct(String name) {

		DefaultTableModel model = new DefaultTableModel(new String[][] {

		}, new String[] { "User", "PWD" });

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/resto", "root", "");
			PreparedStatement stmt = con.prepareStatement("DELETE FROM products WHERE name=?;");
			stmt.setString(1, name);

			stmt.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	
	
	
	
	
	
	
	
	

	public static ArrayList<Product> reloadProducts(String type) {
		ArrayList<Product> result = new ArrayList<>();
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/resto", "root", "");

			PreparedStatement stmt = con.prepareStatement("select *  from products where type = ?");
			stmt.setString(1, type);

			ResultSet rs = stmt.executeQuery();

			int id = 0;
			String name = "";
			double price = 0;

			while (rs.next()) {

				id = rs.getInt(1);
				price = rs.getDouble(3);
				name = rs.getString(4);

				System.out.println(id + " " + price + " " + type + "  " + name);

				result.add(new Product(id, price, type, name));

			}

		} catch (Exception e) {

			e.printStackTrace();
			return result;
		}

		return result;

	}
	
	
	
	
	
	
	public static ArrayList<Product> reloadProducts() {
		ArrayList<Product> result = new ArrayList<>();
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/resto", "root", "");

			PreparedStatement stmt = con.prepareStatement("select *  from products ");
//			stmt.setString(1, type);

			ResultSet rs = stmt.executeQuery();

			int id = 0;
			String name = "";
			double price = 0;
			String type = " ";

			while (rs.next()) {

				id = rs.getInt(1);
				type = rs.getString(2); 
				price = rs.getDouble(3);
				name = rs.getString(4);

				System.out.println(id + " " + price + " " + type + "  " + name);

				result.add(new Product(id, price, type, name));

			}

		} catch (Exception e) {

			e.printStackTrace();
			return result;
		}

		return result;

	}
	
	
	
	
	
	
	
	
	public static DefaultTableModel loadProducts() {

		DefaultTableModel model = new DefaultTableModel(new String[][] {

		}, new String[] { "User", "PWD" });

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/resto", "root", "");
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery("select * from user");
			while (rs.next()) {

				String id = rs.getString(1);
				String pwd = rs.getString(2);

				model.addRow(new String[] { id, pwd });

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return model;

	}
	
	
	
	

	public static DefaultTableModel loadUsers() {

		DefaultTableModel model = new DefaultTableModel(new String[][] {

		}, new String[] { "User", "PWD" });

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/resto", "root", "");
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery("select * from user");
			while (rs.next()) {

				String id = rs.getString(1);
				String pwd = rs.getString(2);

				model.addRow(new String[] { id, pwd });

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return model;

	}

	public static void removeUser(String id) {

		DefaultTableModel model = new DefaultTableModel(new String[][] {

		}, new String[] { "User", "PWD" });

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/resto", "root", "");
			PreparedStatement stmt = con.prepareStatement("DELETE FROM user WHERE id=?;");
			stmt.setString(1, id);

			stmt.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void registerCommand(Command command) {

	}

//

}
