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
    JPanel gameScreen = new GameScreen();
    Arkanoid() {
        //Initializing gameStart() function.
        gameStart = new gameStart();

        //Making the frame window(game window) visible, and adding main screen panel to it.
        frame.setVisible(true);
        frame.add(mainScreen);

        //Mapping the SpaceBar key to mainScreen label.
        mainScreen.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "Start");
        mainScreen.getActionMap().put("Start", gameStart);





        //Mapping LeftKey to the platformLabel label.
    }

    public class gameStart extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            //Get content of the frame and remove it all, update, add new label to the frame, update.
            frame.getContentPane().removeAll();
            frame.add(gameScreen);
            frame.repaint();
            frame.revalidate();
        }
    }



}
