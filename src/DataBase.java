import java.util.ArrayList;

import javax.swing.JOptionPane;

//from this class we recover data from the save files
public class DataBase {
	// TODO double check users & groups
	//TODO failsafe saving of all new staff if someone is to close the program 
	private static ArrayList<User> users;
	private static ArrayList<Group> groups;
	
	
	public DataBase() {
		
		this.users = null;
		this.groups = null;
	}
	
	
	public void addUser(User auser)
	{
		users.add(auser);
	}
	
	public static void addGroup(Group agroup)
	{
		groups.add(agroup);
	}

	public ArrayList<User> getusers() {
		// TODO Retrieve users from savefiles
		return users;

	}

	public ArrayList<Group> getgroups() {
		// TODO Retrieve groups from savefiles
		return groups;
		
	}
	
	//TODO complete getUser
	public User getUser(String username)
	{
		for(User u : users)
		{
			if(u.getName().equals(username))
			{
				
			}
		}
		return null;
	}
	//TODO check checkUser ** static?
	public static boolean checkUser(String name)
	{
		for(User u : users)
		{
			if(u.getName().equals(name))
			{
				while(true)
				{
				String input = JOptionPane.showInputDialog("Enter Input:");
				if(u.isPasswordCorrect(input)) return true;
				
				}
			}
			
		}
		
		
		JOptionPane.showMessageDialog(null,"User not found!","Message",JOptionPane.PLAIN_MESSAGE);
		return false;
	}
	
	
	
	public static boolean isgroup(String g)
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
