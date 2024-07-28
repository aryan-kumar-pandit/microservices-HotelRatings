package com.hotel.services;

import com.hotel.entities.Hotel;

import java.util.List;

public interface HotelService {

    //create
    Hotel createHotel(Hotel hotel);

    //get single
    Hotel getHotel(String id);

    //get all

    List<Hotel> getAll();

}

