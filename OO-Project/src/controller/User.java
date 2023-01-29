package controller;

import java.util.ArrayList;
import model.Album;

/**
 * Class User simulates a behavior of an user 
 * that has an album and is a holder of it 
 *
 */
public class User {

    private ArrayList<Album> albuns; 

    public User(){
        this.albuns = new ArrayList<>();
    }

    /**
     * Method that is responsible for add an album to the user
     * @param album
     */
    public void addAlbum(Album album) {
        albuns.add(album);
    }

    public ArrayList<Album> getUserAlbuns () {
        return albuns;
    }
    
    /**
     * Method responsible for removing an album in the list of user's albums
     * @param album
     */
    public void removeAlbum (Album album) {
        albuns.remove(album);
    }
    
    /**
     * Method responsible for creating an album given its name
     * @param name
     * @return album
     */
    public Album createAlbum (String name){

        Album album = new Album();
        album.setName(name);
        album.setStickers(LoadData.makeStickers(name));
        return album;
    }

    
    /**
     * Method responsible for listing all the albums that already exists.
     * It is going to print their names on the screen. 
     */
   public void listAll() {
       albuns.forEach((album) -> System.out.println(album.getName()));
   }
}
