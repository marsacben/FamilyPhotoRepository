package main.model;

import java.util.LinkedList;

public class Node {
	protected String Name;
	protected Node Mom;
	protected Node dad;
	protected LinkedList<Node> kids = new LinkedList<>();
	
	
	
	public Node(String name, Node mom, Node dad, LinkedList<Node> kids) {
		Name = name;
		Mom = mom;
		this.dad = dad;
		this.kids = kids;
	}
	
	
	/**
	 * given a node, it will find all it ancestors and
	 * return a string which includes all their names in a SQL format
	 */
	public String getAncestors(Node n){
		String s= "";
		if(n != null) {
			s = s.concat(" person = '");
			s = s.concat(n.getName());
			s = s.concat("'");
			Node mom = n.getMom();
			Node dad = n.getDad();
			if(mom != null) {
				s = s.concat(" OR");
				s = s.concat(getAncestors(mom));
			}
			if(dad != null) {
				s = s.concat(" OR");
				s = s.concat(getAncestors(dad));
			}
		}
		return s;
	}
	
	
	/**
	 * given a node, it will find all it descendants and
	 * return a string which includes all their names in a SQL format
	 */
	public String getDecendents(Node n){
		String s= "";
		if(n != null) {
			s = s.concat(" person = '");
			s = s.concat(n.getName());
			s = s.concat("'");
			LinkedList<Node> kids = n.getKids();
			if(kids != null) {
				for(int i=0; i<kids.size(); i++) {
					s = s.concat(" OR");
					s = s.concat(getDecendents(kids.get(i)));
				}
			}
		}
		return s;
	}
	
	///////////////////////////////
	//getters and setters
	///////////////
	
	public String getName() {
		return Name;
	}
	
	public void setName(String name) {
		Name = name;
	}
	
	public Node getMom() {
		return Mom;
	}
	
	public void setMom(Node mom) {
		Mom = mom;
	}
	
	public Node getDad() {
		return dad;
	}
	
	public void setDad(Node dad) {
		this.dad = dad;
	}
	
	public LinkedList<Node> getKids() {
		return kids;
	}
	
	public void setKids(LinkedList<Node> kids) {
		this.kids = kids;
	}

	public Node getKid(int num) {
		LinkedList<Node> k = this.kids;
		if(k != null) {
			if(num<k.size()) {
				return this.kids.get(num);
			}
		}
		return null;
	}
	
}
