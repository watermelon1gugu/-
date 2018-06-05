package DAO;

import java.util.List;

import entity.CourseSelectionTbEntity;


public interface CourseSelectionDAO {
	CourseSelectionTbEntity getCourseSelectionByID(int id); 
	 

    List<CourseSelectionTbEntity> getAllCourseSelection(); 


    void addCourseSelection(CourseSelectionTbEntity courseSelection); 


    void delCourseSelection(int id); 


    void updateCourseSelection(CourseSelectionTbEntity courseSelection); 
}
