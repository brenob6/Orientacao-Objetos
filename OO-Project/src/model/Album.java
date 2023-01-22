package model;

import java.util.ArrayList;

public class Album {
    
    private String name;
    private String alias;
    private ArrayList<Sticker> stickers;
    
    public ArrayList<Sticker> getStickers(){
        return this.stickers;
    }
    
    public void setStickers(ArrayList<Sticker> stickers) {
        this.stickers = stickers;
    }
    
    public ArrayList<Sticker> getRepeatedStickers(){
        ArrayList<Sticker> repeated = new ArrayList<Sticker>();
        stickers.forEach((sticker) -> {
            if(sticker.getQuant() > 1)
                repeated.add(sticker);
        });
        return repeated;
    }
    
    public ArrayList<Sticker> getMissingStickers() {
        ArrayList<Sticker> missing = new ArrayList<Sticker>();
        stickers.forEach((sticker) -> {
            if(sticker.getQuant() == 0)
                missing.add(sticker);
        });
        return missing;
        
    }
    
    public Album(String name, String alias, ArrayList<Sticker> stickers) {
        this.name = name;
        this.alias = alias;
        this.stickers = stickers;
    }

    public Album(){}

    public int getTotal() {
        return this.stickers.size();
    }

    public String getName() {
        return name;
    } 
    public void setName(String name) {
        this.name = name;
    } 
    public String getAlias() {
        return this.alias;
    }
    public void setAlias(String alias) {
        this.alias = alias;
    }
}
