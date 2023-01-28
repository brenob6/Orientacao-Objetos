package controller;

import java.util.ArrayList;

import model.Album;
import model.Sticker;

public class User {

    private ArrayList<Album> albuns; 

    public User(){
        this.albuns = new ArrayList<>();
    }

    public void addAlbum(Album album) {
        albuns.add(album);
    }

    public ArrayList<Album> getUserAlbuns () {
        return albuns;
    }
    
    public void removeAlbum (Album album) {
        albuns.remove(album);
    }
    
    public Album createAlbum (String name){

        Album album = new Album();
        album.setName(name);
        album.setStickers(LoadData.makeStickers(name));
        return album;
    }

    
    public void listAll() {
       albuns.forEach((album) -> System.out.println(album.getName()));
   }
}
