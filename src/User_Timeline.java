import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import java.awt.Font;

public class User_Timeline {

	private JFrame frame;
	JButton btnAddFriend;
	JButton btnDeleteFriend;
	private User activeuser,friend;


	public User_Timeline(User activeuser,User friend) {
		this.activeuser = activeuser;
		this.friend = friend;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame(friend.getName() + " 's Timeline");
		frame.setIconImage(new ImageIcon("FatsaBook__2.jpg").getImage());
		frame.setVisible(true);
		frame.setBounds(100, 100, 662, 429);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnAddFriend = new JButton("Add Friend");
		btnAddFriend.setFont(new Font("Arial", Font.PLAIN, 16));
		btnAddFriend.setBounds(24, 13, 119, 31);
		
		btnDeleteFriend = new JButton("Delete Friend");
		btnDeleteFriend.setFont(new Font("Arial", Font.PLAIN, 16));
		btnDeleteFriend.setBounds(156, 13, 137, 31);

		
		if(!activeuser.equals(friend)){
        	if(activeuser.isFriend(friend))
        		btnAddFriend.setEnabled(false);
	        else if(!activeuser.isFriend(friend))
	        	btnDeleteFriend.setEnabled(false);
        }
        else{
        	btnAddFriend.setVisible(false);
        	btnDeleteFriend.setVisible(false);
        }
		btnAddFriend.addActionListener(new AddFriendListener());
		btnDeleteFriend.addActionListener(new DeleteFriendListener());
		
		JButton btnCommonFriends = new JButton("Common Friends");
		btnCommonFriends.setBounds(445, 13, 173, 31);
		btnCommonFriends.setFont(new Font("Arial", Font.PLAIN, 16));
		frame.getContentPane().add(btnCommonFriends);
		
		JButton btnMorePosts = new JButton("More Posts");
		btnMorePosts.setBounds(204, 333, 143, 25);
		btnMorePosts.setFont(new Font("Arial", Font.PLAIN, 16));
		btnMorePosts.addActionListener(new NextPostsListener());
		frame.getContentPane().add(btnMorePosts);
		
		JPanel panel = new Post_View(activeuser,friend);
		panel.setBounds(12, 66, 620, 262);
		frame.getContentPane().add(panel);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(535, 333, 97, 25);
		btnBack.setFont(new Font("Arial", Font.PLAIN, 16));
		btnBack.addActionListener(new BackListener());
		frame.getContentPane().add(btnBack);
		
		JButton btnFriends = new JButton("Friends");
		btnFriends.setBounds(314, 13, 119, 31);
		btnFriends.setFont(new Font("Arial", Font.PLAIN, 16));
		btnFriends.addActionListener(new CommonFriendsListener());
		frame.getContentPane().add(btnFriends);
		
		if(friend!=null){
			frame.getContentPane().add(btnAddFriend);
			frame.getContentPane().add(btnDeleteFriend);
		}
	}
	
	class AddFriendListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
	        	activeuser.addFriend(friend);
	        	btnAddFriend.setEnabled(false);
	        	DataBase.save();
	        	btnDeleteFriend.setEnabled(true);
		}
			
	}
	
	class DeleteFriendListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
	        	activeuser.removeFriend(friend);
	        	btnAddFriend.setEnabled(true);
	        	DataBase.save();
	        	btnDeleteFriend.setEnabled(false);
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
	
	class groupsActionListener implements ActionListener
	{
		 public void actionPerformed(ActionEvent e)
		 	{
			 //TODO
			 new DisplayLists(activeuser, activeuser.getFriends(), activeuser.getGroups());
		 	}
		
	}
}
