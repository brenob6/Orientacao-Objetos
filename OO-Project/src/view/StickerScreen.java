package view;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.Border;
import javax.swing.text.LabelView;

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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StickerScreen extends JFrame implements Config{

    private JPanel topMenuPane = new JPanel();
    private JPanel listStickesPanel = new JPanel();
    private JPanel listRepeatedPanel = new JPanel();
    private JPanel listMissingPanel = new JPanel();

    private JTabbedPane tabPane = new JTabbedPane();

    public StickerScreen(Album album) {
        this.setTitle("Pseudo Album");
        this.setSize(Config.FRAME_WIDTH, Config.FRAME_HEIGHT);
        this.setLayout(new BorderLayout());
        this.setResizable(true);

        this.add(tabPane);
        listStickesPanel.setAutoscrolls(true);

        titlePanel(album.getName());

        tabPane.add("TODAS", listStickesPanel);
        tabPane.add("FALTANTES", listMissingPanel);
        tabPane.add("REPETIDAS", listRepeatedPanel);
        loadStickerCards(album);

        this.add(tabPane, BorderLayout.CENTER);

        this.setVisible(true);
    }

    private void titlePanel(String title) {
        topMenuPane.setSize(800, 100);
        topMenuPane.setBackground(Config.COLOR_BLACK);
        topMenuPane.setVisible(true);

        JLabel label = new JLabel(title);
        label.setFont(Config.FONT);
        label.setForeground(Config.COLOR_WHITE);

        topMenuPane.add(label);
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
        card.setBackground(Config.COLOR_WHITE);
    
        JLabel countLabel = new JLabel(String.valueOf(sticker.getQuant()));
        countLabel.setFont(new Font("arial", Font.BOLD, 20));

        JButton addButton = makeButton("+");

        JButton removeButton = makeButton("-");

        JButton infoButton = makeButton("i");
        infoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(
                    null, null, sticker.getName(), 1, sticker.getImage());

            }
        });

    
        JLabel nameLabel = new JLabel(); 
        nameLabel.setFont(Config.FONT);
        nameLabel.setText(sticker.getName());
        nameLabel.setBackground(Config.COLOR_WHITE);
        
        card.add(nameLabel);
        card.add(addButton);
        card.add(countLabel);
        card.add(removeButton);
        card.add(infoButton);

        return card;
    }

    private JButton makeButton(String text) {
        JButton button = new JButton(text);
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setPreferredSize(Config.buttonDimension);
        button.setForeground(Config.COLOR_WHITE);
        button.setFont(Config.FONT);
        button.setBackground(Config.COLOR_BLACK);
        return button;
    }
}
