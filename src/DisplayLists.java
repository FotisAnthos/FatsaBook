import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class DisplayLists extends JPanel implements ListSelectionListener {
	private JList list;
	private static JFrame previousframe=null;
	private DefaultListModel listmodel;
	private static JFrame frame;
	private JButton timelinebutton;
	private JButton backtohome;
	private JButton back;
	private JButton createGroupButton;
	private User user;
	private Group agroup;
	private ArrayList<User> users;
	private ArrayList<Group> groups;

	protected User_Timeline usertimeline;
	protected Group_Timeline grouptimeline;


	public DisplayLists(User user,Group group,ArrayList<User> u,ArrayList<Group> g){
		super( new BorderLayout());

		this.agroup=group;
		this.user = user;
		users = u;
		groups = g;

		listmodel = new DefaultListModel();
		list= new JList(listmodel);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ListSelectionModel listSelectionModel = list.getSelectionModel();
		list.setSelectedIndex(0);
		list.addListSelectionListener(this); //TODO
		list.setVisibleRowCount(10);
		JScrollPane listScrollPane = new JScrollPane(list);

		timelinebutton = new JButton("Go to Timeline");
		timelinebutton.addActionListener(new TimelineListener());

		backtohome = new JButton("Back To HomePage");
		backtohome.addActionListener(new BacktoHomeListener());

		back = new JButton("Back");
		back.addActionListener(new BackListener());

		JButton addadmin =new JButton("Add Admin");
		addadmin.addActionListener(new AddAdminListener());

		JButton removemember =new JButton("Remove Member");
		removemember.addActionListener(new RemoveMemberListener());

		JButton addmember =new JButton("Add Member");
		addmember.addActionListener(new AddMemberListener());

		createGroupButton = new JButton("Create New Group");
		createGroupButton.addActionListener(new createGroupListener());

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new BoxLayout(buttonPane,
				BoxLayout.LINE_AXIS));
		buttonPane.add(timelinebutton);
		if(previousframe!=null)
			buttonPane.add(back);
		buttonPane.add(backtohome);

		buttonPane.add(Box.createHorizontalStrut(5));
		buttonPane.add(new JSeparator(SwingConstants.VERTICAL));
		buttonPane.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));



		if(groups==null){
			listmodel.clear();
			for(User user1: users){
				listmodel.addElement(user1);
			}
			if(agroup!=null){
				if(agroup.isAdmin(user)){
					buttonPane.add(addadmin);
					buttonPane.add(removemember);
					if(agroup.getClass().getName()=="PrivateGroup"){
						buttonPane.add(addmember);
					}
				}
			}
		}
		else if(users==null){
			listmodel.clear();
			for(Group group1: groups){
				listmodel.addElement(group1);
			}
			buttonPane.add(createGroupButton);
		}

		if (list.getSelectedIndex() == -1) {
			//No selection, disable timelinebutton button.
			timelinebutton.setEnabled(false);
		}

		add(listScrollPane, BorderLayout.CENTER);
		add(buttonPane, BorderLayout.PAGE_END);

	}

	class TimelineListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			int index = list.getSelectedIndex();

			if(groups==null && !user.equals(list.getSelectedValue())){
				usertimeline = new User_Timeline(user,user.getFriends().get(index-1));
				frame.dispose();
			}
			else if(groups==null && user.equals(list.getSelectedValue())){
				usertimeline = new User_Timeline(user,user);
				frame.dispose();
			}
			else if(users==null){		
				new Group_Timeline(DataBase.getGroupInstance(((Group) list.getSelectedValue()).getName()), user);
				frame.dispose();
			}
			if(previousframe!=null)
				previousframe.dispose();

		}
	}

	class AddAdminListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			int index = list.getSelectedIndex();
			boolean flag=false;

			for(User admin : agroup.admins){
				if(admin.equals(list.getSelectedValue()))
					flag=true;
			}
			if(flag){
				JOptionPane.showMessageDialog(frame, "Error-Already Admin");
			}
			else{
				agroup.addAdmin(users.get(index));
				DataBase.save();
				JOptionPane.showMessageDialog(frame, "Added new Admin");
			}

		}	
	}

	class RemoveMemberListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			int index = list.getSelectedIndex();
			if(!agroup.isAdmin(users.get(index))){
				users.get(index).deleteFromGroup(agroup);
				DataBase.save();
				listmodel.remove(index);
			}
			else
				JOptionPane.showMessageDialog(frame, "Error-Can't delete an admin");
		}	
	}

	class AddMemberListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			final JFrame frame1 = new JFrame("Add a new Member");
			frame1.setVisible(true);
			frame1.setIconImage(new ImageIcon("FatsaBook__2.jpg").getImage());
			frame1.setBounds(100, 100, 450, 300);
			frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame1.getContentPane().setLayout(null);

			final JTextField textField = new JTextField();
			textField.setFont(new Font("Arial", Font.PLAIN, 16));
			textField.setBounds(120, 55, 186, 27);
			frame1.getContentPane().add(textField);
			textField.setColumns(10);

			JButton btnAddMember = new JButton("Add Member");
			btnAddMember.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					User anotherUser = DataBase.findUser(textField.getText());
					if(anotherUser != null){
						agroup.addMember(anotherUser);
						DataBase.save();
						list.repaint();
						frame1.dispose();
					}
					else JOptionPane.showMessageDialog(null, "User could not be found, try another name","Warning", JOptionPane.PLAIN_MESSAGE);
				}
			});
			btnAddMember.setFont(new Font("Arial", Font.PLAIN, 16));
			btnAddMember.setBounds(144, 133, 134, 36);
			frame1.getContentPane().add(btnAddMember);

			JButton btnBack = new JButton("Back");
			btnBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame1.dispose();
				}
			});
			btnBack.setFont(new Font("Arial", Font.PLAIN, 16));
			btnBack.setBounds(323, 215, 97, 25);
			frame.getContentPane().add(btnBack);
		}	
	}

	class BacktoHomeListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			frame.dispose();
			if(previousframe!=null)
				previousframe.dispose();
			new Home_Page(user);
		}	
	}

	class BackListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			frame.dispose();
		}

	}

	class createGroupListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			new CreateGroupScreen(user);
			frame.dispose();
		}
	}


	public static void createAndShowGUI(User user,Group group,ArrayList<User> u,ArrayList<Group> g,JFrame frame1) {

		previousframe = frame1;


		//Create and set up the window.
		frame = new JFrame("List");
		frame.setIconImage(new ImageIcon("FatsaBook__2.jpg").getImage());
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		//Create and set up the content pane.

		JComponent  newContentPane = new DisplayLists(user,group,u,g);
		newContentPane.setOpaque(true); //content panes must be opaque
		frame.setContentPane(newContentPane);

		//Display the window.
		frame.pack();
		frame.setVisible(true);
	}

	public void valueChanged(ListSelectionEvent e) {
		if (e.getValueIsAdjusting() == false) {

			if (list.getSelectedIndex() == -1) {
				//No selection, disable the timelinebutton.
				timelinebutton.setEnabled(false);

			} else {
				//Selection, enable the timeline button.
				timelinebutton.setEnabled(true);
			}
		}
	}
}//end Display_Lists
