
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class Home_Page extends JFrame{

	private JFrame frame;
	private JButton search;
	private JButton groups;
	private JButton friends;
	private JButton timeline;
	private JButton nextposts;
	private User activeuser;
	private JScrollPane scrollpane;
	private JLayeredPane layer;

	private JPanel contentPane;


	public Home_Page(User activeUser) //receives the active user
	{
		super("My HomePage");
		activeuser= activeUser;
		contentPane = new JPanel();
		//LayerPane
		layer = new JLayeredPane();

		//ScrollPane
		scrollpane = new JScrollPane(layer);





		//Buttons
		search = new JButton("Search");//Opens a new Search Screen
		groups = new JButton("Groups");//Opens a Screen with a list of groups the user is enlisted to
		friends = new JButton("Friends");//Opens a Screen with a list of Users the user is friends with
		timeline = new JButton("Timeline");//Opens a Screen with the user's posts
		nextposts = new JButton("More Posts");//Displays more posts from groups and friends to the MainPage

		contentPane.add(search);
		contentPane.add(groups);
		contentPane.add(friends);
		contentPane.add(timeline);
		contentPane.add(nextposts);
		search.addActionListener(new SearchActionListener());
		groups.addActionListener(new groupsActionListener());
		friends.addActionListener(new friendsActionListener());
		timeline.addActionListener(new timelineActionListener());
		nextposts.addActionListener(new nextpostsActionListener());

		//		 JComponent newContentPane = new Post_View(activeUser);
		//		 newContentPane.setOpaque(true); //content panes must be opaque
		//	     this.setContentPane(newContentPane);




		this.setContentPane(contentPane);
		contentPane.add(scrollpane);


		this.pack();
		this.getContentPane().setLayout(new FlowLayout());
		this.setSize(getPreferredSize());
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);


	}



	class SearchActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//TODO 
			new SearchScreen(activeuser);
		}

	}
	class groupsActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			DisplayLists.createAndShowGUI(activeuser,null ,activeuser.getGroups() );
		}

	}
	class friendsActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			DisplayLists.createAndShowGUI(activeuser,activeuser.getFriends() ,null );
		}

	}
	class timelineActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			new User_Timeline(activeuser, activeuser);// Because the activeUser wants to go to his Timeline
		}

	}
	class nextpostsActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//TODO
			post();
		}

	}

	public void post(){





	}

}


