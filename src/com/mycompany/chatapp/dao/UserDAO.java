package com.mycompany.chatapp.dao;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mycompany.chatapp.dto.UserDTO;
import com.mycompany.chatapp.utils.Encryption;

////User CRUD performance
public class UserDAO {

	public boolean isLogin(UserDTO userDTO) throws SQLException, ClassNotFoundException, NoSuchAlgorithmException {
		Connection con=null;
		Statement stmt=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		final String SQL="select userid from users where userid=? and password=?";
		try {
			con= CommonDAO.createConnection();
			pstmt=con.prepareStatement(SQL);
			pstmt.setString(1, userDTO.getUserid());
		String encryptdPwd=Encryption.passwordEncrypt( new  String(userDTO.getPassword()));
		pstmt.setString(2, encryptdPwd);
		rs=pstmt.executeQuery();
		return rs.next();///return boolean
		}	
		
		finally {
			if(rs!=null) {
				rs.close();
			}
			if(pstmt!=null) {
				pstmt.close();
			}
			if(con!=null) {
				con.close();
			}
		}
	}
	

public int add(UserDTO userDTO) throws ClassNotFoundException, SQLException ,Exception{///obj
System.out.println("Recive "+userDTO.getUserid()+" "+userDTO.getPassword());
	Connection connection =null;
	Statement stmt=null;///query
	
	try {
		
	connection=CommonDAO.createConnection();///Connection Create
	////step -2 query
	stmt=connection.createStatement();
	/// insert into users(userid,password)val ues('ram','ram345');
	///new String(userDTO.getPassword()) //here typecase char[] to string mean only database pr real password dikhega but screen pr nhi dikhega
	int record= stmt.executeUpdate("insert into users(userid,password)values('"+userDTO.getUserid()+"','"+Encryption.passwordEncrypt(new String(userDTO.getPassword()))+"')");////insert ,delete ,update operation
	return record;
	}
	
	finally {///in case of return mai bhi finally chalta hai but system.exit mai nhi chlta
		if(stmt!=null) {
	stmt.close();}
		if(connection!=null) {
	connection.close();
	}
	}
	
	
}
	
}
