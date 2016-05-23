
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class LoginSignupScreen extends JFrame {
	
	private JTextField username;
	private JPasswordField password;
	
	private JButton Sign_in;
	private JButton Sign_up;
	private JLabel label,label2;
	public CreateUserScreen m_CreateUserScreen;
	public MainPage m_MainPage;
	public User m_User;
	public Home_Page m_Home_Page;
	
	
	
	public LoginSignupScreen(){
		super("Login & Signup Screen");
		
		JPanel contentPane = new JPanel();	
		label = new JLabel("E-mail:");
		contentPane.add(label);	
		
		
		//Input Fields - username & password
		username = new JTextField(10);
		contentPane.add(username);
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
        

	    this.setSize(1000,500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setContentPane(contentPane);
	}

	
	class SigninActionListener implements ActionListener
	 {

		@SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent e)
		{	
			if(DataBase.checkUserPassword(username.getText(),password.getText()))
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

class SigninActionListener implements ActionListener {

	public SigninActionListener(){

	}

	public void finalize() throws Throwable {

	}
	/**
	 * 
	 * @param e
	 */
	public void actionPerformed(ActionEvent e){

	}
}//end SigninActionListener

/**
 * @author Flotis
 * @version 1.0
 * @updated 17-Ìáú-2016 6:39:10 ìì
 */
class SignupActionListener implements ActionListener {

	public SignupActionListener(){
		CreateUserScreen();
	}

	public void finalize() throws Throwable {

	}
	/**
	 * 
	 * @param e
	 */
	public void actionPerformed(ActionEvent e){

	}
}//end SignupActionListener