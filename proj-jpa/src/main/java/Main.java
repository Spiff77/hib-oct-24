import com.trainings.dao.utils.PersistenceUtils;
import com.trainings.employees.dao.dto.ColorAvgPower;
import com.trainings.model.*;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;


public class Main {


    public static void main(String[] args) {



        String brand = "Peugeot";
        String color = "Red";

        EntityManager em = PersistenceUtils.getInstance().getEmf().createEntityManager();


        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ColorAvgPower> criteria = cb.createQuery(ColorAvgPower.class);
        Root<Car> root = criteria.from(Car.class);

        criteria.select(cb.construct(ColorAvgPower.class, root.get("id").get("color"), cb.avg(root.get("engine").get("power"))));
        criteria.groupBy(root.get("id").get("color"));

        List<ColorAvgPower> eas = em.createQuery(criteria)
                .getResultList();
        System.out.println(eas);


       /* criteria.select(root).distinct(true);

        criteria.orderBy(
                cb.asc(root.get("id").get("brand"))
        );
        Predicate carBrandPredicate = cb.equal(root.get("id").get("brand"), cb.parameter(String.class, "brand"));
        Predicate carColorPredicate = cb.equal(root.get("id").get("color"), cb.parameter(String.class, "color"));

        criteria.where(
                cb.or(carBrandPredicate, carColorPredicate)
        );

        List<Car> cars = em.createQuery(criteria)
                .setParameter("brand",brand)
                .setParameter("color",color)
                .getResultList();
        System.out.println(cars);
       */

        PersistenceUtils.getInstance().shutDown();


    }
}
