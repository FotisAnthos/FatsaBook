import java.awt.BorderLayout;
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
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
	private ArrayList<User> users;
	private ArrayList<Group> groups;
	
	protected User_Timeline usertimeline;
	
	
	public DisplayLists(User user,ArrayList<User> u,ArrayList<Group> g){
		super( new BorderLayout());
		
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
		}
		else if(users==null){
			listmodel.clear();
			for(Group group: groups){
				 listmodel.addElement(group);
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
	
//	public void addObject(Object object){
//		listmodel.addElement(object);
//	}
	
	class TimelineListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			int index = list.getSelectedIndex();
			
			if(groups==null && !user.equals(list.getSelectedValue())){
				usertimeline = new User_Timeline(user,user.getFriends().get(index));
				frame.dispose();
			}
			else if(groups==null && user.equals(list.getSelectedValue())){
				usertimeline = new User_Timeline(user,user);
				frame.dispose();
			}
			else if(users==null){
				new Group_Timeline(user.getGroups().get(index),user);
				frame.dispose();
			}

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
	
	public static void createAndShowGUI(User user,ArrayList<User> u,ArrayList<Group> g,JFrame frame1) {
		previousframe = frame1;
        //Create and set up the window.
        frame = new JFrame("List");
		frame.setIconImage(new ImageIcon("FatsaBook__2.jpg").getImage());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
 
        //Create and set up the content pane.
        JComponent newContentPane = new DisplayLists(user,u,g);
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
	
	public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting() == false) {
 
            if (list.getSelectedIndex() == -1) {
            //No selection, disable fire button.
                timelinebutton.setEnabled(false);
 
            } else {
            //Selection, enable the fire button.
            	timelinebutton.setEnabled(true);
            }
        }
    }
}//end Display_Lists
