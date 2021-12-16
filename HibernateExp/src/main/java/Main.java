import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {
    public static void main(String[] args) {

        try {
            StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                    .configure("hibernate.cfg.xml").build();
            Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
            SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
            Session session = sessionFactory.openSession();

            //EXAMPLES
            int i = 1;
            Course course = session.get(Course.class, i);
            System.out.println(course.getId() + " " + course.getName() + "\nstudents count: " + course.getStudentsCount());
            while(true){
                i++;
                Course course1 = session.get(Course.class,i);
                System.out.println(course1.getId() + " " + course1.getName() + "\nstudents count: " + course1.getStudentsCount());
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
