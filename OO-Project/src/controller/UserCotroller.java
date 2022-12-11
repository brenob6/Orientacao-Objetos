package controller;

import java.util.ArrayList;

import model.Album;

public class UserCotroller {

	private  ArrayList<Album> albuns;
    
    public void addAlbum(Album album) {
        albuns.add(album);
    }
    
    public void deleteAlbum(int id) {
        for (int i = 0; i < albuns.size(); i++) {
            if(albuns.get(i).getId() == id) {
                albuns.remove(i);
                break;
            }
        }
    }
    
   public void listAll() {
       albuns.forEach((album) -> System.out.println(album.getName()));
   }
}
