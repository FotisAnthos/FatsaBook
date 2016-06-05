import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.SwingConstants;

import Post_View.PostListener1;

import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;

public class Post_ViewTest {
	
	private User activeUser,anotherUser;

	private JFrame frame;
	private JPanel createpost = new JPanel();
	private JButton Post1;
	private JTextField postfield;

	public Post_ViewTest(User activeUser, User anotherUser) {
		this.activeUser = activeUser;
		this.anotherUser = anotherUser;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 662, 429);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(12, 66, 601, 262);
		frame.getContentPane().add(layeredPane);
		layeredPane.setLayout(new BoxLayout(layeredPane, BoxLayout.X_AXIS));
		
		Post1 = new JButton("Post");
		postfield = new JTextField(20);
		Post1.addActionListener(new PostListener1());


		createpost.add(postfield, BorderLayout.NORTH);
		createpost.add(Post1, BorderLayout.CENTER);
		
		JPanel panel = new JPanel(new BoxLayout(panel, BoxLayout.Y_AXIS));
		layeredPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		panel.add(createpost);
	
	}
}
