import javax.swing.*;
import java.awt.*;

public class Ball {
    //Initializing variables responsible for ball's movement.
    private int ballXMovement = 0;
    private int ballYMovement = -1;

    //Initializing ball collision arrays.
    private int[] ballXPositions = new int[25];
    private int[] ballYPositions = new int[25];

    //Initializing default ball location.
    final private int ballX = 240;
    final private int ballY = 415;
    //Declaring ball's image.
    Image ballImage;

    Ball() {
        ballImage = new ImageIcon("ball.png").getImage();
        //Initial X positions of the ball
        for (int i = 0; i < 25; i++) {
            ballXPositions[i] = ballX + i;
        }
        for (int i = 0; i < 25; i++) {
            ballYPositions[i] = ballY + i;
        }
    }

    //This will set/get ballYMovement.
    public void setBallYMovement(int ballYMovement) {
        this.ballYMovement = ballYMovement;
    }

    //This will return the amount of pixels the ball will move.
    public int getBallYMovement() {
        return this.ballYMovement;
    }

    //This will change ball's vertical direction.
    public void changeBallYDirection() {
        this.ballYMovement = this.ballYMovement * -1;
    }

    //This will set/get ballXMovement
    public void setBallXMovement(int ballXMovement) {
        this.ballXMovement = ballXMovement;
    }

    public int getBallXMovement() {
        return this.ballXMovement;
    }

    public void updateBall() {
        for (int i = 0; i < ballYPositions.length; i++) {
            ballYPositions[i] = ballYPositions[i] + ballYMovement;
        }
        for (int i = 0; i < ballXPositions.length; i++) {
            ballXPositions[i] = ballXPositions[i] + ballXMovement;
        }
    }

    //This will return the pixel value at a required index from ballY/XPositions arrays.
    public int getBallYValueAtIndex(int index) {
        return this.ballYPositions[index];
    }
    public int getBallXValueAtIndex(int index) {
        return this.ballXPositions[index];
    }

    //This will return the lengths of respective BallX and BallYPositions arrays.
    public int getBallXPositionsLength() {
        return this.ballXPositions.length;
    }
    public int getBallYPositionsLength() {
        return this.ballYPositions.length;
    }
}
