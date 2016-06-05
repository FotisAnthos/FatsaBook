import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class Group_Timeline {

	private JFrame frame;
	private JButton btnPostNewPost;
	private JButton isMemberButton;
	private JPanel panel;
	private JButton addgroup;
	private JButton deletegroup;
	private JButton btnMorePosts;
	JScrollPane scrollpane;
	Group g;
	User activeUser;

	public Group_Timeline(Group group,User user) {
		this.g = group;
		this.activeUser = user;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame(g.getName()+ " 's Timeline");
		frame.setIconImage(new ImageIcon("FatsaBook__2.jpg").getImage());
		frame.setVisible(true);
		frame.setBounds(100, 100, 662, 429);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		isMemberButton = new JButton();
		isMemberButton.setFont(new Font("Arial", Font.PLAIN, 16));
		isMemberButton.setBounds(103, 13, 149, 31);
		isMemberButton.addActionListener(new isMemberButtonActionListener());
		frame.getContentPane().add(isMemberButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(535, 336, 97, 33);
		btnBack.setFont(new Font("Arial", Font.PLAIN, 16));
		btnBack.addActionListener(new BackListener());
		frame.getContentPane().add(btnBack);
		
		JButton Members_List = new JButton("Members");
		Members_List.addActionListener(new MembersListener());
		Members_List.setFont(new Font("Arial", Font.PLAIN, 16));
		Members_List.setBounds(356, 13, 137, 31);
		frame.getContentPane().add(Members_List);
		
		panel = new Post_View(activeUser,g);
		scrollpane = new JScrollPane(panel,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollpane.setBounds(12, 66, 620, 262);
		scrollpane.setBorder(null);
		if(g.isMember(activeUser)){
			isMemberButton.setText("Delete Group");
			frame.getContentPane().add(scrollpane);
		}
		else 
			isMemberButton.setText("Add Group");
		
		btnPostNewPost = new JButton("Post New Post");
		btnPostNewPost.setFont(new Font("Arial", Font.PLAIN, 16));
		btnPostNewPost.setBounds(178, 336, 149, 33);
		btnPostNewPost.addActionListener(new PostListener());
		frame.getContentPane().add(btnPostNewPost);
	}
	
	class isMemberButtonActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(isMemberButton.getText().equals("Add Group")){
				g.addMember(activeUser);
				DataBase.save();
				isMemberButton.setText("Delete Group");
		        panel = new Post_View(activeUser,g);
				frame.getContentPane().add(scrollpane);
				frame.repaint();
				frame.revalidate();
			}
			else if(isMemberButton.getText().equals("Delete Group")){
				activeUser.deleteFromGroup(g);
				DataBase.save();
				isMemberButton.setText("Add Group");
				frame.getContentPane().remove(scrollpane);
	        	frame.getContentPane().revalidate();
	        	frame.getContentPane().repaint();
			}
		}
	}
	
	class BackListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			frame.dispose();
			new Home_Page(activeUser);
		}
			
	}
	
	class MembersListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			DisplayLists.createAndShowGUI(activeUser,g.members ,null,frame);
			
		}
	}
	
	class PostListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{	
			DataBase.createPostFrame(activeUser,null,g,null);
			frame.dispose();
		}
	}
}
