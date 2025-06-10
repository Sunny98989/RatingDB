package com.rating.rating_service.service;

import com.rating.rating_service.model.Rating;
import com.rating.rating_service.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingService {

    private final RatingRepository ratingRepository;

    @Autowired
    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    public Rating createRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    public Optional<Rating> getRatingById(Long id) {
        return ratingRepository.findById(id);
    }

    public Rating updateRating(Long id, Rating updatedRating) {
        return ratingRepository.findById(id).map(existing -> {
            existing.setUserName(updatedRating.getUserName());
            existing.setProductName(updatedRating.getProductName());
            existing.setScore(updatedRating.getScore());
            existing.setComment(updatedRating.getComment());
            return ratingRepository.save(existing);
        }).orElseThrow(() -> new RuntimeException("Rating not found with ID: " + id));
    }

    public void deleteRating(Long id) {
        ratingRepository.deleteById(id);
    }
}
