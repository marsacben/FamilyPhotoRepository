package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import main.database.DAO;

public class testGetPhotoByName {

	@Test
	public void test() {
		DAO database = new DAO();
		database.connect();
		String s = database.getSearchString(true, true, true, "Catarina Rock Varga", "Mexico", "2020");
		String[] arr = database.getPersonPhotos(s);
		String[] ans = {"Fotos/CatyRock-Elisa-2020-Mexico.jpg", null,null, null, null,null, null, null, null};
		System.out.println("test1: " + arr[0] + "  " + arr[1] + "  " + arr[2] + "  "+ arr[3] );
		assertEquals(arr, ans);
	}
	
	@Test
	public void test2() {
		DAO database = new DAO();
		database.connect();
		String s = database.getSearchString(true, true, true, "Ariana Sacristan Benjet", "Mexico", "2020");
		String[] arr = database.getPersonPhotos(s);
		String[] ans = {"Fotos/Ariana Sacristan 2020.jpg", null,null, null, null,null, null, null, null};
		System.out.println("test1: " + arr[0] + "  " + arr[1] + "  " + arr[2] + "  "+ arr[3] );
		assertEquals(arr, ans);
	}

}
