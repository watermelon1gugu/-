package service;

import DAO.BaseHibernateDAO;
import entity.CourseSelectionTbEntity;

public class Stu_CourseSelectionImpl extends BaseHibernateDAO implements Stu_CourseSelectionBiz{
    public void Stu_CourseSelection(int stu_id, int course_id){
        short a = 0;
        CourseSelectionTbEntity courseSelectionTbEntity = new CourseSelectionTbEntity();
        courseSelectionTbEntity.setStuId(stu_id);
        courseSelectionTbEntity.setCourseId(course_id);
        courseSelectionTbEntity.setStuCourseId(90);
        courseSelectionTbEntity.setGrade(a);
        super.add(courseSelectionTbEntity);
    }

    public void SetCourseGrade(int stuCourseId, int stu_id, int course_id, short grade){
        CourseSelectionTbEntity courseSelectionTbEntity = new CourseSelectionTbEntity();
        courseSelectionTbEntity.setCourseId(course_id);
        courseSelectionTbEntity.setGrade(grade);
        courseSelectionTbEntity.setStuId(stu_id);
        courseSelectionTbEntity.setStuCourseId(stuCourseId);
        super.add(courseSelectionTbEntity);
    }
}
