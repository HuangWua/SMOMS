package com.offcn.service;

import java.util.List;

import com.offcn.bean.Provider;
import com.offcn.dao.ProvideDao;

public class ProvideService {
	
	ProvideDao pd=new ProvideDao();
	
	public List<Provider> findAllProvider() {
		
		return pd.findAllProvider();
		
	}

	public List<Provider> showProviders() {
		
		return pd.showProviders();
	}

	public void delete(String id) {
		pd.delete(id);
		
	}

	public Provider findProviderById(String id) {
		
		return pd.findProviderById(id);
	}

	public void updateProvider(Provider p) {
		
		pd.updateProvider(p);
		
	}
	

	public void addProvider(Provider p) {

		pd.addProvider(p);
		
	}

	public List<Provider> findProvidersBycondition(Provider p) {
		// TODO Auto-generated method stub
		return pd.findProvidersBycondition(p);
	}

	public void deleteAll(String ids) {
		
		pd.deleteAll(ids);
		
	}



}
