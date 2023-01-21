package controller;

import java.util.ArrayList;

import model.Album;
import model.CupSticker;
import model.DcSticker;
import model.Sticker;

public class LoadData {

    // Dados figuras DC
    final private String[] movie = {"Cavaleiro das Trevas", "Flash Point", "Homem de Aço"};
    final private String[] alias = {"Batman", "Flash", "Superman"};
    final private String[] name = {"Bruce Wayne", "Barry Alen", "Kent Clark"};
    final private String[] urlDC = {
        "https://upload.wikimedia.org/wikipedia/pt/8/8d/Batman_por_Jim_Lee.jpg",
        "https://upload.wikimedia.org/wikipedia/pt/a/a4/Barry_Allen_Flash.jpg",
        "https://upload.wikimedia.org/wikipedia/pt/thumb/b/be/Super-Homem.jpg/250px-Super-Homem.jpg"
    };
    
    // Dados Figura Copa
    final private String[] selecao = {"Brasil", "Japão"};
    final private String[] posicao = {"atacante", "atacante"};
    final private String[] nameCup = {"Neymar Jr", "Oliver Tsubasa"};
    final private String[] urlCup = {
            "https://upload.wikimedia.org/wikipedia/commons/thumb/8/83/Bra-Cos_%281%29_%28cropped%29.jpg/230px-Bra-Cos_%281%29_%28cropped%29.jpg",
            "https://pt.wikipedia.org/wiki/Captain_Tsubasa#/media/Ficheiro:Captain_Tsubasa_vol._01.jpg"
    };

    public ArrayList<Album> getAlbums() {

        ArrayList<Album> albumList = new ArrayList<>();

        Album dcAlbum = new Album();
        dcAlbum.setName("Herois DC");
        dcAlbum.setStickers(makeStickers(new DcSticker()));
        albumList.add(dcAlbum);

        Album cupAlbum = new Album();
        dcAlbum.setName("Copa do Mundo");
        dcAlbum.setStickers(makeStickers(new CupSticker()));
        albumList.add(cupAlbum);

        return albumList;
    }

    private ArrayList<Sticker> makeStickers(Sticker model) {
        
        ArrayList<Sticker> stickerList = new ArrayList<>();

        if(model.equals(new DcSticker())){
            for(int i = 0; i < selecao.length; i++) {
                stickerList.add(new DcSticker(
                    name[i], urlDC[i], movie[i], alias[i]));
            }
        }

        if(model.equals(new CupSticker())) {
            for(int i = 0; i < selecao.length; i++) {
                stickerList.add(new CupSticker(
                    nameCup[i], urlCup[i], selecao[i], posicao[i]));
            }
        }

        return stickerList;
    }
}
