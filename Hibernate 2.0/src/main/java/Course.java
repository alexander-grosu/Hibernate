import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="Courses")
class Course
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    private String name;

    private Integer duration;

    private String description;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY) // many courses to one teacher
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
    private List<Students> students;

    @OneToMany(mappedBy = "courseName", fetch = FetchType.LAZY)
    private List<PurchaseList> purchaseLists;

}