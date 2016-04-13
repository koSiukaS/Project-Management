package view;

import model.Student;
import model.UniversityProject;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProjectJPanels {

    private MainFrame frame;
    private UniversityProject project;
    private JLabel dateLabel;
    private ProgramDate date;

    public ProjectJPanels(MainFrame frame, UniversityProject project) {
        this.frame = frame;
        this.project = project;
        this.date = frame.getDate();
    }

    /**
     * Creates a JPanel with all details about project
     *
     * @return  JPanel of the single university project with more details
     */
    public JPanel createFullProjectPanel() {
        JPanel singleProjectPanel = new JPanel();

        JLabel labelName = new JLabel(project.getName());
        JLabel labelStudentList = new JLabel("Students list:");
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
        singleProjectPanel.setLayout(spring);
        singleProjectPanel.add(labelName);
        singleProjectPanel.add(labelSupervisor);
        singleProjectPanel.add(scrollingDescription);
        singleProjectPanel.add(labelStudentList);
        singleProjectPanel.add(scrollingStudents);

        spring.putConstraint(SpringLayout.WEST, labelName, 10, SpringLayout.WEST, singleProjectPanel);
        spring.putConstraint(SpringLayout.NORTH, labelName, 10, SpringLayout.NORTH, singleProjectPanel);
        spring.putConstraint(SpringLayout.WEST, labelSupervisor, 10, SpringLayout.WEST, singleProjectPanel);
        spring.putConstraint(SpringLayout.SOUTH, labelSupervisor, -10, SpringLayout.SOUTH, singleProjectPanel);
        spring.putConstraint(SpringLayout.HORIZONTAL_CENTER, scrollingDescription, 0, SpringLayout.HORIZONTAL_CENTER, singleProjectPanel);
        spring.putConstraint(SpringLayout.NORTH, scrollingDescription, 10, SpringLayout.SOUTH, labelName);
        spring.putConstraint(SpringLayout.WEST, labelStudentList, 0, SpringLayout.WEST, scrollingDescription);
        spring.putConstraint(SpringLayout.NORTH, labelStudentList, 10, SpringLayout.SOUTH, scrollingDescription);
        spring.putConstraint(SpringLayout.WEST, scrollingStudents, 0, SpringLayout.WEST, labelStudentList);
        spring.putConstraint(SpringLayout.NORTH, scrollingStudents, 5, SpringLayout.SOUTH, labelStudentList);

        return singleProjectPanel;
    }

    /**
     * Creates a JPanel with some information about certain student.
     * Created only to make {@link #createFullProjectPanel()} code cleaner
     *
     * @param student   specific student
     * @return          JPanel with some information about student
     */
    private JPanel createStudentsList(final Student student){
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEADING, 10, 5));
        JPanel panelStudentFull = new JPanel();
        panelStudentFull.setLayout(new BoxLayout(panelStudentFull, BoxLayout.PAGE_AXIS));
        panelStudentFull.setPreferredSize(new Dimension(200,50));

        JLabel studentNameLabel = new JLabel(student.getFirstNameLetterAndLastName());
        JLabel tasksCountLabel = new JLabel("Tasks count: " + student.getTasks().size());
        JLabel studentAgeLabel = new JLabel("Age: " + student.countYears(frame.getDate()));

        panelStudentFull.add(studentNameLabel);
        panelStudentFull.add(studentAgeLabel);
        panelStudentFull.add(tasksCountLabel);

        JButton buttonStudent = new JButton("Details");
        buttonStudent.setPreferredSize(new Dimension(100,45));
        
        buttonStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getFrame().remove(frame.getCenter());
                frame.setCenter(new SingleStudentGui(frame, student).initiateStudentGui());
                frame.getFrame().add(frame.getCenter());
                frame.getFrame().remove(frame.getEast());
                frame.setEast(new ProjectJPanels(frame, project).showMenu());
                frame.getFrame().add(frame.getEast(), BorderLayout.EAST);
                frame.getFrame().revalidate();
                frame.getFrame().repaint();
            }
        });

        panel.add(panelStudentFull);
        panel.add(buttonStudent);
        return panel;
    }

    public JPanel showMenu() {
        JPanel mainPanel = new JPanel();
        SpringLayout layout = new SpringLayout();
        mainPanel.setLayout(layout);
        mainPanel.setPreferredSize(new Dimension(138, 0));
        mainPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.black),
                "Menu",
                TitledBorder.LEADING,
                TitledBorder.CENTER,
                new Font("Times New Roman", Font.BOLD, 20),
                Color.BLACK));
        JPanel memberButtons = createMemberButtons();
        mainPanel.add(memberButtons);
        JPanel timePanel = this.createTimePanel();
        mainPanel.add(timePanel);
        layout.putConstraint(SpringLayout.SOUTH, timePanel, 0, SpringLayout.SOUTH, mainPanel);
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


    public JPanel createTimePanel() {
        JPanel panel = new JPanel();
        SpringLayout layout = new SpringLayout();
        panel.setLayout(layout);
        panel.setPreferredSize(new Dimension(128, 55));
        JButton button = new JButton("Change date");
        button.setPreferredSize(new Dimension(128, 30));
        JLabel dateStr = new JLabel("Date:");
        dateStr.setFont(new Font("Times New Roman", Font.BOLD, 18));
        this.dateLabel = new JLabel(String.format("%d/%d/%d", date.getProgramYear(), date.getProgramMonth(), date.getProgramDay()));
        dateLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                date.changeTime(ProjectJPanels.this);
            }
        });
        panel.add(dateStr);
        layout.putConstraint(SpringLayout.WEST, dateStr, 0, SpringLayout.WEST, panel);
        panel.add(dateLabel);
        layout.putConstraint(SpringLayout.WEST, dateLabel, 44, SpringLayout.WEST, panel);
        panel.add(button);
        layout.putConstraint(SpringLayout.NORTH, button, 24, SpringLayout.NORTH, panel);
        return panel;
    }

    public void refreshData() {
        dateLabel.setText(String.format("%d/%d/%d", date.getProgramYear(), date.getProgramMonth(), date.getProgramDay()));
        frame.getFrame().remove(frame.getCenter());
        frame.setCenter(createFullProjectPanel());
        frame.getFrame().add(frame.getCenter());
        frame.getFrame().revalidate();
        frame.getFrame().repaint();
    }
}
