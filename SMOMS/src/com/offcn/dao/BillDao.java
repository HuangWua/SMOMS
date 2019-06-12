package com.offcn.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.offcn.bean.Bill;
import com.offcn.util.BaseDao;

public class BillDao extends BaseDao {

	
	public List<Bill> showBills(){
		
		List<Bill>list=new ArrayList<Bill>();
		try {
		
		String sql="SELECT b.*,p.pro_name,p.pro_id FROM bill b INNER JOIN provide p ON b.b_pro_id=p.pro_id WHERE b_status='1'";
		
		ResultSet rs = query(sql);
		
			while (rs.next()) {
				
				Bill b = new Bill();
				b.setB_id(rs.getInt("b_id"));
				b.setB_name(rs.getString("b_name"));
				b.setB_price(rs.getString("b_price"));
				b.setPro_id(rs.getInt("b_pro_id"));
				b.setPro_name(rs.getString("pro_name"));
//			b.setB_pro_id(rs.getString("b_pro_id"));
				b.setB_desc(rs.getString("b_desc"));
//			b.setB_status(rs.getString("b_status"));
				b.setB_isPay(rs.getString("b_isPay"));
				b.setB_num(rs.getString("b_num"));
				b.setB_time(rs.getString("b_time"));
//			b.setB_remark(rs.getString("b_remark"));
				
				list.add(b);
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
			String sql ="UPDATE bill SET b_status=0 WHERE b_id="+id;	
			update(sql);
			
		} finally{
			closeRes();
		}
		
	}

	public void addBill(Bill bill) {
		
		try {
			String sql="INSERT INTO `bill` VALUES (null, '"+bill.getB_name()+"', "+bill.getB_price()
					+", "+bill.getB_pro_id()+", '"+bill.getB_desc()+"', "+bill.getB_status()+", "+bill.getB_isPay()
					+", "+bill.getB_num()+", '"+bill.getB_time()+"', NULL);";
			System.out.println(sql);
			update(sql);
		} finally {
			closeRes();
		}
			
		
	}

	public Bill findBillById(String id) {
		
		Bill b = new Bill();
		try {
		String sql="SELECT b.*,p.pro_name,p.pro_id FROM bill b INNER JOIN provide p ON b.b_pro_id=p.pro_id WHERE b.b_id= "+id;
		
		ResultSet rs=query(sql);
		
			while (rs.next()) {
				
				b.setB_id(rs.getInt("b_id"));
				b.setB_name(rs.getString("b_name"));
				b.setB_price(rs.getString("b_price"));
				b.setPro_id(rs.getInt("pro_id"));
				b.setPro_name(rs.getString("pro_name"));
				b.setB_pro_id(rs.getString("b_pro_id"));
				b.setB_desc(rs.getString("b_desc"));
//			b.setB_status(rs.getString("b_status"));
				b.setB_isPay(rs.getString("b_isPay"));
				b.setB_num(rs.getString("b_num"));
				b.setB_time(rs.getString("b_time"));
//			b.setB_remark(rs.getString("b_remark"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeRes();
		}
		
		return b;
		
	}

	public void updateBill(Bill bill) {
		
		try {
			String sql ="UPDATE bill SET b_name='"+bill.getB_name()+"',b_price='"
					+bill.getB_price()+"',b_pro_id='"+bill.getB_pro_id()+"',b_desc='"
					+bill.getB_desc()+"',b_isPay='"+bill.getB_isPay()+"',b_num='"+bill.getB_num()+"' WHERE b_id="
					+bill.getB_id();
			update(sql);
			
		} finally{
			closeRes();
		}
		
	}

	public List<Bill> findBillsBycondition(Bill bill) {
		
		List<Bill> list=new ArrayList<Bill>();
		
		
		StringBuffer sb=new StringBuffer();
		String sql1="SELECT b.*,p.pro_name,p.pro_id FROM bill b INNER JOIN provide p ON b.b_pro_id=p.pro_id WHERE b_status='1'";
		sb.append(sql1);
		
		if (bill.getB_name()!=null && bill.getB_name().length()>0) {
			String sql2=" AND b.b_name LIKE '%"+bill.getB_name()+"%' ";
			sb.append(sql2);
		}
		if (bill.getB_isPay()!=null && bill.getB_isPay().length()>0) {
			String sql3="AND b.b_isPay="+bill.getB_isPay();
			sb.append(sql3);
		}
		
		System.out.println("SQL:"+sb.toString());
		
		try {
						
			ResultSet rs = query(sb.toString());
			
				while (rs.next()) {
					
					Bill b = new Bill();
					b.setB_id(rs.getInt("b_id"));
					b.setB_name(rs.getString("b_name"));
					b.setB_price(rs.getString("b_price"));
					b.setPro_id(rs.getInt("b_pro_id"));
					b.setPro_name(rs.getString("pro_name"));
//				b.setB_pro_id(rs.getString("b_pro_id"));
					b.setB_desc(rs.getString("b_desc"));
//				b.setB_status(rs.getString("b_status"));
					b.setB_isPay(rs.getString("b_isPay"));
					b.setB_num(rs.getString("b_num"));
					b.setB_time(rs.getString("b_time"));
//				b.setB_remark(rs.getString("b_remark"));
					
					list.add(b);
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
				String sql = "UPDATE bill SET b_status=0 WHERE b_id="+arr[i];
				sqls.add(sql);
			}
			
			batch(sqls);
		} finally{
			closeRes();
		}
		
	}

	
}
