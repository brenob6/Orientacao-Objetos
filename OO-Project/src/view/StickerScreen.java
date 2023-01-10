package view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.border.Border;

import model.Album;
import model.Sticker;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StickerScreen extends JFrame implements Config{

    private JPanel topMenuPane = new JPanel();
    private JPanel listStickesPanel = new JPanel();
    private JPanel listRepeatedPanel = new JPanel();
    private JPanel listMissingPanel = new JPanel();

    private JTabbedPane tabPane = new JTabbedPane();

    public StickerScreen(Album album) {
        this.setTitle("Pseudo Album");
        this.setSize(Config.FRAME_WIDTH, Config.FRAME_HEIGHT);
        this.setBackground(Config.BACKGROUND_COLOR);
        this.setLayout(new BorderLayout());
        this.setResizable(true);

        this.add(tabPane);
        listStickesPanel.setBackground(Config.BACKGROUND_COLOR);

        titlePanel(album.getName());

        tabPane.add("TODAS", listStickesPanel);
        tabPane.add("FALTANTES", listMissingPanel);
        tabPane.add("REPETIDAS", listRepeatedPanel);

        //scrollPane = new JScrollPane(
        //    listStickesPanel,
        //    JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
        //    JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED
        //);

        //this.add(scrollPane, BorderLayout.CENTER);

        loadStickerCards(album);
        //this.add(listStickesPanel, BorderLayout.CENTER);

        this.setVisible(true);
    }

    private void titlePanel(String title) {
        topMenuPane.setSize(800, 100);
        topMenuPane.setBackground(Config.TITLE_COLOR);
        topMenuPane.setVisible(true);

        this.add(topMenuPane, BorderLayout.NORTH);
    }

    private void loadStickerCards(Album album) {
        album.getStickers().forEach(sticker -> {
            listStickesPanel.add(makeStickerCard(sticker));
        });

        album.getRepeatedStickers().forEach(sticker -> {
            listRepeatedPanel.add(makeStickerCard(sticker));
        });

        album.getMissingStickers().forEach(sticker -> {
            listMissingPanel.add(makeStickerCard(sticker));
        });
    }

    public JPanel makeStickerCard(Sticker sticker) {

        JPanel card = new JPanel();
        card.setPreferredSize(new Dimension(800, 80));
    
        JLabel countLabel = new JLabel("0");
        countLabel.setFont(new Font("arial", Font.BOLD, 20));

        JButton addButton = new JButton("+");
        addButton.setPreferredSize(new Dimension(50, 50));
        JButton removeButton = new JButton("-");
        removeButton.setPreferredSize(new Dimension(50, 50));
    
        JCheckBox checkBox = new JCheckBox(); 
        checkBox.setPreferredSize(new Dimension(80, 80));
    
        
        card.add(checkBox);
        card.add(addButton);
        card.add(countLabel);
        card.add(removeButton);

        return card;
    }
}
