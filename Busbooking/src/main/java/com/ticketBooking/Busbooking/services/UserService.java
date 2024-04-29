package com.ticketBooking.Busbooking.services;

import com.ticketBooking.Busbooking.dto.UserDTO;
import com.ticketBooking.Busbooking.entities.User;
import com.ticketBooking.Busbooking.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ModelMapper modelMapper;
    public UserDTO registerUser(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        User registereduser = userRepository.save(user);
        return modelMapper.map(registereduser, UserDTO.class);
    }
    public UserDTO getUserById(Long userId) {
        User user = userRepository.findById(userId)
                .orElse(null);
        if (user != null) {
            return modelMapper.map(user,UserDTO.class);
        } else {
            return null;
        }
    }
    @Transactional
    public void deleteUser(Long userId) {
        // Check if the user exists
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        userRepository.delete(user);
    }
}
