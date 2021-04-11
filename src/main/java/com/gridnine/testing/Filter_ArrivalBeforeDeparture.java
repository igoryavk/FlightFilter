package com.gridnine.testing;

import java.util.ArrayList;
import java.util.List;

public class Filter_ArrivalBeforeDeparture implements Filter{
    private List <Flight> flightList;
    private List <Flight> selectedFlights;

    public Filter_ArrivalBeforeDeparture(List<Flight> flightList) {
        this.flightList = flightList;
        this.selectedFlights=new ArrayList<>();
    }

    @Override
    public List<Flight> getFilteredFlights() {
        for (Flight flight:flightList
        ) {
            boolean selected=false;
            for (Segment segment:flight.getSegments()) {

                if(segment.getArrivalDate().isBefore(segment.getDepartureDate()))
                {
                    selected=true;
                }
            }
            if(selected){
                selectedFlights.add(flight);
            }
        }
        return selectedFlights;
    }
}
