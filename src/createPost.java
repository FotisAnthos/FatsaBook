import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class createPost extends JFrame {

	private JPanel contentPane;
	private User activeUser,anotherUser;
	private Group agroup;

	public createPost(User activeUser, User anotherUser, Group agroup) {//if on group timeline anotherUser==null, if on user timeline agroup==null
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JTextArea postTextField = new JTextArea();
		postTextField.setFont(new Font("Monospaced", Font.PLAIN, 13));
		postTextField.setTabSize(12);

		JButton btnPost = new JButton("Post");
		btnPost.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)//Actual Creation of Post
			{	
				Post apost = new Post(postTextField.getText(), activeUser, anotherUser, agroup);
				if(apost == null) JOptionPane.showMessageDialog(null,"Post could not be created!!","Message",JOptionPane.PLAIN_MESSAGE);
				contentPane.setVisible(false);
				new Home_Page(activeUser);
			}
		});

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				contentPane.setVisible(false);
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
		contentPane.setVisible(true);
	}
}
