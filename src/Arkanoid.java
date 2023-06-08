import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Arkanoid {

    Action moveLeft;
    Action moveRight;
    Action gameStart;
    Action ballMovement;


    JFrame frame = new Frame();
    JLabel mainScreen = new MainScreen();
    GameScreen gameScreen = new GameScreen();
    Arkanoid() {
        //Initializing gameStart() class.
        //gameStart = new gameStart();

        //Making the frame window(game window) visible, and adding main screen panel to it.
        frame.setVisible(true);
        frame.add(gameScreen);

        //Mapping the SpaceBar key to mainScreen label.
        /*mainScreen.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "Start");
        mainScreen.getActionMap().put("Start", gameStart);*/

        //Initializing game control function;
        moveLeft = new moveLeft();
        moveRight = new moveRight();
        ballMovement = new ballMovement();

        //Adding key mapping.
        gameScreen.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "Left");
        gameScreen.getActionMap().put("Left", moveLeft);

        gameScreen.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "Right");
        gameScreen.getActionMap().put("Right", moveRight);

        gameScreen.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "Move");
        gameScreen.getActionMap().put("Move", ballMovement);


    }

    /*public class gameStart extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            //Get content of the frame and remove it all, update, add new label to the frame, update.
            System.out.println("It works!");
            frame.getContentPane().removeAll();
            frame.add(gameScreen);
            frame.repaint();
            frame.revalidate();
        }
    }
    */

    public class moveLeft extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            gameScreen.playerPaddle.setPaddleX(gameScreen.playerPaddle.getPaddleX() - 15);
            frame.repaint();
            frame.revalidate();
        }
    }

    public class moveRight extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            gameScreen.playerPaddle.setPaddleX(gameScreen.playerPaddle.getPaddleX() + 15);
            frame.repaint();
            frame.revalidate();
        }
    }

    public class ballMovement extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
           if (gameScreen.ball.getBallMovement() < 0) {
               if (gameScreen.ball.getBallY() + gameScreen.ball.getBallMovement() <= 0) {
                   gameScreen.ball.setBallMovement(gameScreen.ball.getBallMovement() * -1);
               } else {
                   gameScreen.ball.setBallY(gameScreen.ball.getBallY() + gameScreen.ball.getBallMovement());
               }
           } else if (gameScreen.ball.getBallMovement() > 0) {
               if (gameScreen.ball.getBallY() + gameScreen.ball.getBallMovement() >= gameScreen.PANEL_HEIGHT - 50) {
                   gameScreen.ball.setBallMovement(gameScreen.ball.getBallMovement() * -1);
               } else {
                   gameScreen.ball.setBallY(gameScreen.ball.getBallY() + gameScreen.ball.getBallMovement());
               }
           }
           frame.repaint();
           frame.revalidate();
        }
    }
}
