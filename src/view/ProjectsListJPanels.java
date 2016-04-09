package view;

import model.UniversityProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ProjectsListJPanels {

    private MainFrame frame;

    public ProjectsListJPanels(MainFrame frame) {
        this.frame = frame;
    }

    public JPanel createProjectPanel(final UniversityProject project) {
        final JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEADING, 10, 5));

        JLabel nameLabel = new JLabel();
        nameLabel.setText(project.getName().toUpperCase());
        nameLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));

        JLabel descriptionLabel = new JLabel();
        String shortDescription = project.getDescription().substring(0, 95) + "...";
        descriptionLabel.setText(shortDescription);

        JLabel supervisorLabel = new JLabel();
        String supervisor = "Supervisor: " + project.getSupervisor();
        supervisorLabel.setText(supervisor);

        JLabel membersLabel = new JLabel();
        String members = "Students count: " + project.getStudentsCount();
        membersLabel.setText(members);

        JButton detailsButton = new JButton("Details");
        detailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getFrame().remove(frame.getCenter());
                frame.setCenter(new ProjectJPanels(frame, project).createAndShowFullProjectPanel());
                frame.getFrame().add(frame.getCenter());
                frame.getFrame().remove(frame.getEast());
                frame.setEast(new ProjectJPanels(frame, project).showMenu());
                frame.getFrame().add(frame.getEast(), BorderLayout.EAST);
                frame.getFrame().revalidate();
                frame.getFrame().repaint();
            }
        });

        JPanel informationPanel = new JPanel();
        informationPanel.setPreferredSize(new Dimension(600,75));
        informationPanel.setLayout(new BoxLayout(informationPanel, BoxLayout.PAGE_AXIS));
        informationPanel.add(nameLabel);
        informationPanel.add(descriptionLabel);
        informationPanel.add(supervisorLabel);
        informationPanel.add(membersLabel);

        panel.add(informationPanel);
        panel.add(detailsButton);
        
        return panel;
    }

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

    public JPanel createProjectButtons() {
        JPanel buttonPanel = new JPanel();
        SpringLayout layout = new SpringLayout();
        buttonPanel.setLayout(layout);
        buttonPanel.setPreferredSize(new Dimension(128, 100));
        JButton addProject = new JButton("Add project");
        addProject.setPreferredSize(new Dimension(128, 30));
        JButton editProject = new JButton("Edit project");
        editProject.setPreferredSize(new Dimension(128, 30));
        JButton removeProject = new JButton("Remove project");
        removeProject.setPreferredSize(new Dimension(128, 30));

        buttonPanel.add(addProject);
        layout.putConstraint(SpringLayout.NORTH, addProject, 0, SpringLayout.NORTH, buttonPanel);
        buttonPanel.add(editProject);
        layout.putConstraint(SpringLayout.NORTH, editProject, 35, SpringLayout.NORTH, buttonPanel);
        buttonPanel.add(removeProject);
        layout.putConstraint(SpringLayout.NORTH, removeProject, 70, SpringLayout.NORTH, buttonPanel);
        return buttonPanel;
    }
}
