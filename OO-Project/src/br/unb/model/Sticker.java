package br.unb.model;

import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;

public abstract class Sticker {

    private String raridade;
    private int quant;
    private String UrlImage;
    private String name;
    
    public ImageIcon getImage() {

        URL url = null; 
        try {
            url = new URL(UrlImage);
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return new ImageIcon(url);
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRaridade() {
        return raridade;
    }

    public void setRaridade(String raridade) {
        this.raridade = raridade;
    }

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }

    public String getUrlImage() {
        return UrlImage;
    }

    public void setUrlImage(String urlImage) {
        UrlImage = urlImage;
    }
    
    public Sticker() {}
    
    public Sticker(String name, String raridade, int quant, String UrlImage) {
        this.name = name;
        this.raridade = raridade;
        this.quant = quant; 
        this.UrlImage = UrlImage;
    }

}
