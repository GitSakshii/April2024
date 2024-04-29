package com.ticketBooking.Busbooking.services;

import com.ticketBooking.Busbooking.dto.TicketDTO;
import com.ticketBooking.Busbooking.entities.*;
import com.ticketBooking.Busbooking.repositories.BusRepository;
import com.ticketBooking.Busbooking.repositories.RouteRepository;
import com.ticketBooking.Busbooking.repositories.TicketRepository;
import com.ticketBooking.Busbooking.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TicketBookingService {
    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BusRepository busRepository;

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private ModelMapper modelMapper; // Assuming you have configured ModelMapper

    public void bookTicket(TicketDTO ticketDTO) {

        Ticket ticket = modelMapper.map(ticketDTO, Ticket.class);

        User user = userRepository.findById(ticketDTO.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        Bus bus = busRepository.findById(ticketDTO.getBusId())
                .orElseThrow(() -> new EntityNotFoundException("Bus not found"));

        Route route = routeRepository.findById(ticketDTO.getRouteId())
                .orElseThrow(() -> new EntityNotFoundException("Route not found"));

        ticket.setUser(user);
        ticket.setBus(bus);
        ticket.setRoute(route);
        ticket.setPrice(calculateTicketPrice(route,bus));
        ticketRepository.save(ticket);
    }
    public int calculateTicketPrice(Route route, Bus bus) {

        int distance = calculateDistance(route.getSourceStop(), route.getDestinationStop());

        int  basePrice = distance* bus.getBasePrice();

        // Apply any discounts or surcharges

        // Return the calculated price
        return basePrice;
    }
    private int calculateDistance(Stop source, Stop destination) {

        // External geographical library or external API can be used
        return 50 ;// Example distance in kilometers
    }

}
