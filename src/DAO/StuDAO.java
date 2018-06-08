package DAO;

import entity.StuTbEntity;

import java.util.List;

public interface StuDAO {

    StuTbEntity getStuByID(int id);

    List getStuByName(String name);

    List<StuTbEntity> getAllStu();

    void addStu(StuTbEntity stu);

    void delStu(int id);

    void updateStu(StuTbEntity stu);

}
