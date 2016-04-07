import model.UniversityProject;
import model.Time;
import view.MainFrame;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public ArrayList<UniversityProject> projects = new ArrayList<>();

    public static void main(String[] args) {
        Main start = new Main();
        start.startingInput();
        start.startProgram();
    }

    private void startingInput() {
        try {
            projects = new FilesInputOutput().readFiles();
        } catch(IOException e) {
            System.exit(1);
        }
    }

    private void startProgram() {
        final MainFrame main = new MainFrame(projects);
        final Time time = new Time();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                main.showMainFrame();
                time.time(main.getFrame());
            }
        });
    }
}