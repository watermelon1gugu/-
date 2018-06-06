package service;

public interface Stu_CourseSelectionBiz {
    public void Stu_CourseSelection(int stu_id, int course_id);
    public void SetCourseGrade(int stuCourseId, int stu_id, int course_id, short grade);
}
