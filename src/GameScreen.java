import javax.swing.*;
import java.awt.*;

public class GameScreen extends JPanel {
    final int PANEL_WIDTH = 500;
    final int PANEL_HEIGHT = 500;
    Image userPaddle;

    GameScreen() {
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        userPaddle = new ImageIcon("Platforma.png").getImage();


    }

}
