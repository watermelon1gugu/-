package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "dept_tb", schema = "course_selection_system")
public class DeptTbEntity {
    private int deptId;
    private String deptName;
    private int deptDeanId;
    private String deptTel;

    @Id
    @Column(name = "dept_id", nullable = false)
    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    @Basic
    @Column(name = "dept_name", nullable = false, length = 45)
    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Basic
    @Column(name = "dept_dean_id", nullable = false)
    public int getDeptDeanId() {
        return deptDeanId;
    }

    public void setDeptDeanId(int deptDeanId) {
        this.deptDeanId = deptDeanId;
    }

    @Basic
    @Column(name = "dept_tel", nullable = false, length = 45)
    public String getDeptTel() {
        return deptTel;
    }

    public void setDeptTel(String deptTel) {
        this.deptTel = deptTel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeptTbEntity that = (DeptTbEntity) o;
        return deptId == that.deptId &&
                deptDeanId == that.deptDeanId &&
                Objects.equals(deptName, that.deptName) &&
                Objects.equals(deptTel, that.deptTel);
    }

    @Override
    public int hashCode() {

        return Objects.hash(deptId, deptName, deptDeanId, deptTel);
    }
}
