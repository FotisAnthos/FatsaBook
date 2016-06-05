import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class Post implements Serializable {

	private Date date;
	private String postText;
	private User user;//the creator
	
	private ArrayList<Post> replies= new ArrayList<Post>();; //replies -> String(?) -> postID
	private ArrayList<User> Likes = new ArrayList<User>(); //likes -> String -> user.mail
	private static int No_ofPosts;
	/**
	 * the creator
	 */
	private User owner;
	private Group group;
	private int post_id;

	

	public Post(String postText, User creator) {
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		Date date = new Date(ts.getTime());
		this.date = date;
		
		this.postText = postText;
		this.user = creator;
//		this.replies = null;
//		this.Likes = null;
		No_ofPosts++;
	}
	

	public Post(Date date, String postText, User user, ArrayList<Post> replies, ArrayList<User> likes, User owner,
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
		for(Post r : replies)
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
		for(User like : Likes){
			if(like.equals(auser))
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
	
	public ArrayList<Post> getReplies(){
		return replies;
	}
	
	public void setOwner(User u){
		this.owner = u;
	}
	
	public User getOwner(){
		return owner;
	}
	
	public void setGroup(Group g){
		this.group = g;
	}
	
	public Group getGroup(){
		return group;
	}



//	public int compareTo(Post apost) {
//		 return (date.compareTo(apost.getDate()));
//	}


}