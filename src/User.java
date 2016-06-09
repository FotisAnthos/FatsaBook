import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;

/* Diagraftikan oi methodoi findSuggestedFriends,printSuggestedFriends,printCommonFriends,
 * printFriendList,printEnrolledGroups kai createPost */
public class User implements Serializable{
	
	private ArrayList<User> friends = new ArrayList<User>();
	private ArrayList<Group> groups = new ArrayList<Group>();	
	private List<Post> personalPosts = new ArrayList<Post>();
	
	private String name;
	private String mail;
	private char[] password;
	
	public User(String name, String mail, char[] cs) 
	{
		this.name = name;
		this.mail = mail;
		this.password = cs;
	}	

	public boolean isPasswordCorrect(char[] password)
	{
		if(password == null) {
			JOptionPane.showMessageDialog(null,"Password Incorrect!","Message",JOptionPane.PLAIN_MESSAGE);
			return false;
		}
		return(Arrays.equals(password, this.password));
	}
	
	
	public boolean isFriend(User other) {
		for(User friend : friends) {
			if(friend.getMail().equals(other.getMail()) && friend.getName().equals(other.getName()))
				return true;
		}

		return false;
	}


	public void addFriend(User newFriend) {
		if(!isFriend(newFriend)){
			friends.add(newFriend);
			newFriend.friends.add(this);
			JOptionPane.showMessageDialog(null,"You are now friends!","Message",JOptionPane.PLAIN_MESSAGE);
		}
	}

	public int removeFriend(User afriend){
		int reply = JOptionPane.showConfirmDialog(null, "Are you sure?","Message",JOptionPane.YES_NO_OPTION);
		if(reply == JOptionPane.YES_OPTION){
			friends.remove(afriend);
			afriend.friends.remove(this);
		}
		return reply;	
	}
	
	public boolean deleteFromGroup(Group agroup){
		if(agroup.removeMember(this)){
			groups.remove(agroup);
			return true;
		}

		return false;
		
	}

	public void addToGroup(Group group) {
		groups.add(group);
	}

	public ArrayList<User> findCommonFriends(User other) {
		ArrayList<User> commons = new ArrayList<User>();

		for(User myfriend : this.friends) {
			for(User hisfriend : other.friends) {
				if(myfriend.getName().equals(hisfriend.getName()) && myfriend.getMail().equals(hisfriend.getMail()))
					commons.add(myfriend);
			}
		}
		return commons;
	}

	public String toString() {
		return name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	

	public ArrayList<User> getFriends() {
		return friends;
	}

	public ArrayList<Group> getGroups() {
		return groups;
	}
	

	public List<Post> getPersonalPosts() {
		return personalPosts;
	}

	
	public void addPost(Post apost){
		personalPosts.add(apost);
	}
}
