package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel lblUsername;
	private JLabel lblPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 573, 383);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(209, 161, 146, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(209, 221, 146, 26);
		contentPane.add(passwordField);
		
		lblUsername = new JLabel("Username");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setBounds(62, 164, 99, 20);
		contentPane.add(lblUsername);
		
		lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setBounds(62, 221, 69, 20);
		contentPane.add(lblPassword);
		
		JButton btnEntry = new JButton("Entry");
		btnEntry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String textoUsuario = textField.getText();
				String passwordUsuario = passwordField.getText();
				
				if(textoUsuario.equals("admin") && passwordUsuario.equals("admin")){
					VentanaAdmin ventAd = new VentanaAdmin();
					ventAd.setVisible(true);
					Login.this.setVisible(false);
				}
				else{
					JOptionPane.showMessageDialog(Login.this, "Error 303");
				}
			}
		});
		btnEntry.setBounds(226, 282, 115, 29);
		contentPane.add(btnEntry);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setBounds(240, 92, 69, 20);
		contentPane.add(lblLogin);
		
		JLabel lblGangasCar = new JLabel("GANGAS CAR");
		lblGangasCar.setForeground(Color.WHITE);
		lblGangasCar.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblGangasCar.setBounds(367, 16, 169, 43);
		contentPane.add(lblGangasCar);
		
		
	}
}
