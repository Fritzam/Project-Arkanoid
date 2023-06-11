import javax.swing.*;
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
            if (gameScreen.playerPaddle.getPaddleX() + gameScreen.playerPaddle.getPaddleMovement() > 0) {
                gameScreen.playerPaddle.setPaddleMovementLeft();
                gameScreen.playerPaddle.setPaddleX(gameScreen.playerPaddle.getPaddleX() + gameScreen.playerPaddle.getPaddleMovement());
                gameScreen.playerPaddle.updatePaddlePosition();
                frame.repaint();
                frame.revalidate();
            }
        }
    }

    public class moveRight extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (gameScreen.playerPaddle.getPaddleX() + gameScreen.playerPaddle.getPaddleMovement() < gameScreen.PANEL_WIDTH - 160) {
                gameScreen.playerPaddle.setPaddleMovementRight();
                gameScreen.playerPaddle.setPaddleX(gameScreen.playerPaddle.getPaddleX() + gameScreen.playerPaddle.getPaddleMovement());
                gameScreen.playerPaddle.updatePaddlePosition();
                frame.repaint();
                frame.revalidate();
            }
        }
    }

    public class ballMovement extends AbstractAction {
        Timer timer = new Timer(1, this::actionPerformed);
        @Override
        public void actionPerformed(ActionEvent e) {
            timer.setRepeats(true);
            timer.start();
            if (gameScreen.ball.getBallYMovement() < 0) {
                if (gameScreen.ball.getBallYValueAtIndex(0) + gameScreen.ball.getBallYMovement() > 0) {
                    gameScreen.ball.updateBall();
                } else {
                    gameScreen.ball.changeBallYDirection();
                    gameScreen.ball.updateBall();
                }
            } else if (gameScreen.ball.getBallYMovement() > 0) {
                if (gameScreen.ball.getBallYValueAtIndex(gameScreen.ball.getBallYPositionsLength() - 1) == gameScreen.playerPaddle.getPaddleY()) {
                    outerLoop:
                    for (int i = 0; i < gameScreen.ball.getBallXPositionsLength(); i++) {
                        for (int j = 0; j < gameScreen.playerPaddle.getPaddleLength(); j++) {
                            if (gameScreen.ball.getBallXValueAtIndex(i) == gameScreen.playerPaddle.getPaddlePositionAtIndex(j)) {
                                gameScreen.ball.changeBallYDirection();
                                gameScreen.ball.updateBall();
                                break outerLoop;
                            }
                        }
                    }
                    gameScreen.ball.updateBall();
                } if (gameScreen.ball.getBallYValueAtIndex(gameScreen.ball.getBallYPositionsLength() - 1) + gameScreen.ball.getBallYMovement() >= gameScreen.PANEL_HEIGHT - 24) {
                    gameScreen.ball.changeBallYDirection();
                    gameScreen.ball.updateBall();
                } else {
                    gameScreen.ball.updateBall();
                }
            }
           frame.repaint();
           frame.revalidate();
        }
    }
}
