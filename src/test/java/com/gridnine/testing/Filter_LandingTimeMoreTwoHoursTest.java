package com.gridnine.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Filter_LandingTimeMoreTwoHoursTest {
    private List<Segment> segments;
    private List<Flight> expectedFlights;
    @BeforeEach
    void setUp() {
        segments= new ArrayList<Segment>();
        expectedFlights=new ArrayList<Flight>();

        segments.add(new Segment(LocalDateTime.now(),LocalDateTime.now().plusHours(4)));
        segments.add(new Segment(LocalDateTime.now().plusHours(8),LocalDateTime.now().minusHours(12)));
        expectedFlights.add(new Flight(segments));
    }

    @Test
    void getFilteredFlights() {
        Filter filter=new Filter_LandingTimeMoreTwoHours(expectedFlights);
        assertEquals(expectedFlights.size(),filter.getFilteredFlights().size());
    }
}