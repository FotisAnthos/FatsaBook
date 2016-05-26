import java.awt.FlowLayout;
import java.util.Collections;

import javax.swing.*;



public class Post_View extends JPanel {

	private JPanel postPanel;
	private JButton Comment;
	private JButton Like;
	private int posts_displayed;
	private User activeUser;
	
	
	public Post_View(User activeUser, User anotherUser){//Used for displaying posts on User_Timeline
		JPanel contentPane = new JPanel();
		
		this.activeUser = activeUser;
		posts_displayed = 0;
		
		
		//aPostView(postToBeDisplayedUser(anotherUser));
		
		
		
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
		
	}
	
	
	
	
	
	public JPanel aPostView(){
		JPanel apanel = new JPanel();
		JButton likebutton = new JButton("Like!");
        JButton commentbutton = new JButton("Comment");
        Post apost = new Post("Lalala", activeUser);
		JTextField postTextfield = new JTextField();
		postTextfield.setText(apost.getPostText());//TODO used for check
        
        
        ButtonGroup actions = new ButtonGroup();
        actions.add(likebutton);
        actions.add(commentbutton);
        
        setLayout(new FlowLayout());
        
        
        
		
		
		
		
		
		
		
        this.setSize(getPreferredSize());
		return apanel;
	}
	
	
	public Post postToBeDisplayedUser(User auser){
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
}