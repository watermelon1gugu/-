package DAO;

import java.util.List;

import entity.TeacherTbEntity;


public interface TeacherDAO {
	TeacherTbEntity getTeacherByID(int id); 
	 
	 
    List<TeacherTbEntity> getTeacherByName(String name); 


    List<TeacherTbEntity> getAllTeacher(); 


    void addTeacher(TeacherTbEntity teacher); 


    void delTeacher(int id); 


    void updateTeacher(TeacherTbEntity teacher); 

}
