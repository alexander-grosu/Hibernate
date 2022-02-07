import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
            Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();

            SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            Students student = session.get(Students.class, 45);
            List<Subscriptions> subsList = student.getSubscriptionsList();
            int subsSize = student.getSubscriptionsList().size();
            int i = 0;
            System.out.println("\n" + student.getName() + " subscried to " + subsSize + " courses:\n");
            while (i < subsSize)
            {
                int courseId = subsList.get(i).getCourseId();
                Course course = session.get(Course.class,courseId);
                System.out.println("  |" + course.getName()
                        + "\n  |subscription date: " + subsList.get(i).getSubscriptionDate()
                        + "\n  |teacher: " + course.getTeacher().getName());
                i++;
            }
            transaction.commit();
            session.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
