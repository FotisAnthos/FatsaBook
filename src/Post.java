import java.util.ArrayList;
import java.util.Date;

public class Post {

	private Date date;
	private String post;
	private User user;
	private Post reply;
	private ArrayList<User> Likes;

	public Post(Date date, String post, User user) {
		this.date = date;
		this.post = post;
		this.user = user;
		this.reply = null;
		this.Likes = null;
		
	}

	public void printPost () {
		System.out.println(this.toString());
		if(reply != null) //if post has replies
			printReplies();
	}

	public void printReplies () {
		Post replies = reply;

		while (replies != null){
			System.out.println("  -> " + replies.toString());
			replies = replies.reply;
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
	public void addLike(User auser)
	{
		if(!Likes.add(auser)) 
			{
				System.out.printf("Like couldn't be added!!: ", auser.getName(), "\n");
			}
	}
	public int NumberOfLikes()
	{
		return Likes.size();
	}

	//overrides toString
	public String toString() {
		String print = "| " +this.date+ " | " +this.user.getName()+ " : " +this.post;

		return print;
	}

	//getters and setters
	public Date getDate() {
		return date;
	}


	public String getPost() {
		return post;
	}

	public User getUser() {
		return user;
	}

	



}
