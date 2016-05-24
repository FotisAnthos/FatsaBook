import java.util.ArrayList;

public class main {
	
	

	public static void main(String[] args) {
			
		
		DataBase.createUser("lydia","lydia","lydia");
		DataBase.createUser("rafos","rafos","rafos");
//		DataBase.users.get(0).addFriend(DataBase.users.get(1));
		
//		User u1 = new User("rafos","rafos","rafos");
//		User u2 = new User("lydia1","lydia1","lydia1");
//		u1.addFriend(u2);
//		u1.printFriendList();
//		
//		User u3 = new User("lydia","lydia","lydia");
//		User u4 = new User("tatiana","tatiana","tatiana");
//		DataBase.addUser(u3);
//		DataBase.addUser(u4);
//		u3.addFriend(u4);
		
		new LoginSignupScreen();
		

	}
	
	
	
	
	//TODO failsafe saving of all new staff if someone is to close the program 
}
