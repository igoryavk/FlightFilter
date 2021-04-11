package com.gridnine.testing;

import java.util.ArrayList;
import java.util.List;

public class Filter_LandingTimeMoreTwoHours implements Filter{
    private List <Flight> flightList;
    private List <Flight> selectedFlights;

    public Filter_LandingTimeMoreTwoHours(List<Flight> flightList) {
        this.flightList = flightList;
        this.selectedFlights=new ArrayList<>();
    }


    @Override
    public List<Flight> getFilteredFlights() {
        for (Flight flight : flightList
        ) {
            boolean selected=false;
            int landing_time=0;
            List<Segment> segments = flight.getSegments();
            for (int i = 0; i < segments.size(); i++) {

                if((i+1)<segments.size()) {
                    if(segments.get(i+1).getDepartureDate().getDayOfYear()>segments.get(i).getArrivalDate().getDayOfYear())
                    {
                        int days=segments.get(i+1).getDepartureDate().getDayOfYear()-segments.get(i).getArrivalDate().getDayOfYear();
                        landing_time=+ days*24-segments.get(i).getArrivalDate().getHour();
                        landing_time=+segments.get(i+1).getDepartureDate().getHour();
                    }
                    else
                    {
                        landing_time=+segments.get(i+1).getDepartureDate().getHour()-segments.get(i).getArrivalDate().getHour();
                    }
                }
                if (landing_time>2) {
                    selected=true;
                }
            }
            System.out.println(landing_time);
            if(selected) {
                selectedFlights.add(flight);
            }
        }
        return selectedFlights;
    }
}
