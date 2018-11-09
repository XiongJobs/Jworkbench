package service;

import java.util.ArrayList;
import java.util.List;

import dao.MessageDao;


public class MaintainService {
	MessageDao mesDao=new MessageDao(); 
	
	
	public void deleteOne(String id) {
		if(id !=null && ""!=id.trim()) {
			mesDao.deleteOne(Integer.valueOf(id));
		}		
	}
	

	public void deleteBatch(String[] ids) {
		List<Integer> idList=new ArrayList<Integer>();
		for(String id:ids) {
			idList.add(Integer.valueOf(id));
		}
		
		mesDao.deleteBatch(idList);
	}
}
