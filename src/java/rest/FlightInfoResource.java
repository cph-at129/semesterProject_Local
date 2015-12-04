package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import deploy.DeploymentConfiguration;
import facades.FlightFacade;
import facades.FlightFacadeInterface;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
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
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{from}/{to}/{date}/{numTickets}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllFlightsFrom(
            @PathParam("from") String from,
            @PathParam("date") String date,
            @PathParam("numTickets") int numTickets) {

        
        //List<Flight> flights = flightFacade.getAllFlightsFrom(from, date, numTickets);
        return Response.ok().build();
    }
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{from}/{to}/{date}/{numTickets}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllFlightsFromTo(
            @PathParam("from") String from,
            @PathParam("to") String to,
            @PathParam("date") String date,
            @PathParam("numTickets") int numTickets) {

        //1) convert the String date into a Java date (new Date())
        Date flightDate = new Date();
        
        
        FlightInfo flightInfo = new FlightInfo(from, to, flightDate, numTickets);
        
        List<Flight> flights = flightFacade.getAllFlightsFromTo(flightInfo);
        return Response.ok().build();
    }
}
