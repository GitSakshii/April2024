package com.ticketBooking.Busbooking.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "routes")
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "Source",referencedColumnName = "id")
    private Stop sourceStop;
    @ManyToOne
    @JoinColumn(name = "Destination",referencedColumnName = "id")
    private Stop destinationStop;
    private double distance;
    @ManyToMany
    @JoinTable(
            name = "route_stop",
            joinColumns = @JoinColumn(name = "route_id"),
            inverseJoinColumns = @JoinColumn(name = "stop_id")
    )
    private List<Stop> stops;

    @OneToMany(mappedBy = "route")
    private List<Bus> buses;
}
