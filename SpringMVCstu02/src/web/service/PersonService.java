package web.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import web.bean.Person;

@Service
public class PersonService {
	private static Map<Integer,Person> map = new HashMap<Integer,Person>(); //存储结构
	private static String id="0";
	
		//初始化数据
		static{
			Person p = null;
			for(int i=1;i<=10;i++){
				id=String.valueOf(i);
				
				p = new Person();
				p.setId(id);
				p.setName("tony"+i);
				p.setAge(String.valueOf(20+i));
				
				map.put(i, p);
				id=String.valueOf(i+1);
			}
		}
		
		//列表
		public List<Person> list(){
			return new ArrayList<Person>(map.values());
		}
		
		//获取对象
		public Person getPerson(Integer id) {
			return map.get(id);
		}
		
		//保存对象
		public void saveOrUpdate(Person p){
			if(p.getId()==null){				
				id=String.valueOf(Integer.parseInt(id)+1);
				p.setId(id);
			}else {			
				p.setAge(id+100);
			}			
			System.out.println(p);
			map.put(Integer.parseInt(p.getId()), p);
		}
		
		//删除对象
		public void deleteByid(Integer id){
			map.remove(id);
		}
}
