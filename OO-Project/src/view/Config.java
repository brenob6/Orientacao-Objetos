package view;

import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

/**
 * Interface responsible for having the signature of the setting's constants that will be implemented 
 * to build the screens. 
 *
 */
public interface Config {
    String TITLENAME = "Pseudo Album";

    public static int FRAME_WIDTH = 800;
    public static int FRAME_HEIGHT = 600;

    public static int MODAL_WIDTH = 400;
    public static int MODAL_HEIGHT = 300;
    int TITLE_HEIGHT = 100;

    Font FONT = new Font("monospaced", Font.BOLD, 30);

    Dimension buttonDimension = new Dimension(50, 50);
    public static Dimension cardDimension = new Dimension(800, 80);
    Dimension buttonFormDimension = new Dimension(70, 35); 
    Dimension fieldDimension = new Dimension(100, 35);

    Color BACKGROUND_COLOR = new Color(0xCFFDE1);
    Color COLOR_WHITE = new Color(0xE5E5CB);
    Color COLOR_CREAM = new Color(0xD5CEA3);
    Color COLOR_BLACK = new Color(0x1A120B);
    Color COLOR_RED = new Color(0xDC3535);
    Color COLOR_YELLOW = new Color(0xF49D1A);
    Color COLOR_BLUE = new Color(0x0081C9);
}
