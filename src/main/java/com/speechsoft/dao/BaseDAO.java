package com.speechsoft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;


public interface BaseDAO {
	public Connection getConnection();
	public PreparedStatement getPreparedStatement(Connection con,String sqlQuery) ;

}
