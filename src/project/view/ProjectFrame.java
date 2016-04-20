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
        UniversityProject Project;

        public void Add(){
        
        final JFrame frame=new JFrame("Adding a project");
        
        frame.setSize(400,450);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        
        JLabel lname=new JLabel("Project name");
        JLabel ldescription=new JLabel("Description:");
        JLabel lsupervisor=new JLabel("Supervisor");
        
        final JTextField tname=new JTextField();
        final JTextArea textAreaDescription = new JTextArea();
        textAreaDescription.setWrapStyleWord(true);
        textAreaDescription.setLineWrap(true);
        textAreaDescription.setBorder(BorderFactory.createCompoundBorder(textAreaDescription.getBorder(),BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        textAreaDescription.setFont(new Font("", Font.BOLD, 12));
        JScrollPane scrollingDescription = new JScrollPane(textAreaDescription);
        scrollingDescription.setBounds(10,90,350,180);
        final JTextField tsupervisor=new JTextField();
        
        JButton save=new JButton("Add project");
        
        lname.setBounds(10,10,100,30);
        lname.setFont(new Font("", Font.BOLD, 15));
        
        tname.setBounds(120,10,200,30);
        tname.setFont(new Font("", Font.BOLD, 15));
        
        ldescription.setBounds(10,50,110,30);
        ldescription.setFont(new Font("", Font.BOLD, 15));
        
        
        lsupervisor.setBounds(10,280,100,30);
        lsupervisor.setFont(new Font("", Font.BOLD, 15));
        
        tsupervisor.setBounds(120,280,200,30);
        tsupervisor.setFont(new Font("", Font.BOLD, 15));

        save.setBounds(75,320,250,80);
        save.setFont(new Font("",Font.BOLD,25));

        frame.add(lname);
        frame.add(tname);
        frame.add(ldescription);
        frame.add(scrollingDescription);
        frame.add(lsupervisor);
        frame.add(tsupervisor);
        frame.add(save);


        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
            /*newProject.setName(tname.getText());
            newProject.setDescription(tdescription.getText());
            newProject.setSupervisor(tsupervisor.getText());*/
            frame.dispose();
            }
        });
    }
        public void Edit(UniversityProject project){
        
        final JFrame frame=new JFrame("Editing "+project.getName());
        
        frame.setSize(400,450);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        
        JLabel lname=new JLabel("Project name");
        JLabel ldescription=new JLabel("Description:");
        JLabel lsupervisor=new JLabel("Supervisor");
        
        final JTextField tname=new JTextField(project.getName());
        final JTextArea textAreaDescription = new JTextArea(project.getDescription());
        textAreaDescription.setWrapStyleWord(true);
        textAreaDescription.setLineWrap(true);
        textAreaDescription.setBorder(BorderFactory.createCompoundBorder(textAreaDescription.getBorder(),BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        textAreaDescription.setFont(new Font("", Font.BOLD, 12));
        JScrollPane scrollingDescription = new JScrollPane(textAreaDescription);
        scrollingDescription.setBounds(10,90,350,180);
        final JTextField tsupervisor=new JTextField(project.getSupervisor());
        
        JButton save=new JButton("Save project");
        
        lname.setBounds(10,10,100,30);
        lname.setFont(new Font("", Font.BOLD, 15));
        
        tname.setBounds(120,10,200,30);
        tname.setFont(new Font("", Font.BOLD, 15));
        
        ldescription.setBounds(10,50,110,30);
        ldescription.setFont(new Font("", Font.BOLD, 15));
        
        scrollingDescription.setBounds(10,90,350,180);
        
        lsupervisor.setBounds(10,280,100,30);
        lsupervisor.setFont(new Font("", Font.BOLD, 15));
        
        tsupervisor.setBounds(120,280,200,30);
        tsupervisor.setFont(new Font("", Font.BOLD, 15));

        save.setBounds(75,320,250,80);
        save.setFont(new Font("",Font.BOLD,25));

        frame.add(lname);
        frame.add(tname);
        frame.add(ldescription);
        frame.add(scrollingDescription);
        frame.add(lsupervisor);
        frame.add(tsupervisor);
        frame.add(save);


        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
            /*newProject.setName(tname.getText());
            newProject.setDescription(tdescription.getText());
            newProject.setSupervisor(tsupervisor.getText());*/
            frame.dispose();
            }
        });
    }
        public void Remove(){
    }
}

