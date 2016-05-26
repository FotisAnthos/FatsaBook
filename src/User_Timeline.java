<<<<<<< HEAD
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
=======
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

>>>>>>> refs/remotes/origin/master

/**
 * @author Flotis
 * @version 1.0		
 * @created 17-Ìבת-2016 7:18:18 לל
 */
public class User_Timeline extends JFrame {

<<<<<<< HEAD
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
=======
	private JButton back;
	private  JButton addfriend;
	private  JButton deletefriend;
	private JButton common_Friends;
	private JButton nextPosts;
	public DisplayLists m_Display_Lists;
	private User u,friend;
	private JFrame frame;
>>>>>>> refs/remotes/origin/master

	public User_Timeline(User u,User friend){
		
		this.friend = friend;
		this.u=u;
		
		 frame = new JFrame(friend.getName()+ "'s Timeline");
	     frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        
//	        JComponent component = new Post_View(u,friend);
//			component.setOpaque(true); //content panes must be opaque
//		    frame.setContentPane(component);
	        
	        addfriend = new JButton("Add friend");
	        deletefriend = new JButton("Delete friend");
	        
	        if(!u.equals(friend)){
	        	if(u.isFriend(friend))
		        	addfriend.setEnabled(false);
		        else if(!u.isFriend(friend))
		        	deletefriend.setEnabled(false);
	        }
	        else{
	        	addfriend.setVisible(false);
	        	deletefriend.setVisible(false);
	        }
	        
		        	
	        addfriend.addActionListener(new AddFriendListener());
	        deletefriend.addActionListener(new DeleteFriendListener());
	        
	        common_Friends = new JButton("See friends");
	        common_Friends.addActionListener(new CommonFriendsListener());
	        nextPosts = new JButton("See more posts");
	        nextPosts.addActionListener(new NextPostsListener());
	        back = new JButton("Back");
	        back.addActionListener(new BackListener());
	        
	 
	        JPanel newContentPane = new JPanel();
//	        newContentPane.setOpaque(true); //content panes must be opaque
//	        frame.setContentPane(newContentPane);
		
		JPanel rightPane = new JPanel();
		rightPane.setLayout(new BoxLayout(rightPane,
                BoxLayout.Y_AXIS));
		rightPane.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		rightPane.add(new JSeparator(SwingConstants.VERTICAL));
		rightPane.add(Box.createVerticalStrut(5));
		
		
		if(friend!=null){
			rightPane.add(addfriend);
			rightPane.add(Box.createRigidArea(new Dimension(0,20)));
			rightPane.add(deletefriend);
			rightPane.add(Box.createRigidArea(new Dimension(0,20)));
		}
			
		rightPane.add(common_Friends);
		rightPane.add(Box.createRigidArea(new Dimension(0,20)));
		rightPane.add(nextPosts);
		
		frame.add(newContentPane,BorderLayout.CENTER);
		frame.add(rightPane, BorderLayout.EAST);
		frame.add(back, BorderLayout.PAGE_END);
		
		
		frame.pack();
		frame.setVisible(true);
		
	}
	
	class AddFriendListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
	        	u.addFriend(friend);
	        	addfriend.setEnabled(false);
	        	deletefriend.setEnabled(true);
		}
			
	}
	
	class DeleteFriendListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
	        	u.removeFriend(friend);
	        	addfriend.setEnabled(true);
	        	deletefriend.setEnabled(false);
		}
			
	}
	
	class BackListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			frame.setVisible(false);
		}
			
	}
	
	class CommonFriendsListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
		}
	}
	
	class NextPostsListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
		}
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
<<<<<<< HEAD
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
=======
}
>>>>>>> refs/remotes/origin/master
