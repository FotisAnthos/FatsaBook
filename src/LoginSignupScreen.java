import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class LoginSignupScreen extends JFrame {
	
	private JTextField username;
	private JPasswordField password;
	
	private JButton Sign_in;
	private JButton Sign_up;
	
	
	
	public LoginSignupScreen(){
		super("Login & Signup Screen");
		
		JPanel contentPane = new JPanel();		
		
		//Input Fields - username & password
		username = new JTextField("");
		contentPane.add(username);

		password = new JPasswordField(4);//4 is the minimum amount of password characters
		password.setEchoChar('*');
		contentPane.add(password);
		
		//Buttons 
		Sign_in = new JButton("Sign in");
		contentPane.add(Sign_in);
		Sign_in.addActionListener(new SigninActionListener());

		
		
		Sign_up = new JButton("Sign_up in");
		contentPane.add(Sign_up);
		Sign_up.addActionListener(new SignupActionListener());


	
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	
	class SigninActionListener implements ActionListener
	 {
		public void actionPerformed(ActionEvent e)
		{
			
			
			if(DataBase.checkUser(username.getText()))
			{
				new MainPage(username.getText());
				
			}
				
				
				
					
					
					
				
				

		}
	 }

	 class SignupActionListener implements ActionListener
	 {
		 public void actionPerformed(ActionEvent e)
		 	{
			 	new CreateUserScreen(); 
			}
	 }

	 
	 
	

	



}
