import core.Line;
import core.Station;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import junit.framework.TestCase;

public class RouteCalculatorTest extends TestCase {
    List<Station> route;
    StationIndex stationIndex;
    RouteCalculator routeCalculator;

    @Override
    protected void setUp() throws Exception {
        route = new ArrayList<>();
        stationIndex = new StationIndex();
        routeCalculator = new RouteCalculator(stationIndex);

        Line line1 = new Line(1, "One");
        Line line2 = new Line(2, "Two");
        Line line3 = new Line(3, "Three");

        stationIndex.addStation(new Station("Station A1", line1));
        stationIndex.addStation(new Station("Station A2", line1));
        stationIndex.addStation(new Station("Station A3", line1));
        stationIndex.addStation(new Station("Station B1", line2));
        stationIndex.addStation(new Station("Station B2", line2));
        stationIndex.addStation(new Station("Station B3", line2));
        stationIndex.addStation(new Station("Station C1", line3));
        stationIndex.addStation(new Station("Station C2", line3));
        stationIndex.addStation(new Station("Station C3", line3));

        stationIndex.addLine(line1);
        stationIndex.addLine(line2);
        stationIndex.addLine(line3);
        line1.addStation(stationIndex.getStation("Station A1"));
        line1.addStation(stationIndex.getStation("Station A2"));
        line1.addStation(stationIndex.getStation("Station A3"));
        line2.addStation(stationIndex.getStation("Station B1"));
        line2.addStation(stationIndex.getStation("Station B2"));
        line2.addStation(stationIndex.getStation("Station B3"));
        line3.addStation(stationIndex.getStation("Station C1"));
        line3.addStation(stationIndex.getStation("Station C2"));
        line3.addStation(stationIndex.getStation("Station C3"));

        stationIndex.addConnection(new ArrayList<>(Arrays
                .asList(stationIndex.getStation("Station A1"), stationIndex.getStation("Station B1"))));
        stationIndex.addConnection(new ArrayList<>(Arrays
                .asList(stationIndex.getStation("Station B3"), stationIndex.getStation("Station C3"))));
        stationIndex.addConnection(new ArrayList<>(Arrays
                .asList(stationIndex.getStation("Station B1"), stationIndex.getStation("Station C1"))));
        stationIndex.addConnection(new ArrayList<>(Arrays
                .asList(stationIndex.getStation("Station A3"), stationIndex.getStation("Station B3"))));

    }

    // SUBWAY MAP:
    //            Station A1 [0] <-> Station B1 [3] <-> Station C1 [6]
    //            Station A2 [1]     Station B2 [4]     Station C2 [7]
    //            Station A3 [2] <-> Station B3 [5] <-> Station C3 [8]

    public void testCalculateRouteDuration() {
        // [Station A2, Station A1, <-> Station B1, <-> Station C1,
        // Station C2, Station C3, <-> Station B3, Station B2, Station B1, <-> Station A1, Station A2]
        route = new ArrayList<>(Arrays
                .asList(stationIndex.getStation("Station A2"), stationIndex.getStation("Station A1"),
                        stationIndex.getStation("Station B1"), stationIndex.getStation("Station C1"),
                        stationIndex.getStation("Station C2"), stationIndex.getStation("Station C3"),
                        stationIndex.getStation("Station B3"), stationIndex.getStation("Station B2"),
                        stationIndex.getStation("Station B1"), stationIndex.getStation("Station A1"),
                        stationIndex.getStation("Station A2")));
        double actual = RouteCalculator.calculateDuration(route);
        double expected = 29.0;
        assertEquals(expected, actual);
    }

    public void testGetShortestRouteWithOutConnection() {
        // Expected :[Station A1, Station A2, Station A3]
        // Actual   :[Station A1, Station A2, Station A3]
        List<Station> expected = new ArrayList<Station>(Arrays.asList(
                stationIndex.getStation("Station A1"), stationIndex.getStation("Station A2"), stationIndex.getStation("Station A3")));
        List<Station> actual = routeCalculator
                .getShortestRoute(stationIndex.getStation("Station A1"), stationIndex.getStation("Station A3"));
        assertEquals(expected, actual);
    }

    public void testGetShortestRouteWithOneConnection() {
        // Expected :[Station A1, Station B1, Station B2]
        // Actual   :[Station A1, Station B1, Station B2]
        List<Station> expected = new ArrayList<>(Arrays
                .asList(stationIndex.getStation("Station A1"), stationIndex.getStation("Station B1"),
                        stationIndex.getStation("Station B2")));
        List<Station> actual = routeCalculator
                .getShortestRoute(stationIndex.getStation("Station A1"), stationIndex.getStation("Station B2"));
        assertEquals(expected, actual);
    }

    public void testGetShortestRouteWithTwoConnection() {
        // Expected :[Station A2, Station A3, Station B3, Station C3]
        // Actual   :[Station A2, Station A3, Station B3, Station C3]
        List<Station> expected = new ArrayList<>(Arrays
                .asList(stationIndex.getStation("Station A2"), stationIndex.getStation("Station A3"),
                        stationIndex.getStation("Station B3"), stationIndex.getStation("Station C3")));
        List<Station> actual = routeCalculator
                .getShortestRoute(stationIndex.getStation("Station A2"), stationIndex.getStation("Station C3"));
        assertEquals(expected, actual);
    }
}