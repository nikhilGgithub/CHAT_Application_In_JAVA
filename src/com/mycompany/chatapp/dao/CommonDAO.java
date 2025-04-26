package com.mycompany.chatapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import static com.mycompany.chatapp.utils.ConfigReader.getValue;

////Throw Early and catch Later
public interface CommonDAO {
public static Connection createConnection()throws ClassNotFoundException, SQLException {
	
	
	Class.forName(getValue("DRIVER"));
final String CONNECTION_STRING=getValue("CONNECTION_URL");
final String USER_ID=getValue("USERID");
final String PASSWORD=getValue("PASSWORD");
	Connection con=DriverManager.getConnection(CONNECTION_STRING,USER_ID,PASSWORD);

	if(con!=null) {
		System.out.println("Connection Created...");////if it read config file successfully 
		
	}
	return con;
}

//only for testing
//public static void main(String[] args) throws ClassNotFoundException, SQLException {
//	CommonDAO commonDAO=new CommonDAO();
//	commonDAO.createConnection();
//}
	

}
