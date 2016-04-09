import model.Student;
import model.Task;
import model.UniversityProject;
import view.MainFrame;
import view.ProgramDate;

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
        final ProgramDate date = new ProgramDate();
        final MainFrame main = new MainFrame(projects, date);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                date.changeTime(main);
                main.showMainFrame();
            }
        });
    }
}