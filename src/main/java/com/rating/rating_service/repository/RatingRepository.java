package com.rating.rating_service.repository;

import com.rating.rating_service.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {
    // JpaRepository gives you all CRUD methods by default!!!
}
