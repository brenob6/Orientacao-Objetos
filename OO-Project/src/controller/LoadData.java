package controller;

import java.util.ArrayList;

import model.Album;
import model.CupSticker;
import model.DcSticker;
import model.Sticker;

/**
 * Class responsible for simulating a database of both 
 * Cup and DC stickers that exists in an album
 *
 */
public class LoadData {

    // Dados figuras DC
    final static private String[] movie = {
        "Cavaleiro das Trevas",
        "Flash Point",
        "Homem de Aço",
        "Mulher Maravilha",
        "Liga da Justiça",
        "A família do Batman",
        "Piada Mortal"
    };
    final static private String[] alias = {
        "Batman", 
        "Flash", 
        "Superman",
        "Mulher Maravilha",
        "Caçador de Marte",
        "Asa Noturna",
        "Coringa"
    };
    final static private String[] nameDc = {
        "Bruce Wayne", 
        "Barry Alen",
        "Clark Kent",
        "Princesa Diana",
        "Ajax",
        "Dick Grayson",
        "Arthur Fleck"

    };
    final static private String[] urlDC = {
        "https://upload.wikimedia.org/wikipedia/pt/8/8d/Batman_por_Jim_Lee.jpg",
        "https://upload.wikimedia.org/wikipedia/pt/a/a4/Barry_Allen_Flash.jpg",
        "https://upload.wikimedia.org/wikipedia/pt/thumb/b/be/Super-Homem.jpg/250px-Super-Homem.jpg",
        "https://upload.wikimedia.org/wikipedia/pt/thumb/f/f6/Mulher-Maravilha.jpg/260px-Mulher-Maravilha.jpg",
        "https://upload.wikimedia.org/wikipedia/pt/thumb/6/63/MartianManhunter.jpg/200px-MartianManhunter.jpg",
        "https://upload.wikimedia.org/wikipedia/pt/thumb/9/9d/Asa_Noturna_-_Dick_Grayson.jpg/200px-Asa_Noturna_-_Dick_Grayson.jpg",
        "https://upload.wikimedia.org/wikipedia/pt/thumb/1/1a/Joker_%28DC_Comics%29.jpg/250px-Joker_%28DC_Comics%29.jpg"
    };
    
    // Dados Figura Copa
    final static private String[] selecao = {"Brasil", "Japão"};
    final static private String[] posicao = {"atacante", "atacante"};
    final static private String[] nameCup = {"Neymar Jr", "Oliver Tsubasa"};
    final static private String[] urlCup = {
            "https://upload.wikimedia.org/wikipedia/commons/thumb/8/83/Bra-Cos_%281%29_%28cropped%29.jpg/230px-Bra-Cos_%281%29_%28cropped%29.jpg",
            "https://pt.wikipedia.org/wiki/Captain_Tsubasa#/media/Ficheiro:Captain_Tsubasa_vol._01.jpg"
    };

    private static String DC = "Heróis DC";

/**
 * Method responsible for creating a list of specific 
 * types of albums with its following stickers 
 * @return albumList
 */
    public static ArrayList<Album> getAlbums() {

        ArrayList<Album> albumList = new ArrayList<>();

        Album dcAlbum = new Album();
        dcAlbum.setName(DC);
        dcAlbum.setStickers(makeStickers(DC));
        albumList.add(dcAlbum);

        Album cupAlbum = new Album();
        cupAlbum.setName("Copa do Mundo");
        cupAlbum.setStickers(makeStickers("Copa do Mundo"));
        albumList.add(cupAlbum);

        return albumList;
    }

/**
 * Method responsible for creating stickers with its informations
 * @param n
 * @return stickerList
 */
    public static ArrayList<Sticker> makeStickers(String n) {
        
        ArrayList<Sticker> stickerList = new ArrayList<>();

        if(n.equals(DC)){
            for(int i = 0; i < nameDc.length; i++) {
                stickerList.add(new DcSticker(
                    nameDc[i], urlDC[i], movie[i], alias[i]));
            }
        }

        if(n.equals("Copa do Mundo")) {
            for(int i = 0; i < selecao.length; i++) {
                stickerList.add(new CupSticker(
                    nameCup[i], urlCup[i], selecao[i], posicao[i]));
            }
        }
        
        return stickerList;
    }
}
