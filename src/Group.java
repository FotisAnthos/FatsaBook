import java.io.Serializable;
import java.util.ArrayList;

public abstract class Group implements Serializable{

	protected String name;
	protected String info;
	protected ArrayList<Post> posts = new ArrayList<Post>();
	protected ArrayList<User> members = new ArrayList<User>();


	public Group(String name,String info) {
			this.name = name;
			this.info = info;
	}

	//overrides toString()
	public String toString() {
		return name;
	}


	//getters and setters
	public String getName(){
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public abstract String getInfo();

	public void setInfo(String info) {
		this.info = info;
	}

	public abstract boolean isMember(User user);
	public abstract void addMember(User user);
	public abstract boolean removeMember(User user);
	public abstract void addPost(Post post);
	public abstract void addReplyToPost(Post post, Post reply);
	public abstract boolean canAddPost(User user);

	public ArrayList<Post> getGroupPosts() {
		return posts;
	}

	public void setGroupPosts(ArrayList<Post> groupPosts) {
		this.posts = groupPosts;
	}


}