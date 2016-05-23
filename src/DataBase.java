import java.io.*;
import java.util.ArrayList;

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
	
	public static void print(){
		for( User u: users){
			System.out.println(u.getName() + " " + u.GetPassword());
		}
	}
	
	

	public static void createUser(String name, String mail, String password)
	{
		if(!isUser(mail)){
		User u = new User(name, mail, password);
		users.add(u);
		
		}
	}
		
				

	
	
	public static void deleteUser(User auser)
	{

		String input = JOptionPane.showInputDialog("Enter password to delete user");

		if(auser.isPasswordCorrect(input)) users.remove(auser); 
		JOptionPane.showMessageDialog(null, auser.getName()+ "Deleted!!", "User Deleted!", JOptionPane.INFORMATION_MESSAGE);
	}
	

	
	

	public static  boolean createGroup(String name, String info, boolean is_open) { //if group is to be open b==true else b==false
		if(!isGroup(name)){
			if(is_open){
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
	public static boolean save()
	{
		
		try {
			FileOutputStream fileOut = new FileOutputStream(".users.txt");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(users);
			out.close();
			fileOut.close();		
		}
		catch(IOException i) {
			i.printStackTrace();
			JOptionPane.showMessageDialog(null, "Users could not be saved to file", "Warning", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		finally {
			System.out.println("Users saved...");
		}
		try {
			FileOutputStream fileOut = new FileOutputStream(".groups.txt");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(groups);
			out.close();
			fileOut.close();		
		}
		catch(IOException i) {
			i.printStackTrace();
			JOptionPane.showMessageDialog(null, "Groups could not be saved to file", "Warning", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		finally {
			System.out.println("Groups saved...");
		}
		return true;
		
		
	}

	
	
	



	
	
	public static boolean retrieve()
	{
		

		
		return true;

	}


	public ArrayList<Group> getgroups() {
		// TODO Retrieve groups from savefiles
		return groups;

	}

	//TODO complete getUserInstance
	public static User getUserInstance(String username)
	{
		for(User u : users)
		{
			if(u.getName().equals(username))
			{
				return u;
			}
		}
		JOptionPane.showMessageDialog(null,"User not found!","Message",JOptionPane.WARNING_MESSAGE);
		return null;
	}

	public static Group getGroupInstance(String groupname)
	{
		for(Group g : groups)
		{
			if(g.getName().equals(groupname))
			{
				return g;
			}
		}
		JOptionPane.showMessageDialog(null,"Group not found!","Message",JOptionPane.WARNING_MESSAGE);

		return null;
	}
	
	//TODO check checkUser ** static?

	public static Group getPost(String postID) {
		for(Group gr : groups)
		{
			if(gr.getName().equals(postID))
			{
				return gr;
			}
		}
		return null;
		
	}



	public static boolean checkUserPassword(String name,String password)

	{
		for(User u : users)
		{
			if(u.getName().equals(name))
			{
//				while(true)
//				{
//				String input = JOptionPane.showInputDialog("Enter Input:");
				if(u.isPasswordCorrect(password)) return true;
//				}
			}
		}	
		JOptionPane.showMessageDialog(null,"User not found!","Message",JOptionPane.PLAIN_MESSAGE);
		return false;
	}

	public static boolean isUser(String mail)
	{
		for(User u : users)
		{
			if(u.getMail().equals(mail))
			{
				return true;
			}			
		}
		return false;
	}
	
	
	

	public static boolean isGroup(String g)
	{
		for(Group gr : groups)
		{
			if(gr.getName().equals(g))
			{
				return true;
			}
		}
		return false;
	}
	
	
	
	
	

}