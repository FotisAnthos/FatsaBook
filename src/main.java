import java.awt.Image;

import javax.imageio.ImageIO;

public class main {
	
	public static void main(String[] args) {
		DataBase.retrieve();
//		Post temp =DataBase.createPost(DataBase.users.get(0), null, null, "lalala");
//		DataBase.users.get(0).getFriends().get(0).getPersonalPosts().get(0).getReplies().add(temp);
		new LoginSignupScreen();
	}
}
