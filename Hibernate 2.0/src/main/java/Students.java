import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "Students")
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    private Integer age;

    @Column(name = "registration_date")
    private Date registrationDate;

    private String name;

    @ManyToMany(mappedBy = "students",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude // many students to many courses
    private List<Course> courses;

    @OneToMany(mappedBy = "student")
    @ToString.Exclude
    private List<Subscriptions> subscriptionsList;
    @OneToMany(mappedBy = "studentName")
    @ToString.Exclude
    private List<PurchaseList> purchaseLists;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Students students = (Students) o;
        return id != null && Objects.equals(id, students.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
