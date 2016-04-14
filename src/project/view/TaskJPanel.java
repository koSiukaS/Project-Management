package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import model.*;

public class TaskJPanel{
    Task globalTask;
    MainFrame globalTime;
    public TaskJPanel(MainFrame time, Task task){
        globalTime = time;
        globalTask = task;
        initiateTaskGui();
}
    public JPanel initiateTaskGui(){
        JPanel panel = new JPanel();
        
        JLabel labelTaskName = new JLabel(globalTask.getName());
        JLabel labelTaskDescription = new JLabel("Description:");
        JLabel labelETA = new JLabel("ETA:");
        JLabel labelETADate = new JLabel(globalTask.getDeadlineYear()+"/"+globalTask.getDeadlineMonth()+"/"+globalTask.getDeadlineDay());
        JLabel labelStatus = new JLabel("Task status: "+globalTask.getStatus());
        JTextArea textAreaDescription = new JTextArea(globalTask.getDescription(),5,25);
        
        labelTaskName.setFont(new Font("Times New Roman", Font.BOLD, 35));
        
        textAreaDescription.setWrapStyleWord(true);
        textAreaDescription.setLineWrap(true);
        textAreaDescription.setEditable(false);
        textAreaDescription.setBackground(new Color(238, 238, 238));
        textAreaDescription.setBorder(null);
        textAreaDescription.setBorder(BorderFactory.createCompoundBorder(textAreaDescription.getBorder(),BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        
        JScrollPane scrollingDescription = new JScrollPane(textAreaDescription);
             
        SpringLayout spring = new SpringLayout();
        panel.setLayout(spring);
        panel.add(labelTaskName);
        panel.add(labelTaskDescription);
        panel.add(scrollingDescription);
        panel.add(labelETA);
        panel.add(labelETADate);
        panel.add(labelStatus);
        
        spring.putConstraint(SpringLayout.WEST, labelTaskName, 10, SpringLayout.WEST, panel);
        spring.putConstraint(SpringLayout.NORTH, labelTaskName, 10, SpringLayout.NORTH, panel);
        spring.putConstraint(SpringLayout.WEST, labelTaskDescription, 10, SpringLayout.WEST, panel);
        spring.putConstraint(SpringLayout.NORTH, labelTaskDescription, 10, SpringLayout.SOUTH, labelTaskName);
        spring.putConstraint(SpringLayout.WEST, scrollingDescription, 10, SpringLayout.EAST, labelTaskDescription);
        spring.putConstraint(SpringLayout.NORTH, scrollingDescription, 10, SpringLayout.SOUTH, labelTaskName);
        spring.putConstraint(SpringLayout.WEST, labelETA, 10, SpringLayout.WEST, panel);
        spring.putConstraint(SpringLayout.NORTH, labelETA, 10, SpringLayout.SOUTH, scrollingDescription);
        spring.putConstraint(SpringLayout.WEST, labelETADate, 10, SpringLayout.EAST, labelETA);
        spring.putConstraint(SpringLayout.NORTH, labelETADate, 10, SpringLayout.SOUTH, scrollingDescription);
        spring.putConstraint(SpringLayout.WEST, labelStatus, 10, SpringLayout.WEST, panel);
        spring.putConstraint(SpringLayout.NORTH, labelStatus, 10, SpringLayout.SOUTH, labelETA);
        
        return panel;
    }
}
