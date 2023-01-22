package view;

import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

public interface Config {
    String TITLENAME = "Pseudo Album";

    int FRAME_WIDTH = 800;
    int FRAME_HEIGHT = 600;

    int MODAL_WIDTH = 400;
    int MODAL_HEIGHT = 300;
    int TITLE_HEIGHT = 100;

    Font FONT = new Font("monospaced", Font.BOLD, 30);

    Dimension buttonDimension = new Dimension(50, 50);
    Dimension cardDimension = new Dimension(800, 80);
    Dimension buttonFormDimension = new Dimension(70, 35); 
    Dimension fieldDimension = new Dimension(100, 35);

    Color BACKGROUND_COLOR = new Color(0xCFFDE1);
    Color COLOR_WHITE = new Color(0xE5E5CB);
    Color COLOR_BLACK = new Color(0x1A120B);
}
