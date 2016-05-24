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
	
	private JTextField search;
	private JButton Search;
	public Group m_Group;
	public User_Timeline m_User_Timeline;
	public User m_User;
	private JRadioButton usersearch;
	private JRadioButton groupsearch;
	private User user;
	
	
	public SearchScreen(User user)
	{
		super("Search Screen");
		this.user=user;
		JPanel contentPane = new JPanel();
		
		usersearch = new JRadioButton("Users Search", true);
        groupsearch = new JRadioButton("Group Search", false);
 
        ButtonGroup group = new ButtonGroup();
        group.add(usersearch);
        group.add(groupsearch);
 
        setLayout(new FlowLayout());
        
        search = new JTextField(10);
        contentPane.add(search);
        Search = new JButton("Search");
		contentPane.add(Search);
		Search.addActionListener(new SearchActionListener());
 
        contentPane.add(usersearch);
        contentPane.add(groupsearch);
        
        this.setContentPane(contentPane);
        
        this.setSize(getPreferredSize());
        pack();
        this.setVisible(true);
	
	}
	class SearchActionListener implements ActionListener
	 {
		 public void actionPerformed(ActionEvent e)
		 	{
			 	if(usersearch.isSelected()){
			 		for(User u :DataBase.users){
			 			if(search.getText().equals(u.getName()))
			 				new User_Timeline(user,u);
			 		}
			 	}
			 	else if(groupsearch.isSelected()){
			 		for(Group g :DataBase.groups){
			 			if(search.getText().equals(g.getName()))
			 				new Group_Timeline(g);
			 		}
			 	}
			}
	 }

}