package customerstuff;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Customer {

	private Connection con = null;
	private Statement st = null;
	private ResultSet rs = null;
	String customerInfo = "test";

	public Customer() {

	}

	public String getData(String lastName) {
		try {
			//Class.forName("com.mysql.jdbc.Driver");
		//	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Customers?useSSL=false", "root", "password");
		//	st = con.createStatement();

			//String query = "select * from customers where LastName = '" + lastName + "' ;";
			
			
			//rs = st.executeQuery(query);
			
			
			
			customerInfo = "dirt";
			
			System.out.println(customerInfo);
			/*
			while (rs.next()) {
				String fullName = rs.getString("FullName");
				String title = rs.getString("Title");
				String streetAddress = rs.getString("Address");
			}
			*/

		} catch (Exception ex) {
			System.out.println(ex);
		}
		return customerInfo;
	}
}
