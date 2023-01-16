package view;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.Album;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.ArrayList;

public class MainScreen extends JFrame implements Config{
      
    private final int WIDTH = 800;
    private final int HEIGHT = 600;

    private final String title = "Pseudo Album";

    private JPanel albunsListPanel;

    public MainScreen() {

        screenConfig();
        titlePanel(); 

        albunsListPanel = new JPanel();
        
        albunsListPanel.setBounds(0, 50, WIDTH, 500);
        albunsListPanel.setLayout(new GridLayout(6, 1, 5, 5));

        this.add((albunsListPanel));
    }

    private void titlePanel() {
        JLabel label = new JLabel();
        label.setText("Controle de Figurinhas");
        label.setFont(Config.FONT);
        label.setForeground(Config.COLOR_WHITE);

        JButton button = new JButton("+");
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setBackground(Config.COLOR_BLACK);
        button.setForeground(Config.COLOR_WHITE);
        button.setPreferredSize(Config.buttonDimension);
        button.setFont(Config.FONT);

        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(Config.COLOR_BLACK);
        titlePanel.setBounds(0, 0, WIDTH, 50);
        titlePanel.add(label);
        titlePanel.add(button);

        this.add(titlePanel);
    }

    public void makeAlbumCard(Album album) {
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, WIDTH, HEIGHT/6);
        panel.setBackground(Config.COLOR_WHITE);
        panel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                new StickerScreen(album);
            }
        });

        JLabel label = new JLabel();
        label.setBounds(0, 0, WIDTH, HEIGHT/6);
        label.setFont(Config.FONT);
        label.setText(album.getName());

        panel.add(label);
        
        albunsListPanel.add(panel);
    }

    private void removeAlbumCard(JPanel card) {
        albunsListPanel.remove(card);
    }

    private void screenConfig() {
        this.setTitle(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setSize(WIDTH, HEIGHT);
        this.setResizable(false);
        this.setLayout(null);

        this.setVisible(true);
    }
}
