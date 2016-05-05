import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CreateUserScreen extends JFrame{
	private JTextField username;
	private JTextField mail;
	
	private JPasswordField password;
	
	private JButton CreationKit;
	
	public CreateUserScreen()
	{
		super("Create User Screen");
		
		Container contentPane = this.getContentPane();
		
		username = new JTextField();
		contentPane.add(username);
		mail = new JTextField();
		contentPane.add(mail);

		password = new JPasswordField(4);//4 is the minimum amount of password characters
		password.setEchoChar('*');
		contentPane.add(password);
		
		CreationKit = new JButton("Sign_up in");
		contentPane.add(CreationKit);
		CreationKit.addActionListener(new CreationKitActionListener());

		
		this.setVisible(true);
	}
	
	
	
	
	
	class CreationKitActionListener implements ActionListener
	{
		 public void actionPerformed(ActionEvent e)
		 	{
			 //TODO add password to constructor
			 	User u = new User(username.getText(), mail.getText());
		 	}
		
	}
	

}
