import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "LinkedPurchaseList")
public class LinkedPurchaseList implements Serializable {

    @Id
    @Column(name = "course_id")
    Integer courseId;

    @Id
    @Column(name = "student_id")
    Integer studentId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        LinkedPurchaseList that = (LinkedPurchaseList) o;
        return courseId != null && Objects.equals(courseId, that.courseId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}