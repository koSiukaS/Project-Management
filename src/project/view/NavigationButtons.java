package project.view;


import project.model.Student;
import project.model.Task;
import project.model.UniversityProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NavigationButtons {

    private MainFrame frame;
    private UniversityProject project;
    private Student student;
    private Task task;

    NavigationButtons(MainFrame frame) {
        this.frame = frame;
    }

    NavigationButtons(MainFrame frame, UniversityProject project) {
        this.frame = frame;
        this.project = project;
    }

    NavigationButtons(MainFrame frame, UniversityProject project, Student student) {
        this.frame = frame;
        this.project = project;
        this.student = student;
    }

    NavigationButtons(MainFrame frame, UniversityProject project, Student student, Task task) {
        this.frame = frame;
        this.project = project;
        this.student = student;
        this.task = task;
    }

    private JButton backToProjects() {
        JButton button = new JButton("<< Projects");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getFrame().remove(frame.getCenter());
                frame.setCenter(frame.getProjectsWindow().createProjectsList(frame.getUniversityProjects()));
                frame.getFrame().add(frame.getCenter());
                frame.getFrame().remove(frame.getEast());
                frame.setEast(frame.showMenu(frame.getButtons().mainProjectsButtons()));
                frame.getFrame().add(frame.getEast(), BorderLayout.EAST);
                frame.getFrame().revalidate();
                frame.getFrame().repaint();
            }
        });
        return button;
    }

    private JButton backtoProject() {
        JButton button = new JButton("<< Project");
        setProjectActionListener(button);
        return button;
    }

    private JButton backToStudent() {
        JButton button = new JButton("<< Student");
        setStudentActionListener(button);
        return button;
    }

    /**
     * Creates a JPanel with project buttons inside it
     *
     * @return JPanel with all buttons inside it
     */
    public JPanel mainProjectsButtons() {
        JPanel buttonPanel = new JPanel();
        SpringLayout layout = new SpringLayout();
        buttonPanel.setLayout(layout);
        buttonPanel.setPreferredSize(new Dimension(138, 65));
        JButton addProject = new JButton("Add project");
        addProject.setPreferredSize(new Dimension(138, 30));
        JButton removeProject = new JButton("Remove project");
        removeProject.setPreferredSize(new Dimension(138, 30));

        buttonPanel.add(addProject);
        layout.putConstraint(SpringLayout.NORTH, addProject, 0, SpringLayout.NORTH, buttonPanel);
        buttonPanel.add(removeProject);
        layout.putConstraint(SpringLayout.NORTH, removeProject, 35, SpringLayout.NORTH, buttonPanel);
        return buttonPanel;
    }

    public JPanel projectButtons() {
        JPanel buttonPanel = new JPanel();
        SpringLayout layout = new SpringLayout();
        buttonPanel.setLayout(layout);
        buttonPanel.setPreferredSize(new Dimension(138, 155));
        JButton editProject = new JButton("Edit project");
        editProject.setPreferredSize(new Dimension(138, 30));
        JButton addStudent = new JButton("Add student");
        addStudent.setPreferredSize(new Dimension(138, 30));
        JButton removeStudent = new JButton("Remove student");
        removeStudent.setPreferredSize(new Dimension(138, 30));
        JButton backToProject = backToProjects();
        backToProject.setPreferredSize(new Dimension(138, 30));

        buttonPanel.add(editProject);
        layout.putConstraint(SpringLayout.NORTH, editProject, 0, SpringLayout.NORTH, buttonPanel);
        buttonPanel.add(addStudent);
        layout.putConstraint(SpringLayout.NORTH, addStudent, 40, SpringLayout.NORTH, buttonPanel);
        buttonPanel.add(removeStudent);
        layout.putConstraint(SpringLayout.NORTH, removeStudent, 75, SpringLayout.NORTH, buttonPanel);
        buttonPanel.add(backToProject);
        layout.putConstraint(SpringLayout.NORTH, backToProject, 125, SpringLayout.NORTH, buttonPanel);
        return buttonPanel;
    }

    public JPanel studentButtons() {
        JPanel buttonPanel = new JPanel();
        SpringLayout layout = new SpringLayout();
        buttonPanel.setLayout(layout);
        buttonPanel.setPreferredSize(new Dimension(138, 190));
        JButton addStudent = new JButton("Edit student");
        addStudent.setPreferredSize(new Dimension(138, 30));
        JButton editStudent = new JButton("Add task");
        editStudent.setPreferredSize(new Dimension(138, 30));
        JButton removeStudent = new JButton("Remove task");
        removeStudent.setPreferredSize(new Dimension(138, 30));
        JButton backToProject = backtoProject();
        backToProject.setPreferredSize(new Dimension(138, 30));
        JButton backToProjects = backToProjects();
        backToProjects.setPreferredSize(new Dimension(138, 30));

        buttonPanel.add(addStudent);
        layout.putConstraint(SpringLayout.NORTH, addStudent, 0, SpringLayout.NORTH, buttonPanel);
        buttonPanel.add(editStudent);
        layout.putConstraint(SpringLayout.NORTH, editStudent, 40, SpringLayout.NORTH, buttonPanel);
        buttonPanel.add(removeStudent);
        layout.putConstraint(SpringLayout.NORTH, removeStudent, 75, SpringLayout.NORTH, buttonPanel);
        buttonPanel.add(backToProject);
        layout.putConstraint(SpringLayout.NORTH, backToProject, 125, SpringLayout.NORTH, buttonPanel);
        buttonPanel.add(backToProjects);
        layout.putConstraint(SpringLayout.NORTH, backToProjects, 160, SpringLayout.NORTH, buttonPanel);
        return buttonPanel;
    }

    public JPanel taskButtons(final TaskJPanels panel) {
        JPanel buttonPanel = new JPanel();
        SpringLayout layout = new SpringLayout();
        buttonPanel.setLayout(layout);
        buttonPanel.setPreferredSize(new Dimension(138, 225));
        JButton editTask = new JButton("Edit task");
        editTask.setPreferredSize(new Dimension(138, 30));
        JButton markAsFinished = new JButton("Mark as finished");
        markAsFinished.setPreferredSize(new Dimension(138, 30));
        markAsFinished.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.getTask().setStatus(1);
                panel.refreshData();
            }
        });
        JButton markAsFailed = new JButton("Mark as failed");
        markAsFailed.setPreferredSize(new Dimension(138, 30));
        markAsFailed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.getTask().setStatus(-1);
                panel.refreshData();
            }
        });
        JButton backToStudent = backToStudent();
        backToStudent.setPreferredSize(new Dimension(138, 30));
        JButton backToProject = backtoProject();
        backToProject.setPreferredSize(new Dimension(138, 30));
        JButton backToProjects = backToProjects();
        backToProjects.setPreferredSize(new Dimension(138, 30));

        buttonPanel.add(editTask);
        layout.putConstraint(SpringLayout.NORTH, editTask, 0, SpringLayout.NORTH, buttonPanel);
        buttonPanel.add(markAsFinished);
        layout.putConstraint(SpringLayout.NORTH, markAsFinished, 40, SpringLayout.NORTH, buttonPanel);
        buttonPanel.add(markAsFailed);
        layout.putConstraint(SpringLayout.NORTH, markAsFailed, 75, SpringLayout.NORTH, buttonPanel);
        buttonPanel.add(backToStudent);
        layout.putConstraint(SpringLayout.NORTH, backToStudent, 125, SpringLayout.NORTH, buttonPanel);
        buttonPanel.add(backToProject);
        layout.putConstraint(SpringLayout.NORTH, backToProject, 160, SpringLayout.NORTH, buttonPanel);
        buttonPanel.add(backToProjects);
        layout.putConstraint(SpringLayout.NORTH, backToProjects, 195, SpringLayout.NORTH, buttonPanel);
        return buttonPanel;
    }

    public void setProjectActionListener(JButton button) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProjectJPanels panels = new ProjectJPanels(frame, project);
                frame.getFrame().remove(frame.getCenter());
                frame.setCenter(panels.createFullProjectPanel());
                frame.getFrame().add(frame.getCenter());
                frame.getFrame().remove(frame.getEast());
                frame.setEast(panels.showMenu());
                frame.getFrame().add(frame.getEast(), BorderLayout.EAST);
                frame.getFrame().revalidate();
                frame.getFrame().repaint();
            }
        });
    }

    public void setStudentActionListener(JButton button) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StudentJPanels panels = new StudentJPanels(frame, student, project);
                frame.getFrame().remove(frame.getCenter());
                frame.setCenter(panels.createFullStudentPanel());
                frame.getFrame().add(frame.getCenter());
                frame.getFrame().remove(frame.getEast());
                frame.setEast(panels.showMenu());
                frame.getFrame().add(frame.getEast(), BorderLayout.EAST);
                frame.getFrame().revalidate();
                frame.getFrame().repaint();
            }
        });
    }

    public void setTaskActionListener(JButton button) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TaskJPanels panels = new TaskJPanels(frame, task, project, student);
                frame.getFrame().remove(frame.getCenter());
                frame.setCenter(panels.createFullTaskPanel());
                frame.getFrame().add(frame.getCenter());
                frame.getFrame().remove(frame.getEast());
                frame.setEast(panels.showMenu());
                frame.getFrame().add(frame.getEast(), BorderLayout.EAST);
                frame.getFrame().revalidate();
                frame.getFrame().repaint();
            }
        });
    }
}
