package com.ticketBooking.Busbooking.controllers;

import com.ticketBooking.Busbooking.dto.StopDTO;
import com.ticketBooking.Busbooking.services.StopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stops")
public class StopController {
    @Autowired
     private StopService stopService;
    @PostMapping("/AddStop")
    public ResponseEntity<StopDTO> addStop(@RequestBody StopDTO stopDTO) {
        StopDTO addedStop= stopService.addStop(stopDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedStop);
    }
//    @DeleteMapping("/{userId}")
//    public ResponseEntity<String>  removeStop(@PathVariable Long stopId) {
//        try {
//            stopService.deleteStop(stopId);
//            return ResponseEntity.ok("Stop deleted successfully");
//        } catch (EntityNotFoundException e) {
//            return ResponseEntity.notFound().build();
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete Stop");
//        }
//    }
}
