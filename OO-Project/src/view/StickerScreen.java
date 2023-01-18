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
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.Album;
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

    public StickerScreen(Album album) {
        this.setTitle("Pseudo Album");
        this.setSize(Config.FRAME_WIDTH, Config.FRAME_HEIGHT);
        this.setLayout(new BorderLayout());
        this.setResizable(true);

        this.add(tabPane);
        //listStickesPanel.setAutoscrolls(true);

        titlePanel(album.getName());

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

        JLabel label = new JLabel(title);
        label.setFont(Config.FONT);
        label.setForeground(Config.COLOR_WHITE);

        topMenuPane.add(label);
        this.add(topMenuPane, BorderLayout.NORTH);
    }

    private void updateStickerCards(Album album) {
            
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
        card.setPreferredSize(Config.carDimension);
        card.setBackground(Config.COLOR_WHITE);

        JLabel countLabel = new JLabel(String.valueOf(sticker.getQuant()));
        countLabel.setFont(Config.FONT);

        JButton addButton = makeButton("+");
        JButton removeButton = makeButton("-");
        JButton infoButton = makeButton("i");

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
                    //null, null, sticker.getName(), 1, sticker.getImage());
                    null, makeInfoPanel(sticker), "Informações", JOptionPane.INFORMATION_MESSAGE);
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
