package unicorn.project.controller;

import unicorn.project.dto.BeerWithRatings;
import unicorn.project.model.Beer;
import unicorn.project.model.Rating;
import unicorn.project.service.BeerService;
import unicorn.project.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/beers")
public class BeerController {
    @Autowired
    private BeerService beerService;

    @Autowired
    private RatingService ratingService;

    @GetMapping
    public List<BeerWithRatings> getAllBeers() {
        return beerService.getAllBeers();
    }

    @GetMapping("/{id}")
    public BeerWithRatings getBeerById(@PathVariable String id) {
        return beerService.getBeerById(id);
    }

    @PostMapping
    public Beer createBeer(@RequestBody Beer beer) {
        return beerService.saveBeer(beer);
    }

    /**
    * Endpoint for creating rating of selected beer
    */
    @PostMapping("/{id}/rating")
    public Rating createBeerRating(@PathVariable String id, @RequestBody Rating rating) {
        Rating result = new Rating(
            id,
            rating.getStars(),
            rating.getDescription()
        );

        return ratingService.saveRating(result);
    }

    @DeleteMapping("/{id}")
    public void deleteBeer(@PathVariable String id) {
        beerService.deleteBeer(id);
    }
    
}
