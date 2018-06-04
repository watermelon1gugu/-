package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "major_tb", schema = "course_selection_system", catalog = "")
public class MajorTbEntity {
    private int majorId;
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
                Objects.equals(majorName, that.majorName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(majorId, majorName);
    }
}
