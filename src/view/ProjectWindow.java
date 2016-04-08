package view;

import model.Student;
import model.UniversityProject;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ProjectWindow {

    public JPanel createAndShowFullProjectPanel(UniversityProject project) {
        JPanel informationPanel = new JPanel();
        informationPanel.setPreferredSize(new Dimension(700,275));
        informationPanel.setLayout(new BoxLayout(informationPanel, BoxLayout.PAGE_AXIS));

        JLabel nameLabel = new JLabel(project.getName().toUpperCase());
        nameLabel.setFont(new Font("Times New Roman", Font.BOLD, 35));
        JLabel descriptionLabel = new JLabel(project.getDescription());
        JLabel supervisorLabel = new JLabel("Supervisor: " + project.getSupervisor());

        informationPanel.add(descriptionLabel);
        informationPanel.add(supervisorLabel);

        ArrayList<Student> students = project.getStudents();
        for(int i = 0; i < project.getStudentsCount(); i++) {
            JPanel memberPanel = new JPanel(new FlowLayout(FlowLayout.LEADING, 10, 5));
            JLabel memberLabel = new JLabel(students.get(i).getFirstNameLetterAndLastName());
            JButton button = new JButton("Details");
            memberPanel.add(memberLabel);
            memberPanel.add(button);
            informationPanel.add(memberPanel);
        }

        JScrollPane scrollPane = new JScrollPane(informationPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        //scrollPane.setBorder(BorderFactory.createLineBorder(Color.black));

        JPanel mainPanel = new JPanel();
        mainPanel.add(nameLabel);
        mainPanel.add(scrollPane);

        return mainPanel;
    }

    public JPanel createMemberButtons() {
        JPanel buttonPanel = new JPanel(new GridLayout(3, 1, 0, 3));
        JButton addProject = new JButton("Add member");
        JButton editProject = new JButton("Edit member");
        JButton removeProject = new JButton("Remove member");
        buttonPanel.add(addProject);
        buttonPanel.add(editProject);
        buttonPanel.add(removeProject);
        return buttonPanel;
    }
}
