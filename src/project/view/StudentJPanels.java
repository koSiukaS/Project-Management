package project.view;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;

import project.ProgramDate;
import project.model.*;

public class StudentJPanels {

    private Student globalStudent;
    private MainFrame frame;
    private ProgramDate date;
    private JLabel dateLabel;
    private NavigationButtons buttons;

    public StudentJPanels(MainFrame frame, Student student, UniversityProject project){
        this.frame = frame;
        globalStudent = student;
        date = frame.getDate();
        buttons = new NavigationButtons(frame, project);
    }

    public JPanel createFullStudentPanel(){
        JPanel panel = new JPanel();
        
        JLabel labelFirstName = new JLabel("First Name: "+globalStudent.getFirstName());
        JLabel labelLastName = new JLabel("Last Name: "+globalStudent.getLastName());
        JLabel labelId = new JLabel("Id: "+globalStudent.getId());
        JLabel labelPosition = new JLabel("Position: "+globalStudent.getPosition());
        JLabel labelBirthDate = new JLabel("Birth date: "+globalStudent.getBirthYear()+"/"+globalStudent.getBirthMonth()+"/"+globalStudent.getBirthDay());
        JLabel labelAge = new JLabel("Current age: "+globalStudent.countYears(frame.getDate()));
        JLabel labelCourseName = new JLabel("Course name: "+globalStudent.getCourseName());
        JLabel labelCourseStartYear = new JLabel("Course start year: " + globalStudent.getCourseStartYear() + "/" + globalStudent.getCourseStartMonth() + "/" + globalStudent.getCourseStartDay());
        JLabel labelCourseYear = new JLabel("Course Year: "+globalStudent.countCourseYears(frame.getDate()));
        JLabel labelTaskList = new JLabel("Task list: ");
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
        panel.add(labelBirthDate);
        panel.add(labelAge);
        panel.add(labelCourseName);
        panel.add(labelCourseStartYear);
        panel.add(labelCourseYear);
        panel.add(labelTaskList);
        panel.add(scrollingTasks);
        
        spring.putConstraint(SpringLayout.WEST, labelFirstName, 10, SpringLayout.WEST, panel);
        spring.putConstraint(SpringLayout.NORTH, labelFirstName, 10, SpringLayout.NORTH, panel);
        spring.putConstraint(SpringLayout.WEST, labelLastName, 10, SpringLayout.WEST, panel);
        spring.putConstraint(SpringLayout.NORTH, labelLastName, 10, SpringLayout.SOUTH, labelFirstName);
        spring.putConstraint(SpringLayout.WEST, labelId, 10, SpringLayout.WEST, panel);
        spring.putConstraint(SpringLayout.NORTH, labelId, 10, SpringLayout.SOUTH, labelLastName);
        spring.putConstraint(SpringLayout.WEST, labelPosition, 10, SpringLayout.WEST, panel);
        spring.putConstraint(SpringLayout.NORTH, labelPosition, 10, SpringLayout.SOUTH, labelId);
        spring.putConstraint(SpringLayout.WEST, labelBirthDate, 10, SpringLayout.WEST, panel);
        spring.putConstraint(SpringLayout.NORTH, labelBirthDate, 10, SpringLayout.SOUTH, labelPosition);
        spring.putConstraint(SpringLayout.WEST, labelAge, 10, SpringLayout.WEST, panel);
        spring.putConstraint(SpringLayout.NORTH, labelAge, 10, SpringLayout.SOUTH, labelBirthDate);
        spring.putConstraint(SpringLayout.WEST, labelCourseName, 10, SpringLayout.WEST, panel);
        spring.putConstraint(SpringLayout.NORTH, labelCourseName, 10, SpringLayout.SOUTH, labelAge);
        spring.putConstraint(SpringLayout.WEST, labelCourseStartYear, 10, SpringLayout.WEST, panel);
        spring.putConstraint(SpringLayout.NORTH, labelCourseStartYear, 10, SpringLayout.SOUTH, labelCourseName);
        spring.putConstraint(SpringLayout.WEST, labelCourseYear, 10, SpringLayout.WEST, panel);
        spring.putConstraint(SpringLayout.NORTH, labelCourseYear, 10, SpringLayout.SOUTH, labelCourseStartYear);
        spring.putConstraint(SpringLayout.WEST, labelTaskList, 10, SpringLayout.WEST, panel);
        spring.putConstraint(SpringLayout.NORTH, labelTaskList, 10, SpringLayout.SOUTH, labelCourseYear);
        spring.putConstraint(SpringLayout.WEST, scrollingTasks, 10, SpringLayout.EAST, labelTaskList);
        spring.putConstraint(SpringLayout.NORTH, scrollingTasks, 5, SpringLayout.SOUTH, labelCourseYear);
        
        return panel;
    }

    private JPanel createTasksList(final Task task){
        JPanel student = new JPanel();
        student.setLayout(new FlowLayout(FlowLayout.LEADING, 10, 10));
        JPanel panelTask = new JPanel(new FlowLayout(FlowLayout.LEADING, 0, 5));
        JButton buttonTaskDetails = new JButton("Details");
        panelTask.setLayout(new BoxLayout(panelTask, BoxLayout.PAGE_AXIS));
        panelTask.setPreferredSize(new Dimension(230,30));
        
        buttonTaskDetails.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getFrame().remove(frame.getCenter());
                frame.setCenter(new TaskJPanel(frame, task).initiateTaskGui());
                frame.getFrame().add(frame.getCenter());
                //globalTime.getFrame().remove(globalTime.getEast());
                //globalTime.setEast(new ProjectJPanels(globalTime, project).showMenu());
                //globalTime.getFrame().add(globalTime.getEast(), BorderLayout.EAST);
                frame.getFrame().revalidate();
                frame.getFrame().repaint();
            }
        });
        
        panelTask.add(new JLabel(task.getName()));
        student.add(panelTask);
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


    public JPanel createTimePanel() {
        JPanel panel = new JPanel();
        SpringLayout layout = new SpringLayout();
        panel.setLayout(layout);
        panel.setPreferredSize(new Dimension(138, 55));
        JButton button = new JButton("Change date");
        button.setPreferredSize(new Dimension(138, 30));
        JLabel dateStr = new JLabel("Date:");
        dateStr.setFont(new Font("Times New Roman", Font.BOLD, 18));
        this.dateLabel = new JLabel(String.format("%d/%d/%d", date.getProgramYear(), date.getProgramMonth(), date.getProgramDay()));
        dateLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                date.changeTime(StudentJPanels.this);
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
        frame.setCenter(createFullStudentPanel());
        frame.getFrame().add(frame.getCenter());
        frame.getFrame().revalidate();
        frame.getFrame().repaint();
    }
}
