package com.ticketBooking.Busbooking.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RouteDTO {
    private Long id;
    private StopDTO origin;
    private StopDTO destination;
    private double distance;

}
