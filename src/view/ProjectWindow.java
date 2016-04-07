package view;

import model.UniversityProject;

import javax.swing.*;
import java.awt.*;

public class ProjectWindow {

    //sita suvarkyt turi.
    public JPanel createProjectPanel(UniversityProject project) {
        JPanel panel = new JPanel(new FlowLayout());
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

        JPanel informationPanel = new JPanel();
        Dimension panelSize = new Dimension(600,75);
        informationPanel.setPreferredSize(panelSize);
        informationPanel.setLayout(new BoxLayout(informationPanel, BoxLayout.PAGE_AXIS));
        informationPanel.add(nameLabel);
        informationPanel.add(descriptionLabel);
        informationPanel.add(supervisorLabel);
        informationPanel.add(membersLabel);

        FlowLayout flow = new FlowLayout(FlowLayout.LEADING, 10, 5);
        panel.setLayout(flow);
        panel.add(informationPanel);
        panel.add(detailsButton);
        
        return panel;
    }

    public JPanel createProjectButtons() {
        JPanel buttonPanel = new JPanel(new GridLayout(3, 1, 0, 3));
        JButton addProject = new JButton("Add project");
        JButton editProject = new JButton("Edit project");
        JButton removeProject = new JButton("Remove project");
        buttonPanel.add(addProject);
        buttonPanel.add(editProject);
        buttonPanel.add(removeProject);
        return buttonPanel;
    }
}
