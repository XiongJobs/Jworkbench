package web.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import web.bean.Person;
import web.service.PersonService;

@Controller
@RequestMapping(value={"/person"})
public class PersonController {
	@Resource
	private PersonService ps;
	
	@RequestMapping(value={"/listall"})
	public String list(Map<String,Object> model){		//BindingAwareModelMap
		System.out.println("all");
		List<Person> list = ps.list();
		model.put("PList", list);
		
		return "person/personlistall";
	}
	
	@RequestMapping(value={"/list2"})
	public String list2(Model model) {
		List<Person> list = ps.list();
		model.addAttribute(list);
		return "person/personlistall";
	}
	
	@RequestMapping(value={"/toupdate"})
	public String toupdate( Integer id, Model model){
		System.out.println("touchupdate");
		
		Person p = ps.getPerson(id);
		model.addAttribute(p);
		return "person/personupdate";
	}
	
	@RequestMapping(value="/saveOrUpdate") //可加属性  method={RequestMethod.POST}
	public String saveOrUpdate(@Valid Person p,
			BindingResult br,
			@RequestParam("photo") MultipartFile file,
			HttpServletRequest request){
		System.out.println(p);
		
		if(br.hasErrors()){
			return "person/personupdate";  //有错误返回页面显示错误
		}
		
		if(!file.isEmpty()){
			ServletContext sc = request.getSession().getServletContext();
			String dir = sc.getRealPath("/upload");	//设定文件保存的目录
			//System.out.println("savepath is "+dir);
			String filename = file.getOriginalFilename();	//得到上传时的文件名
			
			try {
				FileUtils.writeByteArrayToFile(new File(dir,filename), file.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			p.setPhotopath("/upload/"+filename);	//设置图片所在路径
			
			System.out.println("upload over. "+ filename);
		}	
		ps.saveOrUpdate(p);
		return "redirect:/person/list2";
	}
	
	//转向新增页面
	@RequestMapping(value={"/tocreate"})
	public String tocreate(){
		return "/person/personCreate";
	}
	
	//删除对象
	@RequestMapping(value={"/delete"})
	public String tocreate(Integer id){
		ps.deleteByid(id);
		return "redirect:/person/list2";
	}
}
