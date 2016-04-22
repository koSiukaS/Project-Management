package project.view;

import project.model.UniversityProject;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ProjectsListJPanels{

    private MainFrame frame;

    public ProjectsListJPanels(MainFrame frame) {
        this.frame = frame;
    }

    /**
     * Method gets certain university project, builds a JPanel and returns it
     *
     * @param project   single UniversityProject
     * @return          JPanel with all content for given project
     */
    public JPanel createProjectPanel(final UniversityProject project) {
        final JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEADING, 10, 5));

        JLabel nameLabel = new JLabel();
        nameLabel.setText(project.getName().toUpperCase());
        nameLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));

        JLabel descriptionLabel = new JLabel();
        String shortDescription = new String();
        if (project.getDescription().length() < 95) {
            shortDescription = project.getDescription();
        }
        else {
            shortDescription = project.getDescription().substring(0, 95) + "...";
        }
        descriptionLabel.setText(shortDescription);

        JLabel supervisorLabel = new JLabel();
        String supervisor = "Supervisor: " + project.getSupervisor();
        supervisorLabel.setText(supervisor);

        JLabel membersLabel = new JLabel();
        String members = "Students count: " + project.getStudentsCount();
        membersLabel.setText(members);

        JButton button = new JButton("Details");
        NavigationButtons detailsButton = new NavigationButtons(frame, project);
        detailsButton.setProjectActionListener(button);

        JPanel informationPanel = new JPanel();
        informationPanel.setPreferredSize(new Dimension(570,75));
        informationPanel.setLayout(new BoxLayout(informationPanel, BoxLayout.PAGE_AXIS));
        informationPanel.add(nameLabel);
        informationPanel.add(descriptionLabel);
        informationPanel.add(supervisorLabel);
        informationPanel.add(membersLabel);

        panel.add(informationPanel);
        panel.add(button);
        
        return panel;
    }

    /**
     * Receives ArrayList of all university projects and returns JPanel
     * of all single JPanels combined
     *
     * @param universityProjects    list of all university projects
     * @return                      JPanel with all JPanels of each university project
     */
    public JPanel createProjectsList(ArrayList<UniversityProject> universityProjects) {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));

        JPanel intermediatePanel = new JPanel();
        intermediatePanel.setLayout(new BoxLayout(intermediatePanel, BoxLayout.PAGE_AXIS));
        for(int i = 0; i < universityProjects.size(); i++) {
            intermediatePanel.add(createProjectPanel(universityProjects.get(i)));
            intermediatePanel.add(new JSeparator(SwingConstants.HORIZONTAL));
        }

        JScrollPane scrollPane = new JScrollPane(intermediatePanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.black));

        JPanel namePanel = new JPanel();
        namePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel nameLabel = new JLabel("Projects", SwingConstants.LEFT);
        nameLabel.setFont(new Font("Times New Roman", Font.BOLD, 35));
        namePanel.add(nameLabel);

        mainPanel.add(namePanel);
        mainPanel.add(scrollPane);
        return mainPanel;
    }
}
