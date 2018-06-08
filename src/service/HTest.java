package service;

import DAO.BaseHibernateDAO;
import DAO.Impl.CourseSelectionDAOImpl;
import entity.ManagerTbEntity;
import entity.StuTbEntity;
import entity.TeacherTbEntity;

public class HTest {
    public static void main(String args[]){
       /* String password = "qwer";
        String name = "fcy";
        int course_id = 1104;
        LoginBiz loginBiz = new LoginBizImpl();
        int flag = loginBiz.checkLogin(name, password);
        System.out.println("flag "+flag);
       *//* if(flag == 1) {
            System.out.println("This is a Student");
            StuTbEntity student = (StuTbEntity) loginBiz.getEntity(name, flag).get(0);
            Stu_CourseSelectionImpl stu_courseSelection = new Stu_CourseSelectionImpl();
            stu_courseSelection.Stu_CourseSelection(student.getStuId(), course_id);
            System.out.println(student.getStuId());
        }
        else if(flag == 2) {
            System.out.println("This is a Manager");
            ManagerTbEntity managerTbEntity = (ManagerTbEntity)loginBiz.getEntity(name, flag).get(0);
        }
        else if(flag == 3) {
            System.out.println("This is a Teacher");
            TeacherTbEntity teacherTbEntity = (TeacherTbEntity)loginBiz.getEntity(name, flag).get(0);
        }
        else System.out.println("input error!");*/
        /*TestService testService = new TestService();
        System.out.println(testService.test());*/
        CourseSelectionDAOImpl courseSelectionDAO = new CourseSelectionDAOImpl();
        System.out.println(courseSelectionDAO.getAllCourseSelection().size());

    }
}
