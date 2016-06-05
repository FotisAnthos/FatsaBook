import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.DefaultCaret;

public class CreateGroupScreen {

	private JFrame frame;
	private JTextField name;
	private ButtonGroup buttongroup;
	JRadioButton opengroup;
	JRadioButton privategroup;
	JTextPane info;

	public CreateGroupScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Create Group Screen");
		frame.getContentPane().setFont(new Font("Arial", Font.PLAIN, 18));
		frame.setIconImage(new ImageIcon("FatsaBook__2.jpg").getImage());
		frame.setVisible(true);
		frame.setBounds(100, 100, 662, 429);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCreateGroup = new JLabel("Create Group");
		lblCreateGroup.setFont(new Font("Arial", Font.PLAIN, 25));
		lblCreateGroup.setBounds(226, 13, 157, 62);
		frame.getContentPane().add(lblCreateGroup);
		
		JLabel lblGroupName = new JLabel("Group Name:");
		lblGroupName.setFont(new Font("Arial", Font.PLAIN, 18));
		lblGroupName.setBounds(128, 80, 121, 29);
		frame.getContentPane().add(lblGroupName);
		
		JLabel lblGroupInfo = new JLabel("Group Info:");
		lblGroupInfo.setFont(new Font("Arial", Font.PLAIN, 18));
		lblGroupInfo.setBounds(236, 122, 94, 29);
		frame.getContentPane().add(lblGroupInfo);
		
		name = new JTextField();
		name.setFont(new Font("Arial", Font.PLAIN, 18));
		name.setBounds(314, 81, 146, 29);
		frame.getContentPane().add(name);
		name.setColumns(10);
		
		info = new JTextPane();
		DefaultCaret caret = (DefaultCaret)info.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		info.setFont(new Font("Arial", Font.PLAIN, 18));
		info.setBounds(128, 164, 332, 87);
		frame.getContentPane().add(info);
		
		opengroup = new JRadioButton("Open Group",true);
		opengroup.setFont(new Font("Arial", Font.PLAIN, 16));
		opengroup.setBounds(333, 270, 127, 25);
		frame.getContentPane().add(opengroup);
		
		privategroup = new JRadioButton("Private Group",false);
		privategroup.setFont(new Font("Arial", Font.PLAIN, 16));
		privategroup.setBounds(122, 270, 127, 25);
		frame.getContentPane().add(privategroup);
		
		buttongroup = new ButtonGroup();
		buttongroup.add(opengroup);
		buttongroup.add(privategroup);
		
		JButton create = new JButton("Create Group");
		create.setFont(new Font("Arial", Font.PLAIN, 16));
		create.setBounds(209, 317, 146, 52);
		create.addActionListener(new GECKActionListener());
		frame.getContentPane().add(create);
	}
	
	class GECKActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(!DataBase.isGroup(name.getText())) {	
				
				String groupname = name.getText();
				String groupinfo = info.getText();
				
				if(buttongroup.getSelection() == opengroup ) {
					if(!DataBase.createGroup(groupname, groupinfo, true)) 
						JOptionPane.showMessageDialog(frame, "Error-Create Group Failed!");
					else{
			        	DataBase.save();
			        	frame.setVisible(false);
					}

				}
				else {
					if(!(DataBase.createGroup(name.getText(), info.getText(), false)))
						JOptionPane.showMessageDialog(frame, "Error-Create Group Failed!");
					else{
			        	DataBase.save();
			        	frame.setVisible(false);
					}
				}
			}
			else
				JOptionPane.showMessageDialog(frame, "Error-Group already exists!");
		}
	}
}
