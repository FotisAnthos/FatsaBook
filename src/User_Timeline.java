import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Home_Page.SearchActionListener;
import Home_Page.friendsActionListener;
import Home_Page.groupsActionListener;
import Home_Page.nextpostsActionListener;
import Home_Page.timelineActionListener;

/**
 * @author Flotis
 * @version 1.0
 * @created 17-Ìבת-2016 7:18:18 לל
 */
public class User_Timeline extends JFrame {

	private JButton search;
	private JButton groups;
	private JButton common_friends;
	private JPanel mainpanel;
	
	private JButton nextposts;
	

	public User_Timeline(User auser){
		mainpanel = new JPanel();
		search = new JButton("Search");//Opens a new Search Screen
		groups = new JButton("Groups");//Opens a Screen with a list of groups the user is enlisted to
		common_friends = new JButton("Common Friends");//Opens a Screen with a list of Users the user is friends with
		nextposts = new JButton("More Posts");//Displays more posts from groups and friends to the MainPage
		mainpanel.add(search);
		mainpanel.add(groups);
		mainpanel.add(common_friends);
		;
		mainpanel.add(nextposts);
		search.addActionListener(new SearchActionListener());
		groups.addActionListener(new groupsActionListener());
		common_friends.addActionListener(new friendsActionListener());
		nextposts.addActionListener(new nextpostsActionListener());

	}
	
	class SearchActionListener implements ActionListener
	{
		 public void actionPerformed(ActionEvent e)
		 	{
			 	new SearchScreen();
		 	}
		
	}
	class groupsActionListener implements ActionListener
	{
		 public void actionPerformed(ActionEvent e)
		 	{
			 //TODO
			 new Display_Lists();
		 	}
		
	}
	class friendsActionListener implements ActionListener
	{
		 public void actionPerformed(ActionEvent e)
		 	{
			 //TODO
			 new Display_Lists();
		 	}
		
	}
	class timelineActionListener implements ActionListener
	{
		 public void actionPerformed(ActionEvent e)
		 	{
			 	new User_Timeline(activeuser);
		 	}
		
	}
	class nextpostsActionListener implements ActionListener
	{
		 public void actionPerformed(ActionEvent e)
		 	{
			 	//TODO

		 	}
		
	}

	
}//end User_Timeline