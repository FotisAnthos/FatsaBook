import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CreateUserScreen extends JFrame {
	private JTextField username;
	private JTextField mail;
	
	private JPasswordField password;
	
	private JButton CreationKit;
	public DataBase m_DataBase;
	public LoginSignupScreen m_LoginSignupScreen;
	
	public CreateUserScreen()
	{
		super("Create User Screen");
		
		JPanel contentPane = new JPanel();
		
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
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	
	
	
	
	class CreationKitActionListener implements ActionListener
	{
		 public void actionPerformed(ActionEvent e)
		 	{
			 	//TODO add createUser
			 DataBase.createUser(username.getText(), mail.getText(), password.getPassword().toString());
	}
	

}
}

/**
 * @author Flotis
 * @version 1.0
 * @updated 17-Ìבת-2016 6:39:10 לל
 */
class CreationKitActionListener implements ActionListener {

	public CreationKitActionListener(){

	}

	public void finalize() throws Throwable {

	}
	/**
	 * 
	 * @param e
	 */
	public void actionPerformed(ActionEvent e){

	}
}//end CreationKitActionListener
