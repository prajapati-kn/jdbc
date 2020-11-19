package com.lti.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
	Connection con;
	PreparedStatement st;
	ResultSet rs;
	
	public App(){
		
		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
			this.con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/OSE","system","system");

			System.out.println("Connected...");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void getAccountDetails(){
		try {
			this.st = this.con.prepareStatement("select * from bank where accountNo = 2 ");
			this.rs = this.st.executeQuery();
			while(this.rs.next()){
				System.out.println(this.rs.getInt(2));
			}
			System.out.println("Done...");
			this.st.close();
			this.rs.close();
		this.con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
    public static void main( String[] args )
    {
        App a = new App();
        a.getAccountDetails();
    }
}
