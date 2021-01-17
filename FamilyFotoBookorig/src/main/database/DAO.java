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
			 		//"jdbc:oracle:thin:@localhost:1521:orcl", USERID, PASSWORD);//local
					 "jdbc:oracle:thin:@DESKTOP-PCIKVCB:1521:orcl", USERID, PASSWORD);//external
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return "1";
		}
		System.out.println("Oracle JDBC Driver Connected!");
		String code = "";
		
		
		return "code";
	}

		
		public String getPerson(String name) {
			Node n = null;
			String relationCode = "";
			try {
				String str = "SELECT * FROM People where name LIKE '%"+name +"%'";
				
				Statement stmt = connection.createStatement();
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
			} catch (SQLException e) {
				System.out.println("Getting Person Data Failed!");
				e.printStackTrace();
			}
			return relationCode;
		}
		
		public LinkedList<String> getPersonPhotos(String search) {
			LinkedList<String> photos = new LinkedList<String>();
			try {
				String str = "SELECT PHOTO, photoid FROM PHOTOS";
				str = str.concat(search);
				System.out.println("compleate search: " +str);
				Statement stmt = connection.createStatement();
				ResultSet rset = stmt.executeQuery(str);
				int id;
				LinkedList<Integer> ids = new LinkedList<Integer>();
				// Process the results
				while (rset.next()) {
					String p = rset.getString("photo");
					id = rset.getInt("photoID");
					if(unique(ids, id)) {
						System.out.println(id);
						photos.add(p);
						ids.add(id);
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
		
		public boolean unique(LinkedList<Integer> l, int id) {
			boolean ans = true;
			for(int i=0; i<l.size(); i++) {
				if(l.get(i)== id) {
					ans = false;
				}
			}
			
			return ans;
		}

}
