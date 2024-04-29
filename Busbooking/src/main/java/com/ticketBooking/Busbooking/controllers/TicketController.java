package com.ticketBooking.Busbooking.controllers;

import com.ticketBooking.Busbooking.dto.TicketDTO;
import com.ticketBooking.Busbooking.services.TicketBookingService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/tickets")
public class TicketController {
    @Autowired
    private TicketBookingService ticketBookingService;

    @PostMapping("/book")
    public ResponseEntity<String> bookTicket(@RequestBody TicketDTO ticketDTO) {
        try {
            ticketBookingService.bookTicket(ticketDTO);
            return ResponseEntity.ok("Ticket booked successfully");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to book ticket");
        }
    }
}
