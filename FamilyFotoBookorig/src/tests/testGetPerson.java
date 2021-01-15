package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import main.database.DAO;

public class testGetPerson {

	@Test
	public void test() {
		DAO database = new DAO();
		database.connect();
		String s = database.getPerson("Catarina Rock Varga");
		assertEquals(s, "FM");
	}
	
	@Test
	public void test2() {
		DAO database = new DAO();
		database.connect();
		String s = database.getPerson("Catarina Varga");
		assertEquals(s, "FM");
	}

}
