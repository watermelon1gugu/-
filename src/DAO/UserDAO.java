package DAO;

import entity.StuTbEntity;

import java.util.List;

public interface UserDAO {
    public void add(StuTbEntity student);
    public void delete(StuTbEntity student);
    List searchByObj(Class cla, Object condition);
    public List searchByName(String name, int flag);
    public int validation(String name, String password);
}
