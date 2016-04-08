package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import model.*;

public class SingleProjectGui{
    UniversityProject globalProject;
    public  SingleProjectGui(UniversityProject project){
        globalProject = project;
        initiateProjectGui();
}
    public JPanel initiateProjectGui(){
        JPanel panel = new JPanel();
        /*JFrame frame = new JFrame();
        frame.setSize(705,420);
        frame.add(panel);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);*/
        
        JLabel labelName = new JLabel(globalProject.getName());
        JLabel labelStudentList = new JLabel("Student list");
        JLabel labelSupervisor = new JLabel("Supervisor: "+globalProject.getSupervisor());
        JTextArea textAreaDescription = new JTextArea(globalProject.getDescription(),5,60);
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
        
        for(int i=0; i<globalProject.getStudentsCount(); i++){
            panelStudents.add(makingStudents(globalProject.getStudents().get(i).getFirstName(),globalProject.getStudents().get(i).getLastName(),globalProject.getStudents().get(i).getTasks().size()));
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
    private JPanel makingStudents(String firstName, String lastName, int taskCount){
        JPanel student = new JPanel();
        student.setLayout(new FlowLayout(FlowLayout.LEADING, 10, 5));
        //student.setPreferredSize(new Dimension(340,40));
        JPanel panelStudentFull = new JPanel();
        panelStudentFull.setLayout(new BoxLayout(panelStudentFull, BoxLayout.PAGE_AXIS));
        panelStudentFull.setPreferredSize(new Dimension(200,50));
        panelStudentFull.add(new JLabel(firstName+" "+lastName));
        panelStudentFull.add(new JLabel("Task count: "+taskCount));
        panelStudentFull.add(new JLabel("Age: "+countAge()));
        //JPanel panelTasks = new JPanel();
        //panelTasks.setPreferredSize(new Dimension(120,40));
        //panelTasks.setLayout(new FlowLayout(FlowLayout.LEFT));
        JButton buttonStudent = new JButton("Details");
        buttonStudent.setPreferredSize(new Dimension(100,45));
        //panelTasks.add(new JLabel("Task count: "+taskCount));
        
        student.add(panelStudentFull);
        //student.add(panelTasks);
        student.add(buttonStudent);
        return student;
    } 
    
    private int countAge(){
        return 15;
    }
}
