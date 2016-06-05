import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class User_Timeline {

	private JFrame frame;
	private Post_View panel;
	JButton btnAddFriend;
	JButton btnDeleteFriend;
	JButton btnMorePosts;
	JScrollPane scrollpane;
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
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		
		JButton btnCommonFriends = new JButton("Friends In Common");
		btnCommonFriends.setBounds(445, 13, 173, 31);
		btnCommonFriends.setFont(new Font("Arial", Font.PLAIN, 16));
		btnCommonFriends.addActionListener(new CommonFriendsListener());
		if(!activeuser.equals(friend))
			frame.getContentPane().add(btnCommonFriends);
		

		scrollpane = new JScrollPane(new Post_View(activeuser,friend),ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollpane.setAutoscrolls(true);
		scrollpane.setBounds(12, 66, 601, 262);
		scrollpane.setBorder(null);
		if(activeuser.isFriend(friend) || activeuser.equals(friend))
			frame.getContentPane().add(scrollpane);

		
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(535, 333, 97, 25);
		btnBack.setFont(new Font("Arial", Font.PLAIN, 16));
		btnBack.addActionListener(new BackListener());
		frame.getContentPane().add(btnBack);
		
		JButton btnFriends = new JButton("Friends");
		btnFriends.setBounds(314, 13, 119, 31);
		btnFriends.setFont(new Font("Arial", Font.PLAIN, 16));
		btnFriends.addActionListener(new FriendsActionListener());
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
	        	panel =new Post_View(activeuser,friend);
	        	frame.getContentPane().add(scrollpane);
	        	frame.repaint();
	        	frame.revalidate();
	        	
		}
			
	}
	
	class DeleteFriendListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
	        	activeuser.removeFriend(friend);
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
			frame.setVisible(false);
			new Home_Page(activeuser);
		}
			
	}
	
	class CommonFriendsListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			ArrayList<User> common = new ArrayList<User>();
			for(User myfriend: activeuser.getFriends()){
				for(User hisfriend: friend.getFriends()){
					if(myfriend.getName().equals(hisfriend.getName()) && myfriend.getMail().equals(hisfriend.getMail()))
						common.add(myfriend);
				}
			}
			if(common!=null)
				DisplayLists.createAndShowGUI(activeuser, common, null);
		}
	}
	
	class FriendsActionListener implements ActionListener
	{
		 public void actionPerformed(ActionEvent e)
		 	{
			 //TODO
			 DisplayLists.createAndShowGUI(activeuser, friend.getFriends(), null);
		 	}
		
	}
}
