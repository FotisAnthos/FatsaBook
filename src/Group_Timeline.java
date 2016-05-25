import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

 /*
  * Εμφανίζει το Χρονολόγιο μιας ομάδας με τις πιο πρόσφατες 
  * δημοσιεύσεις σε αυτή και επιλογές όπως εμφάνιση λίστας 
  * μελών (Group_Members) , προσθήκη/διαγραφή απο μέλος και 
  * δημιουργία ανάρτησης.
  * 
  * Περιέχει την εσωτερική κλάση Group_Members
  * Εμφανίζει τη λίστα μελών της ομάδας καθώς και 
  * τις επιλογές προσθήκης/διαγραφής απο μέλος ή διαχειριστής.
  */
public class Group_Timeline extends JFrame {

	private JFrame groupFrame;
	
	private JButton members;
	private JButton postView;
	private JButton createPost;
	
	private JList postlist;
	
	private JScrollPane scrollPane;
	
	private JPanel panel;
	private JPanel buttonPanel;
	private JPanel listPanel;
	
	public Group group;
	
	public Group_Timeline(Group agroup){
		this.group = agroup;
		
		String title = group.getName()+" timeline";
		groupFrame = new JFrame(title);
		members = new JButton("Members");
		postView = new JButton("See Group's posts");
		createPost = new JButton("Create a post");
		
		postlist = new JList();
		scrollPane = new JScrollPane();
		panel = new JPanel(new BorderLayout());
		buttonPanel = new JPanel(new FlowLayout());
		listPanel = new JPanel();
		
		members.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new Group_Members(group);
			}
		});
		
		ButtonListener listener = new ButtonListener();
		createPost.addActionListener(listener);
		postView.addActionListener(listener);
		
		buttonPanel.add(createPost);
		buttonPanel.add(postView);
		buttonPanel.add(members);
		listPanel.add(postlist);
		listPanel.add(scrollPane);
		panel.add(buttonPanel, BorderLayout.EAST);
		panel.add(listPanel, BorderLayout.WEST);
		groupFrame.setContentPane(panel);
		
		groupFrame.setVisible(true);
		groupFrame.setSize(500, 500);

	}
	
	public class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == createPost) {
				
			}
			if(e.getSource() == postView) {
				
			}
		}
		
	}
	
	
	public class Group_Members extends JFrame {
		
		private JFrame memberFrame;
		private Group group;
		private ArrayList<User> members;
		private JList memberList;
		private JButton joingroup, leavegroup;
		private JButton addmember, deletemember;
		private JButton addadmin, deleteadmin;
		
		public Group_Members(Group agroup) {
			members = new ArrayList<User>();
			this.group=agroup;
			String title = group.getName()+" group members";
			memberFrame = new JFrame(title);
			
		}
	}
}