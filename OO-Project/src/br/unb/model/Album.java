package br.unb.model;

import java.util.List;

public class Album {
    
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
    private int id;
    private String name;
    private String nickname;
    private int total;
    private List<Sticker> stickers; 

}
