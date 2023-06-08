import javax.swing.*;
import java.awt.*;

public class Block {

    int[] blockXPositions = new int[40];
    int[] blockYPositions = new int[20];
    Image blockImage;



    Block(int numberInRow, int numberInColumn, String color) {
        switch(color) {
            case "blue":
                blockImage = new ImageIcon("SP_Brick_Blue.png").getImage();
                break;
            case "red":
                blockImage = new ImageIcon("SP_Brick_Red.png").getImage();
                break;
            case "green":
                blockImage = new ImageIcon("SP_Brick_Green.png").getImage();
                break;
            case "yellow":
                blockImage = new ImageIcon("SP_Brick_Yellow.png").getImage();
        }
        int initialX = 50;
        int initialY = 60;
        this.blockXPositions[0] = initialX*numberInRow;
        for (int i = 1; i <= 40; i++) {
            blockXPositions[i] = initialX * numberInRow + i;
        }
        this.blockYPositions[0] = initialY + 30 * numberInColumn;
        for (int i = 1; i <= 20; i++) {
            blockYPositions[i] = initialY * numberInColumn + i;
        }
    }
}
