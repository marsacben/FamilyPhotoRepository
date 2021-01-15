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
	
	public LinkedList<Node> getAncestors(Node n){
		LinkedList<Node> a = new LinkedList<Node>();
		Node mom = n.getMom();
		Node dad = n.getDad();
		if(mom != null) {
			a.addAll(getAncestors(mom));
		}
		if(dad != null) {
			a.addAll(getAncestors(dad));
		}
		return a;
	}
	
	public LinkedList<Node> getDecendents(Node n){
		LinkedList<Node> a = new LinkedList<Node>();
		LinkedList<Node> kids = n.getKids();
		if(kids != null) {
			for(int i=0; i<kids.size(); i++) {
				a.addAll(getDecendents(kids.get(i)));
			}
		}
		a.addAll(getAncestors(n.getDad()));
		return a;
	}
	
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
		return this.kids.get(num);
	}
	
}
