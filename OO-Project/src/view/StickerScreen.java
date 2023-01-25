package view;

import javax.swing.BoxLayout;
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
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.awt.event.KeyAdapter;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StickerScreen extends JFrame implements Config{

    private JPanel topMenuPane = new JPanel();
    private JPanel listStickesPanel = new JPanel();
    private JPanel listRepeatedPanel = new JPanel(); 
    private JPanel listMissingPanel = new JPanel();

    private JScrollPane listStickesScrollPanel = new JScrollPane();
    private JScrollPane listRepeatedScrollPanel = new JScrollPane();
    private JScrollPane listMissingScrollPanel = new JScrollPane();

    private JTabbedPane tabPane = new JTabbedPane();

    private Album album;

    public StickerScreen(Album album) {
        this.album = album;
        this.setTitle("Pseudo Album");
        this.setSize(Config.FRAME_WIDTH, Config.FRAME_HEIGHT);
        this.setResizable(false);

        listStickesPanel.setLayout(new BoxLayout(listStickesPanel, BoxLayout.Y_AXIS));
        listRepeatedPanel.setLayout(new BoxLayout(listRepeatedPanel, BoxLayout.Y_AXIS));
        listMissingPanel.setLayout(new BoxLayout(listMissingPanel, BoxLayout.Y_AXIS));
        
        listStickesScrollPanel.setViewportView(listStickesPanel);
        listRepeatedScrollPanel.setViewportView(listRepeatedPanel);
        listMissingScrollPanel.setViewportView(listMissingPanel);

        this.add(tabPane);

        topMenuPane = titlePanel(this.album.getName());

        tabPane.add("TODAS", listStickesScrollPanel);
        tabPane.add("FALTANTES", listMissingScrollPanel);
        tabPane.add("REPETIDAS", listRepeatedScrollPanel);

        tabPane.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                listRepeatedPanel.removeAll();
                listStickesPanel.removeAll();
                listMissingPanel.removeAll();
                loadStickerCards(album);
            }
        });

        loadStickerCards(album);

        this.add(topMenuPane, BorderLayout.NORTH);
        this.add(tabPane, BorderLayout.CENTER);

        this.setVisible(true);
    }

    private JPanel titlePanel(String title) {
        topMenuPane.setSize(800, 100);
        topMenuPane.setBackground(Config.COLOR_BLACK);
        topMenuPane.setVisible(true);

        JLabel label = Componets.label(title);
        label.setForeground(COLOR_WHITE);

        JButton addButton = Componets.makeButton("+", COLOR_BLACK);

        JTextField searchField = new JTextField();
        searchField.setPreferredSize(new Dimension(80, 40));

        topMenuPane.add(label);
        topMenuPane.add(addButton);
        topMenuPane.add(searchField);

        searchField.addKeyListener(new KeyAdapter () {
            @Override
            public void keyReleased (KeyEvent e) {
                tabPane.setSelectedComponent(listStickesScrollPanel);
            }

        });;

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
        return topMenuPane;
        //this.add(topMenuPane, BorderLayout.NORTH);
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

        JPanel card = Componets.card();

        JLabel nameLabel = Componets.label(sticker.getName());
        JLabel countLabel = Componets.label(String.valueOf(sticker.getQuant()));

        JButton addButton = Componets.makeButton("+", COLOR_BLACK);
        JButton removeButton = Componets.makeButton("-", COLOR_BLACK);
        JButton infoButton = Componets.makeButton("i", COLOR_BLUE);
        JButton deleteButton = Componets.makeButton("X", COLOR_RED);

        card.add(nameLabel);
        card.add(addButton);
        card.add(countLabel);
        card.add(removeButton);
        card.add(infoButton);
        card.add(deleteButton);

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
                JOptionPane.showMessageDialog(
                    null, makeInfoPanel(sticker), "Informações", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                album.getStickers().remove(sticker);
                loadStickerCards(album);
            }
        });

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
}
