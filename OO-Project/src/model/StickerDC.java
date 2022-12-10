package model;

public class StickerDC extends Sticker{

    private String movie;
    private String alias;

    public StickerDC() {
        super();
        // TODO Auto-generated constructor stub
    }

    public StickerDC(String name, String raridade, int quant, String UrlImage,
            String movie, String alias) {
        super(name, raridade, quant, UrlImage);
        // TODO Auto-generated constructor stub
        this.movie = movie;
        this.alias = alias;
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
