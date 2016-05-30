
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class Home_Page extends JFrame{
	
	private JButton search;
	private JButton groups;
	private JButton friends;
	private JButton timeline;
	private JButton nextposts;
	private User activeuser;
	
	
	private JPanel mainpanel;
	
	
	public Home_Page(User activeUser) //receives the active user
	{
		super("My HomePage");
		
		activeuser= activeUser;
		
		JComponent newContentPane = new Post_View(activeUser);
		newContentPane.setOpaque(true); //content panes must be opaque
	    this.setContentPane(newContentPane);
		
		 mainpanel = new JPanel();
		mainpanel.setLayout(new BoxLayout(mainpanel,BoxLayout.LINE_AXIS));
		
		//Buttons
		search = new JButton("Search");//Opens a new Search Screen
		groups = new JButton("Groups");//Opens a Screen with a list of groups the user is enlisted to
		friends = new JButton("Friends");//Opens a Screen with a list of Users the user is friends with
		timeline = new JButton("Timeline");//Opens a Screen with the user's posts
		nextposts = new JButton("More Posts");//Displays more posts from groups and friends to the MainPage
		
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
		
//		 JComponent newContentPane = new Post_View(activeUser);
//		 newContentPane.setOpaque(true); //content panes must be opaque
//	     this.setContentPane(newContentPane);
		
		
		
		
		
		this.add(mainpanel);
		this.pack();
		
		this.setSize(getPreferredSize());
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		pack();
		this.setVisible(true);
		
		
	}
	
	
	
	class SearchActionListener implements ActionListener
	{
		 public void actionPerformed(ActionEvent e)
		 	{
			 	//TODO 
			 	new SearchScreen(activeuser);
		 	}
		
	}
	class groupsActionListener implements ActionListener
	{
		 public void actionPerformed(ActionEvent e)
		 	{
			 DisplayLists DL1 = new DisplayLists(activeuser,null ,activeuser.getGroups());
			 DisplayLists.createAndShowGUI(activeuser,null ,activeuser.getGroups() );
			 
			 for(Group group: activeuser.getGroups()){
				 DL1.addObject(group);
			 }

		 	}
		
	}
	class friendsActionListener implements ActionListener
	{
		 public void actionPerformed(ActionEvent e)
		 	{
			 DisplayLists DL2 = new DisplayLists(activeuser,activeuser.getFriends() , null);
			 DisplayLists.createAndShowGUI(activeuser,activeuser.getFriends() ,null );
				 
			 	for(User user : activeuser.getFriends()){
			 		DL2.addObject(user);
			 	}

		 	}
		
	}
	class timelineActionListener implements ActionListener
	{
		 public void actionPerformed(ActionEvent e)
		 	{
			 new User_Timeline(activeuser, activeuser);// Because the activeUser wants to go to his Timeline
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


