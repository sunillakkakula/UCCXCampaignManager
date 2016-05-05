package com.speechsoft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.speechsoft.bean.UserDetails;
import com.speechsoft.util.UCCXConstants;

public class LoginDAO extends AbstractDAO {
	/*String sqlQuery=null;
	PreparedStatement pst=null;
	Connection con=null;
	ResultSet resultSet=null;
	String userName,userPassword,userNameDBValue,userPasswordDBValue=null;

	public boolean checkUserCredentials(UserDetails userDetails){
		if(userDetails!=null){
			userName= userDetails.getUserName();
			userPassword= userDetails.getUserPassword();
		}
		try{
			con=AbstractDAO.getConnection();
			pst=AbstractDAO.getPreparedStatement(con, UCCXConstants.VALIDATE_USER_CREDENTIALS_QUERY);
			pst.setString(1, userName);
			pst.setString(2, userPassword);
			resultSet=pst.executeQuery();
			while(resultSet!=null && resultSet.next()){
				userNameDBValue=resultSet.getString("USERNAME");
				userPasswordDBValue=resultSet.getString("USERPASSWORD");
				System.err.println("userNameDBValue :"+userPasswordDBValue+", userPasswordDBValue:--> "+userPasswordDBValue);
			}
		}catch(Exception e){
			if(con!=null){
				try {
					con.close();
					con=null;
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if(pst!=null){
				try {
					pst.close();
					pst=null;
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if(resultSet!=null){
				try {
					resultSet.close();
					resultSet=null;
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		}
		return false;
	}*/
}
