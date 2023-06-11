import javax.swing.*;
import java.awt.*;

public class Paddle {
    private int paddleX = 170;
    final private int paddleY = 440;
    private int[] paddleXPositions = new int[161];
    private int paddleMovement = -15;
    Image paddleImage;

    Paddle() {
         paddleImage = new ImageIcon("Platforma.png").getImage();
         //Filling the paddleX taken pixels array;
         for (int i = 0; i < 161; i++) {
             paddleXPositions[i] = getPaddleX() + i;
         }

    }

    //This will set/get the paddleX position.
    public void setPaddleX(int paddleX) {
        this.paddleX = paddleX;
    }
    public int getPaddleX() { return this.paddleX; }
    //This will get us the paddle image.
    public Image getPaddleImage() { return this.paddleImage; }

    //This will get us paddleY, no setter, no need for one.
    public int getPaddleY() { return this.paddleY; }

    //This will set/get PaddleMovement.
    public int getPaddleMovement() { return this.paddleMovement; }
    public void setPaddleMovementLeft() { this.paddleMovement = -15; }
    public void setPaddleMovementRight() { this.paddleMovement = 15; }

    //This will update the array of pixels taken by paddle at any time.
    public void updatePaddlePosition() {
        for (int i = 0; i < paddleXPositions.length; i++) {
            paddleXPositions[i] = paddleXPositions[i] + paddleMovement;
        }
    }
    //This will return the length of an array of pixels taken by the paddle.
    public int getPaddleLength() { return this.paddleXPositions.length; }
    //This will return pixel at expected index of a pixel array.
    public int getPaddlePositionAtIndex(int index) { return this.paddleXPositions[index]; }
}
