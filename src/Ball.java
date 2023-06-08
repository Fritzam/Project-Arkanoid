import javax.swing.*;
import java.awt.*;

public class Ball {
    //Initializing variable responsible for ball's movement.
    private int ballMovement = -10;

    //Initializing default ball location.
    private int ballX = 240;
    private int ballY = 415;
    //Declaring ball's image.
    Image ballImage;
    Ball() {
        ballImage = new ImageIcon("ball.png").getImage();
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
