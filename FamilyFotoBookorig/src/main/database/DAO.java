package main.database;
import java.sql.*;
import java.util.LinkedList;

import main.model.Node;
import main.model.Tree;

public class DAO {
	
	// Replace the "USERID" and "PASSWORD" with your CS server username and password to get this to work.
	// Note: Remember that your Oracle USERID for some of you is different than your regular login name

	 private static final String USERID = "SYSTEM";//"msacristanbenjet"
	 private static final String PASSWORD = "Sacristan9.";//"Stallions9"
	 static Connection connection = null;
	 
	public String connect() {
		String USERID = "SYSTEM";
		String PASSWORD = "Sacristan9.";
		//String USERID = "c##marsacben";
		//String PASSWORD = "Stallions9";
		System.out.println("-------Oracle JDBC COnnection Testing ---------");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		} catch (ClassNotFoundException e){
			System.out.println("Where is your Oracle JDBC Driver?");
			e.printStackTrace();
			return "1";
		}
		
		System.out.println("Oracle JDBC Driver Registered!");
		//Connection connection = null;
	
		try {
			 connection = DriverManager.getConnection(
			 		//"jdbc:oracle:thin:@localhost:1521:orcl", USERID, PASSWORD);//jdbc:oracle:thin:@localhost:1521:orcl", USERID, PASSWORD  jdbc:oracle:thin:localDB/SYSTEM@//localhost:1521/orclpdb
					 "jdbc:oracle:thin:@[2806:106e:20:15f4:f129:84fd:8cc1:85c7]:1521:orcl", USERID, PASSWORD);
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return "1";
		}
		System.out.println("Oracle JDBC Driver Connected!");
		String code = "";
		/*try {
			Statement stmt = connection.createStatement();
			String str = "SELECT table_name, owner, tablespace_name FROM all_tables where table_name='PEOPLE' OR table_name='PHOTOS'"; //where table_name='PEOPLE' OR table_name='PHOTOS'
			ResultSet rset = stmt.executeQuery(str);

			int custID = 0;
			String tbName = "";
			String owner = "";
			String tbs = "";
			int age = 0;
			// Process the results
			while (rset.next()) {
				//custID = rset.getInt("id");
				tbName = rset.getString("table_name");
				owner = rset.getString("owner");
				tbs = rset.getString("tablespace_name");
				//age = rset.getInt("age");
				System.out.println("table_name: " + tbName+ "   owner: " + owner + "   tablespace_name: " + tbs );
			} // end while
						
			rset.close();
			stmt.close();
			//connection.close();
		} catch (SQLException e) {
			System.out.println("Get Data Failed! Check output console");
			e.printStackTrace();
			return "2";			
		}*/
		
		return "code";
	}

/*	public static void main(String[] args) {
		System.out.println("-------Oracle JDBC COnnection Testing ---------");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		} catch (ClassNotFoundException e){
			System.out.println("Where is your Oracle JDBC Driver?");
			e.printStackTrace();
			return;
		}
		
		System.out.println("Oracle JDBC Driver Registered!");
		//Connection connection = null;
	
		try {
			 connection = DriverManager.getConnection(
			 		"jdbc:oracle:thin:localhost:1521:orcl", USERID, PASSWORD);//jdbc:oracle:thin:@csorcl.cs.wpi.edu:1521:orcl", USERID, PASSWORD
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		}
		System.out.println("Oracle JDBC Driver Connected!");
	}*/
		
		// Performing the query
		/*try {
			Statement stmt = connection.createStatement();
			String str = "SELECT * FROM CUSTOMER";
			ResultSet rset = stmt.executeQuery(str);

			int custID = 0;
			String custName = "";
			String city = "";
			int age = 0;
			// Process the results
			while (rset.next()) {
				custID = rset.getInt("id");
				custName = rset.getString("name");
				city = rset.getString("city");
				age = rset.getInt("age");
				System.out.println("ID: " + custID + "   Name: " + custName + "   City: " + city + "   Age: " + age);
			} // end while
						
			rset.close();
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println("Get Data Failed! Check output console");
			e.printStackTrace();
			return;			
		}*/
		
		public String getPerson(String name) {
			Node n = null;
			String relationCode = "";
			try {
				//Statement stmt = connection.createStatement();
				String str = "SELECT * FROM People where name LIKE '%"+name +"%'";
				//PreparedStatement ps = connection.prepareStatement("SELECT * FROM SYSTEM.People where name = ?");//where name = ?
				//ps.setString(1,name);
				//ResultSet rset = ps.executeQuery();
				
				Statement stmt = connection.createStatement();
				//String str = "SELECT * FROM CUSTOMER";
				ResultSet rset = stmt.executeQuery(str);
				
	
				System.out.println("code1: " + relationCode);
				// Process the results
				while (rset.next()) {
					relationCode = rset.getString("code");
					name = rset.getString("name");
					System.out.println("code: " + relationCode+ "name: " + name);
				} // end while
				System.out.println("code2: " + relationCode);			
				rset.close();
				stmt.close();
				connection.close();
				//n = t.findPerson(relationCode);
			} catch (SQLException e) {
				System.out.println("Getting Person Data Failed!");
				e.printStackTrace();
			}
			return relationCode;
		}
		
		public LinkedList<String> getPersonPhotos(String search) {
			LinkedList<String> photos = new LinkedList();
			try {
				String str = "SELECT PHOTO, photoid FROM PHOTOS";
				str = str.concat(search);
				System.out.println("compleate search: " +str);
				Statement stmt = connection.createStatement();
				ResultSet rset = stmt.executeQuery(str);
				int id;
				LinkedList<String> ids = new LinkedList();
				// Process the results
				while (rset.next()) {
					String p = rset.getString("photo");
					id = rset.getInt("photoID");
					if(!ids.contains(id)) {
						photos.add(p);
					}
				} // end while
							
				rset.close();
				stmt.close();
				connection.close();
			} catch (SQLException e) {
				System.out.println("Getting Person Data Failed!");
				e.printStackTrace();
			}
			return photos;
		}

		
		public String getSearchString(Tree t,boolean ancestors, boolean decendents, boolean name,boolean loc, boolean date, String txtp, String  txtl, String intd) {
			String search = "";
			boolean addAND = false;
			boolean addOR = false;
			boolean addWhere = false;
			if(name || loc || date) {
				search = search.concat(" where");
				if(name) {
					String code = this.getPerson(txtp);
					Node n = t.findPerson(code);
					if((ancestors || decendents) && n != null) {
							search = search.concat("(");
							if(ancestors) {
								search = search.concat(n.getAncestors(n));
								addOR = true;
							}
							if( decendents) {
								if(addOR) {
									search = search.concat(" OR");
								}
								search = search.concat(n.getDecendents(n));
							
							}
							search = search.concat(")");
							addAND = true;
					}
					else {
						String psearch = " person LIKE '%" + txtp + "%'";
						search = search.concat(psearch);
						System.out.println("search aANDpstring: " +search);
						addAND = true;
					}
				}
				if(loc){
					if(addAND) {
						search = search.concat(" AND");
					}
					String lsearch = " location LIKE '%" + txtl + "%'";
					search = search.concat(lsearch);
					addAND = true;
				}
				if(date){
					if(addAND) {
						search = search.concat(" AND");
					}
					String dsearch = " year = " + intd;
					search = search.concat(dsearch);
				}
			}
			System.out.println("search string: " +search);
			return search;
		}

}
