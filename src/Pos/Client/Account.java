package Pos.Client;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName="Account")
public class Account {
	
	@DatabaseField(id = true)
	public int id;
	@DatabaseField
	public String Name;
	@DatabaseField
	public String Password;

	public Account() {
        // ORMLite needs a no-arg constructor 
    }
    public Account(int idd,String name, String password) {
    	this.id=idd;
        this.Name = name;
        this.Password = password;
    }
}
