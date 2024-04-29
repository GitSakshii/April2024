package com.ticketBooking.Busbooking.controllers;

import com.ticketBooking.Busbooking.dto.RouteDTO;
import com.ticketBooking.Busbooking.dto.StopDTO;
import com.ticketBooking.Busbooking.services.RouteService;
import com.ticketBooking.Busbooking.services.StopService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/route")
public class RouteController {
    @Autowired
    private RouteService routeService;
    @Autowired
    private StopService stopService;
    @PostMapping("/AddRoute")
    public ResponseEntity<RouteDTO> addRoute(@RequestBody RouteDTO routeDTO) {

        RouteDTO addedRoute = routeService.addRoute(routeDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedRoute);
    }
    @PostMapping("/{routeId}/stops")
    public ResponseEntity<String> addStopToRoute(@PathVariable Long routeId, @RequestBody StopDTO stopDTO) {
        try {
            routeService.addStopToRoute(routeId, stopDTO);
            return ResponseEntity.ok("Stop added to route successfully");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add stop to route");
        }
    }
}
