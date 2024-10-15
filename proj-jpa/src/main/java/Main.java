import com.trainings.model.*;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Date;
import java.util.List;


public class Main {

    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("formation");

    public static void main(String[] args) {
        createCar();
        List<Car> cars =  getAllCars();

        for (Car car : cars) {
            System.out.println(car.getEngine().getPower());
        }
    }

    public static void createCar() {
        EntityManager em = emf.createEntityManager();

        Car car1 = new Car(new CarId("Peugeot", "asdfasdfds"),new Engine(19999), true);
        Car car2 = new Car(new CarId("Peugeot", "sdxsdffsd"),new Engine(19999), true);

        Truck t1 = new Truck(new CarId("Peugeot", "wsdf"),new Engine(19999),true);
        Truck t2 = new Truck(new CarId("Peugeot", "dsdfd"),new Engine(19999),true);

        Engine e = new Engine(200);
        e.setType(EngineType.DIESEL);
        Owner o = new Owner(new Date(), "Jean");

        Seat s = new Seat("Funky", "lkjffgds", false);
        o.add(car1);
        // ou o.getCarsOwned().add(car1);
        s.setCar(car1);
        car1.setEngine(e);

        em.getTransaction().begin();
        em.persist(s);
        em.persist(o);
        em.persist(car1);
        em.persist(car2);
        em.persist(t1);
        em.persist(t2);

        em.flush();
        em.clear();

        em.getTransaction().commit();

        em.close();
    }

    public static List<Car> getAllCars() {
        EntityManager em = emf.createEntityManager();

        TypedQuery<Car> query = em.createQuery("FROM Car", Car.class);
        List<Car> resultList = query.getResultList();
        em.close();
        return resultList;
    }
}
