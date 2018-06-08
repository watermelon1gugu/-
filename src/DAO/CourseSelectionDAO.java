package DAO;

import entity.CourseSelectionTbEntity;

import java.util.List;


public interface CourseSelectionDAO {
	CourseSelectionTbEntity getCourseSelectionByID(int id);
	 

    List<CourseSelectionTbEntity> getAllCourseSelection(); 


    void addCourseSelection(CourseSelectionTbEntity courseSelection); 


    void delCourseSelection(int id); 


    void updateCourseSelection(CourseSelectionTbEntity courseSelection); 
}
