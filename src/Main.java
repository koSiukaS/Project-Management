import javax.swing.*;
import java.util.ArrayList;

public class Main {

    ArrayList<Project> projects = new ArrayList<>();

    public static void main(String[] args) {
        final MainFrame main = new MainFrame();
        final Time time = new Time();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                main.showMainFrame();
                time.time(main.getFrame());
            }
        });
    }

    private void startingInput() {
        /*
         * Need input here.
         */
    }
}