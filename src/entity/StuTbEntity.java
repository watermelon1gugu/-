package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "stu_tb", schema = "Course_Selection_System", catalog = "")
public class StuTbEntity {
    private int stuId;
    private int majorId;
    private String stuName;
    private String stuSex;
    private String stuPasswd;

    @Id
    @Column(name = "stu_id", nullable = false)
    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    @Basic
    @Column(name = "major_id", nullable = false)
    public int getMajorId() {
        return majorId;
    }

    public void setMajorId(int majorId) {
        this.majorId = majorId;
    }

    @Basic
    @Column(name = "stu_name", nullable = false, length = 45)
    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    @Basic
    @Column(name = "stu_sex", nullable = false, length = 1)
    public String getStuSex() {
        return stuSex;
    }

    public void setStuSex(String stuSex) {
        this.stuSex = stuSex;
    }

    @Basic
    @Column(name = "stu_passwd", nullable = false, length = 45)
    public String getStuPasswd() {
        return stuPasswd;
    }

    public void setStuPasswd(String stuPasswd) {
        this.stuPasswd = stuPasswd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StuTbEntity that = (StuTbEntity) o;
        return stuId == that.stuId &&
                majorId == that.majorId &&
                Objects.equals(stuName, that.stuName) &&
                Objects.equals(stuSex, that.stuSex) &&
                Objects.equals(stuPasswd, that.stuPasswd);
    }

    @Override
    public int hashCode() {

        return Objects.hash(stuId, majorId, stuName, stuSex, stuPasswd);
    }
}
