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
            //If ball goes up.
            if (gameScreen.ball.getBallYMovement() < 0) {
                //If next update will put on, or beyond the top border, change Y direction.
                if (gameScreen.ball.getBallYValueAtIndex(0) + gameScreen.ball.getBallYMovement() <= 0) {
                    gameScreen.ball.changeBallYDirection();
                }
                //If next update will put us on the left/right border, or beyond the panel width, change X direction.
                if (gameScreen.ball.getBallXValueAtIndex(gameScreen.ball.getBallXPositionsLength() - 1) + gameScreen.ball.getBallXMovement() >= gameScreen.PANEL_WIDTH
                        || gameScreen.ball.getBallXValueAtIndex(0) + gameScreen.ball.getBallXMovement() <= 0) {
                    gameScreen.ball.changeBallXDirection();
                }
                gameScreen.ball.updateBall();
            }
            //If ball goes down.
            else if (gameScreen.ball.getBallYMovement() > 0) {
                if (gameScreen.ball.getBallXValueAtIndex(gameScreen.ball.getBallXPositionsLength() - 1) + gameScreen.ball.getBallXMovement() >= gameScreen.PANEL_WIDTH
                        || gameScreen.ball.getBallXValueAtIndex(0) + gameScreen.ball.getBallXMovement() <= 0) {
                    gameScreen.ball.changeBallXDirection();
                }
                //If lowest ball pixel is on the Y level of the paddle, check if they are overlapping, and if they are, reflect the ball on both axis.
                if (gameScreen.ball.getBallYValueAtIndex(gameScreen.ball.getBallYPositionsLength() - 1) == gameScreen.playerPaddle.getPaddleY()) {
                    outerLoop:
                    for (int i = 0; i < gameScreen.ball.getBallXPositionsLength(); i++) {
                        for (int j = 0; j < gameScreen.playerPaddle.getPaddleLength(); j++) {
                            //If ball is in fact overlapping with the paddle:
                            if (gameScreen.ball.getBallXValueAtIndex(i) == gameScreen.playerPaddle.getPaddlePositionAtIndex(j)) {
                                //Divide the paddle into 5 parts:
                                int centralPart = 0;
                                int innerLeftPart = 0;
                                int innerRightPart = 0;
                                int outermostLeftPart = 0;
                                int outermostRightPart = 0;
                                /*Every overlapping pixel is checked to see which part of the paddle it overlaps with.
                                * The amount of pixels touching each part is counted, and added to the integers above.*/
                                for (int k = 0; k < gameScreen.ball.getBallXPositionsLength(); k++) {
                                    for (int l = 0; l < gameScreen.playerPaddle.getPaddleLength(); l++) {
                                        if (gameScreen.ball.getBallXValueAtIndex(k) >= gameScreen.playerPaddle.getPaddlePositionAtIndex(0)
                                        && gameScreen.ball.getBallXValueAtIndex(k) < gameScreen.playerPaddle.getPaddlePositionAtIndex(19)) {
                                            outermostLeftPart++;
                                        }
                                        else if (gameScreen.ball.getBallXValueAtIndex(k) >= gameScreen.playerPaddle.getPaddlePositionAtIndex(19)
                                        && gameScreen.ball.getBallXValueAtIndex(k) < gameScreen.playerPaddle.getPaddlePositionAtIndex(70)) {
                                            innerLeftPart++;
                                        }
                                        else if(gameScreen.ball.getBallXValueAtIndex(k) >= gameScreen.playerPaddle.getPaddlePositionAtIndex(70)
                                        && gameScreen.ball.getBallXValueAtIndex(k) < gameScreen.playerPaddle.getPaddlePositionAtIndex(91)) {
                                            centralPart++;
                                        }
                                        else if(gameScreen.ball.getBallXValueAtIndex(k) >= gameScreen.playerPaddle.getPaddlePositionAtIndex(91)
                                        && gameScreen.ball.getBallXValueAtIndex(k) < gameScreen.playerPaddle.getPaddlePositionAtIndex(141)) {
                                            innerRightPart++;
                                        }
                                        else if(gameScreen.ball.getBallXValueAtIndex(k) >= gameScreen.playerPaddle.getPaddlePositionAtIndex(141)
                                        && gameScreen.ball.getBallXValueAtIndex(k) < gameScreen.playerPaddle.getPaddlePositionAtIndex(160)) {
                                            outermostRightPart++;
                                        }
                                    }
                                }
                                //Check which part of the paddle overlaps with most pixels of the ball, and assign this value to maximum variable.
                                int[] paddleParts = {outermostLeftPart, innerLeftPart, centralPart, innerRightPart, outermostRightPart};
                                //Integer to check which part of the paddle will dictate the ball X direction.
                                int maximum = 0;
                                for (int m = 0; m < paddleParts.length; m++) {
                                    if (paddleParts[m] > maximum) {
                                        maximum = paddleParts[m];
                                    }
                                }
                                /*int centralPart = 0;
                                int innerLeftPart = 0;
                                int innerRightPart = 0;
                                int outermostLeftPart = 0;
                                int outermostRightPart = 0;*/
                                System.out.println("Maximum wynosi: " + maximum);
                                for (int z = 0; z < paddleParts.length; z++) {
                                    System.out.println("paddleParts: " + (z+1) + " wynosi: " + paddleParts[z]);
                                }
                                System.out.println("centralPart wynosi: " + centralPart);
                                System.out.println("innerLeftPart wynosi: " + innerLeftPart);
                                System.out.println("innerRightPart wynosi: " + innerRightPart);
                                System.out.println("outermostLeftPart wynosi: " + outermostLeftPart);
                                System.out.println("outermostRightPart wynosi: " + outermostRightPart);

                                //Check which part of the paddle received most overlaps and set the ballXMovement according to that.
                                if (maximum == centralPart) {
                                    gameScreen.ball.setBallXMovement(0);
                                } else if (maximum == outermostLeftPart) {
                                    gameScreen.ball.setBallXMovement(-2);
                                } else if (maximum == outermostRightPart) {
                                    gameScreen.ball.setBallXMovement(2);
                                } else if (maximum == innerLeftPart) {
                                    gameScreen.ball.setBallXMovement(-1);
                                } else if (maximum == innerRightPart) {
                                    gameScreen.ball.setBallXMovement(1);
                                }
                                gameScreen.ball.changeBallYDirection();
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
