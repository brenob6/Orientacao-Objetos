package controller;

import java.util.ArrayList;
import model.Album;
import model.Sticker;

/**
 * Class User simulates a behavior of an user that has an album and is a holder of it 
 *
 */
public class User {

    private ArrayList<Album> albuns; 

    public User(){
        this.albuns = new ArrayList<>();
    }
<<<<<<< HEAD

=======
    
    /**
     * Method that is responsible for add an album to the user
     * @param album
     */
>>>>>>> 491a77c4f0666d34e731b154c893ba6d7993f396
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
    
<<<<<<< HEAD
    public Album createAlbum (String name){

        Album album = new Album();
        album.setName(name);
        album.setStickers(LoadData.makeStickers(name));
        return album;
    }

    
    public void listAll() {
=======
    /**
     * Method responsible for searching for an album given its name so that the album can be find. 
     * The searching will be based on the data of the holder according to its album.
     * The album will be found if the name of the album exists in the list of the user, then, 
     * the method will return the name of the album. Otherwise, it will return null. 
     * @param name
     * @return album
     * @return null
     */
    public Album findAlbum (String name){
        for (Album album : holder) {
            if(album.getName().equals(name))
                return album;
        }
        return null;
    }
    /**
     * Method responsible for listing all the albums that already exists.
     * It is going to print their names on the screen. 
     */
   public void listAll() {
>>>>>>> 491a77c4f0666d34e731b154c893ba6d7993f396
       albuns.forEach((album) -> System.out.println(album.getName()));
   }
}
