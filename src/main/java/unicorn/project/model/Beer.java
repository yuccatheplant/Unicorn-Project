package unicorn.project.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
* Beer class defining all attributes Beer record needs
*/
@Document(collection = "beers")
public class Beer {
    //Attributes
    private int id;
    @Id
    private String uid;

    private String brand;
    private String name;
    private String style;
    private String hop;
    private String yeast;
    private String malts;
    private String ibu;
    private String alcohol;
    private String blg;

    //Constructors
    public Beer ()
    {}

    public Beer (String uid, String brand, String name, String style, String hop, String yeast, String malts, String ibu, String alcohol, String blg)
    {
        this.uid = uid;
        this.brand = brand;
        this.name = name;
        this.style = style;
        this.hop = hop;
        this.yeast = yeast;
        this.malts = malts;
        this.ibu = ibu;
        this.alcohol = alcohol;
        this.blg = blg;
    }

    //Getters
    public int getId() {
        return id;
    }
    public String getUid() {
        return uid;
    }

    public String getBrand() {
        return brand;
    }
    public String getName() {
        return name;
    }
    public String getStyle() {
        return style;
    }
    public String getHop() {
        return hop;
    }
    public String getYeast() {
        return yeast;
    }
    public String getMalts() {
        return malts;
    }
    public String getIbu() {
        return ibu;
    }
    public String getAlcohol() {
        return alcohol;
    }
    public String getBlg() {
        return blg;
    }
}
