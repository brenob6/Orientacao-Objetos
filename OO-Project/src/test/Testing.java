package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import model.Album;
import model.Sticker;
import org.junit.jupiter.api.Test ;

import org.junit.jupiter.api.Test ;

class Testing {

	@Test
	void testGetRepeatedStickers() {
		class StickerChild extends Sticker{
		    public StickerChild(String name, String UrlImage) {
		        super(name, UrlImage);
		    }
		}		
        ArrayList<Sticker> stickers = new ArrayList<Sticker>();
        stickers.add(new StickerChild("Sticker1", "www.sticker1.com"));
        stickers.add(new StickerChild("Sticker2", "www.sticker2.com"));
        stickers.add(new StickerChild("Sticker3", "www.sticker3.com"));
        Album album = new Album("Meu album", "album1", stickers);
        stickers.get(0).setQuant(1);
        stickers.get(1).setQuant(0);
        stickers.get(2).setQuant(2);
        ArrayList<Sticker> expectedRepeated = new ArrayList<Sticker>();
        expectedRepeated.add(stickers.get(2));
        assertEquals(expectedRepeated, album.getRepeatedStickers());
	}

	@Test
	void testGetMissingStickers() {
		class StickerChild extends Sticker{
		    public StickerChild(String name, String UrlImage) {
		        super(name, UrlImage);
		    }
		}
        Album album = new Album();
        album.setName("Test Album");
        album.setAlias("Test");
        ArrayList<Sticker> stickers = new ArrayList<Sticker>();
        stickers.add(new StickerChild("Sticker 1", "http://url1.com"));
        stickers.add(new StickerChild("Sticker 2", "http://url2.com"));
        stickers.add(new StickerChild("Sticker 3", "http://url3.com"));
        stickers.add(new StickerChild("Sticker 4", "http://url4.com"));
        stickers.get(0).setQuant(0);
        stickers.get(1).setQuant(0);
        stickers.get(2).setQuant(0);
        stickers.get(3).setQuant(0);
        album.setStickers(stickers);
        ArrayList<Sticker> missingStickers = album.getMissingStickers();
        assertEquals(stickers, missingStickers);
    }
	
		@Test
	void testFindStickers() {
		class StickerChild extends Sticker{
			public StickerChild(String name, String UrlImage) {
				super(name, UrlImage);
			}
		}
        ArrayList<Sticker> stickers = new ArrayList<Sticker>();
        stickers.add(new StickerChild("sticker1", "url1"));
        stickers.add(new StickerChild("sticker2", "url2"));
        stickers.add(new StickerChild("sticker3", "url3"));

        Album album = new Album("Álbum de Teste", "AT", stickers);

        ArrayList<Sticker> result = album.findStickers("sticker2");

        assertEquals(1, result.size());
        assertEquals("sticker2", result.get(0).getName());
        
    }
    }


	


