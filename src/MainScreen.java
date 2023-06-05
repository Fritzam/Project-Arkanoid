import javax.swing.*;
import java.awt.*;

public class MainScreen extends JLabel{

    MainScreen() {

        //Main game screen settings.
        //Getting Arkanoid image and adding it to the label.
        ImageIcon mainScreenImage = new ImageIcon("arkanoidLogo256x480.png");
        this.setIcon(mainScreenImage);

        //Graphic and background settings.
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setVerticalAlignment(JLabel.TOP);
        this.setBackground(Color.BLACK);
        this.setOpaque(true);

        //Text settings
        this.setText("Press Space to start the game.");
        this.setFont(new Font("Impact", Font.BOLD, 32));
        this.setForeground(Color.WHITE);
        this.setHorizontalTextPosition(JLabel.CENTER);
        this.setVerticalTextPosition(JLabel.BOTTOM);
        this.setIconTextGap(60);
    }
}
