import javax.swing.*;


import java.awt.*;
import java.awt.event.*;


public class MainPage extends JFrame{
	
	private JButton search;
	private JButton groups;
	private JButton friends;
	private JButton timeline;
	private JButton nextposts;
	
	public MainPage()
	{
		JPanel mainpanel = new JPanel();
		//Buttons
		search = new JButton("Search");
		groups = new JButton("Groups");
		friends = new JButton("Friends");
		timeline = new JButton("Timeline");
		nextposts = new JButton("More Posts");
		
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
		
		
		
		
		
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		pack();
		this.setVisible(true);
	}
	
	
	
	class SearchActionListener implements ActionListener
	{
		 public void actionPerformed(ActionEvent e)
		 	{
			 	//TODO 
			 	new SearchScreen();
		 	}
		
	}
	class groupsActionListener implements ActionListener
	{
		 public void actionPerformed(ActionEvent e)
		 	{
			 	//TODO

		 	}
		
	}
	class friendsActionListener implements ActionListener
	{
		 public void actionPerformed(ActionEvent e)
		 	{
			 	//TODO

		 	}
		
	}
	class timelineActionListener implements ActionListener
	{
		 public void actionPerformed(ActionEvent e)
		 	{
			 	//TODO

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
