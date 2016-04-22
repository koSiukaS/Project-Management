package project.view;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

import project.model.*;

public class StudentJPanels extends BaseClass{

    private UniversityProject project;
    private Student globalStudent;
    private MainFrame frame;
    private NavigationAndButtons buttons;

    public StudentJPanels(MainFrame frame, Student student, UniversityProject project){
        this.frame = frame;
        globalStudent = student;
        date = frame.getDate();
        this.project = project;
        buttons = new NavigationAndButtons(frame, project, student, this);

        student.markFailedTasks(date);
    }

    public JPanel createFullStudentPanel(){
        JPanel panel = new JPanel();
        
        JLabel labelFirstName = new JLabel("First Name: "+globalStudent.getFirstName());
        JLabel labelLastName = new JLabel("Last Name: "+globalStudent.getLastName());
        JLabel labelId = new JLabel("Id: "+globalStudent.getId());
        JLabel labelPosition = new JLabel("Position: "+globalStudent.getPosition());
        JLabel labelAge = new JLabel("Current age: "+globalStudent.countYears(frame.getDate()));
        JLabel labelCourseName = new JLabel("Course name: "+globalStudent.getCourseName());
        JLabel labelGroup = new JLabel("Course group: " + globalStudent.getGroup());
        JLabel labelCourseYear = new JLabel("Course Year: "+globalStudent.countCourseYears(frame.getDate()));
        JLabel labelTaskFinished = new JLabel("Finished tasks: " + globalStudent.countFinishedTasks());
        JLabel labelTaskPending = new JLabel("Pending tasks: " + globalStudent.countPendingTasks());
        JLabel labelTaskFailed = new JLabel("Failed tasks: " + globalStudent.countFailedTasks());
        JLabel labelTaskList = new JLabel("Tasks list: ");
        JTextArea textAreaDescription = new JTextArea(globalStudent.getCourseName(),5,60);
        JPanel panelTasks = new JPanel();
        JScrollPane scrollingTasks = new JScrollPane(panelTasks);
        scrollingTasks.setPreferredSize(new Dimension(350,150));
        
        textAreaDescription.setWrapStyleWord(true);
        textAreaDescription.setLineWrap(true);
        textAreaDescription.setEditable(false);
        textAreaDescription.setBackground(new Color(238, 238, 238));
        textAreaDescription.setBorder(null);
        JScrollPane scrollingDescription = new JScrollPane(textAreaDescription);
        scrollingDescription.setBorder(null);
        
        panelTasks.setLayout(new BoxLayout(panelTasks, BoxLayout.PAGE_AXIS));
        scrollingTasks.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        for(int i=0; i<globalStudent.getTasks().size(); i++){
            panelTasks.add(createTasksList(globalStudent.getTasks().get(i)));
            panelTasks.add(new JSeparator(SwingConstants.HORIZONTAL));
        }
        
        SpringLayout spring = new SpringLayout();
        panel.setLayout(spring);
        panel.add(labelFirstName);
        panel.add(labelLastName);
        panel.add(labelId);
        panel.add(labelPosition);
        panel.add(labelAge);
        panel.add(labelCourseName);
        panel.add(labelGroup);
        panel.add(labelCourseYear);
        panel.add(labelTaskFinished);
        panel.add(labelTaskPending);
        panel.add(labelTaskFailed);
        panel.add(labelTaskList);
        panel.add(scrollingTasks);
        
        spring.putConstraint(SpringLayout.WEST, labelFirstName, 10, SpringLayout.WEST, panel);
        spring.putConstraint(SpringLayout.NORTH, labelFirstName, 9, SpringLayout.NORTH, panel);
        spring.putConstraint(SpringLayout.WEST, labelLastName, 10, SpringLayout.WEST, panel);
        spring.putConstraint(SpringLayout.NORTH, labelLastName, 9, SpringLayout.SOUTH, labelFirstName);
        spring.putConstraint(SpringLayout.WEST, labelId, 10, SpringLayout.WEST, panel);
        spring.putConstraint(SpringLayout.NORTH, labelId, 9, SpringLayout.SOUTH, labelLastName);
        spring.putConstraint(SpringLayout.WEST, labelPosition, 10, SpringLayout.WEST, panel);
        spring.putConstraint(SpringLayout.NORTH, labelPosition, 9, SpringLayout.SOUTH, labelId);
        spring.putConstraint(SpringLayout.WEST, labelAge, 10, SpringLayout.WEST, panel);
        spring.putConstraint(SpringLayout.NORTH, labelAge, 9, SpringLayout.SOUTH, labelPosition);
        spring.putConstraint(SpringLayout.WEST, labelCourseName, 10, SpringLayout.WEST, panel);
        spring.putConstraint(SpringLayout.NORTH, labelCourseName, 9, SpringLayout.SOUTH, labelAge);
        spring.putConstraint(SpringLayout.WEST, labelGroup, 10, SpringLayout.WEST, panel);
        spring.putConstraint(SpringLayout.NORTH, labelGroup, 9, SpringLayout.SOUTH, labelCourseName);
        spring.putConstraint(SpringLayout.WEST, labelCourseYear, 10, SpringLayout.WEST, panel);
        spring.putConstraint(SpringLayout.NORTH, labelCourseYear, 9, SpringLayout.SOUTH, labelGroup);
        spring.putConstraint(SpringLayout.WEST, labelTaskFinished, 10, SpringLayout.WEST, panel);
        spring.putConstraint(SpringLayout.NORTH, labelTaskFinished, 9, SpringLayout.SOUTH, labelCourseYear);
        spring.putConstraint(SpringLayout.WEST, labelTaskPending, 10, SpringLayout.WEST, panel);
        spring.putConstraint(SpringLayout.NORTH, labelTaskPending, 9, SpringLayout.SOUTH, labelTaskFinished);
        spring.putConstraint(SpringLayout.WEST, labelTaskFailed, 10, SpringLayout.WEST, panel);
        spring.putConstraint(SpringLayout.NORTH, labelTaskFailed, 9, SpringLayout.SOUTH, labelTaskPending);
        spring.putConstraint(SpringLayout.WEST, labelTaskList, 10, SpringLayout.WEST, panel);
        spring.putConstraint(SpringLayout.NORTH, labelTaskList, 9, SpringLayout.SOUTH, labelTaskFailed);
        spring.putConstraint(SpringLayout.WEST, scrollingTasks, 10, SpringLayout.WEST, panel);
        spring.putConstraint(SpringLayout.NORTH, scrollingTasks, 9, SpringLayout.SOUTH, labelTaskList);
        
        return panel;
    }

    private JPanel createTasksList(final Task task){
        JPanel student = new JPanel();
        student.setLayout(new FlowLayout(FlowLayout.LEADING, 10, 10));
        JPanel panelTask = new JPanel(new FlowLayout(FlowLayout.LEADING, 0, 5));
        panelTask.setLayout(new BoxLayout(panelTask, BoxLayout.PAGE_AXIS));
        panelTask.setPreferredSize(new Dimension(230,35));
        panelTask.add(new JLabel(task.getName()));
        panelTask.add(new JLabel("Status: " + task.getStatus()));
        student.add(panelTask);
        JButton buttonTaskDetails = new JButton("Details");
        NavigationAndButtons detailsButton = new NavigationAndButtons(frame, project, globalStudent, task);
        detailsButton.setTaskActionListener(buttonTaskDetails);
        student.add(buttonTaskDetails);
        return student;
    }

    public JPanel showMenu() {
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
        JPanel memberButtons = buttons.studentButtons();
        mainPanel.add(memberButtons);
        JPanel timePanel = this.createTimePanel();
        mainPanel.add(timePanel);
        layout.putConstraint(SpringLayout.SOUTH, timePanel, 0, SpringLayout.SOUTH, mainPanel);
        return mainPanel;
    }

    public void refreshData() {
        globalStudent.markFailedTasks(date);
        dateLabel.setText(String.format("%d/%d/%d", date.getProgramYear(), date.getProgramMonth(), date.getProgramDay()));
        frame.getFrame().remove(frame.getCenter());
        frame.setCenter(createFullStudentPanel());
        frame.getFrame().add(frame.getCenter());
        frame.getFrame().revalidate();
        frame.getFrame().repaint();
    }
}
