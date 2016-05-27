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




public class User_Timeline extends JFrame {


	private JButton back;
	private  JButton addfriend;
	private  JButton deletefriend;
	private JButton common_Friends;
	private JButton nextPosts;
	public DisplayLists m_Display_Lists;
	private User activeUser,friend;
	private JFrame frame;


	public User_Timeline(User activeuser,User friend){
		
		this.friend = friend;
		this.activeUser=activeuser;
		
		 frame = new JFrame(friend.getName()+ "'s Timeline");
	     frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        
	        JComponent component = new Post_View(u,friend);
			component.setOpaque(true); //content panes must be opaque
		    frame.setContentPane(component);
//		    frame.add(component, BorderLayout.NORTH);
	        
	        addfriend = new JButton("Add friend");
	        deletefriend = new JButton("Delete friend");
	        
	        if(!activeuser.equals(friend)){
	        	if(activeuser.isFriend(friend))
		        	addfriend.setEnabled(false);
		        else if(!activeuser.isFriend(friend))
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
	        	activeUser.addFriend(friend);
	        	addfriend.setEnabled(false);
	        	deletefriend.setEnabled(true);
		}
			
	}
	
	class DeleteFriendListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
	        	activeUser.removeFriend(friend);
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
			 	new SearchScreen(activeUser);
		 	}
		
	}
	class groupsActionListener implements ActionListener
	{
		 public void actionPerformed(ActionEvent e)
		 	{
			 //TODO
			 new DisplayLists(activeUser, activeUser.getFriends(), activeUser.getGroups());
		 	}
		
	}


}

