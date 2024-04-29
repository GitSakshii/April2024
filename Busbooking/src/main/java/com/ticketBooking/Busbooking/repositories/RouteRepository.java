package com.ticketBooking.Busbooking.repositories;

import com.ticketBooking.Busbooking.entities.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends JpaRepository<Route,Long> {
}
