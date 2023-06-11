import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameScreen extends JPanel {
    //Initializing default panel width/height.
    final int PANEL_WIDTH = 500;
    final int PANEL_HEIGHT = 500;

    //Declarations for the game
    Paddle playerPaddle;
    Ball ball;

    //Arrays containing rows of block objects.
    ArrayList<Block> blueBlocks = new ArrayList<Block>();
    ArrayList<Block> redBlocks = new ArrayList<Block>();
    ArrayList<Block> yellowBlocks = new ArrayList<Block>();
    ArrayList<Block> greenBlocks = new ArrayList<Block>();

    GameScreen() {
        //Setting the GameScreen panel size to the values of PANEL_WIDTH, PANEL_HEIGHT;
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));

        //Instantiating game structures.
        this.playerPaddle = new Paddle();
        this.ball = new Ball();

        //Instantiating the blocks.
        for (int i = 1; i <= 8; i++) {
            blueBlocks.add(new Block(i, 1, "blue"));
            redBlocks.add(new Block(i, 2, "red"));
            yellowBlocks.add(new Block(i, 3, "yellow"));
            greenBlocks.add(new Block(i, 4, "green"));
        }
    }

    //This method will paint the required image on the GameScreen panel.
    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        //Draw paddle.
        g2D.drawImage(playerPaddle.getPaddleImage(), playerPaddle.getPaddleX(), playerPaddle.getPaddleY(), null);
        //Draw ball.
        g2D.drawImage(ball.ballImage, ball.getBallXValueAtIndex(0), ball.getBallYValueAtIndex(0), null);
        //Draw blocks.
        for (int i = 0; i < 8; i++) {
            g2D.drawImage(blueBlocks.get(i).blockImage, blueBlocks.get(i).blockXPositions[0], blueBlocks.get(i).blockYPositions[0], null);
            g2D.drawImage(redBlocks.get(i).blockImage, redBlocks.get(i).blockXPositions[0], redBlocks.get(i).blockYPositions[0], null);
            g2D.drawImage(yellowBlocks.get(i).blockImage, yellowBlocks.get(i).blockXPositions[0], yellowBlocks.get(i).blockYPositions[0], null);
            g2D.drawImage(greenBlocks.get(i).blockImage, greenBlocks.get(i).blockXPositions[0], greenBlocks.get(i).blockYPositions[0], null);
        }

    }
}
