package model;

import java.util.ArrayList;

public class Album {
    
    private int id;
    private String name;
    private String nickname;
    private int total;
    private ArrayList<Sticker> stickers;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getNickname() {
        return nickname;
    }
    public void setNickname(String apelido) {
        this.nickname = apelido;
    }
    public int getTotal() {
        return total;
    }
    public void setTotal(int total) {
        this.total = total;
    } 
}