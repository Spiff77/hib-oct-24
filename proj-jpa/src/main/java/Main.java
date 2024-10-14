import com.trainings.model.Car;
import jakarta.persistence.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("formation");
        EntityManager em = emf.createEntityManager();
        EntityManager em1 = emf.createEntityManager();
        Car car = new Car(1, "Peugeot", "Verte");


        em.getTransaction().begin();
        em.persist(car);
        em.getTransaction().commit();

        TypedQuery<Car> query = em1.createQuery("FROM Car", Car.class);
        List<Car> cars = query.getResultList();

        for (Car car1 : cars) {
            System.out.println(car1.getBrand());
        }

        em.close();
    }
}
