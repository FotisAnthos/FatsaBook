import java.util.ArrayList;

public class main {
	
	

	public static void main(String[] args) {
		char[] c = {'1'};
		DataBase.createUser("Test", "test", c);
		new LoginSignupScreen();
	}
	
	
	
	
	//TODO failsafe saving of all new staff if someone is to close the program 
}
