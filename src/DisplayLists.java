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

/**
 * @author Flotis
 * @version 1.0
 * @updated 17-Ìבת-2016 7:18:09 לל
 */
public class Display_Lists extends JFrame {

	/**
	 * @author Flotis
	 * @version 1.0
	 * @created 17-Ìבת-2016 7:18:09 לל
	 */
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

	public Display_Lists(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}
	/**
	 * 
	 * @param objects
	 */
	public Display_Lists(ArrayList<Object> objects){

	}
}//end Display_Lists
