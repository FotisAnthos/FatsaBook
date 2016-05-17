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
			 	//TODO

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
 * @updated 17-Ìבת-2016 6:39:11 לל
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
 * @updated 17-Ìבת-2016 6:39:11 לל
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
}//end timelineActionListener
