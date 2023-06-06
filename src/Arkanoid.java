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
        gameStart = new GameStart();

        frame.setVisible(true);
        frame.add(mainScreen);

        mainScreen.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "Start");
        mainScreen.getActionMap().put("Start", gameStart);

        gameScreen.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "Left");
        gameScreen.getActionMap().put("Left", moveLeft);

        gameScreen.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "Right");
        gameScreen.getActionMap().put("Right", moveRight);

        frame.add(gameScreen);
        gameScreen.setVisible(false);
    }

    public class GameStart extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.getContentPane().removeAll();
            frame.add(gameScreen);
            gameScreen.setVisible(true);
            frame.repaint();
            frame.revalidate();
        }
    }

    public class MoveLeft extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            gameScreen.setPaddleX(gameScreen.getPaddleX() - 10);
            gameScreen.repaint();
        }
    }

    public class MoveRight extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            gameScreen.setPaddleX(gameScreen.getPaddleX() + 10);
            gameScreen.repaint();
        }
    }
}