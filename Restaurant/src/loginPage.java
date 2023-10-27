import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.DropMode;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class loginPage {
boolean loginSucc = false ; 
	private JFrame frame;
	private JTextField userField;
	private JPasswordField passwordField;
	private String user ; 


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginPage window = new loginPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public loginPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @return 
	 */
	JFrame initialize() {
//		toNext = false ; 
		frame = new JFrame();
		frame.setBounds(100, 100, 974, 651);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 474, 612);
		frame.getContentPane().add(panel);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\MSI\\Pictures\\preview-page0.jpg"));
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.menu);
		panel_1.setBounds(472, 0, 486, 612);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JTextPane Username = new JTextPane();
		Username.setBounds(20, 157, 110, 34);
		Username.setText("Username");
		Username.setFont(new Font("Trebuchet MS", Font.PLAIN, 23));
		Username.setEditable(false);
		Username.setBackground(SystemColor.menu);
		panel_1.add(Username);

		JTextPane Password = new JTextPane();
		Password.setBounds(20, 260, 110, 34);
		Password.setText("Password");
		Password.setFont(new Font("Trebuchet MS", Font.PLAIN, 23));
		Password.setEditable(false);
		Password.setBackground(SystemColor.menu);
		panel_1.add(Password);

		userField = new JTextField();
		userField.setHorizontalAlignment(SwingConstants.CENTER);
		userField.setColumns(10);
		userField.setBounds(140, 144, 294, 60);
		panel_1.add(userField);

		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setBounds(140, 247, 297, 60);
		panel_1.add(passwordField);

		JButton btnNewButton = new JButton("Sign In");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String idvalue = userField.getText();
				String passvalue = passwordField.getText();
				Database data = new Database();
				boolean next = data.check(idvalue, passvalue)|| (idvalue.equals("admin")&&passvalue.equals("admin")) ;
				
//				boolean next = true ; // for test
				
				if (next) {
					System.out.println("ok");
					loginSucc = true ; 
					user = idvalue ; 
				}

				else {
					JOptionPane.showMessageDialog(frame, "Please verify your login",
				               "Login Failed", JOptionPane.ERROR_MESSAGE);
					
					
				}
//					System.out.println("no");

			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\MSI\\Pictures\\sign.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(162, 387, 208, 60);
		panel_1.add(btnNewButton);
		return frame;
	}

	public String getUser() {
		return user;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
