package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "course_tb", schema = "course_selection_system", catalog = "")
public class CourseTbEntity {
    private int courseId;
    private String courseName;
    private short courseCredit;
    private short courseTime;
    private short courseLimit;

    @Id
    @Column(name = "course_id", nullable = false)
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Basic
    @Column(name = "course_name", nullable = false, length = 45)
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Basic
    @Column(name = "course_credit", nullable = false)
    public short getCourseCredit() {
        return courseCredit;
    }

    public void setCourseCredit(short courseCredit) {
        this.courseCredit = courseCredit;
    }

    @Basic
    @Column(name = "course_time", nullable = false)
    public short getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(short courseTime) {
        this.courseTime = courseTime;
    }

    @Basic
    @Column(name = "course_limit", nullable = false)
    public short getCourseLimit() {
        return courseLimit;
    }

    public void setCourseLimit(short courseLimit) {
        this.courseLimit = courseLimit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseTbEntity that = (CourseTbEntity) o;
        return courseId == that.courseId &&
                courseCredit == that.courseCredit &&
                courseTime == that.courseTime &&
                courseLimit == that.courseLimit &&
                Objects.equals(courseName, that.courseName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(courseId, courseName, courseCredit, courseTime, courseLimit);
    }
}
