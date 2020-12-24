import com.skillbox.airport.*;

public class Project {
    public static void main (String[] args) {
///AirPort list
        Airport airportLAX = Airport.getInstance();
        Airport airportGFK = Airport.getInstance();
        Airport airportCDG = Airport.getInstance();
        Airport airportLHR = Airport.getInstance();
///AirPorts LAX & GFK airCrafts count
        System.out.println("LAX airCrafts count: " + airportLAX.getAllAircrafts().size());
        System.out.println("GFK airCrafts count: " + airportGFK.getAllAircrafts().size());
///AirPorts CDG & LHR airCrafts list
        System.out.println("CDG airCrafts list: " + airportCDG.getAllAircrafts());
        System.out.println("LHR airCrafts list: " + airportLHR.getAllAircrafts());
    }
}
