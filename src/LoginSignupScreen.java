
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class LoginSignupScreen extends JFrame {
	
	private JTextField username;
	private JPasswordField password;
	private JLabel username_label;
	private JLabel password_label;
	private JButton Sign_in;
	private JButton Sign_up;
	private JLabel welcome;
	
	
	
	public LoginSignupScreen(){
		super("Login & Signup Screen");
		
		JPanel contentPane = new JPanel(new BorderLayout());
		
		//Username Label and input text field
		username_label = new JLabel("Username");
		username = new JTextField("",20);
		
		//Password Label and input text field
		password = new JPasswordField(4);//4 is the minimum amount of password characters
		password.setEchoChar('*');
		password_label = new JLabel("Password");
		
		//Buttons for Sign in and Sign up
		Sign_in = new JButton("Sign in");
		Sign_in.addActionListener(new SigninActionListener());
		
		Sign_up = new JButton("Sign up");
		Sign_up.addActionListener(new SignupActionListener());
		
		//Grouping all labels in one gridlayout panel
		JPanel labels = new JPanel(new GridLayout(2,1));
		labels.add(username_label);
		labels.add(password_label);
		
		//Group all text fields in one gridlayout panel
		JPanel text_fields =new JPanel(new GridLayout(2,1));
		text_fields.add(username);
		text_fields.add(password);
		
		//Group in one panel all text fields and labels
		JPanel fields = new JPanel();
		fields.add(labels);
		fields.add(text_fields);
		
		//Group all buttons in one Panel
		JPanel buttons = new JPanel();
		buttons.add(Sign_in);
		buttons.add(Sign_up);
		
		//Welcome Label
		JLabel welcome = new JLabel("WELCOME TO FATSABOOK");
		welcome.setHorizontalAlignment(SwingConstants.CENTER);
		
		//Add labels, text_fields and buttons to the main panel
		contentPane.add(welcome,BorderLayout.NORTH);
		contentPane.add(fields,BorderLayout.CENTER);
		contentPane.add(buttons,BorderLayout.EAST);
		
		//Add main panel to frame
		this.add(contentPane);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setSize(500,200);
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

