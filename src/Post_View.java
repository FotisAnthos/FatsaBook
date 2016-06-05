
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.text.DefaultCaret;



public class Post_View extends JPanel {
	
	private Post aPost;

	private JPanel postPanel = new JPanel();
	private JTextPane txtComment;
	private JFrame frame1;
	private JPanel groupallPanel = new JPanel();
	private JPanel createpost = new JPanel();
	private JButton Post1;
	private JTextField postfield;
	private JButton Comment;
	private JButton Like;
	private User activeUser;
	private User anotherUser=null;
	private Group agroup=null;
	
	
	public Post_View(User activeUser, User anotherUser){//Used for displaying posts on User_Timeline
		
		int i;
		this.activeUser = activeUser;
		this.anotherUser = anotherUser;

		postPanel.setLayout(new BoxLayout(postPanel,BoxLayout.Y_AXIS));

		createpost = new JPanel();
		groupallPanel = new JPanel();
		groupallPanel.setLayout(new BoxLayout(groupallPanel,BoxLayout.Y_AXIS));
		
		Post1 = new JButton("Post");
		postfield = new JTextField(20);
		Post1.addActionListener(new PostListener1());


		createpost.add(postfield, BorderLayout.NORTH);
		createpost.add(Post1, BorderLayout.CENTER);
		
		
		postToBeDisplayedUser(anotherUser);
		groupallPanel.add(createpost);
		groupallPanel.add(postPanel);
		add(groupallPanel);

	}
	
	
	public Post_View(User activeUser, Group agroup){ //Used for displaying posts on Group_Timeline\
		this.activeUser = activeUser;
		this.agroup = agroup;	
		int i;

		postPanel.setLayout(new BoxLayout(postPanel,BoxLayout.Y_AXIS));

		createpost = new JPanel();
		groupallPanel = new JPanel();
		groupallPanel.setLayout(new BoxLayout(groupallPanel,BoxLayout.Y_AXIS));
		
		Post1 = new JButton("Post");
		postfield = new JTextField(20);
		Post1.addActionListener(new PostListener2());

		createpost.add(postfield, BorderLayout.NORTH);
		createpost.add(Post1, BorderLayout.CENTER);

		postToBeDisplayedGroup(agroup);
		groupallPanel.add(createpost);
		groupallPanel.add(postPanel);
		add(groupallPanel);
	}
	
	public Post_View(User activeUser){ ////Used for displaying posts on Home_Page

	}

	public JPanel aPostView(Post aPost){
		this.aPost = aPost;
		JPanel apanel = new JPanel();
		JLabel alabel = new JLabel(aPost.getUser().getName() + ": " +aPost.getPostText());

		JButton likebutton = new JButton("Like!");
		JButton commentbutton = new JButton("Comment");
		likebutton.addActionListener(new likeButtonListener());
		commentbutton.addActionListener(new commentButtonListener());

		JPanel actions = new JPanel();

		actions.add(likebutton);
		actions.add(commentbutton);

		apanel.add(alabel,BorderLayout.NORTH);
		if (aPost.NumberOfLikes()>0){
			JLabel likeslabel = new JLabel(aPost.NumberOfLikes() + " ");
			apanel.add(likeslabel);
		}
		
		apanel.add(actions, BorderLayout.CENTER);


		this.setSize(getPreferredSize());
		return apanel;
	}



	public void postToBeDisplayedUser(User anotherUser){
		int i;
		if(anotherUser.getPersonalPosts().size()>=1){
			postPanel.removeAll();
			for(i=anotherUser.getPersonalPosts().size();i>0;i--){ // gia na emfanizetai to teleutaio post pou dimiourgithike prwto
				postPanel.add(aPostView(anotherUser.getPersonalPosts().get(i-1)));
			}
		}
	}


	public void postToBeDisplayedGroup(Group agroup){ 
		int i;
		if(agroup.getGroupPosts().size()>=1){
			for(i=agroup.getGroupPosts().size();i>0;i--){ // gia na emfanizetai to teleutaio post pou dimiourgithike prwto
				postPanel.add(aPostView(agroup.getGroupPosts().get(i-1)));
			}
		}
	}


	class PostListener1 implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{	
			DataBase.createPost(activeUser, anotherUser, null, postfield.getText());
			postfield.setText("");
			postToBeDisplayedUser(anotherUser);
			repaint();
			revalidate();
			DataBase.save();
		}
	}
	
	class PostListener2 implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{	
			DataBase.createPost(activeUser, null, agroup, postfield.getText());
			postfield.setText("");
			postToBeDisplayedGroup(agroup);
			repaint();
			revalidate();
			DataBase.save();
		}
	}
	
	class PostListener3 implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{	
			DataBase.createPost(activeUser, anotherUser, null, postfield.getText());
//			DataBase.save();
		}
	}
	
	class likeButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{	
			aPost.addLike(activeUser);
			DataBase.save();
		}
	}
	
	class commentButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{	
			int i;
			frame1 = new JFrame();
			frame1.setVisible(true);
			frame1.setBounds(12, 66, 662, 429);
			frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame1.getContentPane().setLayout(null);
			
			JLabel lblPost = new JLabel(aPost.getUser().getName()+ " : " +aPost.getPostText());
			lblPost.setHorizontalAlignment(SwingConstants.CENTER);
			lblPost.setFont(new Font("Arial", Font.PLAIN, 18));
			lblPost.setBounds(12, 13, 620, 51);
			frame1.getContentPane().add(lblPost);
			
			JPanel panel = new JPanel();
			panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
			panel.setBounds(12, 72, 620, 192);
			
			if(aPost.getReplies().size()>=1){
				panel.removeAll();
				for(i=aPost.getReplies().size();i>0;i--){ // gia na emfanizetai to teleutaio post pou dimiourgithike prwto
					panel.add(aPostView(aPost.getReplies().get(i-1)));
				}
			}
			frame1.getContentPane().add(panel);
			
			txtComment = new JTextPane();
			DefaultCaret caret = (DefaultCaret)txtComment.getCaret();
			caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
			txtComment.setBounds(12, 277, 620, 58);
			frame1.getContentPane().add(txtComment);

			
			JButton btnComment = new JButton("Comment");
			btnComment.setFont(new Font("Arial", Font.PLAIN, 16));
			btnComment.setBounds(246, 344, 152, 25);
			btnComment.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(anotherUser==null){
						Post temp =DataBase.createPost(activeUser, null, agroup, txtComment.getText());
						aPost.getReplies().add(temp);
						DataBase.save();
					}
				}
			});
			frame1.getContentPane().add(btnComment);
		}
		
	}

}