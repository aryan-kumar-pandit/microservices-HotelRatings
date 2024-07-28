package com.ratingService.rating.controllers;

import com.ratingService.rating.entities.Rating;
import com.ratingService.rating.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;
    @PostMapping
    public ResponseEntity<Rating> create(@RequestBody Rating rating)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.create(rating));
    }

    @GetMapping
    public ResponseEntity<List<Rating>> getAllRating()
    {
        List<Rating> allRating = ratingService.getAllRating();
        return new ResponseEntity<>(allRating,HttpStatus.OK);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getRatingByUser(@PathVariable String userId)
    {
        List<Rating> allRating = ratingService.getRatingByUserId(userId);
        return new ResponseEntity<>(allRating,HttpStatus.OK);
    }

    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingByHotel(@PathVariable String hotelId)
    {
        List<Rating> allRating = ratingService.getRatingByHotelId(hotelId);
        return new ResponseEntity<>(allRating,HttpStatus.OK);
    }

}
