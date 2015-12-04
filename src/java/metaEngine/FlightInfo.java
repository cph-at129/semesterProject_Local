package metaEngine;

import java.util.Date;

public class FlightInfo {
    
    private String origin;
    private String destination;
    private Date flightDate;
    private int numOfTickets;

    public FlightInfo(String origin, Date flightDate, int numOfTickets) {
        this.origin = origin;
        this.flightDate = flightDate;
        this.numOfTickets = numOfTickets;
    }

    public FlightInfo(String origin, String destination, Date flightDate, int numOfTickets) {
        this.origin = origin;
        this.destination = destination;
        this.flightDate = flightDate;
        this.numOfTickets = numOfTickets;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public Date getFlightDate() {
        return flightDate;
    }

    public int getNumOfTickets() {
        return numOfTickets;
    }

    @Override
    public String toString() {
        return "FlightInfo{" + "origin=" + origin + ", destination=" + destination + ", flightDate=" + flightDate + ", numOfTickets=" + numOfTickets + '}';
    }
    
}
