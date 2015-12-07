
package facades;

import entity.Airline;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class AirlineFacade implements AirlineFacadeInterface
{

    private EntityManagerFactory emf;

    public AirlineFacade(EntityManagerFactory emf)
    {
        this.emf = emf;
    }

    public EntityManager getEntityManager()
    {
        return emf.createEntityManager();
    }

    @Override
    public List<Airline> getAllAirlines()
    {

        List<Airline> testFlight = new ArrayList();
        testFlight.add(new Airline("test", "http://angularairline-plaul.rhcloud.com/api"));
        testFlight.add(new Airline("outsourcing", "http://sargardon-001-site1.atempurl.com/api"));
        
        return testFlight;
    }

}
