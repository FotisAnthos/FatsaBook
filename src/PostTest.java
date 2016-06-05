import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.text.DefaultCaret;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PostTest {

	private JFrame frame;
	private JTextPane txtComent;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PostTest window = new PostTest();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PostTest() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(12, 66, 662, 429);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPost = new JLabel("Post");
		lblPost.setHorizontalAlignment(SwingConstants.CENTER);
		lblPost.setFont(new Font("Arial", Font.PLAIN, 18));
		lblPost.setBounds(12, 13, 620, 51);
		frame.getContentPane().add(lblPost);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 72, 620, 192);
		frame.getContentPane().add(panel);
		
		txtComent = new JTextPane();
		DefaultCaret caret = (DefaultCaret)txtComent.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		txtComent.setBounds(12, 277, 620, 58);
		frame.getContentPane().add(txtComent);

		
		JButton btnComment = new JButton("Comment");
		btnComment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnComment.setFont(new Font("Arial", Font.PLAIN, 16));
		btnComment.setBounds(246, 344, 152, 25);
		frame.getContentPane().add(btnComment);
	}

}
