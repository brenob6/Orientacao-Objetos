package model;

public class StickerDC extends Sticker{

    private String movie;
    private String alias;

    public StickerDC() {
        super();
        // TODO Auto-generated constructor stub
    }

    public StickerDC(String name, String UrlImage, String movie, String alias) {
        super(name, UrlImage);
        // TODO Auto-generated constructor stub
        this.movie = movie;
        this.alias = alias;
    }
    
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return this.alias + this.name + this.movie + this.quant + this.urlImage;
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
