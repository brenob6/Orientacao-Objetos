package view;

import java.awt.Font;
import java.awt.Color;

public interface Config {
    int FRAME_WIDTH = 800;
    int FRAME_HEIGHT = 600;

    int TITLE_HEIGHT = 100;

    Font FONT = new Font("monospaced", Font.BOLD, 30);

    Color BACKGROUND_COLOR = new Color(0xCFFDE1);
    Color COLOR_WHITE = new Color(0xE5E5CB);
    Color COLOR_BLACK = new Color(0x1A120B);
}
