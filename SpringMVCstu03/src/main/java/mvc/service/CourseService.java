package mvc.service;

import org.springframework.stereotype.Service;

import mvc.model.Course;

@Service
public interface CourseService {
	
	
	Course getCoursebyId(Integer courseId);
	

	
	

}
