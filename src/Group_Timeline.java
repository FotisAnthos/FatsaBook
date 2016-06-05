import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JPanel;

public class Group_Timeline {

	private JFrame frame;
	private JPanel panel;
	private JButton addgroup;
	private JButton deletegroup;
	private JButton btnMorePosts;
	JScrollPane scrollpane;
	Group g;
	User u;

	public Group_Timeline(Group group,User user) {
		this.g = group;
		this.u = user;
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
		
		addgroup = new JButton("Add group");
		addgroup.setFont(new Font("Arial", Font.PLAIN, 16));
		addgroup.setBounds(57, 13, 119, 31);
		frame.getContentPane().add(addgroup);
		
		deletegroup = new JButton("Delete group");
		deletegroup.setFont(new Font("Arial", Font.PLAIN, 16));
		deletegroup.setBounds(237, 13, 137, 31);
		frame.getContentPane().add(deletegroup);
		
        addgroup.addActionListener(new addgroupListener());
        deletegroup.addActionListener(new deletegroupListener());

		btnMorePosts = new JButton("More Posts");
		btnMorePosts.setBounds(204, 333, 143, 25);
		btnMorePosts.setFont(new Font("Arial", Font.PLAIN, 16));
		btnMorePosts.addActionListener(new NextPostsListener());
		frame.getContentPane().add(btnMorePosts);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(535, 333, 97, 25);
		btnBack.setFont(new Font("Arial", Font.PLAIN, 16));
		btnBack.addActionListener(new BackListener());
		frame.getContentPane().add(btnBack);
		
		JButton Members_List = new JButton("Members");
		Members_List.addActionListener(new MembersListener());
		Members_List.setFont(new Font("Arial", Font.PLAIN, 16));
		Members_List.setBounds(437, 13, 137, 31);
		frame.getContentPane().add(Members_List);
		
		panel = new Post_View(u,g);
		panel.setBounds(12, 66, 620, 262);
		
		  if(g.isMember(u)){
	        	addgroup.setEnabled(false);
	        	frame.getContentPane().add(panel);
	        }
	        else{
	        	deletegroup.setEnabled(false);
	        	btnMorePosts.setEnabled(false);
	        }
		
	}
	
	class addgroupListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			g.addMember(u);			
			addgroup.setEnabled(false);
			deletegroup.setEnabled(true);
			btnMorePosts.setEnabled(true);
	        DataBase.save();
	        panel = new Post_View(u,g);
			panel.setBounds(12, 59, 620, 261);
			frame.getContentPane().add(panel);
			frame.repaint();
			frame.revalidate();
	        
		}
			
	}
	
	class deletegroupListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
				u.deleteFromGroup(g);
				addgroup.setEnabled(true);
				deletegroup.setEnabled(false);
	        	DataBase.save();
	        	
	        	if(btnMorePosts.isEnabled())
	        		frame.getContentPane().remove(panel);
	        	else{
	        		frame.getContentPane().remove(scrollpane);
	        	}
	        		
	        	btnMorePosts.setEnabled(false);
	        	frame.getContentPane().revalidate();
	        	frame.getContentPane().repaint();
		}
			
	}
	
	class NextPostsListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			frame.getContentPane().remove(panel);
			scrollpane = new JScrollPane(panel);
			scrollpane.setBounds(12, 66, 601, 262);
			scrollpane.setBorder(null);
			frame.getContentPane().add(scrollpane);
			btnMorePosts.setEnabled(false);
        	frame.getContentPane().repaint();
        	frame.getContentPane().revalidate();
		}
	}
	
	class BackListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			frame.setVisible(false);
		}
			
	}
	
	class MembersListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			DisplayLists.createAndShowGUI(u,g.members ,null);
			
		}
	}
}
