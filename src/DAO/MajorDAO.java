package DAO;

import java.util.List;

import entity.MajorTbEntity;

public interface MajorDAO {
	MajorTbEntity getMajorByID(int id); 
	 
	 
    List<MajorTbEntity> getMajorByName(String name);

    List<MajorTbEntity> getAllMajor();

    void addMajor(MajorTbEntity major);


    void delMajor(int id); 


    void updateMajor(MajorTbEntity major); 
}
