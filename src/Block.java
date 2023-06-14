import javax.swing.*;
import java.awt.*;

public class Block {

    //Arrays of pixels taken by the blocks.
    int[] blockXPositions = new int[41];
    int[] blockYPositions = new int[21];
    Image blockImage;



    Block(int numberInRow, int numberInColumn, String color) {
        switch (color) {
            case "blue" -> blockImage = new ImageIcon("SP_Brick_Blue.png").getImage();
            case "red" -> blockImage = new ImageIcon("SP_Brick_Red.png").getImage();
            case "green" -> blockImage = new ImageIcon("SP_Brick_Green.png").getImage();
            case "yellow" -> blockImage = new ImageIcon("SP_Brick_Yellow.png").getImage();
        }

        //Initial positions
        int initialX = 50;
        int initialY = 60;
        for (int i = 0; i < 41; i++) {
            blockXPositions[i] = initialX * numberInRow + i;
        }
        for (int i = 0; i < 21; i++) {
            blockYPositions[i] = initialY + (numberInColumn - 1) * 30 + i;
        }
    }
}
