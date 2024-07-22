package unicorn.project.service;

import unicorn.project.dto.BeerWithRatings;
import unicorn.project.model.Beer;
import unicorn.project.model.Rating;
import unicorn.project.repository.BeerRepository;
import unicorn.project.repository.RatingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BeerService {

    @Autowired
    private BeerRepository beerRepository;

    @Autowired
    private RatingRepository ratingRepository;

    /**
    * Get All Service method that was changed to list ratings attached to the beers
    */
    public List<BeerWithRatings> getAllBeers() {
        List<Beer> beers = beerRepository.findAll();
        List<Rating> ratings = ratingRepository.findAll();

        return beers.stream().map(beer -> new BeerWithRatings(
            beer.getUid(),
            beer.getBrand(),
            beer.getName(),
            beer.getStyle(),
            beer.getHop(),
            beer.getYeast(),
            beer.getMalts(),
            beer.getIbu(),
            beer.getAlcohol(),
            beer.getBlg(),
            ratings.stream()
                .filter(rating -> rating.getBeer().equals(beer.getUid()))
                .collect(Collectors.toList())
        ))
        .collect(Collectors.toList());
    }

    /**
    * Get By Id service method that was changed to list ratings attached to selected beer
    */
    public BeerWithRatings getBeerById(String id) {
        Beer beer = beerRepository.findById(id).orElse(null);
        if (beer == null) return null;

        List<Rating> ratings = ratingRepository.findAll();

        return new BeerWithRatings(
            beer.getUid(),
            beer.getBrand(),
            beer.getName(),
            beer.getStyle(),
            beer.getHop(),
            beer.getYeast(),
            beer.getMalts(),
            beer.getIbu(),
            beer.getAlcohol(),
            beer.getBlg(),
            ratings.stream()
                .filter(rating -> rating.getBeer().equals(beer.getUid()))
                .collect(Collectors.toList())
        );
    }

    public Beer saveBeer(Beer beer) {
        return beerRepository.save(beer);
    }

    public void deleteBeer(String id) {
        beerRepository.deleteById(id);
    }
}
