import javax.swing.*;
import java.awt.*;

public class GameScreen extends JPanel {
    //Initializing default panel width/height.
    final int PANEL_WIDTH = 500;
    final int PANEL_HEIGHT = 500;

    //Declarations for the game
    Paddle playerPaddle;
    Ball ball;
    private int initialBoxX = 50;
    private int initialBoxY = 60;
    private int rowDistance = 30;
    Image blueBox;
    Image redBox;
    Image yellowBox;
    Image greenBox;

    GameScreen() {
        //Setting the GameScreen panel size to the values of PANEL_WIDTH, PANEL_HEIGHT;
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));

        //Instantiating game structures.
        this.playerPaddle = new Paddle();
        this.ball = new Ball();

        //Assigning graphics to the game elements.
        blueBox = new ImageIcon("SP_Brick_Blue.png").getImage();
        redBox = new ImageIcon("SP_Brick_Red.png").getImage();
        yellowBox = new ImageIcon("SP_Brick_Yellow.png").getImage();
        greenBox = new ImageIcon("SP_Brick_Green.png").getImage();
    }

    //This method will paint the required image on the GameScreen panel.
    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(playerPaddle.getPaddleImage(), playerPaddle.getPaddleX(), playerPaddle.getPaddleY(), null);
        g2D.drawImage(ball.ballImage, ball.getBallX(), ball.getBallY(), null);
        for (int i = 0; i < 400; i += 50) {
            g2D.drawImage(blueBox, initialBoxX + i, initialBoxY, null);
        }
        for (int i = 0; i < 400; i += 50) {
            g2D.drawImage(redBox, initialBoxX + i, initialBoxY + rowDistance, null);
        }

        for (int i = 0; i < 400; i += 50) {
            g2D.drawImage(yellowBox, initialBoxX + i, initialBoxY + rowDistance * 2, null);
        }
        for (int i = 0; i < 400; i += 50) {
            g2D.drawImage(greenBox, initialBoxX + i, initialBoxY + rowDistance * 3, null);
        }
    }
}
