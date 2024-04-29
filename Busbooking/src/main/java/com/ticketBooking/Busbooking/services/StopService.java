package com.ticketBooking.Busbooking.services;

import com.ticketBooking.Busbooking.dto.StopDTO;
import com.ticketBooking.Busbooking.entities.Stop;
import com.ticketBooking.Busbooking.repositories.StopRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StopService {
    @Autowired
    private StopRepository stopRepository;
    @Autowired
    private ModelMapper modelMapper;
    public StopDTO addStop(StopDTO stopDTO) {
        Stop stop = modelMapper.map(stopDTO, Stop.class);
        Stop savedstop = stopRepository.save(stop);

         return modelMapper.map(savedstop, StopDTO.class);
    }

}
