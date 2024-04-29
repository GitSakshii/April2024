package com.ticketBooking.Busbooking.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BusDTO {
    private Long id;
    private String name;
    private String type;
    private int capacity;
    private int basePrice;
}
