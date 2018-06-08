package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "major_tb", schema = "Course_Selection_System", catalog = "")
public class MajorTbEntity {
    private int majorId;
    private int deptId;
    private String majorName;

    @Id
    @Column(name = "major_id", nullable = false)
    public int getMajorId() {
        return majorId;
    }

    public void setMajorId(int majorId) {
        this.majorId = majorId;
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
    @Column(name = "major_name", nullable = false, length = 45)
    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MajorTbEntity that = (MajorTbEntity) o;
        return majorId == that.majorId &&
                deptId == that.deptId &&
                Objects.equals(majorName, that.majorName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(majorId, deptId, majorName);
    }
}
