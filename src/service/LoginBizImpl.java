package service;

import DAO.Impl.LoginDAOImpl;
import DAO.UserDAO;

import java.util.List;

public class LoginBizImpl implements LoginBiz {
    @Override
    public int checkLogin(String name, String password){
        UserDAO loginDAO = new LoginDAOImpl();
        return loginDAO.validation(name, password);
    }

    @Override
    public List getEntity(String name, int flag){
        UserDAO loginDAO = new LoginDAOImpl();
        return loginDAO.searchByName(name, flag);
    }

}
