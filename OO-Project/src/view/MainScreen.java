package view;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneLayout;
import javax.swing.BoxLayout;

import controller.User;
import model.Album;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Container;

import java.util.ArrayList;

public class MainScreen extends JFrame implements Config {

    private int y = 100;

    private JPanel albunsListPanel = new JPanel();
    private JPanel titlePanel = new JPanel();

    private User controller = new User();
    private JTabbedPane tabPane = new JTabbedPane();
    
    public MainScreen() {
        this.setTitle(TITLENAME);
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setLayout(new BorderLayout());
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.add(tabPane);
        titlePanel(); 
        
        tabPane.add("Meus Albuns", albunsListPanel);

        this.setVisible(true);
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
        button.setName("addAlbum");

        button.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                showModalForm();
            }
        });   button.setFont(Config.FONT);

        titlePanel.setBackground(Config.COLOR_BLACK);
        titlePanel.setBounds(0, 0, WIDTH, 50);
        titlePanel.add(label);
        titlePanel.add(button);

        this.add(titlePanel, BorderLayout.NORTH);
    }

    private void showModalForm () {
        String[] items = {"Heróis DC", "Copa do Mundo"};
        JComboBox<String> combo = new JComboBox<>(items);
        JTextField field = new JTextField();

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(combo);
        panel.add(new JLabel("Nome:"));
        panel.add(field);

        int result = JOptionPane.showConfirmDialog(null, panel, "Adicionar Album",
            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            String name = (String) combo.getSelectedItem(); 
            String alias = field.getText();

            Album album = controller.findAlbum(name);
            album.setAlias(alias);
            controller.addAlbum(album);
            //updateList();
            albunsListPanel.add(makeAlbumCard(album));
            albunsListPanel.revalidate();
            albunsListPanel.repaint();
        }

    }

    private void updateList () {
        albunsListPanel.removeAll();
        controller.getUserAlbuns().forEach(album -> albunsListPanel.add(makeAlbumCard(album)));
    }

    public JPanel makeAlbumCard(Album album) {
        JPanel card = new JPanel();
        card.setPreferredSize(cardDimension);
        card.setBackground(COLOR_WHITE);

        JLabel nameLabel = new JLabel(album.getName());
        nameLabel.setFont(Config.FONT);

        JLabel aliasLabel = new JLabel(album.getAlias());
        aliasLabel.setFont(FONT);

        JButton deleteBtn = Componets.makeButton("X");
        JButton editBtn = Componets.makeButton("e");
        editBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JTextField editField = new JTextField();

                JPanel panel = new JPanel(new GridLayout(0, 1));
                panel.add(new JLabel("Novo apelido:"));
                panel.add(editField);

                int result = JOptionPane.showConfirmDialog(null, panel, "Adicionar Album",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                if (result == JOptionPane.OK_OPTION) {
                    album.setAlias(editField.getText());
                    aliasLabel.setText(album.getAlias());
                }
            }
        });
        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                albunsListPanel.remove(card);
                controller.removeAlbum(album);
                albunsListPanel.revalidate();
                albunsListPanel.repaint();
            }
        });

        card.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                new StickerScreen(album);
            }
        });

        card.add(nameLabel);
        card.add(aliasLabel);
        card.add(editBtn);
        card.add(deleteBtn);

        return card; 
    }

}
