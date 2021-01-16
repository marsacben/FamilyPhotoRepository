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
		String ans = " person = 'Emilio Sacristan Rock' OR person = 'Catarina Rock Varga' OR person = 'Piroska Varga' OR person = 'Lajos Varga II' OR person = 'Rozalia Fart' OR person = 'Esteban Rock' OR person = 'Emilio Sacristan Roy' OR person = 'Dolores Roy Gonzalo' OR person = 'Antonio Sacristan Colas'";
		assertEquals(s, ans);
	}
	
	@Test
	public void testDecendents() {
		Tree t = new Tree();
		t.createTree();
		Node n = t.getMe().getDad();
		String s = n.getDecendents(n);
		String ans = " person = 'Emilio Sacristan Rock' OR person = 'Ari Sacristan Benjet' OR person = 'Maria del Carmen Sacristan Benjet'";
		assertEquals(s, ans);
	}

}
