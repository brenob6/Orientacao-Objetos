package controller;

import java.util.ArrayList;
import model.Sticker;
import model.StickerCopa;
import model.StickerDC;
import model.Album;

public class Main {
    public static void main(String args[]) {
        
        // Dados Figuras DC
        String[] movie = {"Cavaleiro das Trevas", "Flash Point", "Homem de Aço"};
        String[] alias = {"Batman", "Flash", "Superman"};
        String[] name = {"Bruce Wayne", "Barry Alen", "Kent Clark"};
        String[] url = {
                "https://upload.wikimedia.org/wikipedia/pt/8/8d/Batman_por_Jim_Lee.jpg",
				"https://upload.wikimedia.org/wikipedia/pt/a/a4/Barry_Allen_Flash.jpg",
				"https://upload.wikimedia.org/wikipedia/pt/thumb/b/be/Super-Homem.jpg/250px-Super-Homem.jpg"
        };
        
        // Dados Figura Copa
        String[] selecao = {"Brasil", "Japão"};
        String[] posicao = {"atacante", "atacante"};
        String[] name1 = {"Neymar Jr", "Oliver Tsubasa"};
        String[] url1 = {
                "https://upload.wikimedia.org/wikipedia/commons/thumb/8/83/Bra-Cos_%281%29_%28cropped%29.jpg/230px-Bra-Cos_%281%29_%28cropped%29.jpg",
                "https://pt.wikipedia.org/wiki/Captain_Tsubasa#/media/Ficheiro:Captain_Tsubasa_vol._01.jpg"
        };
        
        ArrayList<Sticker> stickerDc = new ArrayList<Sticker>();
        ArrayList<Sticker> stickerCopa = new ArrayList<Sticker>();

        for(int i = 0; i < 3; i++) {
            Sticker sticker = new StickerDC(
                    name[i],
                    url[i],
                    alias[i],
                    movie[i]
                    );
            if (i != 0)
                sticker.setQuant(2);
            stickerDc.add(sticker);
            
        }

        for(int i = 0; i < 2; i++) {
            Sticker sticker = new StickerCopa(
                    name1[i],
                    url1[i],
                    selecao[i],
                    posicao[i]
                    );
            stickerCopa.add(sticker);
        }
        Album albumDc = new Album("Herois DC", "Album do Evynhas", stickerDc); 
        Album albumCopa = new Album("Copa", "Album do MC MK", stickerCopa);

        UserController controller = new UserController();
        controller.addAlbum(albumDc);
        controller.addAlbum(albumCopa);

       controller.listAll(); 
       controller.getAlbuns().forEach(album -> {
           album.getStickers().forEach(sticker -> System.out.println("Todas " + sticker.toString()));
           album.getRepeatedStickers().forEach(sticker -> System.out.println("Repetidas " + sticker.toString()));
           album.getMissingStickers().forEach(sticker -> System.out.println("Faltante " + sticker.toString()));
       });
        
        
    }

}
