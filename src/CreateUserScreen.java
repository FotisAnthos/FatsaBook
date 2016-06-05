import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class CreateUserScreen {

	private JFrame frame;
	private JTextField username;
	private JTextField email;
	private JPasswordField password;


	public CreateUserScreen() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 662, 429);
		frame.setIconImage(new ImageIcon("FatsaBook__2.jpg").getImage());
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblSignUp = new JLabel("Sign Up");
		lblSignUp.setFont(new Font("Arial", Font.PLAIN, 25));
		lblSignUp.setBounds(249, 13, 97, 66);
		frame.getContentPane().add(lblSignUp);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Arial", Font.PLAIN, 18));
		lblUsername.setBounds(99, 116, 97, 33);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 18));
		lblEmail.setBounds(130, 169, 66, 35);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 18));
		lblPassword.setBounds(112, 217, 84, 35);
		frame.getContentPane().add(lblPassword);
		
		username = new JTextField();
		username.setFont(new Font("Arial", Font.PLAIN, 18));
		username.setBounds(297, 116, 146, 28);
		frame.getContentPane().add(username);
		username.setColumns(10);
		
		email = new JTextField();
		email.setBounds(297, 169, 146, 29);
		email.setFont(new Font("Arial", Font.PLAIN, 18));
		frame.getContentPane().add(email);
		email.setColumns(10);
		
		password = new JPasswordField();
		password.setEchoChar('*');
		password.setFont(new Font("Arial", Font.PLAIN, 18));
		password.setBounds(297, 217, 146, 29);
		frame.getContentPane().add(password);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new CreationKitActionListener());
		btnSignUp.setFont(new Font("Arial", Font.PLAIN, 18));
		btnSignUp.setBounds(249, 288, 109, 35);
		frame.getContentPane().add(btnSignUp);
	}
	
	class CreationKitActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		 	{
			 //TODO add createUser
			 if(DataBase.createUser(username.getText(), email.getText(), password.getPassword())){
				 DataBase.save();
				 JOptionPane.showMessageDialog(null,"Sign up completed","Message",JOptionPane.PLAIN_MESSAGE);
				 frame.setVisible(false);
			 }
			 else if(DataBase.isUser(email.getText())){
				 JOptionPane.showMessageDialog(null,"User already exists","Message",JOptionPane.PLAIN_MESSAGE);
				 frame.setVisible(false);
			 }
			 else
				 JOptionPane.showMessageDialog(null,"Can't create new user","Message",JOptionPane.PLAIN_MESSAGE);
		 	}
	}
}