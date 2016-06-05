import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JOptionPane;


public class PrivateGroup extends Group {


	private static int No_ofPrivateGroups;

	public PrivateGroup(String name, String info) {
		super(name,info);
	}
	
	public String getName() {
		return name;
	}
	
	public String getInfo() {
		return info;
	}

	//returns true if the current user is member of this group
	public boolean isMember(User user) {
		for(User m : members){
			if(m.getMail().equals(user.getMail()) && m.getName().equals(user.getName()))
				return true;
		}
		return false;
	}

	//adds the selected user if not a member
	public void addMember(User user) {
		if(isMember(user)){
			return;
		}
		else{
			members.add(user);
			user.addToGroup(this);
			JOptionPane.showMessageDialog(null,"You added " + this.getName()+ " to your groups!","Message",JOptionPane.PLAIN_MESSAGE);
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

//	public boolean addAdmin(){
//		return false;
//	}
//
//	public boolean isAdmin(){
//		return false;
//	}
//
//	public boolean removeAdmin(){
//		return false;
//	}
	

	

}