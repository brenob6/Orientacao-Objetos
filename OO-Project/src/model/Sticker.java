package model;

import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;

public abstract class Sticker {

    private int quant;
    private String urlImage;
    private String name;
    
    
    public Sticker() {}
    
    public Sticker(String name, String UrlImage) {
        this.name = name;
        this.quant = 0; 
        this.urlImage = UrlImage;
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

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "name: " + this.name +
        ";quantidade: " + this.quant;
    }

    public ImageIcon getImage() {

        URL url = null; 
        try {
            url = new URL(urlImage);
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return new ImageIcon(url);
    }

}
