import com.trainings.model.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        MetadataSources sources = new MetadataSources(registry);
        Metadata metadata = sources.buildMetadata();
        SessionFactory sessionFactory = metadata.buildSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            Car car = new Car(1, "Peugeot", "Verte");

            session.getTransaction().begin();
            session.persist(car);
            session.getTransaction().commit();

            Query<Car> query = session.createQuery("FROM Car", Car.class);
            List<Car> cars = query.list();

            for (Car car1 : cars) {
                System.out.println(car1.getBrand());
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        sessionFactory.close();
    }
}
