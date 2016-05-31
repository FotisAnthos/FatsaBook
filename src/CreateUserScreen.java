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
	private JFrame frame;
	private JPanel contentPane;
	
	private JButton CreationKit;
	private JLabel pass,user,email;
	
	public CreateUserScreen()
	{
		
		frame= new JFrame("Create User Screen");
		frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		contentPane = new JPanel();
		
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
		frame.add(contentPane);
		contentPane.setBackground(Color.cyan);
	    frame.pack();
		frame.setVisible(true);
		
	}
	
	
	
	
	
	class CreationKitActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		 	{
			 //TODO add createUser
			 if(DataBase.createUser(username.getText(), mail.getText(), password.getPassword())){
				 DataBase.save();
				 JOptionPane.showMessageDialog(null,"Sign up completed","Message",JOptionPane.PLAIN_MESSAGE);
				 frame.setVisible(false);
			 }
			 else if(DataBase.isUser(mail.getText())){
				 JOptionPane.showMessageDialog(null,"User already exists","Message",JOptionPane.PLAIN_MESSAGE);
				 frame.setVisible(false);
			 }
			 else
				 JOptionPane.showMessageDialog(null,"Can't create new user","Message",JOptionPane.PLAIN_MESSAGE);
		 	}
	}
}
