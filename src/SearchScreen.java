import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class SearchScreen extends JFrame{

	private JTextField search;
	private JButton Search;

	private JRadioButton usersearch;
	private JRadioButton groupsearch;

	private User activeuser;


	public SearchScreen(User activeuser)
	{
		super("Search Screen");
		this.activeuser=activeuser;
		JPanel contentPane = new JPanel();

		usersearch = new JRadioButton("Users Search", true);
		groupsearch = new JRadioButton("Group Search", false);

		ButtonGroup group = new ButtonGroup();
		group.add(usersearch);
		group.add(groupsearch);

		setLayout(new FlowLayout());

		search = new JTextField(10);
		contentPane.add(search);
		Search = new JButton("Search");
		contentPane.add(Search);
		Search.addActionListener(new SearchActionListener());

		contentPane.add(usersearch);
		contentPane.add(groupsearch);

		this.setContentPane(contentPane);

		this.setSize(getPreferredSize());
		pack();
		this.setVisible(true);

	}
	class SearchActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(usersearch.isSelected()){
				User anotherUser = DataBase.findUser(search.getText());
				if(anotherUser != null){
					new User_Timeline(activeuser, anotherUser);
				}
				else JOptionPane.showMessageDialog(null, "User could not be found, try another mail","Warning", JOptionPane.PLAIN_MESSAGE);
			}

			else if(groupsearch.isSelected()){
				Group agroup = DataBase.getGroupInstance(search.getText());
				if(agroup != null){
					new Group_Timeline(agroup, activeuser);
				}
				else JOptionPane.showMessageDialog(null, "Group could not be found, try another group name", "Warning", JOptionPane.PLAIN_MESSAGE);
			}
		}
	}
}

