package Pos.Client;

import java.sql.ResultSet;
import java.sql.SQLException;

public class App {

	public static void main(String[] args) {
		SQLiteTest test=new SQLiteTest();
		ResultSet rs;
		
		try {
			test.addUser("John", "RockerFeller");
			rs= test.displayUsers();
			
			while(rs.next())
			{
				System.out.println(rs.getString("fName") +" "+rs.getString("lName"));
			}
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
