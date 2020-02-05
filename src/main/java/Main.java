import model.Course;
import model.Purchase;
import model.Purchase.PkPurchase;
import model.Student;
import model.Subscription;
import model.Subscription.PK;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {


  public static void main(String[] args) {

    StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
        .configure("hibernate.cfg.xml").build();
    Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
    SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
    Session session = sessionFactory.openSession();
    Transaction transaction = session.beginTransaction();

    //print info about selected student
    Student student = session.get(Student.class, 1);
    System.out.println(student);

    //print info about selected course
    Course course = session.get(Course.class, 2);
    System.out.println(course);

    //print info about selected purchase
    Purchase purchase = session
        .get(Purchase.class, new PkPurchase(course.getName(), student.getName()));
    System.out.println(purchase);

    //print info about selected subscription
    Subscription subscription = session.get(Subscription.class, new PK(student, course));
    System.out.println(subscription.getSubscriptionDate());

    transaction.commit();
    sessionFactory.close();
  }
}
