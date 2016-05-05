package com.speechsoft.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.speechsoft.config.DBCOnfiguration;

public abstract class AbstractDAO implements BaseDAO{

	public Connection getConnection() {
		Connection con=null;
		try{
			DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
			con=DriverManager.getConnection(DBCOnfiguration.URL, DBCOnfiguration.username, DBCOnfiguration.password);
			if(con!=null)
				System.err.println("Established connection"+con);
			else
				System.err.println("Couldnt Get Connection");

		}catch(Exception e ){
			System.err.println("Something Went Really Bad...! "+e);
		}finally{

		}
		return con;
	}

	public PreparedStatement getPreparedStatement(Connection con,String sqlQuery) {
		PreparedStatement pstmnt=null;
		try{
			pstmnt=con.prepareStatement(sqlQuery);
			if(pstmnt!=null)
				System.err.println("Successfully created Prepared Statement : "+pstmnt);
			else
				System.err.println("Could'nt create Prepared Statement");

		}catch(Exception e ){
			System.err.println("Something Went Really Bad...! "+e);
		}finally{

		}
		return pstmnt;
	}


	public static void main(String[] args) {
		System.err.println("Enter get Connection");
//		new AbstractDAO().getConnection();
		System.err.println("Exit get Connection");
	}
}
