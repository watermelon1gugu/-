package entity;

import javax.persistence.Entity;
import java.util.Objects;

@Entity
@javax.persistence.Table(name = "course_selection_tb", schema = "course_selection_system", catalog = "")
public class CourseSelectionTbEntity {
    private int stuCourseId;
    @javax.persistence.Id
    @javax.persistence.Column(name = "stu_course_id", nullable = false)
    public int getStuCourseId() {
        return stuCourseId;
    }

    public void setStuCourseId(int stuCourseId) {
        this.stuCourseId = stuCourseId;
    }

    private int stuId;

    @javax.persistence.Basic
    @javax.persistence.Column(name = "stu_id", nullable = false)
    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    private int courseId;

    @javax.persistence.Basic
    @javax.persistence.Column(name = "course_id", nullable = false)
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    private short grade;

    @javax.persistence.Basic
    @javax.persistence.Column(name = "grade", nullable = false)
    public short getGrade() {
        return grade;
    }

    public void setGrade(short grade) {
        this.grade = grade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseSelectionTbEntity that = (CourseSelectionTbEntity) o;
        return stuCourseId == that.stuCourseId &&
                stuId == that.stuId &&
                courseId == that.courseId &&
                grade == that.grade;
    }

    @Override
    public int hashCode() {

        return Objects.hash(stuCourseId, stuId, courseId, grade);
    }
}
