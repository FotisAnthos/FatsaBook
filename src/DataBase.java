import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

//from this class we recover data from the save files
public final class DataBase {



	protected static  ArrayList<User> users = new ArrayList<User>();
	protected static ArrayList<Group> groups = new ArrayList<Group>();


	public DataBase() {		
				this.users = null;
				this.groups = null;

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
		}
		return true;


	}

	public static boolean retrieve() {
		ArrayList<User> users = null;
		ArrayList<Group> groups = null;
		try
	      {
	         FileInputStream fileIn = new FileInputStream(".users.txt");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         users = (ArrayList) in.readObject();
	         in.close();
	         fileIn.close();
	         DataBase.users.addAll(users);
	      }catch(IOException i)
	      {
	         i.printStackTrace();
	      }catch(ClassNotFoundException c)
	      {
	         System.out.println("Users not found");
	         c.printStackTrace();
	      }
		
		try
	      {
	         FileInputStream fileIn = new FileInputStream(".groups.txt");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         groups = (ArrayList) in.readObject();
	         in.close();
	         fileIn.close();
	         DataBase.groups.addAll(groups);
	      }catch(IOException i)
	      {
	         i.printStackTrace();
	      }catch(ClassNotFoundException c)
	      {
	         System.out.println("Groups not found");
	         c.printStackTrace();
	      }
		return true;
	}


	public ArrayList<Group> getgroups() {
		// TODO Retrieve groups from savefiles
		return groups;
	}

	//TODO complete getUserInstance

	public static Group getGroupInstance(String groupname) {
		for(Group g : groups) {
			if(g.getName().equals(groupname)) {
				return g;
			}
		}
		return null;
	}



	public static Group getPost(Post r) {
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
				if(u.isPasswordCorrect(password)) 
					return true;
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
	
	public static Post createPost(User creator, User anotherUser, Group agroup, String PostText){
		Post apost = new Post(PostText, creator);
		if(anotherUser!=null || agroup!=null){
			if(anotherUser!=null){
				anotherUser.addPost(apost);
				apost.setOwner(anotherUser);
			}
			else if(agroup!=null ){
				agroup.addPost(apost);
				apost.setGroup(agroup);
			}
			return apost;
		}
		return apost;
	}
	
	public static void createPostFrame(final User activeUser, final User anotherUser, final Group agroup,final Post aPost){
		final javax.swing.JFrame f = new javax.swing.JFrame("Create a Post");
		f.setIconImage(new ImageIcon("FatsaBook__2.jpg").getImage());
		javax.swing.JLabel CreatePostLabel;
		javax.swing.JButton postButton, btnPost;
		final javax.swing.JTextArea postTextField;
		javax.swing.JPanel contentPane;

		
		
		CreatePostLabel = new javax.swing.JLabel();
		postButton = new javax.swing.JButton();
		postTextField = new javax.swing.JTextArea();

		f.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
		f.setBounds(100, 100, 450, 300);
		contentPane = new javax.swing.JPanel();
		contentPane.setBorder(new javax.swing.border.EmptyBorder(5, 5, 5, 5));
		f.setContentPane(contentPane);

		postTextField.setLineWrap(true);
		postTextField.setFont(new java.awt.Font("Monospaced", java.awt.Font.PLAIN, 13));
		postTextField.setTabSize(12);

		btnPost = new javax.swing.JButton("Post");
		btnPost.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e)//Actual Creation of Post
			{	
				Post apost =DataBase.createPost(activeUser, anotherUser, agroup, postTextField.getText());
				if(apost == null) 
					JOptionPane.showMessageDialog(null,"Post could not be created!!","Message",JOptionPane.PLAIN_MESSAGE);
	    		f.dispose();
	    		if(anotherUser==null && agroup==null && aPost!=null){
	    			aPost.getReplies().add(apost);
	    		}
	    		if(anotherUser==null && agroup!=null)
	    			new Group_Timeline(agroup,activeUser);
	    		else if(anotherUser!=null && agroup==null)
	    			new User_Timeline(activeUser,anotherUser);
	    		DataBase.save();
	    		
			}
	    });

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				f.dispose();
				new Home_Page(activeUser);			
			}
		}


				);

		JLabel lblCreatePost = new JLabel("Create Post:");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(35)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addComponent(btnPost)
												.addComponent(postTextField, GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(btnBack)
										.addGap(133)
										.addComponent(lblCreatePost, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGap(136)))
						.addGap(39))
				);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(btnBack)
										.addGap(16))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblCreatePost)
										.addPreferredGap(ComponentPlacement.RELATED)))
						.addComponent(postTextField, GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnPost)
						.addGap(23))
				);
		contentPane.setLayout(gl_contentPane);
		f.setVisible(true);
	}
}