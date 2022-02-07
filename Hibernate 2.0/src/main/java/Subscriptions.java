import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Setter
@Getter
@Table(name = "Subscriptions")
public class Subscriptions
{
    @EmbeddedId
    private SubscriptionId sKey;

    @Column(name = "student_id", insertable = false, updatable = false)
    private int studentId;

    @Column(name = "course_id", insertable = false, updatable = false)
    private int courseId;

    @Column(name = "subscription_date")
    private Date subscriptionDate;

    @NoArgsConstructor
    @EqualsAndHashCode
    @Getter
    @Setter
    @ToString
    @Embeddable
    public static class SubscriptionId implements Serializable
    {
        @Column(name = "student_id")
        private int studentId;

        @Column(name = "course_id")
        private int courseId;
    }
}
