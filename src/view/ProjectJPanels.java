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
        JPanel panel = new JPanel();

        JLabel labelName = new JLabel(project.getName());
        JLabel labelStudentList = new JLabel("Student list");
        JLabel labelSupervisor = new JLabel("Supervisor: "+project.getSupervisor());
        JTextArea textAreaDescription = new JTextArea(project.getDescription(),5,60);
        JPanel panelStudents = new JPanel();
        JScrollPane scrollingStudents = new JScrollPane(panelStudents);
        scrollingStudents.setPreferredSize(new Dimension(350,180));

        labelName.setFont(new Font("Times New Roman", Font.BOLD, 35));
        labelSupervisor.setFont(new Font("Times New Roman", Font.BOLD, 15));

        textAreaDescription.setWrapStyleWord(true);
        textAreaDescription.setLineWrap(true);
        textAreaDescription.setEditable(false);
        textAreaDescription.setBackground(new Color(238, 238, 238));
        textAreaDescription.setBorder(null);
        JScrollPane scrollingDescription = new JScrollPane(textAreaDescription);
        scrollingDescription.setBorder(null);

        panelStudents.setLayout(new BoxLayout(panelStudents, BoxLayout.PAGE_AXIS));
        scrollingStudents.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        for(int i=0; i<project.getStudentsCount(); i++){
            panelStudents.add(createStudentsList(project.getStudents().get(i)));
            panelStudents.add(new JSeparator(SwingConstants.HORIZONTAL));
        }

        SpringLayout spring = new SpringLayout();
        panel.setLayout(spring);
        panel.add(labelName);
        panel.add(labelSupervisor);
        panel.add(scrollingDescription);
        panel.add(labelStudentList);
        panel.add(scrollingStudents);

        spring.putConstraint(SpringLayout.WEST, labelName, 10, SpringLayout.WEST, panel);
        spring.putConstraint(SpringLayout.NORTH, labelName, 10, SpringLayout.NORTH, panel);
        spring.putConstraint(SpringLayout.WEST, labelSupervisor, 10, SpringLayout.WEST, panel);
        spring.putConstraint(SpringLayout.SOUTH, labelSupervisor, -10, SpringLayout.SOUTH, panel);
        spring.putConstraint(SpringLayout.HORIZONTAL_CENTER, scrollingDescription, 0, SpringLayout.HORIZONTAL_CENTER, panel);
        spring.putConstraint(SpringLayout.NORTH, scrollingDescription, 10, SpringLayout.SOUTH, labelName);
        spring.putConstraint(SpringLayout.WEST, labelStudentList, 0, SpringLayout.WEST, scrollingDescription);
        spring.putConstraint(SpringLayout.NORTH, labelStudentList, 10, SpringLayout.SOUTH, scrollingDescription);
        spring.putConstraint(SpringLayout.WEST, scrollingStudents, 0, SpringLayout.WEST, labelStudentList);
        spring.putConstraint(SpringLayout.NORTH, scrollingStudents, 5, SpringLayout.SOUTH, labelStudentList);

        return panel;
    }

    private JPanel createStudentsList(Student student){
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEADING, 10, 5));
        JPanel panelStudentFull = new JPanel();
        panelStudentFull.setLayout(new BoxLayout(panelStudentFull, BoxLayout.PAGE_AXIS));
        panelStudentFull.setPreferredSize(new Dimension(200,50));

        JLabel studentNameLabel = new JLabel(student.getFirstNameLetterAndLastName());
        JLabel tasksCountLabel = new JLabel("Tasks count: " + student.getTasks().size());
        JLabel studentAgeLabel = new JLabel("Age: " + 15);

        panelStudentFull.add(studentNameLabel);
        panelStudentFull.add(tasksCountLabel);
        panelStudentFull.add(studentAgeLabel);

        JButton buttonStudent = new JButton("Details");
        buttonStudent.setPreferredSize(new Dimension(100,45));

        panel.add(panelStudentFull);
        panel.add(buttonStudent);
        return panel;
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
