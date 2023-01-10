package view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.Album;
import model.Sticker;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Color;

public class StickerScreen extends JFrame{

    private JPanel topMenuPane = new JPanel();
    private JPanel listStickesPanel = new JPanel();
    private JScrollPane scrollPane;

    public StickerScreen(Album album) {
        this.setTitle("Pseudo Album");
        this.setSize(800, 600);
        this.setResizable(true);
        this.setLayout(new GridLayout(album.getTotal(), 1, 10 , 10));
        this.setVisible(true);
        
        listStickesPanel.setLayout(new GridLayout(album.getTotal(), 1, 5, 5));

        loadStickerCards(album);

        scrollPane = new JScrollPane(
            listStickesPanel,
            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
        );
        scrollPane.setBounds(0, 100, 800, 700);

        this.add(scrollPane);
    }

    private void loadStickerCards(Album album) {
        album.getStickers().forEach(sticker -> {
            createStickerCard(sticker);
        });
    }

    public void createStickerCard(Sticker sticker) {

        JPanel card = new JPanel();
        card.setBackground(Color.RED);
        card.setSize(800,100);
    
        JLabel countLabel = new JLabel("0");
        JButton addButton = new JButton("+");
        JButton removeButton = new JButton("-");

        card.add(addButton);
        card.add(countLabel);
        card.add(removeButton);

        listStickesPanel.add(card);
    }
}
