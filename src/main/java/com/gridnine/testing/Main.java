package com.gridnine.testing;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> generatedFlights=FlightBuilder.createFlights();
        Filter filter;
        System.out.println("This application selects flights from the list of flights according to specified filter");
        System.out.println();
        System.out.println("Here we have all generated flights:");
        generatedFlights.stream().forEach(el-> System.out.println(el));
        System.out.println("This filter shows flights with departure time before now:");

        filter=new Filter_DepartureBeforeNow(generatedFlights);
        filter.getFilteredFlights().stream().forEach(el-> System.out.println(el.toString()));
        System.out.println();
        System.out.println("This filter shows flights with arrival time before daparture time:");
        filter=new Filter_ArrivalBeforeDeparture(generatedFlights);
        filter.getFilteredFlights().stream().forEach(el-> System.out.println(el));
        System.out.println();
        System.out.println("This filter shows flights with landing time more than 2 hours:");
        filter=new Filter_LandingTimeMoreTwoHours(generatedFlights);
        filter.getFilteredFlights().stream().forEach(el-> System.out.println(el));
    }
}
