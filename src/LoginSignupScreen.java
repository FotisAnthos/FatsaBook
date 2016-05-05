import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class LoginSignupScreen extends JFrame implements ActionListener{
	
	private JTextField username;
	private JPasswordField password;
	
	private JButton Sign_in;
	private JButton Sign_up;
	
	/*
	 * JPasswordField idField = new JPasswordField ();
		idField.setEchoChar(‘*’);
	 */
	
	public LoginSignupScreen(){
		super("Login & Signup Screen");
		
		Container contentPane = this.getContentPane();
		
		JPanel ThePanel = new JPanel();
		contentPane.add(ThePanel);
		//Input Fields - username & password
		username = new JTextField("");
		contentPane.add(username);

		password = new JPasswordField(4);//4 is the minimum amount of password characters
		password.setEchoChar('*');
		contentPane.add(password);
		
		//Buttons - https://www.youtube.com/watch?v=VCLxJd1d84s
		Sign_in = new JButton("Sign in");
		contentPane.add(Sign_in);
		Sign_in.addActionListener(new SigninActionListener());

		
		
		Sign_up = new JButton("Sign_up in");
		contentPane.add(Sign_up);
		Sign_up.addActionListener(new SignupActionListener());


	
	
		this.setVisible(true);
	}

	
	class SigninActionListener implements ActionListener
	 {
		public void actionPerformed(ActionEvent e)
		{
				//TODO

		}
	 }

	 class SignupActionListener implements ActionListener
	 {
		 public void actionPerformed(ActionEvent e)
		 	{
			 	//TODO
			}
	 }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}



}
