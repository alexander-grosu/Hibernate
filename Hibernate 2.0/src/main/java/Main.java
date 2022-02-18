import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.Query;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Main {

    //private static Students o.getName();

    public static void main(String[] args) {
        LogManager logManager = LogManager.getLogManager();
        Logger logger = logManager.getLogger("");
        logger.setLevel(Level.SEVERE);

        try {
            StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
            Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();

            SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
            Session session = sessionFactory.openSession();

            //  *** Students List
            Criteria criteria = session.createCriteria(Students.class);
            List<Students> allStudents = criteria.setMaxResults(5).list();
            int i = 0;
            while (i < allStudents.size()) {
                System.out.println("\n" + allStudents.get(i).getId() + ". " + allStudents.get(i).getName()
                        + "\n\t| subscribed to "
                        + allStudents.get(i).getSubscriptionsList().size()
                        + " courses:"
                );
                i++;
            }
            System.out.println();

            //  *** Purchase List
            Query query = session.createQuery("FROM PurchaseList");
            List<PurchaseList> purchaseLists = query.setMaxResults(5).getResultList();
            int index = 0;
            int num = 1;
            while (index < purchaseLists.size()) {
                System.out.print("Purchase # " + num);
                System.out.println("\n\t> course name:  " + purchaseLists.get(index).getCourseName()
                        + "\n\t> student name:  " + purchaseLists.get(index).getStudentName()
                        + "\n\t> price:  " + purchaseLists.get(index).getPrice()
                        + "\n\t> reg date:  " + purchaseLists.get(index).getRegistrationDate()
                        + "\n"
                );
                num++;
                index++;
            }

            //  *** Subscriptions List
            List<Subscriptions> subscriptions = session.createCriteria(Subscriptions.class).setMaxResults(5).list();
            int number = 1;
            for (Subscriptions subscription : subscriptions) {

                System.out.println("SUBSCRIPTION # " + number + "\n" + subscription);
                number++;
            }

            System.out.println("\n");

            // new course
//            Course course = new Course();          // id 50
//            course.setType(CourseType.PROGRAMMING);
//            course.setName("C++ с нуля до PRO");
//            course.setDescription("Представляем вашему вниманию шикарный курс C++");
//            course.setPrice(85000);
//            course.setDuration(12);
//            course.setTeacher(session.get(Teacher.class,4));
//            course.setPricePerHour(2000);
//            session.beginTransaction();
//            session.save(course);
//            session.getTransaction().commit();

            // new student
//            Students student = new Students();   //id 101
//            student.setName("Alexander Grosu");
//            student.setAge(32);
//            student.setRegistrationDate(new Date());
//            session.beginTransaction();
//            session.save(student);
//            session.getTransaction().commit();

            //new subscription
//            Subscriptions subscription = new Subscriptions();
//            subscription.setSKey(new SubscriptionKey(101,50));
//            subscription.setSubscriptionDate(new Date());
//            session.beginTransaction();
//            session.save(subscription);
//            session.getTransaction().commit();


            Students student = session.get(Students.class, 101);
            System.out.println("\n\nstudent : " + student.getName()
                    + "\n\t> age: " + student.getAge()
                    + "\n\t> reg date: " + student.getRegistrationDate() + "\n\t> subscribed to " + student.getCourses().size() + " courses"
                    + "\n\t\t> course name: " + student.getCourses().get(0).getName()
                    + "\n\t\t> type: " + student.getCourses().get(0).getType()
                    + "\n\t\t> teacher name: " + student.getCourses().get(0).getTeacher().getName()
                    + "\n\t\t> start learning: " + student.getSubscriptionsList().get(0).getSubscriptionDate());


            Subscriptions subscription = session.get(Subscriptions.class, new SubscriptionKey(101, 50));
            if (session.get(Students.class, 101) != null && session.get(Course.class, 50) != null) {
                System.out.println("\nfind subscription with key (student id 101, course id 50)\n" + subscription);
            } else {
                System.out.println("\nno such subscription exists");
            }

            List<PurchaseList> pList = session.createQuery("FROM " + PurchaseList.class.getSimpleName()).getResultList();
            for (PurchaseList p : pList) {

                List<Students> sList = session.createQuery("FROM " + Students.class.getSimpleName()).getResultList();
                List<Course> cList = session.createQuery("FROM " + Course.class.getSimpleName()).getResultList();

                List<Students> students = sList.stream().filter(o -> Objects.equals(o.getName(), p.getStudentName())).collect(Collectors.toList());
                List<Course> courses = cList.stream().filter(o -> Objects.equals(o.getName(), p.getCourseName())).collect(Collectors.toList());

//                LinkedPurchaseList linkedPurchaseList = new LinkedPurchaseList();

//                linkedPurchaseList.setStudentId(students.get(0).getId());
//                linkedPurchaseList.setCourseId(courses.get(0).getId());
//                session.beginTransaction();
//                session.save(linkedPurchaseList);
//                session.getTransaction().commit();

            }


            session.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
