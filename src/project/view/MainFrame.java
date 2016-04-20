package project.view;

import project.FilesInputOutput;
import project.ProgramDate;
import project.model.UniversityProject;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class MainFrame extends BaseClass{

    private JFrame frame = new JFrame("Project Management");
    private ProjectsListJPanels projectsWindow = new ProjectsListJPanels(MainFrame.this);
    private ArrayList<UniversityProject> universityProjects = new ArrayList<>();
    private JPanel center;
    private JPanel east;
    private NavigationButtons buttons = new NavigationButtons(MainFrame.this);

    /**
     * When Object is created specific params must be passed,
     * GUI is created too (but is not visible until date is saved)
     *
     * @param universityProjects    list of all university projects
     * @param date                  application date
     */
    public MainFrame(ArrayList<UniversityProject> universityProjects, ProgramDate date) {
        this.universityProjects = universityProjects;
        this.date = date;

        east = showMenu(buttons.mainProjectsButtons());
        center = projectsWindow.createProjectsList(universityProjects);
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                new FilesInputOutput().createAndShowExit(MainFrame.this);
            }
        });
        frame.setSize(860, 500);
        frame.setResizable(false);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
        frame.add(east, BorderLayout.EAST);
        frame.add(center);
        frame.setVisible(false);
    }

    public JPanel showMenu(JPanel navigationPanel) {
        JPanel mainPanel = new JPanel();
        SpringLayout layout = new SpringLayout();
        mainPanel.setLayout(layout);
        mainPanel.setPreferredSize(new Dimension(148, 0));
        mainPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.black),
                "Menu",
                TitledBorder.LEADING,
                TitledBorder.CENTER,
                new Font("Times New Roman", Font.BOLD, 20),
                Color.BLACK));
        mainPanel.add(navigationPanel);
        JPanel timePanel = createTimePanel();
        mainPanel.add(timePanel);
        layout.putConstraint(SpringLayout.SOUTH, timePanel, 0, SpringLayout.SOUTH, mainPanel);
        return mainPanel;
    }

    public void refreshData() {
        dateLabel.setText(String.format("%d/%d/%d", date.getProgramYear(), date.getProgramMonth(), date.getProgramDay()));
        frame.remove(center);
        center = projectsWindow.createProjectsList(universityProjects);
        frame.add(center);
        frame.revalidate();
        frame.repaint();
    }

    public NavigationButtons getButtons() {
        return this.buttons;
    }

    public ProgramDate getDate() {
        return date;
    }

    public JPanel getCenter() {
        return center;
    }

    public void setCenter(JPanel center) {
        this.center = center;
    }

    public JPanel getEast() {
        return east;
    }

    public void setEast(JPanel east) {
        this.east = east;
    }

    public ArrayList<UniversityProject> getUniversityProjects() {
        return universityProjects;
    }

    public ProjectsListJPanels getProjectsWindow() {
        return projectsWindow;
    }

    public JFrame getFrame() {
        return frame;
    }
}
