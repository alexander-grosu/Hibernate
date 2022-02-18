import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "PurchaseList")
public class PurchaseList implements Serializable
{
    @EmbeddedId
    PurchaseKey pKey;

    @Column(name = "student_name", updatable = false, insertable = false)
    private String studentName;

    @Column(name = "course_name", updatable = false, insertable = false)
    private String courseName;

    private Integer price;

    @Column(name = "registration_date")
    private Date registrationDate;

    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode
    @ToString
    @Getter
    @Setter
    @Embeddable
    public static class PurchaseKey implements Serializable
    {
        @Column(name = "student_name")
        private String studentName;

        @Column(name = "course_name")
        private String courseName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PurchaseList that = (PurchaseList) o;
        return pKey != null && Objects.equals(pKey, that.pKey);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pKey);
    }
}
