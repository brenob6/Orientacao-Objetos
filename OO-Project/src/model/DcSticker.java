package model;

/**
 * Class responsible for simulating a DC sticker and is inherited from the class Sticker
 */
public class DcSticker extends Sticker{

    private String movie;
    private String alias;

    
    public DcSticker() {
        this.code = Code.Dc;
    }

/**
 * Constructor responsible for instantiate the class DCSticker
 * @param name
 * @param UrlImage
 * @param movie
 * @param alias
 */
    public DcSticker(String name, String UrlImage, String movie, String alias) {
        super(name, UrlImage);
        // TODO Auto-generated constructor stub
        this.code = Code.Dc;
        this.movie = movie;
        this.alias = alias;
    }
    
/**
 * Method responsible for returning the identity of the object "movie" and "alias" 
 */
    public String toString() {
        return super.toString() + ";movie: " + this.movie + ";alias" + this.alias;
    }

    public String getMovie() {
        return movie;
    }
    public void setMovie(String movie) {
        this.movie = movie;
    }
    public String getAlias() {
        return alias;
    }
    public void setAlias(String alias) {
        this.alias = alias;
    }

}
