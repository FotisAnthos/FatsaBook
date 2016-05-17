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
	public Group m_Group;
	public DataBase m_DataBase;

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
				 	if( !DataBase.isGroup(name.getText()))
				 		{	//TODO change syso to popup window
				 			if(group.getSelection() == opengroup )
				 			{
				 				if(!DataBase.createGroup(name.getText(), info.getText(), true)) System.out.println("Error-Create Group Failed!");
				 			}
				 			else if(group.getSelection() == privategroup )
				 			{
				 				if(!DataBase.createGroup(name.getText(), info.getText(), false)) System.out.println("Error-Create Group Failed!");
				 			}
				 			else System.out.println("Error-Create Group Failed!");
				 			
			 	 		}
			 	}
	}
}

/**
 * @author Flotis
 * @version 1.0
 * @updated 17-Ìבת-2016 6:39:10 לל
 */
class GECKActionListener implements ActionListener {

	public GECKActionListener(){

	}

	public void finalize() throws Throwable {

	}
	/**
	 * 
	 * @param e
	 */
	public void actionPerformed(ActionEvent e){

	}
}//end GECKActionListener
