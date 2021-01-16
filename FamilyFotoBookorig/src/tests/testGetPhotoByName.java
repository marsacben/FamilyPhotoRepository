package tests;

import static org.junit.Assert.*;

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
		String[] arr = database.getPersonPhotos(s);
		String[] ans = {"Fotos/CatyRock-Elisa-2020-Mexico.jpg", null,null, null, null,null, null, null, null};
		System.out.println("test1: " + arr[0] + "  " + arr[1] + "  " + arr[2] + "  "+ arr[3] );
		assertEquals(arr, ans);
	}
	
	@Test
	public void test2() {
		DAO database = new DAO();
		database.connect();
		Tree t = new Tree();
		String s = database.getSearchString(t,false,false,true, false, true, "Ariana Sacristan Benjet", "Mexico", "2020");
		String[] arr = database.getPersonPhotos(s);
		String[] ans = {"Fotos/Ariana Sacristan 2020.jpg", null,null, null, null,null, null, null, null};
		System.out.println("test1: " + arr[0] + "  " + arr[1] + "  " + arr[2] + "  "+ arr[3] );
		assertEquals(arr, ans);
	}
	
	@Test
	public void test3() {
		DAO database = new DAO();
		
		Tree t = new Tree();
		t.createTree();
		database.connect();
		String s = database.getSearchString(t,false,true,true, false, true, "Emilio Sacristan Rock", "Mexico", "2020");
		database.connect();
		String[] arr = database.getPersonPhotos(s);
		String[] ans = {null, null,null, null, null,null, null, null, null};
		System.out.println("test1: " + arr[0] + "  " + arr[1] + "  " + arr[2] + "  "+ arr[3] + arr[4] + "  " + arr[5] + "  " + arr[6] + "  "+ arr[7] + "  "+ arr[8] );
		assertEquals(arr, ans);
	}

}
