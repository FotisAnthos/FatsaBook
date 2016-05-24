import java.util.ArrayList;

public class main {
	
	

	public static void main(String[] args) {
			
		DataBase.createUser("lydia","lydia","lydia");
		DataBase.createUser("tatiana","tatiana","tatiana");
		DataBase.users.get(0).addFriend(DataBase.users.get(1));
		new LoginSignupScreen();
		

	}
	
	
	
	
	//TODO failsafe saving of all new staff if someone is to close the program 
}
