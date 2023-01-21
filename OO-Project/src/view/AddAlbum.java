package view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddAlbum extends JFrame implements Config, ActionListener {

    private JButton createButton;
    private JButton cancelButton;

    private JTextField textField;
    private JComboBox combo;

    public AddAlbum(){
        this.setTitle("Criar Album");
        this.setSize(MODAL_WIDTH, MODAL_HEIGHT);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        this.setVisible(true);

        makeAlbumForm();
    }

    private void makeAlbumForm() {

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 50));

        JLabel label1 = new JLabel("Nome");
        JLabel label2 = new JLabel("Selecione o Album:");

        createButton = Componets.makeButton("Criar");
        cancelButton = Componets.makeButton("Cancelar");
        createButton.addActionListener(this);
        cancelButton.addActionListener(this);

        textField = new JTextField();

        String[] options = {"Heróis DC", "Copa do Mundo"};
        combo = new JComboBox<String>(options);
        combo.setBounds(50, 30, 150, 40);

        panel.add(label1);
        panel.add(textField);
        panel.add(label2);
        panel.add(combo);
        panel.add(createButton);
        panel.add(cancelButton);
        this.add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        if(src.equals(cancelButton)) {
            this.setVisible(false);
        }

        if(src == createButton) {
            String name = textField.getText();
            String seleted = (String) combo.getSelectedItem();
        }
    }
}
