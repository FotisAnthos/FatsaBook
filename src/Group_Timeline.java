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


public class Group_Timeline extends JFrame {

	private User u;
	private Group g;
	private JButton back;
	private  JButton addgroup;
	private  JButton deletegroup;
	private JButton Members_List;
	private JButton nextPosts;
	private JFrame frame;
	public DisplayLists m_Display_Lists;
	public Group m_Group;

	public Group_Timeline(Group g,User u){
		this.u= u;
		this.g=g;
		
		frame = new JFrame(g.getName() + "Timeline");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        back = new JButton("Back");
        addgroup = new JButton("Add group");
        deletegroup = new JButton("Delete group");
        nextPosts = new JButton("See more posts");
        
        if(g.isMember(u))
        	addgroup.setEnabled(false);
        else
        	deletegroup.setEnabled(false);
        
        addgroup.addActionListener(new addgroupListener());
        deletegroup.addActionListener(new deletegroupListener());
        back.addActionListener(new BackListener());
        nextPosts.addActionListener(new NextPostsListener());
        
        JPanel newContentPane = new Post_View(u,g);
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);
        
        JPanel rightPane = new JPanel();
		rightPane.setLayout(new BoxLayout(rightPane,
                BoxLayout.Y_AXIS));
		rightPane.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		rightPane.add(new JSeparator(SwingConstants.VERTICAL));
		rightPane.add(Box.createVerticalStrut(5));
		
		if(g!=null){
			rightPane.add(addgroup);
			rightPane.add(Box.createRigidArea(new Dimension(0,20)));
			rightPane.add(deletegroup);
			rightPane.add(Box.createRigidArea(new Dimension(0,20)));
		}
			
		rightPane.add(nextPosts);
		rightPane.add(Box.createRigidArea(new Dimension(0,20)));
		rightPane.add(back);
		
		frame.add(rightPane, BorderLayout.EAST);
		
		
		frame.pack();
		frame.setVisible(true);
	}
	
	class addgroupListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
				g.addMember(u);
				addgroup.setEnabled(false);
				deletegroup.setEnabled(true);
	        	DataBase.save();
		}
			
	}
	
	class deletegroupListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
				u.deleteFromGroup(g);
				addgroup.setEnabled(true);
				deletegroup.setEnabled(false);
	        	DataBase.save();
		}
			
	}
	
	class BackListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			frame.setVisible(false);
		}		
	}
	
	class NextPostsListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
		}
	}

}//end Group_Timeline