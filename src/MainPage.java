import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

	
	public class MainPage extends JFrame{
		
		
		private JButton search;
		private JButton groups;
		private JButton friends;
		private JButton timeline;
		private JButton nextposts;
		public DisplayLists m_DisplayLists;
		public SearchScreen m_SearchScreen;
		public User m_User;
		
		public MainPage(String string)
		{
			JPanel mainpanel = new JPanel();
			//Buttons
			search = new JButton("Search");//Opens a new Search Screen
			groups = new JButton("Groups");//Opens a Screen with a list of groups the user is enlisted to
			friends = new JButton("Friends");//Opens a Screen with a list of Users the user is friends with
			timeline = new JButton("Timeline");//Opens a Screen with the user's posts
			nextposts = new JButton("More Posts");//Displays more posts from groups and friends to the MainPage
			
			mainpanel.add(search);
			mainpanel.add(groups);
			mainpanel.add(friends);
			mainpanel.add(timeline);
			mainpanel.add(nextposts);
			search.addActionListener(new SearchActionListener());
			groups.addActionListener(new groupsActionListener());
			friends.addActionListener(new friendsActionListener());
			timeline.addActionListener(new timelineActionListener());
			nextposts.addActionListener(new nextpostsActionListener());
			
			
			this.setContentPane(mainpanel);
			
			
			this.setSize(1000,500);
			this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			pack();
			this.setVisible(true);
		}
		
		
		
		class SearchActionListener implements ActionListener
		{
			 public void actionPerformed(ActionEvent e)
			 	{
				 	//TODO 
				 	new SearchScreen();
			 	}
			
		}
		class groupsActionListener implements ActionListener
		{
			 public void actionPerformed(ActionEvent e)
			 	{
				 	//TODO

			 	}
			
		}
		class friendsActionListener implements ActionListener
		{
			 public void actionPerformed(ActionEvent e)
			 	{
				 	//TODO

			 	}
			
		}
		class timelineActionListener implements ActionListener
		{
			 public void actionPerformed(ActionEvent e)
			 	{
				 	new User_Timeline();

			 	}
			
		}
		class nextpostsActionListener implements ActionListener
		{
			 public void actionPerformed(ActionEvent e)
			 	{
				 	//TODO

			 	}
			
		}

	}

	/**
	 * @author Flotis
	 * @version 1.0
	 * @updated 17-Ìáú-2016 6:39:11 ìì
	 */
	class nextpostsActionListener implements ActionListener {

		public nextpostsActionListener(){

		}

		public void finalize() throws Throwable {

		}
		/**
		 * 
		 * @param e
		 */
		public void actionPerformed(ActionEvent e){

		}
	}//end nextpostsActionListener

	/**
	 * @author Flotis
	 * @version 1.0
	 * @updated 17-Ìáú-2016 6:39:11 ìì
	 */
	class timelineActionListener implements ActionListener {

		public timelineActionListener(){

		}

		public void finalize() throws Throwable {

		}
		/**
		 * 
		 * @param e
		 */
		public void actionPerformed(ActionEvent e){

		}
	}

	/**
	 * @author Flotis
	 * @version 1.0
	 * @updated 17-Ìáú-2016 7:18:16 ìì
	 */
	public class Home_Page extends JFrame {

		/**
		 * @author Flotis
		 * @version 1.0
		 * @created 17-Ìáú-2016 7:18:16 ìì
		 */
		class SearchActionListener implements ActionListener {

			public SearchActionListener(){

			}

			public void finalize() throws Throwable {

			}
			/**
			 * 
			 * @param e
			 */
			public void actionPerformed(ActionEvent e){

			}
		}//end SearchActionListener

		/**
		 * @author Flotis
		 * @version 1.0
		 * @created 17-Ìáú-2016 7:18:16 ìì
		 */
		class groupsActionListener implements ActionListener {

			public groupsActionListener(){

			}

			public void finalize() throws Throwable {

			}
			/**
			 * 
			 * @param e
			 */
			public void actionPerformed(ActionEvent e){

			}
		}//end groupsActionListener

		/**
		 * @author Flotis
		 * @version 1.0
		 * @created 17-Ìáú-2016 7:18:16 ìì
		 */
		class friendsActionListener implements ActionListener {

			public friendsActionListener(){

			}

			public void finalize() throws Throwable {

			}
			/**
			 * 
			 * @param e
			 */
			public void actionPerformed(ActionEvent e){

			}
		}//end friendsActionListener

		private JButton friends;
		private JButton groups;
		private JButton nextposts;
		private JButton search;
		private JButton timeline;
		public SearchScreen m_SearchScreen;
		public Display_Lists m_Display_Lists;
		public User m_User;

		public Home_Page(){

		}

		public void finalize() throws Throwable {
			super.finalize();
		}
		/**
		 * 
		 * @param string
		 */
		public Home_Page(String string){

		}
	}//end Home_Page//end timelineActionListener