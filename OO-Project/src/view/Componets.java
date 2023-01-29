package view;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

/**
 * Class responsible for having a standard setting to be applied in the view's screen.
 * It is going to implement the interface Config. 
 *
 */
public class Componets {

    /**
     * Static method responsible for setting the aconstants for a card
     * @return card
     */
    protected static JPanel card() {

        JPanel card = new JPanel();
        //card.setPreferredSize(Config.cardDimension);
        card.setMaximumSize(Config.cardDimension);
        card.setMinimumSize(Config.cardDimension);
        card.setBackground(Config.COLOR_WHITE);

        return card;
    }

    /**
     * Static method responsible for setting the constants of a label
     * @param text
     * @return label
     */
    protected static JLabel label (String text) {
        JLabel label = new JLabel(); 
        label.setFont(Config.FONT);
        label.setText(text);
        label.setBackground(Config.COLOR_WHITE);
        return label;
    }

    /**
    * Static method responsible for setting the constants of a button
    * @param text
    * @param background
    * @return button
    */
    protected static JButton makeButton(String text, Color background) {

        JButton button = new JButton(text);
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setBackground(background);
        button.setForeground(Config.COLOR_WHITE);
        button.setPreferredSize(Config.buttonDimension);
        button.setFont(Config.FONT);
        button.addMouseListener(new MouseAdapter(){

            public void mouseEntered (MouseEvent e) {
                button.setBackground(background.darker());;
            }

            public void mouseExited (MouseEvent e) {
                button.setBackground(background);
            }

        });

        return button;
    }
}
