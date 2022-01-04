import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();
        List courseList = session.createQuery("FROM " + Course.class.getSimpleName()).getResultList();

        int size = courseList.size();
        int id = 1;

        Course course = session.get(Course.class, id);
        System.out.println("\n" + course.getName() + " | " + course.getType() + "\nstudents count: " + course.getStudentsCount() + "\n");
        while (id < size) {
            id++;
            course = session.get(Course.class, id);
            System.out.println(course.getName() + " | " + course.getType() +  "\nstudents count: " + course.getStudentsCount() + "\n");
        }

        registry.close();
        sessionFactory.close();
        session.close();
    }
}
