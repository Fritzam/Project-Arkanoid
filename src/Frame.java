import javax.swing.*;

class Frame extends JFrame {

    Frame() {
        //Adding icon to the top bar.
        ImageIcon mainScreenIcon = new ImageIcon("arkanoid.png");
        this.setIconImage(mainScreenIcon.getImage());

        //Basic frame settings.
        this.setTitle("Arkanoid");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(512, 512);
    }
}
