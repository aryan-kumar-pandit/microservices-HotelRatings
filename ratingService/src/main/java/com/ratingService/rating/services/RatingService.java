package com.ratingService.rating.services;

import com.ratingService.rating.entities.Rating;

import java.util.List;

public interface RatingService {
    //create
    Rating create(Rating rating);

    //get all ratings
    List<Rating> getAllRating();

    //get ratings for user
    List<Rating> getRatingByUserId(String userId);

    //get ratings by hotelId
    List<Rating> getRatingByHotelId(String hotelId);

}
