package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import main.database.DAO;
import main.model.Node;
import main.model.Tree;

public class testGetPerson {

	@Test
	public void test() {
		DAO database = new DAO();
		database.connect();
		String s = database.getPerson("Catarina Rock Varga");
		assertEquals(s, "FM");
	}
	
	@Test
	public void test3() {
		DAO database = new DAO();
		database.connect();
		String s = database.getPerson("Ariana Sacristan Benjet");
		assertEquals(s, "F0");
	}
	@Test
	public void test4() {
		DAO database = new DAO();
		database.connect();
		String s = database.getPerson("Isabela Leal Contreras");
		assertEquals(s, "FMM0100");
	}
	
	@Test
	public void test5() {
		Tree t = new Tree();
		t.createTree();
		Node n = t.findPerson("FMM010");
		assertEquals(n.getName(), "Alejandra Contreras Rock");
	}
	
	@Test
	public void test6() {
		Tree t = new Tree();
		t.createTree();
		Node n = t.findPerson("FMMFF");
		assertEquals(n.getName(), "Lajos Varga");
	}
	
	@Test
	public void test7() {
		Tree t = new Tree();
		t.createTree();
		Node n = t.findPerson("FMM0101");
		assertEquals(n.getName(), "Santiago Leal Contreras");
	}
	
	@Test
	public void test8() {
		Tree t = new Tree();
		t.createTree();
		Node n = t.findPerson("F");
		assertEquals(n.getName(), "Emilio Sacristan Rock");
	}
	
	@Test
	public void test9() {
		Tree t = new Tree();
		t.createTree();
		Node n = t.findPerson("FM");
		assertEquals(n.getName(), "Catarina Rock Varga");
	}
	
	@Test
	public void test10() {
		Tree t = new Tree();
		t.createTree();
		Node n = t.findPerson("FMM0100");
		assertEquals(n.getName(), "Isabela Leal Contreras");
	}

}
