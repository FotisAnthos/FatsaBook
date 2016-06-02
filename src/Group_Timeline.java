import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;





public class Group_Timeline extends JFrame {

	private User activeUser;
	private Group group;
	private javax.swing.JLabel GroupName;
	private javax.swing.JButton SearchButton;
	private javax.swing.JButton backButton;
	private javax.swing.JButton newPostButton;
	private javax.swing.JButton memberStatusButton;
	private javax.swing.JButton membersButton;
	private javax.swing.JButton morepostsButton;
	private Post_View GroupTimelineView_Post;


	public Group_Timeline(Group g, User u){	
		super(g.getName()+ "'s Timeline");
		this.activeUser = u;
		this.group = g;
		GroupTimelineView_Post = new Post_View(null, "Group_Timeline");


		initComponents();
		this.setVisible(true);
	}



	private void initComponents() {

		GroupName = new javax.swing.JLabel();
		backButton = new javax.swing.JButton();
		SearchButton = new javax.swing.JButton();
		membersButton = new javax.swing.JButton();
		morepostsButton = new javax.swing.JButton();
		memberStatusButton = new javax.swing.JButton();
		newPostButton = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		GroupName.setText("Group name");

		backButton.setText("Back");
		backButton.addActionListener(new BackListener());

		SearchButton.setText("Search");
		SearchButton.addActionListener(new SearchActionListener());

		membersButton.setText("Members List");
		membersButton.addActionListener(new MembersListener());

		morepostsButton.setText("More posts");
		morepostsButton.addActionListener(new NextPostsListener());

		memberStatusButton.setText("become Member");
		if(group.isMember(activeUser)) memberStatusButton.setText("Remove Group");
		else memberStatusButton.setText("Become Member");
		memberStatusButton.addActionListener(new memberStatusActionListener());

		newPostButton.setText("Post to group");
		newPostButton.addActionListener(new newPostButton());

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
						.addComponent(backButton)
						.addGap(18, 18, 18)
						.addComponent(SearchButton)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(membersButton)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 232, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(newPostButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(memberStatusButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap())
				.addGroup(layout.createSequentialGroup()
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(morepostsButton)
								.addComponent(GroupName))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(GroupName)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(backButton)
								.addComponent(SearchButton)
								.addComponent(membersButton)
								.addComponent(memberStatusButton))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(newPostButton)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 240, Short.MAX_VALUE)
						.addComponent(morepostsButton))
				);

		pack();
	}

	//Button listeners

	class memberStatusActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(memberStatusButton.getText().equals("Remove Group")){
				activeUser.deleteFromGroup(group);
				DataBase.save();
				memberStatusButton.setText("Become Member");
			}
			else if(memberStatusButton.getText().equals("Become Member")){
				group.addMember(activeUser);
				DataBase.save();
				memberStatusButton.setText("Remove Group");			
			}		
		}		
	}

	class SearchActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			new SearchScreen(activeUser);
		}
	}
	
	class newPostButton implements ActionListener{
		public void actionPerformed(ActionEvent e){
			DataBase.createPost(activeUser, null, group);
		}
	}


	class BackListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			setVisible(false);
		}

	}

	class NextPostsListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//TODO
			post(5);
		}
	}

	class MembersListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			DisplayLists.createAndShowGUI(activeUser, group.members ,null);			
		}
	}
	public void post(int numberOfPosts){//the number of posts to be displayed
		int i;
		for(i=0; i<numberOfPosts; i++){
		this.add(GroupTimelineView_Post.display(null, group));
		}
	}

}//end Group_Timeline