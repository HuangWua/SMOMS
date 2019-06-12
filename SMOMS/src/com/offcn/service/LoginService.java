package com.offcn.service;

import com.offcn.bean.User;
import com.offcn.dao.LoginDao;

public class LoginService {
	
	public User login(User user) {
		
		LoginDao ld=new LoginDao();
		
		return ld.login(user);
	}

} 
