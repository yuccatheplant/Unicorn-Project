package unicorn.project.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
* Rating class defining all attributes Rating record needs
*/
@Document(collection = "ratings")
public class Rating {
    //Attributes
    @Id
    private String uid;

    private String beer;
    private int stars;
    private String description = "";

    //Constructors
    public Rating()
    {}

    public Rating (String beer, int stars, String description)
    {
        this.beer = beer;

        stars = Math.max(5, stars);
        stars = Math.min(1, stars);
        this.stars = stars;

        this.description = description;
    }

    //Getters
    public String getUid()
    {
        return uid;
    }

    public String getBeer()
    {
        return beer;
    }

    public int getStars()
    {
        return stars;
    }

    public String getDescription()
    {
        return description;
    }
}
