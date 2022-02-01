package com.crm.comcast.GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;
/**
 * 
 * @author suchi
 *
 */
public class DasabaseUtility {
Connection	connection = null;
/**
 * this method will do the connection to the database
 * @throws Throwable 
 */
public void connectToDB() throws Throwable {
	Driver driver = new Driver();
	DriverManager.registerDriver(driver);
	connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentinfo","root","root");
}
/**
 * this method will close the database connection
 * @throws Throwable 
 */
public void closeDB() throws Throwable {
	connection.close();
	
}
/**
 * this method will fetch all the data from the database
 * @param query
 * @throws Throwable 
 */
public void getAllData(String query) throws Throwable {
	ResultSet result = connection.createStatement().executeQuery(query);
}
/**
 * this method will update the data in the database and it will verify
 * @param query
 * @return 
 * @throws Throwable
 */
public boolean updateData(String query) throws Throwable {
	boolean flag = false;
	int result = connection.createStatement().executeUpdate(query);
	if(result==1) {
		System.out.println("data is updated in database");
		flag = true;
	} else {
		System.out.println("data is not updated in the database");
		}
	return flag;
}
/**
 * this method will verify the given data is present in the database or not
 * @param query
 * @param columnNumber
 * @param expectedData
 * @return
 * @throws Throwable
 */
	
public String getTheData(String query,int columnNumber,String expectedData) throws Throwable {
	boolean flag = false;
	String actualData = null;
	ResultSet result = connection.createStatement().executeQuery(query);
	while(result.next()) {
		String data = result.getString(columnNumber);
		if(data.equals(expectedData) ) {
			actualData = data;
			flag=true;
			break;
		}
	}
	if(flag==true) {
		System.out.println("data is present in the database");
		return actualData;
	} else { System.out.println("data is not present in the database");
	return actualData;
		}
}
	
}
	

