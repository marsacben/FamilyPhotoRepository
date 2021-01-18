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
		t.createTree();
		String s = database.getSearchString(t, false,false,true, true, true, "Catarina Rock Varga", "Mexico", "2020");
		database.connect();
		LinkedList<String> list = database.getPersonPhotos(s);
		LinkedList<String> ans = new LinkedList<String>();
		ans.add("Fotos/CatyRock-Elisa-2020-Mexico.jpg");
		assertEquals(list, ans);
	}
	
	@Test
	public void test2() {
		DAO database = new DAO();
		database.connect();
		Tree t = new Tree();
		t.createTree();
		String s = database.getSearchString(t,false,false,true, false, true, "Ariana Sacristan Benjet", "Mexico", "2020");
		database.connect();
		LinkedList<String> list = database.getPersonPhotos(s);
		LinkedList<String> ans = new LinkedList<String>();
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
		LinkedList<String> ans = new LinkedList<String>();
		ans.add("Fotos/Ariana Sacristan 2020.jpg");
		assertEquals(list, ans);
	}
	
	@Test
	public void test5() {
		DAO database = new DAO();
		Tree t = new Tree();
		t.createTree();
		database.connect();
		String s = database.getSearchString(t,true,true,true, false, true, "Maria del Carmen Sacristan Benjet", "Mexico", "2020");
		assertEquals(s, " where( person = 'Maria del Carmen Sacristan Benjet' OR person = 'Corina Benjet' OR person = 'Rosalyn Benjet' OR person = 'Sylvia Benjet' OR person = 'Harry Benjet' OR person = 'Reginald Thomas Miner' OR person = 'Cecilia Mae Miner' OR person = 'Arthur Miner' OR person = 'Emilio Sacristan Rock' OR person = 'Catarina Rock Varga' OR person = 'Piroska Varga' OR person = 'Lajos Varga Fart' OR person = 'Rozalia Fart' OR person = 'Lajos Varga' OR person = 'Esteban Rock' OR person = 'Emilio Sacristan Roy' OR person = 'Dolores Roy Gonzalo' OR person = 'Antonio Sacristan Colas' OR person = 'Maria del Carmen Sacristan Benjet') AND year = 2020");
	}
	
	@Test
	public void test4() {
		DAO database = new DAO();
		Tree t = new Tree();
		t.createTree();
		database.connect();
		String s = database.getSearchString(t,false,true,true, false, false, "Corina Benjet", "Mexico", "2020");
		assertEquals(s, " where( person = 'Corina Benjet' OR person = 'Ariana Sacristan Benjet' OR person = 'Maria del Carmen Sacristan Benjet')");
	}

}
