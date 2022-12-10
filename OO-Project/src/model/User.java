package model;

import java.util.ArrayList;

public class User {
    private static ArrayList<Album> albuns;
    
    public User() {
        this.albuns = new ArrayList<Album>();
    } 
    
    public static void addAlbum(Album album) {
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
}