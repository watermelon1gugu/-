package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "course_selection_tb", schema = "course_selection_system", catalog = "")
public class CourseSelectionTbEntity {
    private int stuCourseId;
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
    @Column(name = "grade", nullable = false)
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
                grade == that.grade;
    }

    @Override
    public int hashCode() {

        return Objects.hash(stuCourseId, grade);
    }
}
