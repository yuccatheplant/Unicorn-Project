package unicorn.project.dto;

import unicorn.project.model.Beer;
import unicorn.project.model.Rating;

import java.util.List;

/**
* Class extending standard beer by a list of ratings, used for listing the rating together with beers
*/
public class BeerWithRatings extends Beer {
    //Attributes
    private List<Rating> ratings;

    //Constructors
    public BeerWithRatings()
    {
        super();
    }

    public BeerWithRatings(String uid, String brand, String name, String style, String hop, String yeast, String malts, String ibu, String alcohol, String blg, List<Rating> ratings)
    {
        super(uid, brand, name, style, hop, yeast, malts, ibu, alcohol, blg);
        this.ratings = ratings;
    }

    //Getters
    public List<Rating> getRatings()
    {
        return ratings;
    }
}
