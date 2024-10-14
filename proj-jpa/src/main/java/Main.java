import com.trainings.model.Car;
import com.trainings.model.CarId;
import com.trainings.model.Fruit;
import com.trainings.model.Truck;
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
        Car car1 = new Car(new CarId("Peugeot", "Bleu"), true);
        Car car2 = new Car(new CarId("Peugeot", "Verte"), true);

        Fruit f = new Fruit(50);
        Fruit f2 = new Fruit(60);

        em.getTransaction().begin();
        em.persist(car1);
        em.persist(car2);

        em.getTransaction().commit();

        TypedQuery<Car> query = em.createQuery("FROM Car", Car.class);
        List<Car> cars = query.getResultList();

        for (Car car : cars) {
            System.out.println(car.getId());
        }

        em.close();
    }
}
