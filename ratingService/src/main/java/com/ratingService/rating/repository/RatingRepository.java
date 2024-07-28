package com.ratingService.rating.repository;

import com.mongodb.client.model.geojson.LineString;
import com.ratingService.rating.entities.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RatingRepository extends MongoRepository<Rating,String> {

    List<Rating> findByUserId(String userId);
    List<Rating> findByHotelId(String hotelId);
}
