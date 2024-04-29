package com.ticketBooking.Busbooking.controllers;

import com.ticketBooking.Busbooking.dto.BusDTO;
import com.ticketBooking.Busbooking.services.BusService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/buses")
public class BusController {
    @Autowired
    private BusService busService;
    @GetMapping("/{id}")
    public ResponseEntity<BusDTO> getBusById(@PathVariable Long id) {
        BusDTO busDTO = busService.getBusById(id);
        if (busDTO != null) {
            return ResponseEntity.ok(busDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/add")
    public ResponseEntity<BusDTO> createBus(@RequestBody BusDTO busDTO) {
        BusDTO createdBusDTO = busService.createBus(busDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBusDTO);
    }
    @DeleteMapping("/{busId}")
    public ResponseEntity<String> deleteBus(@PathVariable Long busId) {
        try {
            busService.deleteBus(busId);
            return ResponseEntity.ok("Bus deleted successfully");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete Bus");
        }
    }
    @PostMapping("/{busId}/routes/{routeId}")
    public ResponseEntity<String> addRouteToBus(@PathVariable Long busId, @PathVariable Long routeId) {
        try {
            busService.addRouteToBus(busId, routeId);
            return ResponseEntity.ok("Route added to bus successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add route to bus");
        }
    }
    @GetMapping("/bySourceAndDestination")
    public ResponseEntity<List<BusDTO>> getBusesBySourceAndDestination(
            @RequestParam String sourceStop,
            @RequestParam String destinationStop) {
        try {
            List<BusDTO> buses = busService.getBusesBySourceAndDestination(sourceStop, destinationStop);
            return ResponseEntity.ok(buses);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}
