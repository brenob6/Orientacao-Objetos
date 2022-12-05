package br.unb.model;

import java.util.ArrayList;

public interface CRUD<T> {

    public void create(T object);
    public ArrayList<T> read(T object);
    public void update(T object);
    public void delete(T object);
}
