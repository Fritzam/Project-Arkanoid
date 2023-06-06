import javax.swing.*;
import java.awt.*;

public class GameScreen extends JPanel {
    //Initializing default panel width/height.
    final int PANEL_WIDTH = 500;
    final int PANEL_HEIGHT = 500;

    //Initializing default paddle settings.
    private int paddleX = 170;
    private int paddleY = 440;
    Image userPaddle;

    GameScreen() {
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        userPaddle = new ImageIcon("Platforma.png").getImage();
    }

    //This method will paint the required image on the GameScreen panel.
    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(userPaddle, paddleX, paddleY, null);
    }

    //This will set/get the paddleX position.
    public void setPaddleX(int paddleX) {
        this.paddleX = paddleX;
    }
    public int getPaddleX() {
        return paddleX;
    }

}
