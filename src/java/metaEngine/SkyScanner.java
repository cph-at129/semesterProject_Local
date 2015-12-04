package metaEngine;

import entity.Airline;
import java.util.concurrent.Callable;

public class SkyScanner implements Callable<Flight>{

    private Airline airline;
    private FlightInfo flightInfo;

    public SkyScanner(Airline airline, FlightInfo flightInfo) {
        this.airline = airline;
        this.flightInfo = flightInfo;
    }
    
    @Override
    public Flight call() throws Exception {
        
        //scan the airline for flights
        
        //....
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
