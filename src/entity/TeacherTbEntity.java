package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "teacher_tb", schema = "Course_Selection_System", catalog = "")
public class TeacherTbEntity {
    private int teacherId;
    private int deptId;
    private String teacherName;
    private String teacherSex;
    private String teacherTitle;
    private String teacherPasswd;

    @Id
    @Column(name = "teacher_id", nullable = false)
    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    @Basic
    @Column(name = "dept_id", nullable = false)
    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    @Basic
    @Column(name = "teacher_name", nullable = false, length = 45)
    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    @Basic
    @Column(name = "teacher_sex", nullable = false, length = 1)
    public String getTeacherSex() {
        return teacherSex;
    }

    public void setTeacherSex(String teacherSex) {
        this.teacherSex = teacherSex;
    }

    @Basic
    @Column(name = "teacher_title", nullable = false, length = 45)
    public String getTeacherTitle() {
        return teacherTitle;
    }

    public void setTeacherTitle(String teacherTitle) {
        this.teacherTitle = teacherTitle;
    }

    @Basic
    @Column(name = "teacher_passwd", nullable = false, length = 45)
    public String getTeacherPasswd() {
        return teacherPasswd;
    }

    public void setTeacherPasswd(String teacherPasswd) {
        this.teacherPasswd = teacherPasswd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeacherTbEntity that = (TeacherTbEntity) o;
        return teacherId == that.teacherId &&
                deptId == that.deptId &&
                Objects.equals(teacherName, that.teacherName) &&
                Objects.equals(teacherSex, that.teacherSex) &&
                Objects.equals(teacherTitle, that.teacherTitle) &&
                Objects.equals(teacherPasswd, that.teacherPasswd);
    }

    @Override
    public int hashCode() {

        return Objects.hash(teacherId, deptId, teacherName, teacherSex, teacherTitle, teacherPasswd);
    }
}
