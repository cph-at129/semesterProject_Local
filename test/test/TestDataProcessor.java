
package test;


import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import deploy.DeploymentConfiguration;
import facades.FlightFacade;
import java.util.List;
import javax.persistence.Persistence;
import metaEngine.Flight;
import metaEngine.FlightInfo;

/**
 *
 * @author wookash
 */
public class TestDataProcessor
{

    private static Gson gson = new GsonBuilder().setPrettyPrinting().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).create();

    public static void main(String[] args)
    {
        FlightFacade flightfacade = new FlightFacade(Persistence.createEntityManagerFactory(DeploymentConfiguration.PU_NAME));
        List<Flight> flights = flightfacade.getAllFlightsFrom(new FlightInfo("CPH", "2016-01-21T00:00:00.000Z", 2));
        for (Flight flight : flights) {
            System.out.println(gson.toJson(flight));
        }
    }

}
