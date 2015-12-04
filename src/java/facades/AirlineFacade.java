package facades;

import entity.Airline;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class AirlineFacade implements AirlineFacadeInterface{

    private EntityManagerFactory emf;
    
    public AirlineFacade(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
     public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    @Override
    public List<Airline> getAllAirlines() {
        
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
