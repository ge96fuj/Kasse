import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.ScrollPaneConstants;

import java.awt.CardLayout;
import java.awt.BorderLayout;
import javax.swing.JLayeredPane;
import java.awt.SystemColor;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import java.awt.Component;
import javax.swing.JDesktopPane;
import javax.swing.JScrollBar;
import javax.swing.Box;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;
import java.awt.GridLayout;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JFormattedTextField;
import javax.swing.JToggleButton;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JMenu;

public class offPage {
	private static ArrayList<Product> pizzaProducts;
//	private static ArrayList<Product> BasketProducts = new ArrayList<>();
	private static ArrayList<Product> burgerProducts = new ArrayList<>();
	private static Basket basket;
	private static Database database = new Database();
	private static double total;
	private static JFrame frame;
	private final JPanel menuPanel = new JPanel();
	private JTextPane SumPane;
	private static DefaultTableModel modell;
	private String user ; 
	private static JPanel CardPanel ; 

	
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		pizzaProducts = database.reloadProducts("pizza");
		burgerProducts = database.reloadProducts("burger");
//		System.out.println(pizzaProducts);
//		BasketProducts = new ArrayList<>();

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					offPage window = new offPage();
					window.frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		while (true) {
		}

	}

	/**
	 * Create the application.
	 */
	public offPage() {
		initialize();
	}

	
	public offPage(String user) {
		this.user=user ; 
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 * @return 
	 */
	JFrame initialize() {
		burgerProducts = database.reloadProducts("burger");
		pizzaProducts = database.reloadProducts("pizza");
		total = 0;
		modell = new DefaultTableModel(new String[][] {

		}, new String[] { "Article", "Quantity", "Price" });

		basket = new Basket(table);

		frame = new JFrame();
		frame.setBounds(100, 100, 1450, 792);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		menuPanel.setBackground(UIManager.getColor("info"));
		menuPanel.setBounds(0, 0, 192, 731);
		frame.getContentPane().add(menuPanel);
		menuPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Pizza");
		lblNewLabel.setBackground(UIManager.getColor("info"));

		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Bookman Old Style", Font.PLAIN, 34));
		lblNewLabel.setForeground(UIManager.getColor("desktop"));
		lblNewLabel.setBounds(18, 28, 117, 46);

		JLabel lblNewLabel_1 = new JLabel("Burger");

		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Bookman Old Style", Font.PLAIN, 34));
		lblNewLabel_1.setForeground(UIManager.getColor("menuPressedItemB"));
		lblNewLabel_1.setBounds(24, 107, 125, 54);

		 CardPanel = new JPanel();
		CardPanel.setBounds(192, 0, 876, 731);
		frame.getContentPane().add(CardPanel);
		CardPanel.setLayout(new CardLayout(0, 0));
/// JPANEL PRODUCTS LOAD 
		JPanel PizzaPanel = new JPanel();

		CardPanel.add(PizzaPanel, "name_530528211034100");

		JScrollPane PizzaPaneloff = new JScrollPane(PizzaPanel);
		PizzaPanel.setLayout(new GridLayout(0, 2, 0, 0));

		CardPanel.add(PizzaPaneloff, BorderLayout.CENTER);

		JPanel Burgerpanel = new JPanel();
		CardPanel.add(Burgerpanel, "name_530747437858800");

		JScrollPane BurgerPaneloff = new JScrollPane(Burgerpanel);
		Burgerpanel.setLayout(new GridLayout(1, 0, 0, 0));
		CardPanel.add(BurgerPaneloff, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		CardPanel.add(panel, "name_1125658213487400");
		panel.setLayout(null);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		mntmNewMenuItem.setBounds(0, 0, 437, 729);
		panel.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("New menu item");
		mntmNewMenuItem_3.setBounds(0, 0, 437, 364);
		panel.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("New menu item");
		mntmNewMenuItem_2.setBounds(0, 0, 437, 364);
		panel.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("New menu item");
		mntmNewMenuItem_1.setBounds(0, 0, 437, 364);
		panel.add(mntmNewMenuItem_1);

		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CardPanel.removeAll();
				CardPanel.add(PizzaPaneloff);
				CardPanel.repaint();
				CardPanel.revalidate();
			}
		});

		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CardPanel.removeAll();
				CardPanel.add(Burgerpanel);
				CardPanel.repaint();
				CardPanel.revalidate();
			}
		});

		menuPanel.add(lblNewLabel);
		menuPanel.add(lblNewLabel_1);

		JLabel lblNewLabel_6 = new JLabel("Drinks");
		lblNewLabel_6.setFont(new Font("Bookman Old Style", Font.PLAIN, 34));
		lblNewLabel_6.setForeground(UIManager.getColor("infoText"));
		lblNewLabel_6.setBounds(32, 199, 117, 32);
		menuPanel.add(lblNewLabel_6);

		JPanel rightPanel = new JPanel();
		rightPanel.setBounds(1069, 0, 365, 731);
		frame.getContentPane().add(rightPanel);
		rightPanel.setLayout(null);

		JPanel BuyPanel = new JPanel();
		BuyPanel.setBounds(0, 637, 315, 94);
		rightPanel.add(BuyPanel);
		BuyPanel.setLayout(null);

		JPanel BasketPanel = new JPanel();
		BasketPanel.setBounds(0, 0, 315, 636);
		rightPanel.add(BasketPanel);

		JScrollPane scrollPane = new JScrollPane(BasketPanel);
		BasketPanel.setLayout(new GridLayout(1, 0, 0, 0));

		table = new JTable();
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);

		table.setModel(modell);

		JButton deleteBasket = new JButton("Delete");
		deleteBasket.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int selectedRows = table.getSelectedRow();
//				   DefaultTableModel model = (DefaultTableModel) table.getModel();
				String productName = (String) modell.getValueAt(selectedRows, 0);

				modell.removeRow(selectedRows);
				refreshSumPane();

			}
		});
		deleteBasket.setBounds(242, 11, 63, 17);
		BuyPanel.add(deleteBasket);

		SumPane = new JTextPane();
		SumPane.setBounds(60, 8, 88, 20);
		BuyPanel.add(SumPane);

		JLabel lblNewLabel_2 = new JLabel("TOTAL");
		lblNewLabel_2.setFont(new Font("Urdu Typesetting", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(0, 1, 72, 28);
		BuyPanel.add(lblNewLabel_2);

		JButton commandButton = new JButton("Command");
		commandButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				refreshSumPane() ; 
				 int input = JOptionPane.showConfirmDialog(null, "Command with total : " +total+" the command ? ");
				
				if (input==0) {
					
					Command currentCommand = new Command(basket) ; 
					Database.registerCommand(currentCommand) ; 
					//ne9es print 
					modell = new DefaultTableModel(new String[][] {

					}, new String[] { "Article", "Quantity", "Price" });
					table.setModel(modell);
					basket = new Basket(table); 
					refreshSumPane() ; 
					
				}
				
			}
		});
		commandButton.setBackground(Color.GREEN);
		commandButton.setForeground(Color.BLACK);
		commandButton.setBounds(10, 39, 165, 44);
		BuyPanel.add(commandButton);

		JLabel lblNewLabel_3 = new JLabel("R");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				refreshSumPane();
			}
		});
		lblNewLabel_3.setBackground(UIManager.getColor("List.selectionBackground"));
		lblNewLabel_3.setBounds(178, 12, 31, 17);
		BuyPanel.add(lblNewLabel_3);
		
		JLabel userLabel = new JLabel(user);
		userLabel.setBounds(199, 54, 88, 29);
		BuyPanel.add(userLabel);

		table.getColumnModel().getColumn(0).setPreferredWidth(154);
		table.getColumnModel().getColumn(1).setPreferredWidth(26);
		table.getColumnModel().getColumn(2).setPreferredWidth(50);
		BasketPanel.add(table);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		scrollPane.setBounds(0, 0, 305, 636);
		rightPanel.add(scrollPane);

		for (Product p : pizzaProducts) {
			JButton prodButton = new JButton(p.getName());
			JLabel label = new JLabel(p.getName());
			prodButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {

					toBasket(p);
					refreshSumPane();
				}
			});

			PizzaPanel.add(prodButton);

		}
		
		
		
		
		
		for (Product p : burgerProducts) {
			JButton prodButton = new JButton(p.getName());
			JLabel label = new JLabel(p.getName());
			prodButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {

					toBasket(p);
					refreshSumPane();
				}
			});

			Burgerpanel.add(prodButton);

		}
		return frame;
		
		
		
		
		

	}

	private void toBasket(Product p) {

		basket.addItem(p);
		total = basket.getTotalPrice();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.addRow(new String[] { p.getName(), "1", Double.toString(p.getPrice()) });

		total = basket.getSumFromTable(table);
	}

	private void refreshSumPane() {
		total = basket.getSumFromTable(table);
		SumPane.setText(Double.toString(total));

	}
}
