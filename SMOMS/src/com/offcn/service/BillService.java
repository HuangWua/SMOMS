package com.offcn.service;


import java.util.List;

import com.offcn.bean.Bill;
import com.offcn.dao.BillDao;

public class BillService {
	
	BillDao bd=new BillDao();
	
	public List<Bill> showBills(){
		
		return bd.showBills();
		
	}

	public void delete(String id) {
		bd.delete(id);
	}

	public void addBill(Bill bill) {

		bd.addBill(bill);
		
	}

	public Bill findBillById(String id) {
	
		return bd.findBillById(id);
		
	}

	public void updateBill(Bill bill) {
		
		bd.updateBill(bill);
		
	}

	public List<Bill> findBillsBycondition(Bill b) {
		// TODO Auto-generated method stub
		return bd.findBillsBycondition(b);
	}

	public void deleteAll(String ids) {
		
		bd.deleteAll(ids);
		
	}

	

}
