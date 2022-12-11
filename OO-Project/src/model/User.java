package model;

import java.util.ArrayList;

import model.Album;

public class User {

    private  ArrayList<Album> albuns = new ArrayList<Album>();
    
    public void addAlbum(Album album) {
        albuns.add(album);
    }
    
    public void deleteAlbum(int id) {
        for (int i = 0; i < albuns.size(); i++) {
            if(albuns.get(i).getId() == id) {
                albuns.remove(id);
                break;
            }
        }
    }
    
   public ArrayList<Album> getAlbuns(){
       return this.albuns;
   }
    
   public void listAll() {
       albuns.forEach((album) -> System.out.println(album.getName()));
   }
}
