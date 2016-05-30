import javax.swing.JButton;
import javax.swing.JFrame;


public class Group_Timeline extends JFrame {

	private JButton back;
	private  JButton addgroup;
	private  JButton deletegroup;
	private JButton Members_List;
	private JButton nextPosts;
	private JFrame frame;
	public DisplayLists m_Display_Lists;
	public Group m_Group;

	public Group_Timeline(Group g,User u){
		frame = new JFrame(g.getName());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        back = new JButton("Back");
        addgroup = new JButton("Add group");
        deletegroup = new JButton("Delete group");
        
        
	}

}//end Group_Timeline