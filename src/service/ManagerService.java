package service;

import java.util.List;

import entity.CourseSelectionTbEntity;
import entity.CourseTbEntity;

public interface ManagerService {
	

	List<CourseTbEntity> ManagerFindCourse() ;
	

	List<CourseSelectionTbEntity> ManagerFindCourseSelection(int stuId);
	

	public void ManagerDeleteStuCourse(int courseId, int stuId);
		
}
