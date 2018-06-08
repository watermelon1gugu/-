import service.StudentService;
import service.StudentServiceImpl;

public class Test {

    public static void main(String[] args){
        StudentService studentService = new StudentServiceImpl();
        studentService.StudentSelectionCourse(10221,463004);
        System.out.println(111);
    }
}
