package DAO;

import java.util.List;

import entity.DeptTbEntity;

public interface DeptDAO{
	DeptTbEntity getDeptByID(int id); 
	 
	 
    List<DeptTbEntity> getDeptByName(String name); 


    List<DeptTbEntity> getAllDept(); 


    void addDept(DeptTbEntity dept); 


    void delDept(int id); 


    void updateDept(DeptTbEntity dept); 
}
