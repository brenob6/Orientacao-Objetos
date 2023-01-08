package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


import model.Album;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.ArrayList;

public class MainScreen extends JFrame {
      
    private final int WIDTH = 800;
    private final int HEIGHT = 600;

    private final String title = "Pseudo Album";

    private ArrayList<JPanel> albunsPanel = new ArrayList<JPanel>();

    public MainScreen() {
        
        titlePanel(); 
        screenConfig();
    }

    private void titlePanel() {
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(Color.RED);
        titlePanel.setBounds(0, 0, WIDTH, 100);
        this.add(titlePanel);
    }

    public void updateAlbumListPanel() {
        JPanel panel = new JPanel();
        panel.setBounds(0, 100, WIDTH, 700);
        panel.setLayout(new GridLayout(9, 1, 10, 10));
        panel.setBackground(Color.BLUE);

        albunsPanel.forEach((albumPanel) -> {
            panel.add(albumPanel);
        });

        this.add(panel);
    }

    public void createAlbumCard(Album album) {
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, WIDTH, HEIGHT/6);
        panel.setBackground(Color.GREEN);
        panel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                System.out.println(album.getAlias());
            }
        });

        JLabel label = new JLabel();
        label.setBounds(0, 0, WIDTH, HEIGHT/6);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setText(album.getName());

        panel.add(label);
        albunsPanel.add(panel);

        updateAlbumListPanel();
    }

    private void screenConfig() {
        this.setTitle(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WIDTH, HEIGHT);
        this.setResizable(false);
        this.setLayout(null);

        this.setVisible(true);
    }
}
