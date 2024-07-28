package com.hotel.controllers;


import com.hotel.entities.Hotel;
import com.hotel.services.HotelService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    //create
    @PostMapping
    private ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel)
    {
        Hotel hotel1 = hotelService.createHotel(hotel);
        return new ResponseEntity<>(hotel1, HttpStatus.CREATED);
    }

    //get single
    @GetMapping("/{hotelId}")
    private ResponseEntity<Hotel> getHotel(@PathVariable String hotelId)
    {
        Hotel hotel1 = hotelService.getHotel(hotelId);
        return new ResponseEntity<>(hotel1, HttpStatus.OK);
    }

    //get all
    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotel()
    {
        List<Hotel> hotels = hotelService.getAll();
        return new ResponseEntity<>(hotels, HttpStatus.OK);
    }


}
