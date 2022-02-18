import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "LinkedPurchaseList")
public class LinkedPurchaseList {
    @EmbeddedId
    LinkedPurchaseKey lpKey;

    @Column(name = "student_id", updatable = false, insertable = false)
    private Integer studentId;

    @Column(name = "course_id", updatable = false, insertable = false)
    private Integer courseId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        LinkedPurchaseList that = (LinkedPurchaseList) o;
        return lpKey != null && Objects.equals(lpKey, that.lpKey);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lpKey);
    }
}

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Embeddable
class LinkedPurchaseKey implements Serializable {

    @Column(name = "student_id")
    Integer studentId;

    @Column(name = "course_id")
    Integer courseId;
}