import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Arkanoid {

    Action moveLeft;
    Action moveRight;
    Action gameStart;


    JFrame frame = new Frame();
    JLabel mainScreen = new MainScreen();
    GameScreen gameScreen = new GameScreen();
    Arkanoid() {
        //Initializing gameStart() class.
        gameStart = new gameStart();

        //Making the frame window(game window) visible, and adding main screen panel to it.
        frame.setVisible(true);
        frame.add(mainScreen);

        //Mapping the SpaceBar key to mainScreen label.
        mainScreen.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "Start");
        mainScreen.getActionMap().put("Start", gameStart);

        //Initializing moveLeft and moveRight functions;
        moveLeft = new moveLeft();
        moveRight = new moveRight();

        gameScreen.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "Left");
        gameScreen.getActionMap().put("Left", moveLeft);

        gameScreen.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "Right");
        gameScreen.getActionMap().put("Right", moveRight);
        //Mapping LeftKey to the platformLabel label.

        //Requesting focus to prevent bugs.
        //frame.requestFocusInWindow();
    }

    public class gameStart extends AbstractAction {
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

    public class moveLeft extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            gameScreen.setPaddleX(gameScreen.getPaddleX() - 15);
            System.out.println("It works!");
            frame.repaint();
            frame.revalidate();
        }
    }

    public class moveRight extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            gameScreen.setPaddleX(gameScreen.getPaddleX() + 15);
            System.out.println("It works!");
            frame.repaint();
            frame.revalidate();
        }
    }



}
