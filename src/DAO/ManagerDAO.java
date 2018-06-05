package DAO;

import java.util.List;

import entity.ManagerTbEntity;

public interface ManagerDAO {
	ManagerTbEntity getManagerByID(int id); 
	 
	 
    List<ManagerTbEntity> getManagerByName(String name); 


    List<ManagerTbEntity> getAllManager(); 


    void addManager(ManagerTbEntity manager); 


    void delManager(int id); 


    void updateManager(ManagerTbEntity manager); 

}
