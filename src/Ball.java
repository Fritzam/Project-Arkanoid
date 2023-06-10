import javax.swing.*;
import java.awt.*;

public class Ball {
    //Initializing variables responsible for ball's movement.
    private int ballXMovement = 0;
    private int ballYMovement = -1;

    //Initializing ball collision arrays.
    int[] ballXPositions = new int[25];
    int[] ballYPositions = new int[25];

    //Initializing default ball location.
    private int ballX = 240;
    private int ballY = 415;
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

    //This will set/get the BallX position.
    public void setBallX(int ballX) {
        this.ballX = ballX;
    }

    public int getBallX() {
        return this.ballX;
    }

    //This will set/get the BallY position.
    public void setBallY(int ballY) {
        this.ballY = ballY;
    }

    public int getBallY() {
        return this.ballY;
    }

    //This will set/get ballYMovement.
    public void setBallYMovement(int ballYMovement) {
        this.ballYMovement = ballYMovement;
    }

    public int getBallYMovement() {
        return this.ballYMovement;
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
}
