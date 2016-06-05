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
	private JButton isMemberButton;
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
		
		isMemberButton = new JButton();
		isMemberButton.setFont(new Font("Arial", Font.PLAIN, 16));
		isMemberButton.setBounds(103, 13, 149, 31);
		isMemberButton.addActionListener(new isMemberButtonActionListener());
		frame.getContentPane().add(isMemberButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(535, 333, 97, 25);
		btnBack.setFont(new Font("Arial", Font.PLAIN, 16));
		btnBack.addActionListener(new BackListener());
		frame.getContentPane().add(btnBack);
		
		JButton Members_List = new JButton("Members");
		Members_List.addActionListener(new MembersListener());
		Members_List.setFont(new Font("Arial", Font.PLAIN, 16));
		Members_List.setBounds(356, 13, 137, 31);
		frame.getContentPane().add(Members_List);
		
		panel = new Post_View(u,g);
		scrollpane = new JScrollPane(panel,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollpane.setBounds(12, 66, 620, 262);
		scrollpane.setBorder(null);
		if(g.isMember(u)){
			isMemberButton.setText("Delete Group");
			frame.getContentPane().add(scrollpane);
		}
		else 
			isMemberButton.setText("Add Group");
	}
	
	class isMemberButtonActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(isMemberButton.getText().equals("Add Group")){
				g.addMember(u);
				DataBase.save();
				isMemberButton.setText("Delete Group");
		        panel = new Post_View(u,g);
				frame.getContentPane().add(scrollpane);
				frame.repaint();
				frame.revalidate();
			}
			else if(isMemberButton.getText().equals("Delete Group")){
				u.deleteFromGroup(g);
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
			new Home_Page(u);
		}
			
	}
	
	class MembersListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			DisplayLists.createAndShowGUI(u,g.members ,null,frame);
			
		}
	}
}
