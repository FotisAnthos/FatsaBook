import java.util.ArrayList;

public abstract class Group {

	private String name;
	private String info;
	private static int No_ofGroups;
<<<<<<< HEAD
	private ArrayList<Post> groupPosts;
=======
	public User m_User;
	public Post m_Post;
>>>>>>> refs/remotes/origin/master

	public Group(String name, String info) {
		this.name = name;
		this.info = info;
	}

	//overrides toString()
	public String toString() {
		return name;
	}


	//getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public abstract boolean isMember(User user);
	public abstract void addMember(User user);
	public abstract boolean removeMember(User user);
	public abstract void printMembers();
	public abstract void addPost(Post post);
	public abstract void addReplyToPost(Post post, Post reply);
	public abstract void printWall();
	public abstract boolean canAddPost(User user);

	public ArrayList<Post> getGroupPosts() {
		return groupPosts;
	}

	public void setGroupPosts(ArrayList<Post> groupPosts) {
		this.groupPosts = groupPosts;
	}

	

}
