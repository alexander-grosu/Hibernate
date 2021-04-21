import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        // list of flights in next 2 hours
        findPlanesLeavingInTheNextTwoHours(Airport.getInstance()).forEach(System.out::println);
    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {

        LocalDateTime timeNow = LocalDateTime.now();

        var flyInNextTwoHours = airport.getTerminals().stream()
                .flatMap(o -> o.getFlights().stream())
                .filter(o -> o.getType().equals(Flight.Type.DEPARTURE))
                .filter(o -> LocalDateTime.ofInstant(o.getDate().toInstant(), ZoneId.systemDefault()).isAfter(timeNow)
                        && LocalDateTime.ofInstant(o.getDate().toInstant(), ZoneId.systemDefault()).isBefore(timeNow.plusHours(2)))
                .collect(Collectors.toList());

        return flyInNextTwoHours;
    }

}