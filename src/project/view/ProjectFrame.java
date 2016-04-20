package project.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import project.model.UniversityProject;


public class ProjectFrame{
    
    public void Add(){
        final JFrame frameProject = new JFrame("Adding a project");
        JLabel labelName = new JLabel("Project name");
        JLabel labelDescription = new JLabel("Description:");
        JLabel labelSupervisor = new JLabel("Supervisor");    
        final JTextField textFieldName = new JTextField();       
        final JTextArea textAreaDescription = new JTextArea();
        final JTextField textFieldSupervisor = new JTextField();
        JButton buttonSave = new JButton("Add project");
        
        frameProject.setSize(400, 450);
        frameProject.setLayout(null);
        frameProject.setVisible(true);
        frameProject.setLocationRelativeTo(null);
        
        textAreaDescription.setWrapStyleWord(true);
        textAreaDescription.setLineWrap(true);
        textAreaDescription.setBorder(BorderFactory.createCompoundBorder(textAreaDescription.getBorder(),BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        textAreaDescription.setFont(new Font("", Font.BOLD, 12));
        JScrollPane scrollingDescription = new JScrollPane(textAreaDescription);
        
        labelName.setBounds(10,10,100,30);
        labelName.setFont(new Font("", Font.BOLD, 15));
        textFieldName.setBounds(120,10,200,30);
        textFieldName.setFont(new Font("", Font.BOLD, 15));
        labelDescription.setBounds(10,50,110,30);
        labelDescription.setFont(new Font("", Font.BOLD, 15));
        scrollingDescription.setBounds(10,90,350,180);
        labelSupervisor.setBounds(10,280,100,30);
        labelSupervisor.setFont(new Font("", Font.BOLD, 15));
        textFieldSupervisor.setBounds(120,280,200,30);
        textFieldSupervisor.setFont(new Font("", Font.BOLD, 15));
        buttonSave.setBounds(75,320,250,80);
        buttonSave.setFont(new Font("",Font.BOLD,25));

        frameProject.add(labelName);
        frameProject.add(textFieldName);
        frameProject.add(labelDescription);
        frameProject.add(scrollingDescription);
        frameProject.add(labelSupervisor);
        frameProject.add(textFieldSupervisor);
        frameProject.add(buttonSave);


        buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
            frameProject.dispose();
            }
        });
    }
        public void Edit(UniversityProject project){
        final JFrame frameProject = new JFrame("Editing "+project.getName());
        JLabel labelName = new JLabel("Project name");
        JLabel labelDescription = new JLabel("Description:");
        JLabel labelSupervisor = new JLabel("Supervisor");    
        final JTextField textFieldName = new JTextField(project.getName());       
        final JTextArea textAreaDescription = new JTextArea(project.getDescription());
        final JTextField textFieldSupervisor = new JTextField(project.getSupervisor());
        JButton buttonSave = new JButton("Save project");
        
        frameProject.setSize(400, 450);
        frameProject.setLayout(null);
        frameProject.setVisible(true);
        frameProject.setLocationRelativeTo(null);
        
        textAreaDescription.setWrapStyleWord(true);
        textAreaDescription.setLineWrap(true);
        textAreaDescription.setBorder(BorderFactory.createCompoundBorder(textAreaDescription.getBorder(),BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        textAreaDescription.setFont(new Font("", Font.BOLD, 12));
        JScrollPane scrollingDescription = new JScrollPane(textAreaDescription);
        
        labelName.setBounds(10,10,100,30);
        labelName.setFont(new Font("", Font.BOLD, 15));
        textFieldName.setBounds(120,10,200,30);
        textFieldName.setFont(new Font("", Font.BOLD, 15));
        labelDescription.setBounds(10,50,110,30);
        labelDescription.setFont(new Font("", Font.BOLD, 15));
        scrollingDescription.setBounds(10,90,350,180);
        labelSupervisor.setBounds(10,280,100,30);
        labelSupervisor.setFont(new Font("", Font.BOLD, 15));
        textFieldSupervisor.setBounds(120,280,200,30);
        textFieldSupervisor.setFont(new Font("", Font.BOLD, 15));
        buttonSave.setBounds(75,320,250,80);
        buttonSave.setFont(new Font("",Font.BOLD,25));

        frameProject.add(labelName);
        frameProject.add(textFieldName);
        frameProject.add(labelDescription);
        frameProject.add(scrollingDescription);
        frameProject.add(labelSupervisor);
        frameProject.add(textFieldSupervisor);
        frameProject.add(buttonSave);


        buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
            frameProject.dispose();
            }
        });
    }
        public void Remove(){
    }
}

