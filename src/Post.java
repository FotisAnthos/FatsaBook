import java.util.*;
import javax.swing.*;

public class Post {

	private Date date;
	private String postText;
	private User user;//the creator
	
	private ArrayList<int> replies; //replies -> String(?) -> postID
	private ArrayList<String> Likes; //likes -> String -> user.mail
	private static int No_ofPosts;
	/**
	 * the creator
	 */
	private User owner;
	private int post_id;
	public User m_User;
	public Post_View m_Post_View;

	public Post(Date date, String post, User user) {
		this.date = date;
		this.postText = post;
		this.user = user;
		this.replies = null;
		this.Likes = null;
		
	}

	public void printPost () {
		System.out.println(this.toString());
		if(!replies.isEmpty()) //if post has replies
			printReplies();
	}

	public void printReplies () {
		for(String r : replies)
		{
			DataBase.getPost(r);
		}

	}
	/*
	//dieukolynsh ektypwshs olwn twn replies toy post wste na xrhsimopoihthei sth
	//methodo getLatestPost ths klasshs Group
	public String printAllReplies() {
		String repl = "\n";
		String mark = "  -> ";

		Post temp = this.reply;

		while (temp != null){
			repl += mark + temp.toString() + "\n";
			temp = temp.reply;
		}

		return repl;
	}
	*/
	public boolean addLike(String auser)
	{
		if(!Likes.add(auser)) 
			{
				System.out.printf("Like couldn't be added!!: ", auser, "\n");
				return false;
			}
		return true;
	}
	
	public int NumberOfLikes()
	{
		return Likes.size();
	}

	//overrides toString
	public String toString() {
		String print = "| " +this.date+ " | " +this.user.getName()+ " : " +this.postText;

		return print;
	}

	//getters and setters
	public Date getDate() {
		return date;
	}


	public String getPost() {
		return postText;
	}

	public User getUser() {
		return user;
	}

	public void setReply(Post reply2) {
		// TODO Auto-generated method stub
		
		
	}

	public boolean display_Likes(){
		return false;
	}

	

	



}
