package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import model.*;

public class SingleStudentGui{
    Student globalStudent;
    MainFrame globalTime;
    public SingleStudentGui(MainFrame time, Student student){
        globalTime = time;
        globalStudent = student;
        initiateStudentGui();
}
    public JPanel initiateStudentGui(){
        JPanel panel = new JPanel();
        
        JLabel labelFirstName = new JLabel("First Name: "+globalStudent.getFirstName());
        JLabel labelLastName = new JLabel("Last Name: "+globalStudent.getLastName());
        JLabel labelId = new JLabel("Id: "+globalStudent.getId());
        JLabel labelPosition = new JLabel("Position: "+globalStudent.getPosition());
        JLabel labelBirthDate = new JLabel("Birth date: "+globalStudent.getBirthYear()+"/"+globalStudent.getBirthMonth()+"/"+globalStudent.getBirthDay());
        JLabel labelAge = new JLabel("Current age: "+globalStudent.countYears(globalTime.getDate()));
        JLabel labelCourseName = new JLabel("Course name: "+globalStudent.getCourseName());
        JLabel labelCourseYear = new JLabel("Course Year: "+globalStudent.countCourseYears(globalTime.getDate()));
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
            panelTasks.add(makingTasks(i));
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
        spring.putConstraint(SpringLayout.WEST, labelCourseYear, 10, SpringLayout.WEST, panel);
        spring.putConstraint(SpringLayout.NORTH, labelCourseYear, 10, SpringLayout.SOUTH, labelCourseName);
        spring.putConstraint(SpringLayout.WEST, labelTaskList, 10, SpringLayout.WEST, panel);
        spring.putConstraint(SpringLayout.NORTH, labelTaskList, 10, SpringLayout.SOUTH, labelCourseYear);
        spring.putConstraint(SpringLayout.WEST, scrollingTasks, 10, SpringLayout.EAST, labelTaskList);
        spring.putConstraint(SpringLayout.NORTH, scrollingTasks, 5, SpringLayout.SOUTH, labelCourseYear);
        
        return panel;
    }

    private JPanel makingTasks(int i){
        JPanel student = new JPanel();
        student.setLayout(new FlowLayout(FlowLayout.LEADING, 10, 10));
        JPanel panelTask = new JPanel();
        panelTask.setLayout(new BoxLayout(panelTask, BoxLayout.PAGE_AXIS));
        panelTask.setPreferredSize(new Dimension(200,30));
        panelTask.add(new JLabel(globalStudent.getTasks().get(i).getName()));
        student.add(panelTask);
        return student;
    } 
    
    private int countAge(){
        return 15;
    }
}
