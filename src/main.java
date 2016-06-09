import java.awt.Image;

import javax.imageio.ImageIO;

public class main {
	
	public static void main(String[] args) {
		Group g = new OpenGroup("name","info");
		DataBase.retrieve();
		new LoginSignupScreen();
	}
}