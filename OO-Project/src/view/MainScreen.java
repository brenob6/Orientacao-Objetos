package view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.BoxLayout;

import controller.User;
import model.Album;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Class responsible for implementing the interface Config, inherits the JFRame class and makes possible the manufacture of the main screen 
 * so that the user can interact with the view through the actions provided by the panels, components and its events
 *
 */

public class MainScreen extends JFrame implements Config {

    private JPanel albunsListPanel = new JPanel();
    private JPanel titlePanel = new JPanel();
    private JScrollPane scrollPane = new JScrollPane();

    private User controller = new User();
    private JTabbedPane tabPane = new JTabbedPane();
    /**
     * Constructor responsible for instantiate the class MainScreen
     */
    public MainScreen() {
        this.setTitle(TITLENAME);
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.add(tabPane);
        albunsListPanel.setLayout(new BoxLayout(albunsListPanel, BoxLayout.Y_AXIS));
        this.scrollPane.setViewportView(albunsListPanel);;
        this.add(scrollPane);
        titlePanel(); 
        
        this.setVisible(true);
    }

    /**
     * Method responsible for setting the components and its events of a panel so that it can be shown in the main screen
     */
    private void titlePanel() {
        JLabel label = new JLabel();
        label.setText("Controle de Figurinhas");
        label.setFont(Config.FONT);
        label.setForeground(Config.COLOR_WHITE);

        JButton button = Componets.makeButton("+", COLOR_BLACK);

        button.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                showModalForm();
            }
        });
        //button.setFont(Config.FONT);

        titlePanel.setBackground(Config.COLOR_BLACK);
        titlePanel.add(label);
        titlePanel.add(button);

        this.add(titlePanel, BorderLayout.NORTH);
    }

    /**
     * Method responsible for making a modal panel and its components so that it will be possible to
     * create a new album  giving it a name 
     */
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

            Album album = controller.createAlbum(name);
            album.setAlias(alias);
            controller.addAlbum(album);

            JPanel card = makeAlbumCard(album);
            card.setMaximumSize(cardDimension);
            card.setMinimumSize(cardDimension);
            //albunsListPanel.add(makeAlbumCard(album), Box.createHorizontalBox());
            albunsListPanel.add(card);
            albunsListPanel.revalidate();
            albunsListPanel.repaint();
        }

    }

    /**
     * Method responsible for generating an update in the album's list
     */
    private void updateList () {
        albunsListPanel.removeAll();
        controller.getUserAlbuns().forEach(album -> albunsListPanel.add(makeAlbumCard(album)));
    }

    /**
     * Method responsible for creating an album card and its components 
     * @return card
     */
    public JPanel makeAlbumCard(Album album) {

        JPanel card = Componets.card();

        JLabel nameLabel = Componets.label(album.getName());

        JLabel aliasLabel = new JLabel(album.getAlias());
        aliasLabel.setFont(FONT);

        JButton deleteBtn = Componets.makeButton("X", COLOR_RED);
        JButton editBtn = Componets.makeButton("e", COLOR_YELLOW);

        editBtn.addActionListener(new ActionListener() {
        	
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
            public void actionPerformed(ActionEvent e) {
                albunsListPanel.remove(card);
                controller.removeAlbum(album);
                albunsListPanel.revalidate();
                albunsListPanel.repaint();
            }
        });

        card.addMouseListener(new MouseAdapter() {
            public void mouseEntered (MouseEvent e) {
                card.setBackground(COLOR_CREAM);
            }

            public void mouseExited (MouseEvent e) {
                card.setBackground(COLOR_WHITE);
            }
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
