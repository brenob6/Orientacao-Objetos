package model;

import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;

/**
 * Abstract class responsible for simulating a sticker.
 * It is going to extend its attributes to DC and Cup stickers 
 *
 */
public abstract class Sticker {

    private int quant = 0;
    private String urlImage;
    private String name;
    
    /**
     * Constructor responsible for instantiate the class Sticker
     * @param name
     * @param UrlImage
     */
    public Sticker(String name, String UrlImage) {
        this.name = name;
        this.urlImage = UrlImage;
    }

    public Sticker() {
        this.name = "";
        this.urlImage = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }

    public String getUrlImage() {
        return this.urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    /**
     * Method responsible for generating sticker's images having the image's urls 
     */
    public ImageIcon getImage() {
        URL url = null; 
        try {
            url = new URL(urlImage);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
        
        return new ImageIcon(url);
    }

    /**
     * Method responsible for returning the identity of the object "name" and "quantidade" 
     */
    public String toString() {
        return "name: " + this.name +
        ";quantidade: " + this.quant;
    }

}
