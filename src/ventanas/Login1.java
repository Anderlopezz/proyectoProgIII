package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login1 extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField pwdPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login1 frame = new Login1();
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
	public Login1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(Login1.class.getResource("/image/auto-car-dealer-logo-design-600w-568160641.jpg")));
		lblNewLabel.setBounds(606, 0, 180, 463);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("GANGAS");
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(619, 371, 211, 49);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("GANGAS CAR DEALER");
		lblNewLabel_2.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 22));
		lblNewLabel_2.setBounds(27, 73, 301, 33);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Login");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(27, 157, 89, 49);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Username");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_4.setBounds(27, 235, 89, 14);
		contentPane.add(lblNewLabel_4);
		
		txtUsername = new JTextField();
		txtUsername.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(txtUsername.getText().equals("Username")) {
					txtUsername.setText("");
					txtUsername.setForeground(Color.black);
				}
				if(String.valueOf(pwdPassword.getPassword()).equals("******")) {
					pwdPassword.setText("*******");
					pwdPassword.setForeground(Color.gray);
				}
			}
		});
		txtUsername.setBorder(null);
		txtUsername.setForeground(Color.GRAY);
		txtUsername.setText("Username");
		txtUsername.setBounds(27, 260, 371, 20);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(27, 291, 371, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel_4_1 = new JLabel("Password");
		lblNewLabel_4_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_4_1.setBounds(27, 314, 89, 14);
		contentPane.add(lblNewLabel_4_1);
		
		pwdPassword = new JPasswordField();
		pwdPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(String.valueOf(pwdPassword.getPassword()).equals("*****")) {
					pwdPassword.setText("");
					pwdPassword.setForeground(Color.black);
				}
				if(txtUsername.getText().isEmpty()) {
					txtUsername.setText("Username");
					txtUsername.setForeground(Color.gray);
				}
			}
		});
		pwdPassword.setForeground(Color.GRAY);
		pwdPassword.setBorder(null);
		pwdPassword.setText("Password");
		pwdPassword.setBounds(27, 349, 371, 20);
		contentPane.add(pwdPassword);
		
		JButton btnNewButton = new JButton("Enter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String textoUsuario = txtUsername.getText();
				String passwordUsuario = pwdPassword.getText();
				
				if(textoUsuario.equals("admin") && passwordUsuario.equals("admin")){
					VentanaAdmin ventAd = new VentanaAdmin();
					ventAd.setVisible(true);
					Login1.this.setVisible(false);
				}
				else{
					JOptionPane.showMessageDialog(Login1.this, "Error 303");
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnNewButton.setBounds(164, 397, 89, 23);
		contentPane.add(btnNewButton);
	}
}
