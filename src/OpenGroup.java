import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;


public class OpenGroup extends Group {

	private static int No_ofOpenGroups;

	public OpenGroup(String name, String info) {
		super(name,info);
	}
	
	public String getName() {
		return name;
	}
	
	public String getInfo() {
		return info;
	}

	//returns true if the current user is member of this group
	public boolean isMember(User user) {
		for(User m : members){
			if(m.getMail().equals(user.getMail()) && m.getName().equals(user.getName()))
				return true;
		}
		return false;
	}

	//adds the selected user if not a member
	public void addMember(User user) {
		if(isMember(user)){
			System.out.println(user.getName()+" is already a member!");
			return;
		}

		members.add(user);
		user.addToGroup(this);
	}


	//returns true if the current user can add a post in this group
	public boolean canAddPost(User user) {
		if(isMember(user))
			return true;

		return false;
	}

	//adds a post in the selected group
	public void addPost(Post post) {
		if(canAddPost(post.getCreator())) //only if the user can add a post
			posts.add(post);
		else
			System.out.println("User " + post.getCreator() + "is not a member nor his friends.");
	}

	//adds a reply to a selected post
	public void addReplyToPost(Post post, Post reply) {
		if(canAddPost(reply.getCreator())) //only if the user can add a reply
			post.setReply(reply);
		else
			System.out.println("User " + reply.getCreator() + "is not a member nor his friends.");
	}

	public void printWall() {
		System.out.println("Group " + super.getName() + " wall");
		for (Post post : posts){
			post.printPost();
		}
	}
	public boolean removeMember(User user){
		if(members.remove(user))
			return true;
		return false;
	}
}


/*
 * @(#)$Id: ObjectStack.java 3619 2008-03-26 07:23:03Z yui $
 *
 * Copyright 2006-2008 Makoto YUI
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * Contributors:
 *     Makoto YUI - initial porting
 */
//package xbird.util.collections;

