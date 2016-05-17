import java.util.ArrayList;


public class PrivateGroup extends Group{
	//TODO take them to class Group
	private ArrayList<User> members;
	private ArrayList<Post> posts;
	private ArrayList<User> admins;
	private static int No_ofPrivateGroups;

	public PrivateGroup(String name, String info) {
		super(name, info);

		members = new ArrayList<User>();
		posts = new ArrayList<Post>();
	}

	//returns true if the current user is member of this group
	public boolean isMember(User user) {
		if(members.contains(user))
			return true;
		return false;
	}

	//adds the selected user if not a member
	public void addMember(User user) {
		if(isMember(user)){
			System.out.println(user.getName()+" is already a member!");
			return;
		}

		members.add(user);
		user.addToGroup(this);

	}

	public void printMembers() {
		System.out.println("********************************");
		System.out.println("Members of group "+this.getName());
		System.out.println("********************************");

		int counter = 1;
		for(User member : members) {
			System.out.println(counter+": "+member.getName());
			counter++;
		}

	}

	//returns true if the current user can add a post in this group
	public boolean canAddPost(User user) {
		if(isMember(user))
			return true;

		return false;
	}

	//adds a post in the selected group
	public void addPost(Post post) {
		if(canAddPost(post.getUser())) //only if the user can add a post
			posts.add(post);
		else
			System.out.println("User " + post.getUser() + " cannot post on Private Group " + super.getName());
	}

	public void addReplyToPost(Post post, Post reply) {
		if(canAddPost(reply.getUser())) //only if the user can add a reply
			post.setReply(reply);
		else
			System.out.println("User " + reply.getUser() + " cannot post on Private Group " + super.getName());

	}

	public void printWall() {
		System.out.println("Group " + super.getName() + " wall");
		for (Post post : posts){
			post.printPost();
		}
	}
	public boolean removeMember(User user){
		if(members.remove(user))
			return true;
		return false;
	}

	public boolean addAdmin(){
		return false;
	}

	public boolean isAdmin(){
		return false;
	}

	public boolean removeAdmin(){
		return false;
	}
	

	

}
