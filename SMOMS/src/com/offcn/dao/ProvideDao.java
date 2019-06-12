package com.offcn.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.offcn.bean.Provider;
import com.offcn.util.BaseDao;

public class ProvideDao extends BaseDao {

	public List<Provider> findAllProvider() {
		
		List<Provider> list =new ArrayList<Provider>();
		
		try {
		String sql="SELECT pro_id,pro_name FROM provide WHERE pro_status=1";
		
		ResultSet rs=query(sql);
		
			while (rs.next()) {
				Provider p=new Provider();
				p.setPro_id(rs.getInt("pro_id"));
				p.setPro_name(rs.getString("pro_name"));
				list.add(p);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeRes();
		}
		
		return list;
		
	}

	
	public List<Provider> showProviders(){
		
		List<Provider>list=new ArrayList<Provider>();
		try {
		
		String sql="SELECT * FROM provide WHERE pro_status='1'";
		
		ResultSet rs = query(sql);
		
			while (rs.next()) {
				
				Provider p = new Provider();

				p.setPro_id(rs.getInt("pro_id"));
				p.setPro_name(rs.getString("pro_name"));
				p.setPro_desc(rs.getString("pro_desc"));
				p.setPro_linkman(rs.getString("pro_linkman"));
				p.setPro_phone(rs.getString("pro_phone"));
				p.setPro_tel(rs.getString("pro_tel"));
				p.setPro_addr(rs.getString("pro_addr"));
				p.setPro_remark(rs.getString("pro_remark"));

				list.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeRes();
		}
		return list;
		
	}


	public void delete(String id) {
		
		try {
			String sql ="UPDATE provide SET pro_status=0 WHERE pro_id="+id;	
			update(sql);
			
		} finally{
			closeRes();
		}
		
	}

	public void addProvider(Provider p) {
		
		try {
			String sql="INSERT INTO `provide` VALUES ("+p.getPro_id()+", '"+p.getPro_name()+"', '"+p.getPro_desc()
					+"', '"+p.getPro_linkman()+"', '"+p.getPro_phone()+"', '"+p.getPro_tel()+"', '"+p.getPro_addr()
					+"', null , "+p.getPro_status()+");";
			update(sql);
		} finally {
			closeRes();
		}
			
		
	}

	public Provider findProviderById(String id) {
		
		Provider p = new Provider();
		try {
		String sql="SELECT * FROM provide WHERE pro_id= "+id;
		
		ResultSet rs=query(sql);
		
			while (rs.next()) {
				
				p.setPro_id(rs.getInt("pro_id"));
				p.setPro_name(rs.getString("pro_name"));
				p.setPro_desc(rs.getString("pro_desc"));
				p.setPro_linkman(rs.getString("pro_linkman"));
				p.setPro_phone(rs.getString("pro_phone"));
				p.setPro_tel(rs.getString("pro_tel"));
				p.setPro_addr(rs.getString("pro_addr"));
				p.setPro_remark(rs.getString("pro_remark"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeRes();
		}
		
		return p;
		
	}


	public void updateProvider(Provider p) {
		
		try {
			String sql ="UPDATE provide SET pro_name='"+p.getPro_name()+"',pro_desc='"
					+p.getPro_desc()+"',pro_linkman='"+p.getPro_linkman()+"',pro_phone='"
					+p.getPro_phone()+"',pro_tel='"+p.getPro_tel()+"',pro_addr='"+p.getPro_addr()+"' WHERE pro_id="
					+p.getPro_id();
			update(sql);
			
		} finally{
			closeRes();
		}
		
	}


	public List<Provider> findProvidersBycondition(Provider provider) {
		
		List<Provider> list=new ArrayList<Provider>();
		
		
		StringBuffer sb=new StringBuffer();
		String sql1="SELECT * FROM provide WHERE pro_status='1'";
		sb.append(sql1);
		
		if (provider.getPro_name()!=null && provider.getPro_name().length()>0) {
			String sql2=" AND pro_name LIKE '%"+provider.getPro_name()+"%'";
			sb.append(sql2);
		}
		if (provider.getPro_desc()!=null && provider.getPro_desc().length()>0) {
			String sql3=" AND pro_desc LIKE '%"+provider.getPro_desc()+"%'";
			sb.append(sql3);
		}
		
		System.out.println("SQL:"+sb.toString());
		
		try {
						
			ResultSet rs = query(sb.toString());
			
			while (rs.next()) {
				
				Provider p = new Provider();

				p.setPro_id(rs.getInt("pro_id"));
				p.setPro_name(rs.getString("pro_name"));
				p.setPro_desc(rs.getString("pro_desc"));
				p.setPro_linkman(rs.getString("pro_linkman"));
				p.setPro_phone(rs.getString("pro_phone"));
				p.setPro_tel(rs.getString("pro_tel"));
				p.setPro_addr(rs.getString("pro_addr"));
				p.setPro_remark(rs.getString("pro_remark"));
				
				list.add(p);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				closeRes();
			}
		
		return list;
	}


	public void deleteAll(String ids) {
		
		try {
			List<String> sqls = new ArrayList<String>();
			String[] arr = ids.split(",");
			for (int i=0;i<arr.length;i++) {
				String sql = "UPDATE provide SET pro_status=0 WHERE pro_id="+arr[i];
				sqls.add(sql);
			}
			
			batch(sqls);
		} finally{
			closeRes();
		}
		
	}

	
}
