package com.ticketBooking.Busbooking.services;

import com.ticketBooking.Busbooking.dto.RouteDTO;
import com.ticketBooking.Busbooking.dto.StopDTO;
import com.ticketBooking.Busbooking.entities.Route;
import com.ticketBooking.Busbooking.entities.Stop;
import com.ticketBooking.Busbooking.repositories.RouteRepository;
import com.ticketBooking.Busbooking.repositories.StopRepository;
import jakarta.persistence.EntityNotFoundException;
 import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouteService {
    @Autowired
    private RouteRepository routeRepository;
    @Autowired
    private ModelMapper modelMapper;
   @Autowired
   private StopRepository stopRepository;
    public RouteDTO addRoute(RouteDTO routeDTO) {

        Route route = new Route();
        Stop source=stopRepository.save(modelMapper.map(routeDTO.getOrigin(),Stop.class));
        Stop destination=stopRepository.save(modelMapper.map(routeDTO.getDestination(),Stop.class));
        route.setSourceStop(source);
        route.setDestinationStop(destination);
        route.setDistance(routeDTO.getDistance());
        Route savedRoute = routeRepository.save(route);
        RouteDTO savedRouteDTO = modelMapper.map(savedRoute, RouteDTO.class);

        return savedRouteDTO;
    }

    public void addStopToRoute(Long routeId, StopDTO stopDTO) {
        // Retrieve the route entity from the database
        Route route = routeRepository.findById(routeId)
                .orElseThrow(() -> new EntityNotFoundException("Route not found"));

        // Create a new Stop entity from the StopDTO
        Stop stop = new Stop();
        stop.setName(stopDTO.getName());
        stop.setLocation(stopDTO.getLocation());

        route.getStops().add(stop);

        routeRepository.save(route);
    }
}
