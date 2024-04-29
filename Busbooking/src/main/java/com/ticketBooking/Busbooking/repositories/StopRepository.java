package com.ticketBooking.Busbooking.repositories;

import com.ticketBooking.Busbooking.entities.Stop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StopRepository extends JpaRepository<Stop,Long> {
}
