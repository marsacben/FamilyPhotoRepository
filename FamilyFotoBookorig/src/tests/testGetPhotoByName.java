package tests;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

import main.database.DAO;
import main.model.Tree;

public class testGetPhotoByName {

	@Test
	public void test() {
		DAO database = new DAO();
		database.connect();
		Tree t = new Tree();
		String s = database.getSearchString(t, false,false,true, true, true, "Catarina Rock Varga", "Mexico", "2020");
		database.connect();
		LinkedList<String> list = database.getPersonPhotos(s);
		LinkedList<String> ans = new LinkedList();
		ans.add("Fotos/CatyRock-Elisa-2020-Mexico.jpg");
		assertEquals(list, ans);
	}
	
	@Test
	public void test2() {
		DAO database = new DAO();
		database.connect();
		Tree t = new Tree();
		String s = database.getSearchString(t,false,false,true, false, true, "Ariana Sacristan Benjet", "Mexico", "2020");
		database.connect();
		LinkedList<String> list = database.getPersonPhotos(s);
		LinkedList<String> ans = new LinkedList();
		ans.add("Fotos/Ariana Sacristan 2020.jpg");
		assertEquals(list, ans);
	}
	
	@Test
	public void test3() {
		DAO database = new DAO();
		
		Tree t = new Tree();
		t.createTree();
		database.connect();
		String s = database.getSearchString(t,false,true,true, false, true, "Emilio Sacristan Rock", "Mexico", "2020");
		database.connect();
		LinkedList<String> list = database.getPersonPhotos(s);
		LinkedList<String> ans = new LinkedList();
		assertEquals(list, ans);
	}

}
