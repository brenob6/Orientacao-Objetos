package view;

import javax.swing.JButton;
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
    private final Font FONT = new Font("Arial", Font.BOLD, 20);

    private final String title = "Pseudo Album";

    private JPanel albunsListPanel;
    
    //private ArrayList<JPanel> albunsPanel = new ArrayList<JPanel>();

    public MainScreen() {

        screenConfig();
        titlePanel(); 

        albunsListPanel = new JPanel();
        
        albunsListPanel.setBounds(0, 50, WIDTH, 500);
        albunsListPanel.setLayout(new GridLayout(6, 1, 5, 5));

        this.add(albunsListPanel);
    }

    private void titlePanel() {
        JLabel label = new JLabel();
        label.setText("Controle de Figurinhas");
        label.setFont(FONT);

        JButton button = new JButton();
        button.setFont(FONT);
        button.setText("+");

        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(Color.RED);
        titlePanel.setBounds(0, 0, WIDTH, 50);
        titlePanel.add(label);
        titlePanel.add(button);

        this.add(titlePanel);
    }

    //public void updateAlbumListPanel() {
    //    albunsPanel.forEach((albumPanel) -> {
    //        albunsListPanel.add(albumPanel);
    //    });
    //}

    public void createAlbumCard(Album album) {
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, WIDTH, HEIGHT/6);
        panel.setBackground(Color.GREEN);
        panel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                new StickerScreen();
            }
        });

        JLabel label = new JLabel();
        label.setBounds(0, 0, WIDTH, HEIGHT/6);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setText(album.getName());

        panel.add(label);

        albunsListPanel.add(panel);
       // albunsPanel.add(panel);

        //updateAlbumListPanel();
    }

    public void removeAlbumCard(Album album) {
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
