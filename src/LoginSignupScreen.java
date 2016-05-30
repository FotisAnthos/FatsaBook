
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class LoginSignupScreen extends JFrame {
	

	private JTextField mail;

	private JPanel contentPane;

	private JPasswordField password;
	private JFrame frame;
	
	
	private JButton Sign_in;
	private JButton Sign_up;
	private JLabel label,label2;
	
	
	
	
	public LoginSignupScreen(){
		super("Login & Signup Screen");

		frame = new JFrame();
		contentPane = new JPanel();	
		label = new JLabel("E-mail:");
		contentPane.add(label);	
		
		
		//Input Fields - username & password
		mail = new JTextField(10);
		contentPane.add(mail);
        label2 = new JLabel("Password:");
		contentPane.add(label2);
		password = new JPasswordField(4);//4 is the minimum amount of password characters
		password.setEchoChar('*');
		contentPane.add(password);
		
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
		
		//Buttons 
		Sign_in = new JButton("Sign in");
		
		    contentPane.add(Sign_in);
		
		Sign_in.addActionListener(new SigninActionListener());

		
		
		Sign_up = new JButton("Sign up");
		contentPane.add(Sign_up);
		Sign_up.addActionListener(new SignupActionListener());
		
		contentPane.setBackground(Color.cyan);
		frame.add(contentPane);
        

	    frame.setSize(1000,500);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setContentPane(contentPane);
	}

	
	class SigninActionListener implements ActionListener
	 {

		
		public void actionPerformed(ActionEvent e)
		{	
			//if(DataBase.checkUserPassword(mail.getText(), password.getPassword().toString()))//password.getPassword().toString() is probably wrong
			if(DataBase.checkUserPassword(mail.getText(), password.getPassword()))
			{
				User u ;
				u = DataBase.findUser(mail.getText());
				new Home_Page(u);

				frame.setVisible(false);
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

