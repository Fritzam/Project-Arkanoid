import javax.swing.*;
import java.awt.*;

class GameScreen extends JPanel {
    final int PANEL_WIDTH = 500;
    final int PANEL_HEIGHT = 500;
    private int paddleX = 170;
    private int paddleY = 440;
    private Image userPaddle;

    GameScreen() {
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        userPaddle = new ImageIcon("Platforma.png").getImage();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(userPaddle, paddleX, paddleY, null);
    }

    public void setPaddleX(int paddleX) {
        this.paddleX = paddleX;
    }

    public int getPaddleX() {
        return paddleX;
    }
}