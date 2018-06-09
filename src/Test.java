import DAO.CourseSelectionDAO;
import DAO.Impl.CourseSelectionDAOImpl;
import service.StudentService;
import service.StudentServiceImpl;

public class Test {

    public static void main(String[] args){
        /*StudentService studentService = new StudentServiceImpl();
        studentService.StudentSelectionCourse(10221,463004);*/
        CourseSelectionDAO courseSelectionDAO = new CourseSelectionDAOImpl();
        courseSelectionDAO.delCourseSelection(123409);
        //CourseSelectionDAO courseSelectionDAO = new CourseSelectionDAOImpl();
        //System.out.println(courseSelectionDAO.getAllCourseSelection().size());
        System.out.println(111);
    }
}
