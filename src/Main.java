import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        final Main design = new Main();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                design.createAndShowGUI();
            }
        });
    }

    private void createAndShowGUI() {
        JFrame f = new JFrame("Project Management");
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setSize(860, 500);
        f.setVisible(true);
    }
}