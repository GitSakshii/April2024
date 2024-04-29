package com.ticketBooking.Busbooking.repositories;

import com.ticketBooking.Busbooking.entities.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface BusRepository extends JpaRepository<Bus,Long> {
    @Query("SELECT DISTINCT b FROM Bus b JOIN b.route r WHERE r.sourceStop.name = :sourceStopName AND r.destinationStop.name = :destinationStopName")
    List<Bus> findBusesBySourceAndDestinationStops(String sourceStopName, String destinationStopName);

}
