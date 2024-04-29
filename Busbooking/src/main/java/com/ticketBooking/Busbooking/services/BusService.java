package com.ticketBooking.Busbooking.services;

import com.ticketBooking.Busbooking.dto.BusDTO;
import com.ticketBooking.Busbooking.entities.Bus;
import com.ticketBooking.Busbooking.entities.Route;
import com.ticketBooking.Busbooking.entities.User;
import com.ticketBooking.Busbooking.repositories.BusRepository;
import com.ticketBooking.Busbooking.repositories.RouteRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BusService {
    @Autowired
    private BusRepository busRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private RouteRepository routeRepository;

    public BusDTO getBusById(Long id){
        Optional<Bus> optionalBus = busRepository.findById(id);
        if (optionalBus.isPresent()) {
            Bus bus = optionalBus.get();
            return modelMapper.map(bus, BusDTO.class);
        }
        return null;
    }
    public BusDTO createBus(BusDTO busDTO) {
         Bus bus = modelMapper.map(busDTO, Bus.class);
        Bus savedBus = busRepository.save(bus);
       return modelMapper.map(savedBus, BusDTO.class);
    }
    public BusDTO addRouteToBus(Long busId, Long routeId) {
        Bus bus = busRepository.findById(busId)
                .orElseThrow(() -> new EntityNotFoundException("Bus not found"));

        Route route = routeRepository.findById(routeId)
                .orElseThrow(() -> new EntityNotFoundException("Route not found"));

        bus.setRoute(route);
        Bus updatedBus = busRepository.save(bus);
        return modelMapper.map(updatedBus, BusDTO.class);
    }

    public void deleteBus(Long userId) {
       Bus bus = busRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("Bus not found"));

        busRepository.delete(bus);
    }
    public List<BusDTO> getBusesBySourceAndDestination(String sourceStop, String destinationStop) {
        List<Bus> buses = busRepository.findBusesBySourceAndDestinationStops(sourceStop, destinationStop);
        return mapToBusDTOs(buses);
    }
    private List<BusDTO> mapToBusDTOs(List<Bus> buses) {
        return buses.stream()
                .map(this::mapToBusDTO)
                .collect(Collectors.toList());
    }
    private BusDTO mapToBusDTO(Bus bus) {
        BusDTO busDTO = new BusDTO();
        busDTO.setId(bus.getId());
        busDTO.setName(bus.getName());
        return busDTO;
    }

}
