package com.offcn.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.offcn.bean.User;
import com.offcn.util.BaseDao;

public class LoginDao extends BaseDao {
	
	public User login(User user) {
		
		User u=null;
		
		try {
			
			String sql="SELECT * FROM user WHERE u_name='"+user.getU_name()+"'" +" AND u_pwd='"+user.getU_pwd()+"'";
			ResultSet rs = query(sql); 
			if (rs.next()) {
				u=new User();
				u.setU_name(rs.getString("u_name"));
				u.setU_pwd(rs.getString("u_pwd"));
				System.out.print(rs.getString("u_name")+"\t"+rs.getShort("u_pwd")+"\n");
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 
		return u;
	}

}
