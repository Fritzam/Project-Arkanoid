import javax.swing.*;

class Frame extends JFrame {

    Frame() {
        this.setTitle("Arkanoid");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(420, 420);
        this.setVisible(true);

        ImageIcon image = new ImageIcon("arkanoid2.png");
        this.setIconImage(image.getImage());
    }
}
