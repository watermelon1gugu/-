package service;

import java.util.List;

public interface LoginBiz {
    public int checkLogin(String name, String password);
    public List getEntity(String name, int flag);
}
