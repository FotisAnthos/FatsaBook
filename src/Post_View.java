
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class Post_View extends JPanel {
	
	private Post aPost;

	private JPanel postPanel = new JPanel();
	private JPanel groupallPanel = new JPanel();
	private JPanel createpost = new JPanel();
	private JButton Post1;
	private JButton Post2;
	private JTextField postfield;
	private JButton Comment;
	private JButton Like;
	private User activeUser;
	private User anotherUser;
	private Group agroup;
	
	
	public Post_View(User activeUser, User anotherUser){//Used for displaying posts on User_Timeline
		
		int i;
		this.activeUser = activeUser;
		this.anotherUser = anotherUser;

		postPanel = new JPanel();
		postPanel.setLayout(new BoxLayout(postPanel,BoxLayout.Y_AXIS));

		createpost = new JPanel();
		groupallPanel = new JPanel();
		groupallPanel.setLayout(new BoxLayout(groupallPanel,BoxLayout.Y_AXIS));
		
		Post1 = new JButton("Post");
		postfield = new JTextField(20);
		Post1.addActionListener(new PostListener1());


		createpost.add(postfield, BorderLayout.NORTH);
		createpost.add(Post1, BorderLayout.CENTER);
		
		
		postToBeDisplayedUser(activeUser,anotherUser);
//		if(anotherUser.getPersonalPosts().size()>=1){
//			for(i=anotherUser.getPersonalPosts().size();i>0;i--){ // gia na emfanizetai to teleutaio post pou dimiourgithike prwto
//				postPanel.add(aPostView(anotherUser.getPersonalPosts().get(i-1)));
//			}
//		}
		groupallPanel.add(createpost);
		groupallPanel.add(postPanel);
		add(groupallPanel);

	}
	
	
	public Post_View(User activeUser, Group agroup){ //Used for displaying posts on Group_Timeline\
		this.activeUser = activeUser;
		this.agroup = agroup;	
		int i;

		postPanel.setLayout(new BoxLayout(postPanel,BoxLayout.Y_AXIS));

		createpost = new JPanel();
		groupallPanel = new JPanel();
		groupallPanel.setLayout(new BoxLayout(groupallPanel,BoxLayout.Y_AXIS));
		
		Post1 = new JButton("Post");
		postfield = new JTextField(20);
		Post1.addActionListener(new PostListener2());

		createpost.add(postfield, BorderLayout.NORTH);
		createpost.add(Post1, BorderLayout.CENTER);

		if(agroup.getGroupPosts().size()>=1){
			for(i=agroup.getGroupPosts().size();i>0;i--){ // gia na emfanizetai to teleutaio post pou dimiourgithike prwto
				postPanel.add(aPostView(agroup.getGroupPosts().get(i-1)));
			}
		}
		groupallPanel.add(createpost);
		groupallPanel.add(postPanel);
		add(groupallPanel);
	}
	
	public Post_View(User activeUser){ ////Used for displaying posts on Home_Page

	}

	public JPanel aPostView(Post aPost){
		this.aPost = aPost;
		JPanel apanel = new JPanel();
		JLabel alabel = new JLabel(aPost.getUser().getName() + ": " +aPost.getPostText());

		JButton likebutton = new JButton("Like!");
		JButton commentbutton = new JButton("Comment");
		likebutton.addActionListener(new likeButtonListener());
		commentbutton.addActionListener(new commentButtonListener());

		JPanel actions = new JPanel();

		actions.add(likebutton);
		actions.add(commentbutton);

		apanel.add(alabel,BorderLayout.NORTH);
		if (aPost.NumberOfLikes()>0){
			JLabel likeslabel = new JLabel(aPost.NumberOfLikes() + " ");
			apanel.add(likeslabel);
		}
		
		apanel.add(actions, BorderLayout.CENTER);


		this.setSize(getPreferredSize());
		return apanel;
	}



	public void postToBeDisplayedUser(User activeUser,User anotherUser){
		int i;
		if(anotherUser.getPersonalPosts().size()>=1){
			postPanel.removeAll();
			for(i=anotherUser.getPersonalPosts().size();i>0;i--){ // gia na emfanizetai to teleutaio post pou dimiourgithike prwto
				postPanel.add(aPostView(anotherUser.getPersonalPosts().get(i-1)));
			}
		}
	}


//	public Post postToBeDisplayedGroup(Group agroup){ 
//		if(agroup.isMember(activeUser)){							 
//			Collections.sort(agroup.getGroupPosts()); //TODO Collections.sort refers to List not ArrayList
//			return agroup.getGroupPosts().get(posts_displayed++);
//		}
//		return null;
//	}


	class PostListener1 implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{	
			DataBase.createPost(activeUser, anotherUser, null, postfield.getText());
			postfield.setText("");
			postToBeDisplayedUser(activeUser,anotherUser);
			remove(groupallPanel);
			add(groupallPanel);
			repaint();
			revalidate();
			DataBase.save();
		}
	}
	
	class PostListener2 implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{	
			DataBase.createPost(activeUser, null, agroup, postfield.getText());
			postfield.setText("");
			DataBase.save();
		}
	}
	
	class PostListener3 implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{	
			DataBase.createPost(activeUser, anotherUser, null, postfield.getText());
//			DataBase.save();
		}
	}
	
	class likeButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{	
			aPost.addLike(activeUser);
			DataBase.save();
		}
	}
	
	class commentButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{	
			
		}
	}

}