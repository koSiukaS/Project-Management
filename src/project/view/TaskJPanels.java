package project.view;

import project.ProgramDate;
import project.model.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TaskJPanels {

    private Task globalTask;
    private MainFrame frame;
    private JLabel dateLabel;
    private ProgramDate date;
    private NavigationButtons buttons;
    private JLabel labelStatus;

    public TaskJPanels(MainFrame frame, Task task, UniversityProject project, Student student){
        this.frame = frame;
        globalTask = task;
        date = frame.getDate();
        buttons = new NavigationButtons(frame, project, student, task);
    }

    public JPanel createFullTaskPanel(){
        JPanel panel = new JPanel();
        
        JLabel labelTaskName = new JLabel(globalTask.getName());
        JLabel labelTaskDescription = new JLabel("Description:");
        JLabel labelETA = new JLabel("ETA:");
        JLabel labelETADate = new JLabel(globalTask.getDeadlineYear()+"/"+globalTask.getDeadlineMonth()+"/"+globalTask.getDeadlineDay());
        labelStatus = new JLabel("Task status: "+globalTask.getStatus());
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
        JPanel memberButtons = buttons.taskButtons(this);
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
                date.changeTime(TaskJPanels.this);
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
        labelStatus.setText("Task status: "+globalTask.getStatus());
        dateLabel.setText(String.format("%d/%d/%d", date.getProgramYear(), date.getProgramMonth(), date.getProgramDay()));
        frame.getFrame().remove(frame.getCenter());
        frame.setCenter(createFullTaskPanel());
        frame.getFrame().add(frame.getCenter());
        frame.getFrame().revalidate();
        frame.getFrame().repaint();
    }

    public Task getTask() {
        return globalTask;
    }
}
