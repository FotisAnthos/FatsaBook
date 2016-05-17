import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;

public class DisplayLists extends JFrame{
	
	public DisplayLists(ArrayList<Object> objects)
	{
		super(objects.getClass().getName() + "List");
		JPanel contentPane = new JPanel();
		
		Object[] ob = objects.toArray(new Object[objects.size()]);//TODO check this again
		
		JList l = new JList();
		contentPane.add(l);
		l.setListData(ob);
		l.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		pack();
		this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	class listener implements ActionListener
	 {
		 public void actionPerformed(ActionEvent e)
		 	{
			 	//TODO 			 	
			}
	 }
	public CreateGroupScreen m_CreateGroupScreen;

	
	

}
