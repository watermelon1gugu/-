package DAO;

import java.util.List;

import entity.CourseTbEntity;



public interface CourseDAO { 
	 
	 
    CourseTbEntity getCourseByID(int id); 


    List<CourseTbEntity> getCourseByName(String name); 


    List<CourseTbEntity> getAllCourse(); 


    void addCourse(CourseTbEntity course); 


    void delCourse(int id); 


    void updateCourse(CourseTbEntity course); 

} 
