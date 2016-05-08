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
	
	public void deleteUser(User auser)
	{
		String input = JOptionPane.showInputDialog("Enter Input:");
		if(auser.isPasswordCorrect(input)) users.remove(auser);
	}
	
	public static void addGroup(Group agroup)
	{
		groups.add(agroup);
	}

	public ArrayList<User> getusers() {
		// TODO Retrieve users from savefiles
		return users;

	}
	//TODO save users
	public void saveUsers()
	{
		
	}

	public ArrayList<Group> getgroups() {
		// TODO Retrieve groups from savefiles
		return groups;
		
	}
	
	//TODO complete getUserInstance
	public User getUserInstance(String username)
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
	public Group getGroupInstance(String groupname)
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
	public static boolean isUser(String name)
	{
		for(User u : users)
		{
			if(u.getName().equals(name))
			{
				return true;
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
