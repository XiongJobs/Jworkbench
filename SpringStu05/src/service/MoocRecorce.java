package service;

import java.io.IOException;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.Resource;

public class MoocRecorce implements ApplicationContextAware{
	
	private ApplicationContext applicationContext;
	
	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		this.applicationContext=arg0;
		
	}
	
	
	public void resorces() throws IOException {
		Resource resource=applicationContext.getResource("classpath:config.txt");
		System.out.println(resource.getFilename());
		System.out.println(resource.contentLength());
	}
}
