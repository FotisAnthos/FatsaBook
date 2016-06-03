import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class LoginSignupScreen {

	private JFrame frame;
	private JTextField mail;
	private JButton Sign_in;
	private JButton Sign_up;
	private JPasswordField password;

	public LoginSignupScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Login Screen");
		frame.getContentPane().setFont(new Font("Arial", Font.PLAIN, 18));
		frame.setIconImage(new ImageIcon("FatsaBook__2.jpg").getImage());
		frame.setVisible(true);
		frame.setBounds(100, 100, 662, 429);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblWelcomeToFatsabook = new JLabel("Welcome to Fatsabook");
		lblWelcomeToFatsabook.setFont(new Font("Arial", Font.PLAIN, 25));
		lblWelcomeToFatsabook.setBounds(192, 32, 272, 60);
		frame.getContentPane().add(lblWelcomeToFatsabook);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 18));
		lblEmail.setBounds(121, 139, 75, 39);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 18));
		lblPassword.setBounds(112, 191, 115, 60);
		frame.getContentPane().add(lblPassword);
		
		mail = new JTextField();
		mail.setFont(new Font("Arial", Font.PLAIN, 18));
		mail.setBounds(278, 148, 160, 30);
		mail.setVisible(true);
		frame.getContentPane().add(mail);
		mail.setColumns(10);
		
		Sign_in = new JButton("Sign In");
		Sign_in.addActionListener(new SigninActionListener());
		
		
		Sign_in.setFont(new Font("Arial", Font.PLAIN, 18));
		Sign_in.setBounds(247, 265, 128, 30);
		frame.getContentPane().add(Sign_in);
		
		Sign_up = new JButton("Sign Up");
		Sign_up.addActionListener(new SignupActionListener());
		
		Sign_up.setFont(new Font("Arial", Font.PLAIN, 18));
		Sign_up.setBounds(247, 321, 128, 30);
		frame.getContentPane().add(Sign_up);
		
		password = new JPasswordField();
		password.setEchoChar('*');
		password.setFont(new Font("Arial", Font.PLAIN, 18));
		password.setBounds(278, 211, 160, 30);
		frame.getContentPane().add(password);
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
