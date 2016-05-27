
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;

import javax.swing.*;



public class Post_View extends JPanel {

	private JPanel postPanel;
	private JPanel contentPane;
	private JPanel createpost;
	private JButton Post1;
	private JButton Post2;
	private JButton Post3;
	private JTextField postfield;
	private JButton Comment;
	private JButton Like;
	private int posts_displayed;
	private User activeUser;
	private User anotherUser;
	
	
	public Post_View(User activeUser, User anotherUser){//Used for displaying posts on User_Timeline
		this.activeUser = activeUser;
		this.anotherUser = anotherUser;
		
		contentPane = new JPanel();
		
		createpost = new JPanel();
		Post1 = new JButton("Post");
		Post1.addActionListener(new PostListener1());
		postfield = new JTextField(20);
		
		createpost.add(postfield, BorderLayout.NORTH);
		createpost.add(Post1, BorderLayout.CENTER);
		
		contentPane.add(createpost, BorderLayout.NORTH);
		
		if(anotherUser.getPersonalPosts().size()>=1){
//			Collections.sort(anotherUser.getPersonalPosts());
			for(Post post: anotherUser.getPersonalPosts()){
				postPanel.add(aPostView(post));
			}
			contentPane.add(postPanel);
		}
		
		
//		postPanel=aPostView(postToBeDisplayedUser(anotherUser));
		


		this.activeUser = activeUser;
		posts_displayed = 0;
		
		add(contentPane);
		
		


		
		
		
	}
	public Post_View(User activeUser, Group agroup){ //Used for displaying posts on Group_Timeline
		posts_displayed = 0;
		this.activeUser = activeUser;
		int i;
		//for(i=0; i<5;i++){
		//	aPostView(postToBeDisplayedGroup(agroup));			
		//}
		
	
		
		

	}
	public Post_View(User activeUser){ ////Used for displaying posts on Home_Page

		Post apost = new Post("Lalala", activeUser);
//		aPostView();

	}
	
	
	
	
	

	public JPanel aPostView(Post aPost){
		JPanel apanel = new JPanel();
		JLabel alabel = new JLabel(aPost.getPostText());
		JButton likebutton = new JButton("Like!");
        JButton commentbutton = new JButton("Comment");
        
//		postTextfield.setText(apost.getPostText());//TODO used for check
        
        
        JPanel actions = new JPanel();

        actions.add(likebutton);
        actions.add(commentbutton);
        
        setLayout(new FlowLayout());
        
        
        
		
		apanel.add(alabel,BorderLayout.NORTH);
		apanel.add(actions, BorderLayout.CENTER);

		
		
		
		
		
        this.setSize(getPreferredSize());
		return apanel;
	}
	
	

	public int postToBeDisplayedUser(User activeUser,User anotherUser){
		int count;
		if(activeUser.isFriend(anotherUser)){
			Collections.sort(anotherUser.getPersonalPosts());
		}
	
		if(auser.isFriend(auser)){									 
		Collections.sort(auser.getPersonalPosts()); //TODO check / Collections.sort refers to List not ArrayList
			return auser.getPersonalPosts().get(posts_displayed++);	
	}
		return null;
	}

	
	public Post postToBeDisplayedGroup(Group agroup){ 
		if(agroup.isMember(activeUser)){							 
			Collections.sort(agroup.getGroupPosts()); //TODO Collections.sort refers to List not ArrayList
			return agroup.getGroupPosts().get(posts_displayed++);
		}
		return null;
	}

	
	class PostListener1 implements ActionListener
	 {
		public void actionPerformed(ActionEvent e)
		{	
			DataBase.createPost(activeUser, anotherUser, null, postfield.toString());
		}
	 }

}