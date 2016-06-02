import java.sql.Timestamp;
import java.util.*;
import javax.swing.*;

public class Post implements Comparable<Post> {

	private Date date;
	private String postText;
	private User user;//the creator
	private User anotherUser;//points to the user timeline the post is displayed, null if displayed in a group
	private Group agroup;//points to the group timeline the post is displayed, null if displayed in a User's timeline
	private ArrayList<Integer> replies; //replies -> String(?) -> postID
	private ArrayList<User> Likes; //likes -> String -> user.mail
	private static int No_ofPosts;
	/**
	 * the creator
	 */
	private User owner;
	private int post_id;
	
	
	public Post(String postText, User creator, User anotherUser) {//Used for creating posts in User's timelines
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		Date date = new Date(ts.getTime());
		this.date = date;
		this.anotherUser = anotherUser;
		
		this.postText = postText;
		this.user = creator;
		this.replies = null;
		this.Likes = null;
		No_ofPosts++;
	}
	

	public Post(String postText, User creator, Group agroup) {//Used for creating posts in Groups
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		Date date = new Date(ts.getTime());
		this.date = date;
		this.agroup = agroup;
		
		this.postText = postText;
		this.user = creator;
		this.replies = null;
		this.Likes = null;
		No_ofPosts++;
	}
	

	public Post(Date date, String postText, User user, ArrayList<Integer> replies, ArrayList<User> likes, User owner,
<<<<<<< HEAD
			int post_id) {//Used when retrieving from save files
=======
			int post_id) {
>>>>>>> refs/remotes/origin/master
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
	public boolean addLike(User auser)
	{
<<<<<<< HEAD
		if(!Likes.add(auser))
			{
				System.out.printf("Like couldn't be added!!: ", auser, "\n");
=======
		for(User like : Likes){
			if(like.equals(auser))
>>>>>>> refs/remotes/origin/master
				return false;
		}
		Likes.add(auser);
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