package DAO.Impl;

import DAO.UserDAO;
import DAO.BaseHibernateDAO;
import entity.ManagerTbEntity;
import entity.StuTbEntity;
import entity.TeacherTbEntity;

import java.util.List;

public class LoginDAOImpl extends BaseHibernateDAO implements UserDAO {
    @Override
    public void add(StuTbEntity student){
        super.add(student);
    }

    @Override
    public void delete(StuTbEntity student){
        super.delete(student);
    }

    @Override
    public List searchByObj(Class cla, Object condition){
        return super.searchByObj(cla, condition);
    }

    @Override
    public List searchByName(String name, int flag){
        if(flag == 1){
            StuTbEntity condition1 = new StuTbEntity();
            condition1.setStuName(name);
            return super.searchByObj(StuTbEntity.class, condition1);
        }
        else if(flag == 2){
            ManagerTbEntity condition2 = new ManagerTbEntity();
            condition2.setManagerName(name);
            return super.searchByObj(ManagerTbEntity.class, condition2);
        }
        else if(flag == 3){
            TeacherTbEntity condition3 = new TeacherTbEntity();
            condition3.setTeacherName(name);
            return super.searchByObj(TeacherTbEntity.class, condition3);
        }
        else{
            return null;
        }
    }

    @Override
    public int validation(String name, String password){
        int flag = 0;

        StuTbEntity condition = new StuTbEntity();
        condition.setStuPasswd(password);
        condition.setStuName(name);

        List list = super.searchByObj(StuTbEntity.class, condition);
        if(list.size() > 0){
            flag = 1;
        }
        else{
            ManagerTbEntity condition2 = new ManagerTbEntity();
            condition2.setManagerName(name);
            condition2.setManagerPasswd(password);
            list = super.searchByObj(ManagerTbEntity.class, condition2);

            if(list.size() > 0) flag = 2;
            else{
                TeacherTbEntity condition3 = new TeacherTbEntity();
                condition3.setTeacherName(name);
                condition3.setTeacherPasswd(password);
                list = super.searchByObj(TeacherTbEntity.class, condition3);
                if(list.size() > 0) flag = 3;
            }

        }
        return flag;
    }
}
