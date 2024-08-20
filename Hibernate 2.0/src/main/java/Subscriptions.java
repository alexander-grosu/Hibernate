import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "Subscriptions")
public class Subscriptions
{
    @EmbeddedId
    private SubscriptionKey sKey;

    @ManyToOne
    @JoinColumn(name = "student_id",insertable = false,updatable = false)
    private Students student;

    @ManyToOne
    @JoinColumn(name = "course_id", insertable = false, updatable = false)
    private Course course;

    @Column(name = "subscription_date")
    private Date subscriptionDate;

    public Subscriptions(SubscriptionKey sKey) {
        this.sKey = sKey;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Subscriptions that = (Subscriptions) o;
        return sKey != null && Objects.equals(sKey, that.sKey);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sKey);
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
    class SubscriptionKey implements Serializable {

        @Column(name = "student_id")
        int studentId;

        @Column(name = "course_id")
        int courseId;
    }
