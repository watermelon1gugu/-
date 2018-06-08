package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "manager_tb", schema = "Course_Selection_System", catalog = "")
public class ManagerTbEntity {
    private int managerId;
    private String managerName;
    private String managerSex;
    private String managerPasswd;

    @Id
    @Column(name = "manager_id", nullable = false)
    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    @Basic
    @Column(name = "manager_name", nullable = false, length = 45)
    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    @Basic
    @Column(name = "manager_sex", nullable = false, length = 1)
    public String getManagerSex() {
        return managerSex;
    }

    public void setManagerSex(String managerSex) {
        this.managerSex = managerSex;
    }

    @Basic
    @Column(name = "manager_passwd", nullable = false, length = 45)
    public String getManagerPasswd() {
        return managerPasswd;
    }

    public void setManagerPasswd(String managerPasswd) {
        this.managerPasswd = managerPasswd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ManagerTbEntity that = (ManagerTbEntity) o;
        return managerId == that.managerId &&
                Objects.equals(managerName, that.managerName) &&
                Objects.equals(managerSex, that.managerSex) &&
                Objects.equals(managerPasswd, that.managerPasswd);
    }

    @Override
    public int hashCode() {

        return Objects.hash(managerId, managerName, managerSex, managerPasswd);
    }
}
