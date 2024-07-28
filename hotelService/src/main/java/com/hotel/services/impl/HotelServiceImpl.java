package com.hotel.services.impl;

import com.hotel.entities.Hotel;
import com.hotel.exception.ResourceNotFoundException;
import com.hotel.repository.HotelRepository;
import com.hotel.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelRepository hotelRepository;
    @Override
    public Hotel createHotel(Hotel hotel) {
        String hotelId = UUID.randomUUID().toString();
        hotel.setId(hotelId);
        Hotel saved = hotelRepository.save(hotel);
        return saved;
    }

    @Override
    public Hotel getHotel(String id) {
        Hotel hotel = hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("hotel not found"));

        return hotel;
    }

    @Override
    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }
}
