import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
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

    @ManyToMany(mappedBy = "students",cascade = CascadeType.ALL, fetch = FetchType.LAZY) // many students to many courses
    private List<Course> courses;

    @OneToMany(mappedBy = "studentId", fetch = FetchType.LAZY)
    private List<Subscriptions> subscriptionsList;

}
