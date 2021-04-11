package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Filter_DepartureBeforeNow  implements Filter {
    private List <Flight> flightList;
    private List <Flight> selectedFlights;

    public Filter_DepartureBeforeNow(List<Flight> flightList) {
        this.flightList = flightList;
        this.selectedFlights=new ArrayList<>();
    }

    @Override
    public List<Flight> getFilteredFlights() {
        for (Flight flight:flightList)
        {
            boolean selected=false;
            if (flight.getSegments().get(0).getDepartureDate().isBefore(LocalDateTime.now()))
            {
                selected=true;
            }
            if(selected) {
                selectedFlights.add(flight);
            }
        }
        return selectedFlights;
    }
}
