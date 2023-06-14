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
        gameStart = new gameStart();

        //Making the frame window(game window) visible, and adding main screen panel to it.
        frame.setVisible(false);
        frame.add(mainScreen);
        frame.setVisible(true);

        //Mapping the SpaceBar key to mainScreen label.
        mainScreen.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "Start");
        mainScreen.getActionMap().put("Start", gameStart);

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

    public class gameStart extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            //Get content of the frame and remove it all, update, add new label to the frame, update.
            frame.setVisible(false);
            frame.getContentPane().removeAll();
            frame.add(gameScreen);
            frame.setVisible(true);
            frame.repaint();
            frame.revalidate();
        }
    }


    //This class moves our paddle left (towards gameScreen.WIDTH == 0).
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

    //This class moves our paddle right (towards gameScreen.WIDTH)
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

    //This class is responsible for moving the ball, and handling every possible situation on it's path.
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
                //If particular color of blocks is still present on the map: green
                if (gameScreen.greenBlocks.size() > 0) {
                    //If BallY position is equal to the lowest BlockY position:
                    if (gameScreen.ball.getBallYValueAtIndex(0) == 170
                            || gameScreen.ball.getBallYValueAtIndex(24) == 150) {
                        boolean changeDirection = false;
                        for (int i = 0; i < gameScreen.greenBlocks.size(); i++) {
                            boolean removed = false;
                            for (int j = 0; j < gameScreen.greenBlocks.get(i).blockXPositions.length - 1; j++) {
                                for (int k = 0; k < gameScreen.ball.getBallXPositionsLength(); k++) {
                                    if (gameScreen.ball.getBallXValueAtIndex(k) == gameScreen.greenBlocks.get(i).blockXPositions[j]) {
                                        removed = true;
                                        changeDirection = true;
                                    }
                                }
                            }
                            if (removed == true) {
                                gameScreen.greenBlocks.remove(i);
                            }
                        }
                        //If any block was removed, change the directions on the ball's Y axis.
                        if (changeDirection) {
                            gameScreen.ball.changeBallYDirection();
                        }
                        //if (gameScreen.ball.getBallXValueAtIndex())
                    }
                }
                //If yellowBlocks are still present on the map:
                if (gameScreen.yellowBlocks.size() > 0) {
                    //If BallY position is equal to the lowest BlockY position:
                    if (gameScreen.ball.getBallYValueAtIndex(0) == 140
                            || gameScreen.ball.getBallYValueAtIndex(24) == 110) {
                        boolean changeDirection = false;
                        for (int i = 0; i < gameScreen.yellowBlocks.size(); i++) {
                            boolean removed = false;
                            for (int j = 0; j < gameScreen.yellowBlocks.get(i).blockXPositions.length - 1; j++) {
                                for (int k = 0; k < gameScreen.ball.getBallXPositionsLength(); k++) {
                                    if (gameScreen.ball.getBallXValueAtIndex(k) == gameScreen.yellowBlocks.get(i).blockXPositions[j]) {
                                        removed = true;
                                        changeDirection = true;
                                    }
                                }
                            }
                            if (removed == true) {
                                gameScreen.yellowBlocks.remove(i);
                            }
                        }
                        //If any block was removed, change the directions on the ball's Y axis.
                        if (changeDirection) {
                            gameScreen.ball.changeBallYDirection();
                        }
                    }
                }
                //If redBlocks are still present on the map:
                if (gameScreen.redBlocks.size() > 0) {
                    //If BallY position is equal to the lowest BlockY position:
                    if (gameScreen.ball.getBallYValueAtIndex(0) == 105
                            || gameScreen.ball.getBallYValueAtIndex(24) == 75) {
                        boolean changeDirection = false;
                        for (int i = 0; i < gameScreen.redBlocks.size(); i++) {
                            boolean removed = false;
                            for (int j = 0; j < gameScreen.redBlocks.get(i).blockXPositions.length - 1; j++) {
                                for (int k = 0; k < gameScreen.ball.getBallXPositionsLength(); k++) {
                                    if (gameScreen.ball.getBallXValueAtIndex(k) == gameScreen.redBlocks.get(i).blockXPositions[j]) {
                                        removed = true;
                                        changeDirection = true;
                                    }
                                }
                            }
                            if (removed == true) {
                                gameScreen.redBlocks.remove(i);
                            }
                        }
                        //If any block was removed, change the directions on the ball's Y axis.
                        if (changeDirection) {
                            gameScreen.ball.changeBallYDirection();
                        }
                    }
                }
                //If blueBlocks are still present on the map:
                if (gameScreen.blueBlocks.size() > 0) {
                    //If BallY position is equal to the lowest BlockY position:
                    if (gameScreen.ball.getBallYValueAtIndex(0) == 80
                            || gameScreen.ball.getBallYValueAtIndex(24) == 50) {
                        boolean changeDirection = false;
                        for (int i = 0; i < gameScreen.blueBlocks.size(); i++) {
                            boolean removed = false;
                            for (int j = 0; j < gameScreen.blueBlocks.get(i).blockXPositions.length - 1; j++) {
                                for (int k = 0; k < gameScreen.ball.getBallXPositionsLength(); k++) {
                                    if (gameScreen.ball.getBallXValueAtIndex(k) == gameScreen.blueBlocks.get(i).blockXPositions[j]) {
                                        removed = true;
                                        changeDirection = true;
                                    }
                                }
                            }
                            if (removed == true) {
                                gameScreen.blueBlocks.remove(i);
                            }
                        }
                        //If any block was removed, change the directions on the ball's Y axis.
                        if (changeDirection) {
                            gameScreen.ball.changeBallYDirection();
                        }
                    }
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
                                            break;
                                        }
                                        else if (gameScreen.ball.getBallXValueAtIndex(k) >= gameScreen.playerPaddle.getPaddlePositionAtIndex(19)
                                        && gameScreen.ball.getBallXValueAtIndex(k) < gameScreen.playerPaddle.getPaddlePositionAtIndex(70)) {
                                            innerLeftPart++;
                                            break;
                                        }
                                        else if(gameScreen.ball.getBallXValueAtIndex(k) >= gameScreen.playerPaddle.getPaddlePositionAtIndex(70)
                                        && gameScreen.ball.getBallXValueAtIndex(k) < gameScreen.playerPaddle.getPaddlePositionAtIndex(91)) {
                                            centralPart++;
                                            break;
                                        }
                                        else if(gameScreen.ball.getBallXValueAtIndex(k) >= gameScreen.playerPaddle.getPaddlePositionAtIndex(91)
                                        && gameScreen.ball.getBallXValueAtIndex(k) < gameScreen.playerPaddle.getPaddlePositionAtIndex(141)) {
                                            innerRightPart++;
                                            break;
                                        }
                                        else if(gameScreen.ball.getBallXValueAtIndex(k) >= gameScreen.playerPaddle.getPaddlePositionAtIndex(141)
                                        && gameScreen.ball.getBallXValueAtIndex(k) < gameScreen.playerPaddle.getPaddlePositionAtIndex(160)) {
                                            outermostRightPart++;
                                            break;
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
                    System.exit(0);
                } else {
                    gameScreen.ball.updateBall();
                }
            }
           frame.repaint();
           frame.revalidate();
        }
    }
}
