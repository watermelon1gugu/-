package service;

import java.util.List;

import entity.CourseSelectionTbEntity;
import entity.CourseTbEntity;

public interface StudentService {

	List<CourseSelectionTbEntity> StudentFindOwnCourse(int stuId);

	List<CourseTbEntity> StudentFindCourse();

	void StudentDeleteCourse(int courseId, int stuId);

	void StudentSelectionCourse(int courseId,int stuId);

}
