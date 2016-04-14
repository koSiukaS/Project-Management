import model.UniversityProject;
import view.MainFrame;
import view.ProgramDate;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    private ArrayList<UniversityProject> projects = new ArrayList<>();

    public static void main(String[] args) {
        Main start = new Main();
        start.startingInput();
        start.startProgram();
    }

    private void startingInput() {
        try {
            projects = new FilesInputOutput().readFiles();
        } catch(IOException e) {
            System.err.println("Couldn't read files");
        }
    }

    private void startProgram() {
        final ProgramDate date = new ProgramDate();
        final MainFrame main = new MainFrame(projects, date);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                date.changeTime(main);
            }
        });
    }
}