import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionListener;

/**
 * @author Flotis
 * @version 1.0
 * @updated 17-Ìבת-2016 7:18:09 לל
 * 
 * 
 */
public class DisplayLists extends JPanel implements ListSelectionListener {
	private JList list;
	private DefaultListModel listmodel;
	private JButton timelinebutton;
	private User user;
	private ArrayList<User> users;
	private ArrayList<Group> groups;
	/**
	 * @author Flotis
	 * @version 1.0
	 * @created 17-Ìבת-2016 7:18:09 לל
	 */
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
	 	
	 	JPanel buttonPane = new JPanel();
	 	buttonPane.setLayout(new BoxLayout(buttonPane,
                BoxLayout.LINE_AXIS));
	 	buttonPane.add(timelinebutton);
	 	buttonPane.add(Box.createHorizontalStrut(5));
	 	buttonPane.add(new JSeparator(SwingConstants.VERTICAL));
	 	buttonPane.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

	 	add(listScrollPane, BorderLayout.CENTER);
	 	add(buttonPane, BorderLayout.PAGE_END);
	 	
	 	if(groups==null){
			listmodel.clear();
			for(User user: u){
				listmodel.addElement(user);
			}
		}
		else if(users==null){
			listmodel.clear();
			for(Group group: g){
				 listmodel.addElement(group);
			 }
		}
	 	
	 	if (list.getSelectedIndex() == -1) {
            //No selection, disable timelinebutton button.
                timelinebutton.setEnabled(false);
		}

	}
	
	public void addObject(Object object){
		listmodel.addElement(object);
	}
	
	class TimelineListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			int index = list.getSelectedIndex();
			
			if(groups==null){
				new User_Timeline(user,DataBase.users.get(index));
			}
			else if(users==null)
				new Group_Timeline(DataBase.groups.get(index));
		}
	}
	
	
	class listener implements ActionListener {

		public listener(){

		}

		public void finalize() throws Throwable {

		}
		/**
		 * 
		 * @param e
		 */
		public void actionPerformed(ActionEvent e){

		}
	}//end listener

	public CreateGroupScreen m_CreateGroupScreen;


	public void finalize() throws Throwable {
		super.finalize();
	}
	/**
	 * 
	 * @param objects
	 */
	
	public static void createAndShowGUI(User user,ArrayList<User> u,ArrayList<Group> g) {
        //Create and set up the window.
        JFrame frame = new JFrame("List");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
 
        //Create and set up the content pane.
        JComponent newContentPane = new DisplayLists(user,u,g);
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
}//end Display_Lists
