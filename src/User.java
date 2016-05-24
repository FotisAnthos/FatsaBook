import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;


public class User {
	
	private ArrayList<User> friends = new ArrayList<User>();
	private ArrayList<Group> groups;
	
	private ArrayList<Post> personalPosts;

	
	

	private String name;
	private String mail;
	private String password;
	public User_Timeline m_User_Timeline;
	//TODO check password
	public User(String name, String mail, String cs) 
	{
		this.name = name;
		this.mail = mail;
		this.password = cs;
		
		friends = new ArrayList<User>();
		groups = new ArrayList<Group>();
		personalPosts = new ArrayList<Post>();
	}
	
	

	public boolean isPasswordCorrect(String passkey)
	{
		return(passkey.equals(password));
	}
	
	public boolean isFriend(User other) {
		for(User friend : friends) {
			if(friend.getMail().equals(other.getMail()) && friend.getName().equals(other.getName()))
				return true;
		}

		return false;
	}


	public void addFriend(User newFriend) {
//		if(this.getMail().equals(newFriend.getMail())) {
//			System.out.println("The user is the same!");
//			return;
//		}
//		else {
//			if(isFriend(newFriend)) {
//				System.out.println("Users are already friends!");
//				return;
//			}
//		}

		friends.add(newFriend);
		newFriend.friends.add(this);
		JOptionPane.showMessageDialog(null,"You are now friends!","Message",JOptionPane.PLAIN_MESSAGE);
	}

	public void removeFriend(User afriend){
//		if(friends.remove(afriend))
//			return true;
//		return false;
		friends.remove(afriend);
		afriend.friends.remove(this);
	}
	
	public void enrollInGroup(Group agroup) {

		if(agroup.isMember(this))
			System.out.println(name+" is already a member in the group "+agroup.getName());
		else {
			agroup.addMember(this);
		}
	}
	public boolean deleteFromGroup(Group agroup){
		if(agroup.removeMember(this))
			return true;
		return false;
		
	}

	public void addToGroup(Group group) {
		groups.add(group);
	}

	public ArrayList<User> findCommonFriends(User other) {
		ArrayList<User> commons = new ArrayList<User>();

		for(User friends1 : this.friends) {
			for(User friends2 : other.friends) {
				if(friends2.hashCode() == friends1.hashCode())
					commons.add(friends1);
			}
		}

		return commons;
	}

	public ArrayList<User> findSuggestedFriends() {

		ArrayList<User> suggested = new ArrayList<User>();

		for(User friend : this.friends) {
			for(User friendsfriend : friend.friends) {
				if((!this.friends.contains(friendsfriend)) && (!friendsfriend.name.equals(this.name))) {
					suggested.add(friendsfriend);
				}

			}
		}
		return suggested;
	}

	public void printSuggestedFriends() {
		ArrayList<User> sugfriends = new ArrayList<User>();
		sugfriends = findSuggestedFriends();

		System.out.println("----------------------------------");
		System.out.println("Suggested Friends for " + this.name + " :");

		for(User user : sugfriends)
			System.out.println(user.name);

		System.out.println("----------------------------------");
	}

	public void printCommonFriends(User other) {
		System.out.println("********************************");
		System.out.println("Common friends of "+this.name+" and "+other.name);
		System.out.println("********************************");

		int counter = 1;

		ArrayList<User> commons;
		commons = findCommonFriends(other);

		for(User common : commons) {
			System.out.println(counter+": "+common.toString());
			counter++;
		}

		System.out.println("---------------------------------");
	}

	public void printFriendList() {
		System.out.println("********************************");
		System.out.println("Friends of "+this.getName());
		System.out.println("********************************");

		int counter = 1;
		for(User friend : friends) {
			System.out.println(counter+": "+friend.getName());
			counter ++;
		}
		System.out.println("---------------------------------");
	}
	

	public void printEnrolledGroups() {
		System.out.println("********************************");
		System.out.println("Groups that "+this.name+" has enrolled");
		System.out.println("********************************");

		int counter = 1;
		for(Group group : groups) {
			System.out.println(counter+": "+group.toString());
			counter ++;
		}
		System.out.println("---------------------------------");
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
	
	public String getPassword(){
		return password;
	}

	public ArrayList<User> getFriends() {
		return friends;
	}

	public ArrayList<Group> getGroups() {
		return groups;
	}

	public Post createPost(String aString) {
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		Date date = new Date(ts.getTime());

		Post apost = new Post(date, aString, this);
		personalPosts.add(apost);
		return apost;
		
	}
	
}
