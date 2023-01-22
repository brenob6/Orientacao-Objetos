package controller;

import java.util.ArrayList;

import model.Album;

public class User {

    private final ArrayList<Album> holder; 

    private ArrayList<Album> albuns; 

    public User(){
        this.albuns = new ArrayList<>();
        this.holder = LoadData.getAlbums();
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
    
    public Album findAlbum (String name){
        for (Album album : holder) {
            if(album.getName().equals(name))
                return album;
        }
        return null;
    }
    
   public void listAll() {
       albuns.forEach((album) -> System.out.println(album.getName()));
   }
}
