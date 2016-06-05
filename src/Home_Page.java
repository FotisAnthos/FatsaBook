import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home_Page {

	private JFrame frame;
	private JScrollPane scrollpane;
	private JRadioButton rdbtnUsersSearch;
	private JRadioButton rdbtnGroupSearch;
	private User activeuser;
	private JTextField searchfield;


	public Home_Page(User activeuser) {
		this.activeuser = activeuser;
		initialize();	
	}

	private void initialize() {
		frame = new JFrame("My HomePage");
		frame.getContentPane().setFont(new Font("Arial", Font.PLAIN, 18));
		frame.setIconImage(new ImageIcon("FatsaBook__2.jpg").getImage());
		frame.setVisible(true);
		frame.setBounds(100, 100, 662, 429);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnGroups = new JButton("Groups");
		btnGroups.addActionListener(new groupsActionListener());
		btnGroups.setFont(new Font("Arial", Font.PLAIN, 18));
		btnGroups.setBounds(12, 34, 120, 42);
		frame.getContentPane().add(btnGroups);
		
		JButton btnFriends = new JButton("Friends");
		btnFriends.addActionListener(new friendsActionListener());
		btnFriends.setFont(new Font("Arial", Font.PLAIN, 18));
		btnFriends.setBounds(165, 34, 120, 42);
		frame.getContentPane().add(btnFriends);
		
		JButton btnTimeline = new JButton("Timeline");
		btnTimeline.addActionListener(new timelineActionListener());
		btnTimeline.setFont(new Font("Arial", Font.PLAIN, 18));
		btnTimeline.setBounds(317, 34, 120, 42);
		frame.getContentPane().add(btnTimeline);
		
//		JPanel panel_1 = new JPanel();
//		panel_1.setBounds(12, 107, 425, 262);
//		frame.getContentPane().add(panel_1);
		scrollpane = new JScrollPane(new Post_View(activeuser),ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollpane.setAutoscrolls(true);
		scrollpane.setBounds(12, 107, 425, 262);
		scrollpane.setBorder(null);
		frame.getContentPane().add(scrollpane);
		
		searchfield = new JTextField();
		searchfield.setBounds(467, 34, 165, 42);
		searchfield.setFont(new Font("Arial", Font.PLAIN, 18));
		frame.getContentPane().add(searchfield);
		searchfield.setColumns(10);
		
		rdbtnUsersSearch = new JRadioButton("Users Search",true);
		rdbtnUsersSearch.setFont(new Font("Arial", Font.PLAIN, 13));
		rdbtnUsersSearch.setBounds(487, 85, 127, 25);
		frame.getContentPane().add(rdbtnUsersSearch);
		
		rdbtnGroupSearch = new JRadioButton("Group Search",false);
		rdbtnGroupSearch.setFont(new Font("Arial", Font.PLAIN, 13));
		rdbtnGroupSearch.setBounds(487, 107, 127, 25);
		frame.getContentPane().add(rdbtnGroupSearch);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnUsersSearch);
		group.add(rdbtnGroupSearch);
		
		JButton search = new JButton("Search");
		search.addActionListener(new SearchActionListener());
		search.setFont(new Font("Arial", Font.PLAIN, 16));
		search.setBounds(487, 141, 116, 42);
		frame.getContentPane().add(search);
	}
	
	class groupsActionListener implements ActionListener
	{
		 public void actionPerformed(ActionEvent e)
		 	{
			 DisplayLists.createAndShowGUI(activeuser,null ,activeuser.getGroups() );
			 frame.dispose();
		 	}
		
	}
	class friendsActionListener implements ActionListener
	{
		 public void actionPerformed(ActionEvent e)
		 	{
			 DisplayLists.createAndShowGUI(activeuser,activeuser.getFriends() ,null );
			 frame.dispose();
		 	}
		
	}
	class timelineActionListener implements ActionListener
	{
		 public void actionPerformed(ActionEvent e)
		 	{
			 new User_Timeline(activeuser, activeuser);// Because the activeUser wants to go to his Timeline
			 frame.dispose();
		 	}
		
	}
	
	class SearchActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(rdbtnUsersSearch.isSelected()){
				User anotherUser = DataBase.findUser(searchfield.getText());
				if(anotherUser != null){
					new User_Timeline(activeuser, anotherUser);
				}
				else JOptionPane.showMessageDialog(null, "User could not be found, try another mail","Warning", JOptionPane.PLAIN_MESSAGE);
			}
			else if(rdbtnGroupSearch.isSelected()){
				Group agroup = DataBase.getGroupInstance(searchfield.getText());
				if(agroup != null){
					new Group_Timeline(agroup, activeuser);
				}
				else JOptionPane.showMessageDialog(null, "Group could not be found, try another group name", "Warning", JOptionPane.PLAIN_MESSAGE);
			}
		}
	}
}
