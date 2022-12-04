package br.unb.model;

import java.util.ArrayList;

public class User implements CRUD<Album>{
    private ArrayList<Album> albuns;
    
    public User() {
        this.albuns = new ArrayList<Album>();
    }

    @Override
    public void create(Album object) {
        // TODO Auto-generated method stub
        albuns.add(object);
        
    }

    @Override
    public void read(Album object) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void update(Album object) {
        // TODO Auto-generated method stub
        for (int i = 0; i < albuns.size(); i++) {
            if(object.getId() == albuns.get(i).getId()) {
               albuns.set(i, object) ;
			} 
		} 
    }

    @Override
    public void delete(Album object) {
        // TODO Auto-generated method stub
        albuns.remove(object);
        
    }

}
