import java.util.ArrayList;

public class main {
	
	

	public static void main(String[] args) {
		DataBase.retrieve();
		
		DataBase.createGroup("lalala", "lalala", true); //just to check
		new LoginSignupScreen();
	}
	
	
	
	
	//TODO failsafe saving of all new staff if someone is to close the program 
}
