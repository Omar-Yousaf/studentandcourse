package Pos.Client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteTest {

	private static Connection con;
	private static boolean hasData= false;
	
	
	public ResultSet displayUsers() throws SQLException, ClassNotFoundException
	{
		if(con == null)
		{
			getConnection();
		}
		
		Statement state= con.createStatement();
		ResultSet rs= state.executeQuery("Select fName, lName from User");
		return rs;
	}
	
	private void getConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("org.sqlite.JDBC");
		con = DriverManager.getConnection("jdbc:sqlite:SQLiteTest.db");
		//initialize();
	}

	private void initialize() throws SQLException {
		// TODO Auto-generated method stub
		if(! hasData)
		{
			hasData= true;
			
			Statement state= con.createStatement();
			ResultSet rs= state.executeQuery("SELECT name FROM sqlite_master WHERE type='table' AND name='User' ");
			if(!rs.next())
			{
				System.out.println("Building 'User' Table with populated values");
				//////
				
				Statement state2= con.createStatement();
				state2.execute("CREATE TABLE user(id integer, fName varchar(60), lName varchar(60), primary key(id));");
				// Insert data
				PreparedStatement prep=con.prepareStatement("INSERT into User values(?,?,?);");
				prep.setString(2, "Paul");
				prep.setString(3, "Smith");
				prep.execute();
				
				PreparedStatement prep2=con.prepareStatement("INSERT into User values(?,?,?);");
				prep2.setString(2, "Paula");
				prep2.setString(3, "Smithsonion");
				prep2.execute();
				
			}
		}
	}
	
	public void addUser(String first, String last) throws ClassNotFoundException, SQLException
	{
		if(con == null)
		{
			getConnection();
		}
		
		PreparedStatement prep=con.prepareStatement("INSERT into User values(?,?,?);");
		prep.setString(2, first);
		prep.setString(3, last);
		prep.execute();
		
		
	}
	
	
	
}
