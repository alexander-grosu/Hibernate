import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="Courses")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
class Course
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    private String name;

    private Integer duration;

    private String description;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude // many courses to one teacher
    private Teacher teacher;

    @Column(name = "students_count")
    private Integer studentsCount;

    private Integer price;

    @Column(name = "price_per_hour")
    private float pricePerHour;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum")
    private CourseType type;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY) // many courses to many students
    @JoinTable(
            name = "Subscriptions",
            joinColumns = @JoinColumn(name="course_id", referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName="id"))
    @ToString.Exclude
    private List<Students> students;


    @OneToMany(mappedBy = "course")
    @ToString.Exclude
    private List<Subscriptions> subscriptionsList;
    @OneToMany(mappedBy = "courseName")
    @ToString.Exclude
    private List<PurchaseList> purchaseLists;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Course course = (Course) o;
        return id != null && Objects.equals(id, course.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}