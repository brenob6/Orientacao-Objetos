package view;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.Album;
import model.CupSticker;
import model.DcSticker;
import model.Sticker;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StickerScreen extends JFrame implements Config{

    private JPanel topMenuPane = new JPanel();
    private JPanel listStickesPanel = new JPanel();
    private JPanel listRepeatedPanel = new JPanel();
    private JPanel listMissingPanel = new JPanel();

    private JTabbedPane tabPane = new JTabbedPane();

    private Album album;

    public StickerScreen(Album album) {
        this.album = album;
        this.setTitle("Pseudo Album");
        this.setSize(Config.FRAME_WIDTH, Config.FRAME_HEIGHT);
        this.setLayout(new BorderLayout());
        this.setResizable(true);

        this.add(tabPane);

        titlePanel(this.album.getName());

        tabPane.add("TODAS", listStickesPanel);
        tabPane.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                listRepeatedPanel.removeAll();
                listStickesPanel.removeAll();
                listMissingPanel.removeAll();
                loadStickerCards(album);
            }
        });

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

        JButton addButton = Componets.makeButton("+");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField nameField = new JTextField();

                JPanel panel = new JPanel(new GridLayout(0, 1));
                panel.add(new JLabel("Nome:"));
                panel.add(nameField);

                int result = JOptionPane.showConfirmDialog(null, panel, "Adicionar Figura",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                if (result == JOptionPane.OK_OPTION) {

                    Sticker sticker = null;
                    switch (album.getName()) {
                        case "Heróis DC" :
                        sticker = new DcSticker();

                        break;
                        case "Copa do Mundo":
                        sticker = new CupSticker();
                        break;
                        
                        default:
                        sticker = new DcSticker();
                    }
            
                    sticker.setName(nameField.getText());
                    album.getStickers().add(sticker);
                    loadStickerCards(album);
                }

            }
        });

        JLabel label = new JLabel(title);
        label.setFont(Config.FONT);
        label.setForeground(Config.COLOR_WHITE);

        topMenuPane.add(label);
        topMenuPane.add(addButton);

        this.add(topMenuPane, BorderLayout.NORTH);
    }

    private void loadStickerCards(Album album) {
        listStickesPanel.removeAll();
        listRepeatedPanel.removeAll();
        listMissingPanel.removeAll();

        album.getStickers().forEach(sticker -> {
            listStickesPanel.add(makeStickerCard(sticker));
        });

        album.getRepeatedStickers().forEach(sticker -> {
            listRepeatedPanel.add(makeStickerCard(sticker));
        });

        album.getMissingStickers().forEach(sticker -> {
            listMissingPanel.add(makeStickerCard(sticker));
        });

        listStickesPanel.revalidate();
        listStickesPanel.repaint();
        listMissingPanel.revalidate();
        listMissingPanel.repaint();
        listRepeatedPanel.revalidate();
        listRepeatedPanel.repaint();
        
    }

    public JPanel makeStickerCard(Sticker sticker) {

        JPanel card = new JPanel();
        card.setPreferredSize(Config.cardDimension);
        card.setBackground(Config.COLOR_WHITE);

        JLabel countLabel = new JLabel(String.valueOf(sticker.getQuant()));
        countLabel.setFont(Config.FONT);

        JButton addButton = makeButton("+");
        JButton removeButton = makeButton("-");
        JButton infoButton = makeButton("i");
        JButton deleteButton = makeButton("X");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	sticker.setQuant(sticker.getQuant()+1);
            	countLabel.setText(String.valueOf(sticker.getQuant()));

            }
        });
        
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	sticker.setQuant(sticker.getQuant()-1);
            	countLabel.setText(String.valueOf(sticker.getQuant()));
            	if (sticker.getQuant() < 0) {
            		sticker.setQuant(0);
                	countLabel.setText(String.valueOf(sticker.getQuant()));
                }
            } 		 
        });

        infoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                makeInfoPanel(sticker);    
            }
        });
    
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                album.getStickers().remove(sticker);
                loadStickerCards(album);
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
        card.add(deleteButton);

        return card;
    }

    private JPanel makeInfoPanel(Sticker sticker) {
        JPanel panel = new JPanel();
        JLabel img = new JLabel(); 
        img.setText(makeInfoText(sticker));
        img.setIcon(sticker.getImage());
        panel.add(img);
        return panel;
    }

    private String makeInfoText(Sticker sticker) {
        String[] infos = sticker.toString().split(";");
        String text = "<html>";
        for(int i = 0; i < infos.length; i++) {
            text += infos[i] + "<br/>";
        }
        text += "</html>";
        return text;
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
