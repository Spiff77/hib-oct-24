import com.trainings.dao.CarDAO;
import com.trainings.dao.EngineDAO;
import com.trainings.dao.impl.CarDAOHibernate;
import com.trainings.dao.impl.CarDAOJpa;
import com.trainings.dao.impl.EngineDAOJpa;
import com.trainings.dao.utils.PersistenceUtils;
import com.trainings.model.*;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;


public class Main {


    public static void main(String[] args) {

        CarDAO cdao = new CarDAOJpa();
        EngineDAO eDao = new EngineDAOJpa();

        PersistenceUtils.getInstance().shutDown();
    }
}
