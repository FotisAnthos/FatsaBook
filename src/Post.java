import java.sql.Timestamp;
import java.util.*;
import javax.swing.*;

public class Post implements Comparable<Post> {

	private Date date;
	private String postText;
	private User user;//the creator
	
	private ArrayList<Integer> replies; //replies -> String(?) -> postID
	private ArrayList<String> Likes; //likes -> String -> user.mail
	private static int No_ofPosts;
	/**
	 * the creator
	 */
	private User owner;
	private int post_id;

	

	public Post(String postText, User creator) {
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		Date date = new Date(ts.getTime());
		this.date = date;
		
		this.postText = postText;
		this.user = creator;
		this.replies = null;
		this.Likes = null;
		No_ofPosts++;
	}
	

	public Post(Date date, String postText, User user, ArrayList<Integer> replies, ArrayList<String> likes, User owner,
			int post_id) {
		this.date = date;
		this.postText = postText;
		this.user = user;
		this.replies = replies;
		Likes = likes;
		this.owner = owner;
		this.post_id = post_id;
	}//To be used only from DataBase class when loading saved files


	public void printPost () {
		System.out.println(this.toString());
		if(!replies.isEmpty()) //if post has replies
			printReplies();
	}

	public void printReplies () {
		for(int r : replies)
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




	public User getUser() {
		return user;
	}

	public void setReply(Post reply2) {
		// TODO Auto-generated method stub
		
		
	}

	public boolean display_Likes(){
		return false;
	}

	public static int getNo_ofPosts() {
		return No_ofPosts;
	}
<<<<<<< HEAD
	

	public String getPostText() {
		return postText;
	}


	public void setPostText(String postText) {
		this.postText = postText;
	}


	@Override //TODO check again, may create some problem in sorting //Override for implementation Comparable
	public int compareTo(Post apost) {
		 return (date.compareTo(apost.getDate()));
	}

=======
>>>>>>> refs/remotes/origin/master
	

	public String getPostText() {
		return postText;
	}


	public void setPostText(String postText) {
		this.postText = postText;
	}


	@Override //TODO check again, may create some problem in sorting //Override for implementation Comparable
	public int compareTo(Post apost) {
		 return (date.compareTo(apost.getDate()));
	}




}