package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import deploy.DeploymentConfiguration;
import facades.FlightFacade;
import facades.FlightFacadeInterface;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import metaEngine.Flight;
import metaEngine.FlightInfo;

@Path("flightinfo")
public class FlightInfoResource {

    @Context
    private UriInfo context;

    private FlightFacadeInterface flightFacade;
    private EntityManagerFactory emf;
    private static Gson gson;

    public FlightInfoResource() {

        emf = Persistence.createEntityManagerFactory(DeploymentConfiguration.PU_NAME);
        flightFacade = new FlightFacade(emf);
        gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").
                setPrettyPrinting().create();
    }

    @GET
    @Path("{from}/{date}/{numTickets}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllFlightsFrom(
            @PathParam("from") String from,
            @PathParam("date") String date,
            @PathParam("numTickets") int numTickets) throws ParseException {

       //encapsulate the flightinfo parameters
        FlightInfo flightInfo = new FlightInfo(from, date, numTickets);

        List<Flight> demoflights = new ArrayList();
        
        demoflights.add(new Flight("AirlineTest", "2016-01-04T23:00:00.000Z", 20, 1111.20, "BUS1213213", 140, "BCN", "CPH"));
        demoflights.add(new Flight("AirlineTest1", "2016-01-04T23:00:00.000Z", 20, 1111.20, "BUS1213213", 140, "BCN", "CPH"));
        demoflights.add(new Flight("AirlineTest2", "2016-01-04T23:00:00.000Z", 20, 1111.20, "BUS1213213", 140, "BCN", "CPH"));
        demoflights.add(new Flight("AirlineTest3", "2016-01-04T23:00:00.000Z", 20, 1111.20, "BUS1213213", 140, "BCN", "CPH"));
        demoflights.add(new Flight("AirlineTest4", "2016-01-04T23:00:00.000Z", 20, 1111.20, "BUS1213213", 140, "BCN", "CPH"));
        demoflights.add(new Flight("AirlineTest5", "2016-01-04T23:00:00.000Z", 20, 1111.20, "BUS1213213", 140, "BCN", "CPH"));
        demoflights.add(new Flight("AirlineTest6", "2016-01-04T23:00:00.000Z", 20, 1111.20, "BUS1213213", 140, "BCN", "CPH"));
        
        //pass the flight info to the facade
        //List<Flight> flights = flightFacade.getAllFlightsFromTo(flightInfo);

        return Response.ok(gson.toJson(demoflights)).build();
    }

    @GET
    @Path("{from}/{to}/{date}/{numTickets}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllFlightsFromTo(
            @PathParam("from") String from,
            @PathParam("to") String to,
            @PathParam("date") String date,
            @PathParam("numTickets") int numTickets) throws ParseException {


        //encapsulate the flightinfo parameters
        FlightInfo flightInfo = new FlightInfo(from, to, date, numTickets);

        List<Flight> demoflights = new ArrayList();
        
        demoflights.add(new Flight("AirlineTest", "2016-01-04T23:00:00.000Z", 20, 1111.20, "BUS1213213", 140, "BCN", "CPH"));
        demoflights.add(new Flight("AirlineTest1", "2016-01-04T23:00:00.000Z", 20, 1111.20, "BUS1213213", 140, "BCN", "CPH"));
        demoflights.add(new Flight("AirlineTest2", "2016-01-04T23:00:00.000Z", 20, 1111.20, "BUS1213213", 140, "BCN", "CPH"));
        demoflights.add(new Flight("AirlineTest3", "2016-01-04T23:00:00.000Z", 20, 1111.20, "BUS1213213", 140, "BCN", "CPH"));
        demoflights.add(new Flight("AirlineTest4", "2016-01-04T23:00:00.000Z", 20, 1111.20, "BUS1213213", 140, "BCN", "CPH"));
        demoflights.add(new Flight("AirlineTest5", "2016-01-04T23:00:00.000Z", 20, 1111.20, "BUS1213213", 140, "BCN", "CPH"));
        demoflights.add(new Flight("AirlineTest6", "2016-01-04T23:00:00.000Z", 20, 1111.20, "BUS1213213", 140, "BCN", "CPH"));
        
        //pass the flight info to the facade
        //List<Flight> flights = flightFacade.getAllFlightsFromTo(flightInfo);

        return Response.ok(gson.toJson(demoflights)).build();
    }
}
