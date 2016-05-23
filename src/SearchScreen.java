import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class SearchScreen extends JFrame{
	
	private JTextField username;
	private JButton Search;
	public Group m_Group;
	private JTextField name;
	public User_Timeline m_User_Timeline;
	public User m_User;
	
	
	public SearchScreen()
	{
		super("Search Screen");
		JPanel contentPane = new JPanel();
		
		JRadioButton usersearch = new JRadioButton("Users Search", true);
        JRadioButton groupsearch = new JRadioButton("Group Search", false);
 
        ButtonGroup group = new ButtonGroup();
        group.add(usersearch);
        group.add(groupsearch);
 
        setLayout(new FlowLayout());
        
        Search = new JButton("Search");
		contentPane.add(Search);
		Search.addActionListener(new SearchActionListener());
 
        contentPane.add(usersearch);
        contentPane.add(groupsearch);
        
        this.setContentPane(contentPane);
        
 
        pack();
        this.setVisible(true);
	
	}
	class SearchActionListener implements ActionListener
	 {
		 public void actionPerformed(ActionEvent e)
		 	{
			 	//TODO 			 	
			}
	 }

}