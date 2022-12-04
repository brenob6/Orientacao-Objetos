package br.unb.model;

public interface CRUD<T> {

    public void create(T object);
    public void read(T object);
    public void update(T object);
    public void delete(T object);
}
