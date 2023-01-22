package view;

import javax.swing.*;

import model.Album;

public class Componets implements Config{
    protected static JButton makeButton(String text) {

        JButton button = new JButton(text);
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setBackground(COLOR_BLACK);
        button.setForeground(COLOR_WHITE);
        button.setPreferredSize(buttonDimension);
        button.setFont(FONT);

        return button;
    }
    public static JPanel makeStickerCard(Album album) {

        JPanel card = new JPanel();
        card.setPreferredSize(Config.cardDimension);
        card.setBackground(Config.COLOR_WHITE);

        JLabel nameLabel = new JLabel(); 
        nameLabel.setFont(Config.FONT);
        nameLabel.setText(album.getName());
        nameLabel.setBackground(Config.COLOR_WHITE);
        
        card.add(nameLabel);

        return card;
    }
}
