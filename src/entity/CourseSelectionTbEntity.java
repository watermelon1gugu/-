package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "course_selection_tb", schema = "Course_Selection_System")
public class CourseSelectionTbEntity {
    private int stuCourseId;
    private int stuId;
    private int courseId;
    private short grade;

    @Id
    @Column(name = "stu_course_id", nullable = false)
    public int getStuCourseId() {
        return stuCourseId;
    }

    public void setStuCourseId(int stuCourseId) {
        this.stuCourseId = stuCourseId;
    }

    @Basic
    @Column(name = "stu_id", nullable = false)
    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    @Basic
    @Column(name = "course_id", nullable = false)
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Column(name = "grade")
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
