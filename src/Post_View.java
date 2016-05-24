import java.util.Collections;

import javax.swing.*;



public class Post_View extends JFrame {

	private JPanel postsPanel;
	private JButton Comment;
	private JButton Like;
	private int posts_displayed;

	public Post_View(User theUser, String displayPlace){ //Receives the user for whom to display posts,
		//String displayPlace refers to where the posts will be displayed(User_Timeline, Home_Page, Group_Timeline)
		//refered to by their name
		posts_displayed = 0;
		
		
		if(displayPlace == "User_Timeline"){//TODO
			
		}
		else if(displayPlace == "Group_Timeline"){//TODO
		
		}
		else if(displayPlace == "Home_Page"){//TODO
			
		}
		
		

	}
	
	public Comparable<Post> postsToBeDisplayed(User auser, int posts_displayed){//int posts_displayed refers to how many posts have already 
		if(auser.isFriend(auser)){									//displayed by Post_View 
			
			Collections.sort(auser.getPersonalPosts()); //TODO Collections.sort refers to List not ArrayList
			
			
			return auser.getPersonalPosts().get(posts_displayed++);

			
		}
		return null;

	
	}//end Post_View
}