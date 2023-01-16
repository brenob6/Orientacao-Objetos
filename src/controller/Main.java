package controller;

import java.util.ArrayList;

import model.Sticker;
import model.CupSticker;
import model.DcSticker;
import model.Album;
import model.User;
import view.MainScreen;

public class Main {
    public static void main(String args[]) {
        MainScreen mainScreen = new MainScreen();    
        // Dados Figuras DC
        String[] movie = {"Cavaleiro das Trevas", "Flash Point", "Homem de Aço"};
        String[] alias = {"Batman", "Flash", "Superman"};
        String[] name = {"Bruce Wayne", "Barry Alen", "Clark Kent"};
        String[] url = {
                "https://upload.wikimedia.org/wikipedia/pt/8/8d/Batman_por_Jim_Lee.jpg",
    			"https://upload.wikimedia.org/wikipedia/pt/a/a4/Barry_Allen_Flash.jpg",
    			"https://upload.wikimedia.org/wikipedia/pt/thumb/b/be/Super-Homem.jpg/250px-Super-Homem.jpg"
        };
        
        // Dados Figura Copa
        String[] selecao = {"Brasil", "Japão"};
        String[] posicao = {"Atacante", "Atacante"};
        String[] name1 = {"Neymar Jr", "Oliver Tsubasa"};
        String[] url1 = {
                "https://upload.wikimedia.org/wikipedia/commons/thumb/8/83/Bra-Cos_%281%29_%28cropped%29.jpg/230px-Bra-Cos_%281%29_%28cropped%29.jpg",
                "https://pt.wikipedia.org/wiki/Captain_Tsubasa#/media/Ficheiro:Captain_Tsubasa_vol._01.jpg"
        };
        
        ArrayList<Sticker> stickerDc = new ArrayList<Sticker>();
        ArrayList<Sticker> stickerCopa = new ArrayList<Sticker>();
 
        for(int i = 0; i < 3; i++) {
            Sticker sticker = new DcSticker(
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
            Sticker sticker = new CupSticker(
                    name1[i],
                    url1[i],
                    selecao[i],
                    posicao[i]
                    );
            stickerCopa.add(sticker);
        }
        Album albumDc = new Album(0, "Herois DC", "Album do Evynhas", stickerDc); 
        Album albumCopa = new Album(1, "Copa", "Album do MC MK", stickerCopa);
 
        User user = new User();
        user.addAlbum(albumDc);
        user.addAlbum(albumCopa);

        user.getAlbuns().forEach(albuns -> {
            mainScreen.makeAlbumCard(albuns);
        });
        
        

        
        
        
        
        
        
    }

}