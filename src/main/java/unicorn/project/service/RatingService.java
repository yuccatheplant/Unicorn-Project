package unicorn.project.service;

import unicorn.project.model.Rating;
import unicorn.project.repository.RatingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    public Rating getRatingById(String id) {
        return ratingRepository.findById(id).orElse(null);
    }

    public Rating saveRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    public void deleteRating(String id) {
        ratingRepository.deleteById(id);
    }
}
