package br.unb.model;

import java.util.ArrayList;

public class User {
    private ArrayList<Album> albuns;
    
    public User() {
        this.albuns = new ArrayList<Album>();
    } 
    
    public void addAlbum(Album album) {
        this.albuns.add(album);
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