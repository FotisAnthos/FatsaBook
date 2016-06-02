import java.sql.Timestamp;
import java.util.*;
import javax.swing.*;

public class Post implements Comparable<Post> {

	private Date date;
	private String postText;
	private User creator;//the creator
	private User anotherUser;//points to the user timeline the post is displayed, null if displayed in a group
	private Group agroup;//points to the group timeline the post is displayed, null if displayed in a User's timeline
	private ArrayList<Integer> replies; //replies -> String(?) -> postID
	private ArrayList<User> Likes; //likes -> String -> user.mail
	private static int No_ofPosts;
	
	
	private int post_id;


	public Post(String postText, User creator, User anotherUser, Group agroup) {
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		Date date = new Date(ts.getTime());
		this.date = date;
		this.anotherUser = anotherUser;//null if posted in a group
		this.setAgroup(agroup);//null if posted in a user's timeline

		this.postText = postText;
		this.creator = creator;
		this.replies = null;
		this.Likes = null;
		No_ofPosts++;
	}


	


	public Post(Date date, String postText, User creator, User anotherUser, Group agroup, ArrayList<Integer> replies, ArrayList<User> likes,
			int post_id) {

		this.date = date;
		this.postText = postText;
		this.creator = creator;
		this.anotherUser = anotherUser;//null if posted in a group
		this.setAgroup(agroup);//null if posted in a user's timeline
		this.replies = replies;
		this.Likes = likes;

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

		if(!Likes.add(auser))
		{
			System.out.printf("Like couldn't be added!!: ", auser, "\n");

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
		String print = "| " +this.date+ " | " +this.creator.getName()+ " : " +this.postText;

		return print;
	}

	//getters and setters
	public Date getDate() {
		return date;
	}




	public User getCreator() {
		return creator;
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


	public User getAnotherUser() {
		return anotherUser;
	}


	public void setAnotherUser(User anotherUser) {
		this.anotherUser = anotherUser;
	}


	public Group getAgroup() {
		return agroup;
	}





	public void setAgroup(Group agroup) {
		this.agroup = agroup;
	}





	@Override //TODO check again, may create some problem in sorting //Override for implementation Comparable
	public int compareTo(Post apost) {
		return (date.compareTo(apost.getDate()));
	}


}