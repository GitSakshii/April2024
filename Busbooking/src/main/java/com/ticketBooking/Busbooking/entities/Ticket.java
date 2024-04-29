package com.ticketBooking.Busbooking.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false,referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "bus_id", nullable = false,referencedColumnName = "id")
    private Bus bus;

    @ManyToOne
    @JoinColumn(name = "route_id", nullable = false,referencedColumnName = "id")
    private Route route;

    private String departureTime;
    private String arrivalTime;
    private int seatNumber;
    private int price;
    }
