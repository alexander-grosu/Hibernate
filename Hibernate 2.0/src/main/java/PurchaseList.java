import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
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
}
