import javax.swing.*;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CreateGroupScreen extends JFrame{
	
	private JTextField name;
	private JTextField info;

	private JButton GECK;
	private ButtonGroup group;
	private JRadioButton opengroup;
	private JRadioButton privategroup;

	public CreateGroupScreen()
	{
		super("Create Group Screen");
		
		JPanel contentPane = new JPanel();
		contentPane.add(name);
		contentPane.add(info);
		
		GECK = new JButton("Create Group");
		contentPane.add(GECK);
		GECK.addActionListener(new GECKActionListener());
		
		
		opengroup = new JRadioButton("Open Group", true);
        privategroup = new JRadioButton("Private Group", false);
 
        group = new ButtonGroup();
        group.add(opengroup);
        group.add(privategroup);
        
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		pack();
		this.setVisible(true);
		
		
	}
	class GECKActionListener implements ActionListener
		{
			 public void actionPerformed(ActionEvent e)
			 	{
				 	if( !DataBase.isgroup(name.getText()))
				 		{
				 			if(group.getSelection() == opengroup )
				 			{
				 				DataBase.addGroup(new OpenGroup(name.getText(), info.getText()));
				 			}
				 			else if(group.getSelection() == privategroup )
				 			{
				 				DataBase.addGroup(new PrivateGroup(name.getText(), info.getText()));
				 			}
				 			else System.out.println("Error-Create Group Failed!");
			 	 		}
			 	}
	}
}
