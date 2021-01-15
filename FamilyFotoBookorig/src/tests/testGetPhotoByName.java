package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import main.database.DAO;

public class testGetPhotoByName {

	@Test
	public void test() {
		DAO database = new DAO();
		database.connect();
		String[] arr = database.getPersonPhotos("Catarina Rock Varga");
		String[] ans = {"Fotos/CatyRock-Elisa-2020-Mexico.jpg", null,null, null, null,null, null, null, null};
		assertEquals(arr, ans);
	}

}
