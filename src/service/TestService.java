package service;

import DAO.Impl.MajorDAOImpl;
import DAO.MajorDAO;

public class TestService {
    public int test(){
        MajorDAO majorDAO = new MajorDAOImpl();
        return majorDAO.getAllMajor().size();
    }
}
