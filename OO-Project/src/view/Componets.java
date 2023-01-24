package view;

import javax.swing.*;

import java.awt.*;

public class Componets implements Config{

    protected static JPanel card() {

        JPanel card = new JPanel();
        //card.setPreferredSize(Config.cardDimension);
        card.setMaximumSize(cardDimension);
        card.setMinimumSize(cardDimension);
        card.setBackground(Config.COLOR_WHITE);

        return card;
    }

    protected static JLabel label (String text) {
        JLabel label = new JLabel(); 
        label.setFont(Config.FONT);
        label.setText(text);
        label.setBackground(Config.COLOR_WHITE);
        return label;
    }

    protected static JButton makeButton(String text, Color background) {

        JButton button = new JButton(text);
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setBackground(background);
        button.setForeground(COLOR_WHITE);
        button.setPreferredSize(buttonDimension);
        button.setFont(FONT);

        return button;
    }
}
