import java.io.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

//from this class we recover data from the save files
public final class DataBase {
	// TODO double check users & groups about static
	//TODO failsafe saving of all new staff if someone is to close the program 


	protected static  ArrayList<User> users = new ArrayList<User>();
	protected static ArrayList<Group> groups = new ArrayList<Group>();
	protected static ArrayList<Post> posts = new ArrayList<Post>();

	public User m_User;
	public Post m_Post;


	public DataBase() {		
		//		this.users = null;
		//		this.groups = null;
		//		this.posts = null;



	}

	public static User findUser(String mail) {
		for(User u: users) {
			if(mail.equals(u.getMail())){
				return u;
			}
		}
		return null;		
	}

	public static boolean createUser(String name, String mail, char[] password) {
		if(!isUser(mail)){
			User u = new User(name, mail, password);
			users.add(u);
			return true;
		}
		return false;
	}

	public static void deleteUser(User auser) {
		char[] input = JOptionPane.showInputDialog("Enter password to delete user").toCharArray();
		if(auser.isPasswordCorrect(input)) users.remove(auser); 
		JOptionPane.showMessageDialog(null, auser.getName()+ "Deleted!!", "User Deleted!", JOptionPane.INFORMATION_MESSAGE);
	}

	public static  boolean createGroup(String name, String info, boolean is_open) {
		//if group is to be open b==true else b==false
		if(!isGroup(name)) {
			if(is_open) {
				Group agroup = new OpenGroup(name, info);
				groups.add(agroup);
			}
			else {
				Group agroup = new PrivateGroup(name, info);
				groups.add(agroup);
			}
			return true; //Group Created
		}
		return false; //Group not Created		
	}

	public static boolean deleteGroup(String name){
		if(isGroup(name)){
			//TODO show confirmation panel
			Group agroup = getGroupInstance(name);
			groups.remove(agroup);

		}
		return false;		
	}

	//TODO save --find better way
	public static boolean save() {

		try {
			FileOutputStream fileOut = new FileOutputStream(".users.txt");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(users);
			out.close();
			fileOut.close();		
		}catch(IOException i) {
			i.printStackTrace();
			JOptionPane.showMessageDialog(null, "Users could not be saved to file", "Warning", JOptionPane.WARNING_MESSAGE);
			return false;
		}finally {
			System.out.println("Users saved...");
		}
		try {
			FileOutputStream fileOut = new FileOutputStream(".groups.txt");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(groups);
			out.close();
			fileOut.close();		
		}catch(IOException i) {
			i.printStackTrace();
			JOptionPane.showMessageDialog(null, "Groups could not be saved to file", "Warning", JOptionPane.WARNING_MESSAGE);
			return false;
		}finally {
			System.out.println("Groups saved...");
		}
		return true;


	}

	public static boolean retrieve() {

		return true;
	}


	public ArrayList<Group> getgroups() {
		// TODO Retrieve groups from savefiles
		return groups;
	}

	//TODO complete getUserInstance
	public static User getUserInstance(String username) {
		for(User u : users) {
			if(u.getName().equals(username)) {
				return u;
			}
		}
		JOptionPane.showMessageDialog(null,"User not found!","Message",JOptionPane.WARNING_MESSAGE);
		return null;
	}

	public static Group getGroupInstance(String groupname) {
		for(Group g : groups) {
			if(g.getName().equals(groupname)) {
				return g;
			}
		}
		JOptionPane.showMessageDialog(null,"Group not found!","Message",JOptionPane.WARNING_MESSAGE);

		return null;
	}



	public static Group getPost(int r) {
		for(Group gr : groups) {
			if(gr.getName().equals(r)) {
				return gr;
			}
		}
		return null;
	}

	public static boolean checkUserPassword(String mail,char[] password) {
		for(User u : users) {
			if(u.getMail().equals(mail)) {
				//				while(true)
				//				{
				//				String input = JOptionPane.showInputDialog("Enter Input:");
				if(u.isPasswordCorrect(password)) 
					return true;
				//				}
			}
		}	
		JOptionPane.showMessageDialog(null,"User not found!","Message",JOptionPane.PLAIN_MESSAGE);
		return false;
	}

	public static boolean isUser(String mail) {
		for(User u : users) {
			if(u.getMail().equals(mail)) {
				return true;
			}			
		}
		return false;
	}

	public static boolean isGroup(String g) {
		for(Group gr : groups) {
			if(gr.getName().equals(g)) {
				return true;
			}
		}
		return false;
	}

	public static ArrayList<User> getUsers() {
		return users;
	}

	public static void setUsers(ArrayList<User> users) {
		DataBase.users = users;
	}

	public static ArrayList<Group> getGroups() {
		return groups;
	}

	public static void setGroups(ArrayList<Group> groups) {
		DataBase.groups = groups;
	}

	public static ArrayList<Post> getPosts() {
		return posts;
	}

	public static void setPosts(ArrayList<Post> posts) {
		DataBase.posts = posts;
	}
	
	public static void createPost(User creator, User anotherUser, Group agroup, String PostText){
		Post apost = new Post(PostText, creator);
		if(anotherUser!=null || agroup!=null){
			if(anotherUser!=null && DataBase.isUser(anotherUser.getMail())){
				anotherUser.addPost(apost);
			}
			else if(agroup!=null && DataBase.isGroup(agroup.getName())){
				agroup.addPost(apost);
			}
		}















	}

}





