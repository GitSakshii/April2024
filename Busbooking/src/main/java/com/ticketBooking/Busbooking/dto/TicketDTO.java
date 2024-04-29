package com.ticketBooking.Busbooking.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TicketDTO {
    private Long id;
    private Long userId;
    private Long busId;
    private Long routeId;
    private String departureTime;
    private String arrivalTime;
    private int seatNumber;

}
