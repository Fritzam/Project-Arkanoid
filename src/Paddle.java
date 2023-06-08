import javax.swing.*;
import java.awt.*;

public class Paddle {
    private int paddleX = 170;
    final private int paddleY = 440;
    Image paddleImage;

    Paddle() {
         paddleImage = new ImageIcon("Platforma.png").getImage();
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
}
