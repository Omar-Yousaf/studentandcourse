package Pos.Client;

import java.io.IOException;
import java.sql.SQLException;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

@SuppressWarnings("unused")
public class AccountApp {

	public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		Class.forName("org.sqlite.JDBC");
		ConnectionSource con=new JdbcConnectionSource("jdbc:sqlite:SQLiteTest.db");
		Dao<Account, String> accountDao =
	            DaoManager.createDao(con, Account.class);
		//TableUtils.createTable(con, Account.class);
		
		//Account ac=new Account(5,"Ali 4 Ahmed","15643444");
		//accountDao.create(ac);
		
		 Account account2 = accountDao.queryForId("4");
	        System.out.println("Account: " + account2.Name);
		
		con.close();
		
	}

}
