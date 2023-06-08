import javax.swing.*;
import java.awt.*;

public class GameScreen extends JPanel {
    //Initializing default panel width/height.
    final int PANEL_WIDTH = 500;
    final int PANEL_HEIGHT = 500;

    //Initializing default paddle location.
    private int paddleX = 170;
    private int paddleY = 440;
    private int ballMovement = -10;
    //Initializing default ball location.
    private int ballX = 240;
    private int ballY = 415;

    /*
    private int initialBoxX = 50;
    private int initialBoxY = 60;
    private int rowDistance = 30;*/
    Image userPaddle;
    Image ball;
    /*Image blueBox;
    Image redBox;
    Image yellowBox;
    Image greenBox;*/

    GameScreen() {
        //Setting the GameScreen panel size to the values of PANEL_WIDTH, PANEL_HEIGHT;
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));

        //Assigning graphics to the game elements.
        userPaddle = new ImageIcon("Platforma.png").getImage();
        ball = new ImageIcon("ball.png").getImage();
        /*blueBox = new ImageIcon("SP_Brick_Blue.png").getImage();
        redBox = new ImageIcon("SP_Brick_Red.png").getImage();
        yellowBox = new ImageIcon("SP_Brick_Yellow.png").getImage();
        greenBox = new ImageIcon("SP_Brick_Green.png").getImage();*/
    }

    //This method will paint the required image on the GameScreen panel.
    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(userPaddle, paddleX, paddleY, null);
        g2D.drawImage(ball, ballX, ballY, null);
        /*for (int i = 0; i < 400; i += 50) {
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
        }*/
    }

    //This will set/get the paddleX position.
    public void setPaddleX(int paddleX) {
        this.paddleX = paddleX;
    }
    public int getPaddleX() {
        return paddleX;
    }

    //This will set/get the BallX position.
    public void setBallX(int ballX) { this.ballX = ballX; }
    public int getBallX() {return this.ballX; }

    //This will set/get the BallY position.
    public void setBallY(int ballY) { this.ballY = ballY; }
    public int getBallY() { return this.ballY; }

    //This will set/get ballMovement.
    public void setBallMovement(int ballMovement) { this.ballMovement = ballMovement; }
    public int getBallMovement() { return this.ballMovement; }



}
