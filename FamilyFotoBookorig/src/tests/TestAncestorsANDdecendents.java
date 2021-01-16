package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import main.model.Node;
import main.model.Tree;

public class TestAncestorsANDdecendents {

	@Test
	public void testAncestors() {
		Tree t = new Tree();
		t.createTree();
		Node n = t.getMe().getDad();
		String s = n.getAncestors(n);
		String ans = " person = 'Emilio Sacristan Rock' OR person = 'Catarina Rock Varga' OR person = 'Piroska Varga' OR person = 'Lajos Varga Fart' OR person = 'Rozalia Fart' OR person = 'Lajos Varga' OR person = 'Esteban Rock' OR person = 'Emilio Sacristan Roy' OR person = 'Dolores Roy Gonzalo' OR person = 'Antonio Sacristan Colas'";
		assertEquals(s, ans);
	}
	
	@Test
	public void testDecendents() {
		Tree t = new Tree();
		t.createTree();
		Node n = t.getMe().getDad();
		String s = n.getDecendents(n);
		String ans = " person = 'Emilio Sacristan Rock' OR person = 'Ariana Sacristan Benjet' OR person = 'Maria del Carmen Sacristan Benjet'";
		assertEquals(s, ans);
	}
	
	@Test
	public void testDecendents2() {
		Tree t = new Tree();
		t.createTree();
		Node n = t.getMe().getDad().getKid(0);
		String s = n.getDecendents(n);
		String ans = " person = 'Ariana Sacristan Benjet'";
		assertEquals(s, ans);
	}
	

}
