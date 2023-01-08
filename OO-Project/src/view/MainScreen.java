package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;

public class MainScreen extends JFrame {
      
    private final int WIDTH = 800;
    private final int HEIGHT = 600;

    private final String title = "Pseudo Album";

    public MainScreen() {
        
        titlePanel(); 
        albumListPanel();
        screenConfig();
    }

    private void titlePanel() {
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(Color.RED);
        titlePanel.setBounds(0, 0, WIDTH, 100);
        this.add(titlePanel);
    }

    private void albumListPanel() {
        JPanel panel = new JPanel();
        panel.setBounds(0, 100, WIDTH, 700);
        panel.setBackground(Color.BLUE);
        this.add(panel);
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
