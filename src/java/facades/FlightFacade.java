
package facades;

import entity.Airline;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import metaEngine.Flight;
import metaEngine.FlightInfo;
import metaEngine.MetaEngine;

public class FlightFacade implements FlightFacadeInterface{
    
    private EntityManagerFactory emf;
    private AirlineFacade airlineFacade;

    public FlightFacade(EntityManagerFactory emf) {
        this.emf = emf;
        airlineFacade = new AirlineFacade(emf);
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public List<Flight> getAllFlightsFrom(FlightInfo flightInfo) {
        //get all airlines
        List<Airline> airlines = airlineFacade.getAllAirlines();
        //pass the airlines to the engine
        MetaEngine engine = new MetaEngine(airlines);
        //get all flights
        List<Flight> flights = engine.getAllFlightsFrom(flightInfo);
        
        return flights;
    }

    @Override
    public List<Flight> getAllFlightsFromTo(FlightInfo flightInfo) {
        
        //get all airlines
        List<Airline> airlines = airlineFacade.getAllAirlines();
        //pass the airlines to the engine
        MetaEngine engine = new MetaEngine(airlines);
        //get all flights
        List<Flight> flights = engine.getAllFlightsFromTo(flightInfo);
        
        return flights;
    }
    
    
}
