package model;

import java.util.ArrayList;
/**
 * Class responsible for simulating an album
 *
 */
public class Album {
    
    private String name;
    private String alias;
    private ArrayList<Sticker> stickers;
    
    /**
     * Constructor responsible for instantiate the class Album
     * @param name
     * @param alias
     * @param stickers
     */
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

    public ArrayList<Sticker> getStickers(){
        return this.stickers;
    }
    
    public void setStickers(ArrayList<Sticker> stickers) {
        this.stickers = stickers;
    }
    
    /**
     * Method responsible for searching and listing repeated stickers in an album
     * @return repeated
     */
    public ArrayList<Sticker> getRepeatedStickers(){
        ArrayList<Sticker> repeated = new ArrayList<Sticker>();
        stickers.forEach((sticker) -> {
            if(sticker.getQuant() > 1)
                repeated.add(sticker);
        });
        return repeated;
    }

    /**
     * Method responsible for searching and listing missing stickers in an album
     * @return missing
     */
    public ArrayList<Sticker> getMissingStickers() {
        ArrayList<Sticker> missing = new ArrayList<Sticker>();
        stickers.forEach((sticker) -> {
            if(sticker.getQuant() == 0)
                missing.add(sticker);
        });
        return missing;
        
    }

    /**
     * Method responsible for searching a given name in the array list 
     * of album and returns the found album's name if it's in the list
     * @param name
     * @return found
     */
    public ArrayList<Sticker> findStickers (String name) {
        ArrayList<Sticker> found = new ArrayList<>(); 
        name = name.toUpperCase();

        for(Sticker sticker : stickers) {
            String a = sticker.getName().toUpperCase();
            if(a.contains(name.toUpperCase()))
                found.add(sticker);
        }
        
        return found;
    }

}
