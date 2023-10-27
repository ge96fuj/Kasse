
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import java.awt.GridLayout;
import javax.swing.ScrollPaneConstants;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Component;

public class AdminPanel {

	private JFrame frmAdminPanel;
	private JTextField idAddUserField;
	private JPasswordField passwordAddUserField;
	private static JPanel panel;
	private JTable table;
	private JButton CashierFunctionsButton;
	private Database dataBase;
	private JTextField ProductnameField;
	private JTextField priceField;
	private JTextField addTypeNameField;
	private JTable deleteProductTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPanel window = new AdminPanel();
					window.frmAdminPanel.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminPanel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		dataBase = new Database();
		frmAdminPanel = new JFrame();
		frmAdminPanel.setTitle("Admin Panel");
		frmAdminPanel.setBounds(100, 100, 1002, 566);
		frmAdminPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdminPanel.getContentPane().setLayout(null);

		JPanel MenuPanel = new JPanel();
		MenuPanel.setBorder(new EmptyBorder(1, 1, 1, 1));
		MenuPanel.setBounds(0, 0, 220, 527);
		frmAdminPanel.getContentPane().add(MenuPanel);
		MenuPanel.setLayout(null);

		JButton LogoutButton = new JButton("Log out");
		LogoutButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(1);
			}
		});
		LogoutButton.setBounds(24, 475, 186, 41);
		MenuPanel.add(LogoutButton);

		panel = new JPanel();
		panel.setBounds(222, 0, 774, 527);
		frmAdminPanel.getContentPane().add(panel);
		panel.setLayout(new CardLayout(0, 0));

		JPanel DefaultPanel = new JPanel();
		panel.add(DefaultPanel, "name_622477414658900");
		DefaultPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\MSI\\Pictures\\preview-page0.jpg"));
		lblNewLabel.setBounds(81, 10, 611, 494);
		DefaultPanel.add(lblNewLabel);

		JPanel usersPanel = new JPanel();
		panel.add(usersPanel, "name_622889703720800");
		usersPanel.setLayout(null);

		JPanel addUser = new JPanel();
		addUser.setBounds(538, 11, 226, 505);
		usersPanel.add(addUser);
		addUser.setLayout(null);

		idAddUserField = new JTextField();
		idAddUserField.setColumns(10);
		idAddUserField.setBounds(46, 100, 170, 32);
		addUser.add(idAddUserField);

		passwordAddUserField = new JPasswordField();
		passwordAddUserField.setBounds(50, 205, 166, 32);
		addUser.add(passwordAddUserField);

		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(0, 100, 36, 32);
		addUser.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("PWD");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(0, 209, 55, 23);
		addUser.add(lblNewLabel_2);

		JButton addUserButton = new JButton("Add User");
		addUserButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String id = idAddUserField.getText();
				String pwd = passwordAddUserField.getText();

				if (id.isEmpty() || pwd.isEmpty()) {
					JOptionPane.showMessageDialog(frmAdminPanel, "ID OR MDP IS EMPTY ", "Login Failed",
							JOptionPane.ERROR_MESSAGE);
				} else if (!Database.checkifexist(id)) {
					JOptionPane.showMessageDialog(frmAdminPanel, "USERNAME EXIST , PLEASE CHANGE ANOTHER USERNAME",
							"Login Failed", JOptionPane.ERROR_MESSAGE);

				} else if (Database.checkifexist(id)) {
					Database.register(id, pwd);
					JOptionPane.showMessageDialog(frmAdminPanel, "REGISTRED ", "Login Failed",
							JOptionPane.INFORMATION_MESSAGE);

				}

			}
		});
		addUserButton.setBounds(60, 305, 115, 53);
		addUser.add(addUserButton);

		JLabel lblNewLabel_3 = new JLabel("ADD USER");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(30, 11, 160, 53);
		addUser.add(lblNewLabel_3);

		JPanel deleteUserPanel = new JPanel();
		deleteUserPanel.setBounds(0, 0, 535, 516);
		usersPanel.add(deleteUserPanel);
		deleteUserPanel.setLayout(null);

		JLabel lblNewLabel_3_1 = new JLabel("DELETE USER");
		lblNewLabel_3_1.setBounds(174, 24, 154, 47);
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		deleteUserPanel.add(lblNewLabel_3_1);

		JPanel tablepanel = new JPanel();
		tablepanel.setBounds(1, 1, 496, 400);
		deleteUserPanel.add(tablepanel);

		JScrollPane scrollPane = new JScrollPane(tablepanel);
		scrollPane.setBounds(10, 130, 515, 308);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		tablepanel.setLayout(new GridLayout(0, 1, 0, 0));

		table = new JTable();
		table.setSurrendersFocusOnKeystroke(true);
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		table.setModel(new DefaultTableModel(new Object[][] { { "ID", "PWD" }, },
				new String[] { "New column", "New column" }));
		tablepanel.add(table);
		deleteUserPanel.add(scrollPane);

		JButton deleteUserButton = new JButton("Delete");
		deleteUserButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int selectedRows = table.getSelectedRow();
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				String id = (String) model.getValueAt(selectedRows, 0);

				int input = JOptionPane.showConfirmDialog(null, "YOU CONFIRM THE DELTE OF USER " + id + " ?");
				if (input == 0) {

					model.removeRow(selectedRows);
					Database.removeUser(id);
					table.setModel(dataBase.loadUsers());

				}

			}
		});
		deleteUserButton.setBounds(213, 449, 126, 36);
		deleteUserPanel.add(deleteUserButton);

		JButton LoadUsersPannel = new JButton("LOAD");
		LoadUsersPannel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.setModel(Database.loadUsers());
			}
		});
		LoadUsersPannel.setBounds(456, 469, 69, 36);
		deleteUserPanel.add(LoadUsersPannel);
//		deleteUserPanel.add(scrollPane);

		JPanel addAdminPanel = new JPanel();
		panel.add(addAdminPanel, "name_622894333421300");

		JPanel addProductPanel = new JPanel();
		panel.add(addProductPanel, "name_622896612631600");
		addProductPanel.setLayout(null);

		ProductnameField = new JTextField();
		ProductnameField.setBounds(38, 69, 143, 44);
		addProductPanel.add(ProductnameField);
		ProductnameField.setColumns(10);

		priceField = new JTextField();
		priceField.setBounds(391, 69, 73, 44);
		addProductPanel.add(priceField);
		priceField.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Product Name");
		lblNewLabel_4.setBounds(66, 36, 115, 23);
		addProductPanel.add(lblNewLabel_4);

		JLabel lblNewLabel_4_1 = new JLabel("Product Type");
		lblNewLabel_4_1.setBounds(241, 36, 115, 23);
		addProductPanel.add(lblNewLabel_4_1);

		JLabel lblNewLabel_5 = new JLabel("Price");
		lblNewLabel_5.setBounds(409, 41, 45, 13);
		addProductPanel.add(lblNewLabel_5);

		JComboBox productTypeBox = new JComboBox();
		productTypeBox.setModel(new DefaultComboBoxModel(new String[] { "Pizza", "Burger", "Drinks" }));
		productTypeBox.setBounds(251, 69, 81, 44);
		addProductPanel.add(productTypeBox);

		JPanel addTypePanel = new JPanel();
		addTypePanel.setBounds(10, 252, 369, 265);
		addProductPanel.add(addTypePanel);
		addTypePanel.setLayout(null);

		JButton addProductBut = new JButton("ADD");
		addProductBut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String productName = ProductnameField.getText();
				Object[] type = productTypeBox.getSelectedObjects();
				String price = priceField.getText();
				double priceInDouble = Double.valueOf(price);
				Database.addProduct(new Product(70, priceInDouble, (String) type[0], productName));

				JOptionPane.showMessageDialog(frmAdminPanel, "Product CREATED ", "Successful ",
						JOptionPane.INFORMATION_MESSAGE);

			}
		});

		addProductBut.setBounds(542, 68, 132, 44);
		addProductPanel.add(addProductBut);

		addTypeNameField = new JTextField();
		addTypeNameField.setBounds(44, 170, 119, 38);
		addTypeNameField.setColumns(10);
		addTypePanel.add(addTypeNameField);

		JPanel deleteTypePanel = new JPanel();
		deleteTypePanel.setBounds(381, 252, 383, 265);
		addProductPanel.add(deleteTypePanel);
		deleteTypePanel.setLayout(null);

		JComboBox deleteTypeBox = new JComboBox();
		deleteTypeBox.setBounds(73, 166, 121, 42);
		deleteTypePanel.add(deleteTypeBox);

		JButton typeAddButt = new JButton("ADD TYPE");
		typeAddButt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (Database.checkType(addTypeNameField.getText())) {

					Database.createType(addTypeNameField.getText());

					productTypeBox.setModel(refreshTypes());
					deleteTypeBox.setModel(refreshTypes());

					JOptionPane.showMessageDialog(frmAdminPanel, "TYPE CREATED ", "Successful ",
							JOptionPane.INFORMATION_MESSAGE);

				}

				else {

					JOptionPane.showMessageDialog(frmAdminPanel, "TYPE ALREADY EXIST ", "Failed",
							JOptionPane.ERROR_MESSAGE);

				}

			}
		});

		typeAddButt.setBounds(196, 169, 97, 38);
		addTypePanel.add(typeAddButt);

		JLabel lblNewLabel_6 = new JLabel("ADD TYPE");
		lblNewLabel_6.setBounds(144, 78, 77, 19);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		addTypePanel.add(lblNewLabel_6);

		JLabel TypeNameLabel = new JLabel("Type Name");
		TypeNameLabel.setBounds(58, 137, 119, 23);
		addTypePanel.add(TypeNameLabel);

		JLabel deleteTypeLabel = new JLabel("DELETE TYPE");
		deleteTypeLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		deleteTypeLabel.setBounds(139, 59, 113, 53);
		deleteTypePanel.add(deleteTypeLabel);

		JButton btnNewButton = new JButton("DELETE TYPE");

		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				Object[] type = deleteTypeBox.getSelectedObjects();

				int input = JOptionPane.showConfirmDialog(null, "YOU CONFIRM THE DELETE OF TYPE " + type[0] + " ?");
				if (input == 0) {

					Database.deleteType(type[0]);
					deleteTypeBox.setModel(refreshTypes());
					productTypeBox.setModel(refreshTypes());

					JOptionPane.showMessageDialog(frmAdminPanel, "TYPE DELETED ", null,
							JOptionPane.INFORMATION_MESSAGE);

				}

			}
		});
		btnNewButton.setBounds(241, 169, 93, 36);
		deleteTypePanel.add(btnNewButton);

		JPanel deleteProductPanel = new JPanel();
		panel.add(deleteProductPanel, "name_622900221828400");
		deleteProductPanel.setLayout(null);

		JPanel deleteProductTablePanel = new JPanel();
		deleteProductTablePanel.setBounds(1, 1, 446, 372);
		deleteProductPanel.add(deleteProductTablePanel);
		deleteProductTablePanel.setLayout(new GridLayout(0, 1, 0, 0));

		deleteProductTable = new JTable();
		deleteProductTable.setCellSelectionEnabled(true);
		deleteProductTable.setColumnSelectionAllowed(true);
		deleteProductTable.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "New column", "New column", "New column" }));
		deleteProductTablePanel.add(deleteProductTable);

		JScrollPane scrollPane_1 = new JScrollPane(deleteProductTablePanel);
		scrollPane_1.setBounds(186, 40, 448, 374);
		deleteProductPanel.add(scrollPane_1);

		JButton deleteProductBut = new JButton("DELETE");
		deleteProductBut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				;
				DefaultTableModel model = (DefaultTableModel) deleteProductTable.getModel();
//				DefaultTableModel model = new DefaultTableModel() ; 

				String id = (String) model.getValueAt(deleteProductTable.getSelectedRow(), 0);

				int input = JOptionPane.showConfirmDialog(null, "YOU CONFIRM THE DELTE OF USER " + id + " ?");
				if (input == 0) {

					model.removeRow(deleteProductTable.getSelectedRow());
					Database.removeProduct(id);
					deleteProductTable.setModel(refreshProducts());

				}
			}
		});
		deleteProductBut.setBounds(346, 442, 161, 44);
		deleteProductPanel.add(deleteProductBut);

		JButton loadProductButton = new JButton("LOAD");
		loadProductButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		loadProductButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				deleteProductTable.removeAll();
//			
//				
//				DefaultTableModel modeltmp = refreshProducts();
//			
//				deleteProductTable.setModel(modeltmp);

				deleteProductTable.setModel(refreshProducts());

			}
		});
		loadProductButton.setBounds(644, 65, 94, 44);
		deleteProductPanel.add(loadProductButton);

		JPanel cashierFunctionsPanel = new JPanel();
		panel.add(cashierFunctionsPanel, "name_622901542764500");
		cashierFunctionsPanel.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("Close Cashier");
		btnNewButton_2.setBounds(292, 31, 156, 49);
		cashierFunctionsPanel.add(btnNewButton_2);

		JButton modifyUsers = new JButton("Modify Users");
		modifyUsers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				panel.removeAll();
				panel.add(usersPanel);
				panel.repaint();
				panel.revalidate();

			}
		});

		modifyUsers.setBounds(47, 101, 119, 41);
		MenuPanel.add(modifyUsers);

		JButton addAdminButton = new JButton("Add Admin");
		addAdminButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				panel.removeAll();
				panel.add(addAdminPanel);
				panel.repaint();
				panel.revalidate();

			}
		});
		addAdminButton.setBounds(47, 153, 119, 41);
		MenuPanel.add(addAdminButton);

		JButton addProductButton = new JButton("Add Product");
		addProductButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				panel.removeAll();
				panel.add(addProductPanel);
				panel.repaint();
				panel.revalidate();

				DefaultComboBoxModel model = refreshTypes();

				productTypeBox.setModel(model);
				deleteTypeBox.setModel(model);

			}
		});
		addProductButton.setBounds(47, 204, 119, 41);
		MenuPanel.add(addProductButton);

		JButton deleteProductButton = new JButton("Delete Product");
		deleteProductButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel.removeAll();
				panel.add(deleteProductPanel);
				panel.repaint();
				panel.revalidate();
			}
		});
		deleteProductButton.setBounds(47, 256, 119, 41);
		MenuPanel.add(deleteProductButton);

		CashierFunctionsButton = new JButton("Cashier Functions");
		CashierFunctionsButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				panel.removeAll();
				panel.add(cashierFunctionsPanel);
				panel.repaint();
				panel.revalidate();

			}

		});

		CashierFunctionsButton.setBounds(47, 308, 119, 41);
		MenuPanel.add(CashierFunctionsButton);
		
		JLabel lblNewLabel_7 = new JLabel("Username :");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(10, 10, 179, 41);
		MenuPanel.add(lblNewLabel_7);

	}

	private DefaultComboBoxModel refreshTypes() {

		DefaultComboBoxModel model = new DefaultComboBoxModel();

		ArrayList<String> typesNames = Database.loadTypes();

		for (String s : typesNames) {

			model.addElement(s);

		}

		return model;

	}

	private DefaultTableModel refreshProducts() {
		DefaultTableModel model = new DefaultTableModel(new String[][] {

		}, new String[] { "Name", "type", "Price" });

//		DefaultTableModel model = (DefaultTableModel) deleteProductTable.getModel();
//		DefaultTableModel model = new DefaultTableModel(); 

		ArrayList<Product> productNames = Database.reloadProducts();

		for (Product p : productNames) {

			String name = p.getName();
			String price = Double.toString(p.getPrice());
			String type = p.getType();

			model.addRow(new String[] { name, type, price });

		}

		return model;

	}
}
