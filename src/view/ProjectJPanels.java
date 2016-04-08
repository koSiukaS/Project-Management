package view;

import model.Student;
import model.UniversityProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ProjectJPanels {

    private MainFrame frame;

    public ProjectJPanels(MainFrame frame) {
        this.frame = frame;
    }

    public JPanel createAndShowFullProjectPanel(UniversityProject project) {
        JPanel informationPanel = new JPanel();
        informationPanel.setPreferredSize(new Dimension(715,275));
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
        JPanel buttonPanel = new JPanel();
        SpringLayout layout = new SpringLayout();
        buttonPanel.setLayout(layout);
        buttonPanel.setPreferredSize(new Dimension(128, 150));
        JButton addStudent = new JButton("Add student");
        addStudent.setPreferredSize(new Dimension(128, 30));
        JButton editStudent = new JButton("Edit student");
        editStudent.setPreferredSize(new Dimension(128, 30));
        JButton removeStudent = new JButton("Remove student");
        removeStudent.setPreferredSize(new Dimension(128, 30));
        JButton backToProject = backToProject();
        backToProject.setPreferredSize(new Dimension(128, 30));

        buttonPanel.add(addStudent);
        layout.putConstraint(SpringLayout.NORTH, addStudent, 0, SpringLayout.NORTH, buttonPanel);
        buttonPanel.add(editStudent);
        layout.putConstraint(SpringLayout.NORTH, editStudent, 35, SpringLayout.NORTH, buttonPanel);
        buttonPanel.add(removeStudent);
        layout.putConstraint(SpringLayout.NORTH, removeStudent, 70, SpringLayout.NORTH, buttonPanel);
        buttonPanel.add(backToProject);
        layout.putConstraint(SpringLayout.NORTH, backToProject, 120, SpringLayout.NORTH, buttonPanel);
        return buttonPanel;
    }

    private JButton backToProject() {
        JButton button = new JButton("<< Projects");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getFrame().remove(frame.getCenter());
                frame.setCenter(frame.getProjectsWindow().createProjectsList(frame.getUniversityProjects()));
                frame.getFrame().add(frame.getCenter());
                frame.getFrame().remove(frame.getEast());
                frame.setEast(frame.showMenu(frame.getProjectsWindow().createProjectButtons()));
                frame.getFrame().add(frame.getEast(), BorderLayout.EAST);
                frame.getFrame().revalidate();
                frame.getFrame().repaint();
            }
        });

        return button;
    }
}
