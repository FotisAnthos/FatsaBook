import javax.swing.*;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Home_Page extends JFrame{
	
	
	private JButton search;
	private JButton groups;
	private JButton friends;
	private JButton timeline;
	private JButton nextposts;
	private User activeuser;
	private JPanel mainpanel;
	private Post_View postview;
	
	public Home_Page(User activeuser) //receives the active user
	{
		this.activeuser = activeuser;
		
		mainpanel = new JPanel();
		//Buttons
		search = new JButton("Search");//Opens a new Search Screen
		groups = new JButton("Groups");//Opens a Screen with a list of groups the user is enlisted to
		friends = new JButton("Friends");//Opens a Screen with a list of Users the user is friends with
		timeline = new JButton("Timeline");//Opens a Screen with the user's posts
		nextposts = new JButton("More Posts");//Displays more posts from groups and friends to the MainPage
		
		postview = new Post_View(activeuser);
		
		mainpanel.add(search);
		mainpanel.add(groups);
		mainpanel.add(friends);
		mainpanel.add(timeline);
		mainpanel.add(nextposts);
		search.addActionListener(new SearchActionListener());
		groups.addActionListener(new groupsActionListener());
		friends.addActionListener(new friendsActionListener());
		timeline.addActionListener(new timelineActionListener());
		nextposts.addActionListener(new nextpostsActionListener());
		
		mainpanel.add(postview.aPostView());
		
		
		
		this.setSize(1000,500);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setContentPane(mainpanel);
		this.setVisible(true);
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

}










