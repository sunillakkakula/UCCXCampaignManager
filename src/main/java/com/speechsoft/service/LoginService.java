package com.speechsoft.service;

import com.speechsoft.bean.UserDetails;
import com.speechsoft.dao.BaseDAO;
import com.speechsoft.dao.LoginDAO;

public class LoginService {
	
	public boolean validateUserCredentials(UserDetails userDetails){
		BaseDAO loginDAO=new LoginDAO();
		return false;
	}

}
