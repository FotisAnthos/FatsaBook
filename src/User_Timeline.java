import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class User_Timeline {

	private JFrame frame;
	private Post_View panel;
	private JButton isFriendsButton;
	JButton btnAddFriend;
	JButton btnDeleteFriend;
	JButton btnMorePosts;
	JScrollPane scrollpane;
	private User activeUser,friend;
	private JButton btnPostNewPost;


	public User_Timeline(User activeuser,User friend) {
		this.activeUser = activeuser;
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
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		isFriendsButton = new JButton();
		isFriendsButton.setBounds(34, 13, 149, 31);
		isFriendsButton.setFont(new Font("Arial", Font.PLAIN, 16));
		
		JButton btnCommonFriends = new JButton("Friends In Common");
		btnCommonFriends.setBounds(428, 13, 173, 31);
		btnCommonFriends.setFont(new Font("Arial", Font.PLAIN, 16));
		btnCommonFriends.addActionListener(new CommonFriendsListener());
		if(!activeUser.equals(friend)){
			frame.getContentPane().add(btnCommonFriends);
			frame.getContentPane().add(isFriendsButton);
		}
		

		scrollpane = new JScrollPane(new Post_View(activeUser,friend),ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollpane.setAutoscrolls(true);
		scrollpane.setBounds(12, 66, 601, 262);
		scrollpane.setBorder(null);
		if(activeUser.isFriend(friend))
			frame.getContentPane().add(scrollpane);		
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(535, 336, 97, 33);
		btnBack.setFont(new Font("Arial", Font.PLAIN, 16));
		btnBack.addActionListener(new BackListener());
		frame.getContentPane().add(btnBack);
		
		JButton btnFriends = new JButton("Friends");
		btnFriends.setBounds(244, 13, 119, 31);
		btnFriends.setFont(new Font("Arial", Font.PLAIN, 16));
		btnFriends.addActionListener(new FriendsActionListener());
		frame.getContentPane().add(btnFriends);
		
		btnPostNewPost = new JButton("Post New Post");
		btnPostNewPost.setFont(new Font("Arial", Font.PLAIN, 16));
		btnPostNewPost.setBounds(178, 336, 149, 33);
		btnPostNewPost.addActionListener(new PostListener());
		frame.getContentPane().add(btnPostNewPost);
		
		if(!activeUser.equals(friend)){
			if(activeUser.isFriend(friend))
				isFriendsButton.setText("Delete Friend");
			else {
				isFriendsButton.setText("Add Friend");
				btnPostNewPost.setEnabled(false);
			}

			isFriendsButton.addActionListener(new isFriendsButtonActionListener());	
			frame.getContentPane().add(isFriendsButton);
		}
	}
	
	class isFriendsButtonActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(isFriendsButton.getText().equals("Add Friend")){
				activeUser.addFriend(friend);
				DataBase.save();
				isFriendsButton.setText("Delete Friend");
				btnPostNewPost.setEnabled(true);
				panel =new Post_View(activeUser,friend);
	        	frame.getContentPane().add(scrollpane);
	        	frame.repaint();
	        	frame.revalidate();
			}
			else if(isFriendsButton.getText().equals("Delete Friend")){
				activeUser.removeFriend(friend);
				DataBase.save();
				isFriendsButton.setText("Add Friend");
				btnPostNewPost.setEnabled(false);
				frame.getContentPane().remove(scrollpane);
	        	frame.getContentPane().revalidate();
	        	frame.getContentPane().repaint();
			}
		}
	}
	
	class AddFriendListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
	        	activeUser.addFriend(friend);
	        	btnAddFriend.setEnabled(false);
	        	DataBase.save();
	        	btnDeleteFriend.setEnabled(true);
	        	panel =new Post_View(activeUser,friend);
	        	frame.getContentPane().add(scrollpane);
	        	frame.repaint();
	        	frame.revalidate();
	        	
		}
			
	}
	
	class DeleteFriendListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
	        	activeUser.removeFriend(friend);
	        	btnAddFriend.setEnabled(true);
	        	DataBase.save();
	        	btnDeleteFriend.setEnabled(false);
	        	frame.getContentPane().remove(scrollpane);
	        	frame.getContentPane().revalidate();
	        	frame.getContentPane().repaint();
		}
			
	}
	
	class BackListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			frame.dispose();
			new Home_Page(activeUser);
		}
			
	}
	
	class CommonFriendsListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			ArrayList<User> commons = new ArrayList<User>();
			commons = activeUser.findCommonFriends(friend);
			if(commons!=null)
				DisplayLists.createAndShowGUI(activeUser, commons, null,frame);
		}
	}
	
	class FriendsActionListener implements ActionListener
	{
		 public void actionPerformed(ActionEvent e)
		 	{
			 //TODO
			 DisplayLists.createAndShowGUI(activeUser, friend.getFriends(), null,frame);
		 	}
		
	}
	
	class PostListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{	
			DataBase.createPostFrame(activeUser,friend,null,null);
			frame.dispose();
		}
	}
	
	
}
