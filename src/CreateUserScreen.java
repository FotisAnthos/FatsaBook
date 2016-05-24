import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class CreateUserScreen extends JFrame {
	private JTextField username;
	private JTextField mail;
	
	private JPasswordField password;
	
	private JButton CreationKit;
	private JLabel pass,user,email;
	public DataBase m_DataBase;
	public LoginSignupScreen m_LoginSignupScreen;
	
	public CreateUserScreen()
	{
		super("Create User Screen");
		
		JPanel contentPane = new JPanel();
		
		user= new JLabel("Username:");
		contentPane.add(user);
		username = new JTextField(10);
		contentPane.add(username);
		
		email = new JLabel("E-mail:");
		contentPane.add(email);
		mail = new JTextField(10);
		contentPane.add(mail);

		pass = new JLabel("New Password:");
		contentPane.add(pass);
		password = new JPasswordField(4);//4 is the minimum amount of password characters
		password.setEchoChar('*');
		contentPane.add(password);
		
		CreationKit = new JButton("Sign up");
		contentPane.add(CreationKit);
		CreationKit.addActionListener(new CreationKitActionListener());
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
		
		this.setContentPane(contentPane);
		contentPane.setBackground(Color.cyan);
        

	    this.setSize(1000,500);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	
	
	
	
	class CreationKitActionListener implements ActionListener
	{
		 @SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent e)
		 	{
			 	//TODO add createUser
			 DataBase.createUser(username.getText(), mail.getText(), password.getText());
			 JOptionPane.showMessageDialog(null,"Sign up completed","Message",JOptionPane.PLAIN_MESSAGE);
	}
	

}
}

/**
 * @author Flotis
 * @version 1.0
 * @updated 17-Ìáú-2016 6:39:10 ìì
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