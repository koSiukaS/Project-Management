package project.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.Border;
import project.model.UniversityProject;

public class ProjectActionDialogs{
    private String tempTextName, tempTextSupervisor, tempTextDescription;
    private Border compound, oldFieldBorder, oldAreaBorder;
    private Boolean boolName, boolSupervisor, boolDescription;
    
    public void addProject(final ArrayList<UniversityProject> projects, final MainFrame frame){
        final JDialog dialogProject = new JDialog();
        dialogProject.setTitle("Adding a project");
        JPanel panelProject = new JPanel();
        JLabel labelName = new JLabel("Project name:");
        JLabel labelDescription = new JLabel("Description:");
        JLabel labelSupervisor = new JLabel("Supervisor:");    
        final JTextField textFieldName = new JTextField(15);
        final JTextField textFieldSupervisor = new JTextField(10);
        final JTextArea textAreaDescription = new JTextArea(9, 34);
        JButton buttonSave = new JButton("Add project");
        
        textAreaDescription.setWrapStyleWord(true);
        textAreaDescription.setLineWrap(true);
        textAreaDescription.setBorder(BorderFactory.createCompoundBorder(textAreaDescription.getBorder(),BorderFactory.createEmptyBorder(2, 2, 2, 2)));
        JScrollPane scrollingDescription = new JScrollPane(textAreaDescription);
        textFieldName.setBorder(BorderFactory.createCompoundBorder(textFieldName.getBorder(),BorderFactory.createEmptyBorder(2, 2, 2, 2)));
        textFieldName.setDocument(new TextLimit(50));
        textFieldSupervisor.setBorder(BorderFactory.createCompoundBorder(textFieldSupervisor.getBorder(),BorderFactory.createEmptyBorder(2, 2, 2, 2))); 
        textFieldSupervisor.setDocument(new TextLimit(30));
        buttonSave.setPreferredSize(new Dimension(382, 30));
        
        SpringLayout spring = new SpringLayout();
        panelProject.setLayout(spring);
        panelProject.setPreferredSize(new Dimension(480, 240));
        panelProject.add(labelName);
        panelProject.add(textFieldName);
        panelProject.add(labelDescription);
        panelProject.add(scrollingDescription);
        panelProject.add(labelSupervisor);
        panelProject.add(textFieldSupervisor);
        panelProject.add(buttonSave);
        panelProject.setVisible(true);

        spring.putConstraint(SpringLayout.WEST, labelName, 10, SpringLayout.WEST, panelProject);
        spring.putConstraint(SpringLayout.VERTICAL_CENTER, labelName, 0, SpringLayout.VERTICAL_CENTER, textFieldName);
        spring.putConstraint(SpringLayout.WEST, textFieldName, 6, SpringLayout.EAST, labelName);
        spring.putConstraint(SpringLayout.NORTH, textFieldName, 10, SpringLayout.NORTH, panelProject);
        spring.putConstraint(SpringLayout.WEST, labelDescription, 0, SpringLayout.WEST, labelName);
        spring.putConstraint(SpringLayout.NORTH, labelDescription, 0, SpringLayout.NORTH, scrollingDescription);
        spring.putConstraint(SpringLayout.WEST, scrollingDescription, 0, SpringLayout.WEST, textFieldName);
        spring.putConstraint(SpringLayout.NORTH, scrollingDescription, 10, SpringLayout.SOUTH, textFieldName);
        spring.putConstraint(SpringLayout.EAST, textFieldSupervisor, 0, SpringLayout.EAST, scrollingDescription);
        spring.putConstraint(SpringLayout.NORTH, textFieldSupervisor, 10, SpringLayout.NORTH, panelProject);
        spring.putConstraint(SpringLayout.EAST, labelSupervisor, -6, SpringLayout.WEST, textFieldSupervisor);
        spring.putConstraint(SpringLayout.VERTICAL_CENTER, labelSupervisor, 0, SpringLayout.VERTICAL_CENTER, textFieldSupervisor);
        spring.putConstraint(SpringLayout.EAST, buttonSave, 0, SpringLayout.EAST, scrollingDescription);
        spring.putConstraint(SpringLayout.NORTH, buttonSave, 10, SpringLayout.SOUTH, scrollingDescription);
        
        Border redLine = BorderFactory.createLineBorder(Color.red);
        Border spacing = BorderFactory.createEmptyBorder(2, 2, 2, 2);
        compound = BorderFactory.createCompoundBorder(redLine, spacing);
        oldFieldBorder = textFieldName.getBorder();
        oldAreaBorder = textAreaDescription.getBorder();
        
                textFieldName.addFocusListener(new FocusListener() {
                       @Override
                       public void focusGained(FocusEvent e) {
                           textFieldName.setText(tempTextName);
                } 

                        @Override
                        public void focusLost(FocusEvent e) {
                            tempTextName = textFieldName.getText();
                            if (textFieldName.getText().length() < 4) {
                                textFieldName.setBackground(new Color(255, 180, 180));
                                textFieldName.setBorder(compound);
                                textFieldName.setText("At least 4 characters");
                                boolName = false;
                            }
                            else {
                                textFieldName.setBackground(new Color(255, 255, 255));
                                textFieldName.setBorder(oldFieldBorder);
                                boolName = true;
                            }
                        }
                    });
                
                textFieldSupervisor.addFocusListener(new FocusListener() {
                       @Override
                       public void focusGained(FocusEvent e) {
                           textFieldSupervisor.setText(tempTextSupervisor);
                } 

                        @Override
                        public void focusLost(FocusEvent e) {
                            tempTextSupervisor = textFieldSupervisor.getText();
                            if (textFieldSupervisor.getText().length() < 4) {
                                textFieldSupervisor.setBackground(new Color(255, 180, 180));
                                textFieldSupervisor.setBorder(compound);
                                textFieldSupervisor.setText("At least 4 characters");
                                boolSupervisor = false;
                            }
                            else {
                                textFieldSupervisor.setBackground(new Color(255, 255, 255));
                                textFieldSupervisor.setBorder(oldFieldBorder);
                                boolSupervisor = true;
                            }
                        }
                    });
                
                textAreaDescription.addFocusListener(new FocusListener() {
                       @Override
                       public void focusGained(FocusEvent e) {
                           textAreaDescription.setText(tempTextDescription);
                } 

                        @Override
                        public void focusLost(FocusEvent e) {
                            tempTextDescription = textAreaDescription.getText();
                            if (textAreaDescription.getText().length() < 100) {
                                textAreaDescription.setBackground(new Color(255, 180, 180));
                                textAreaDescription.setBorder(compound);
                                textAreaDescription.setText("The description must consist out of 100 characters at least");
                                boolDescription = false;
                            }
                            else {
                                textAreaDescription.setBackground(new Color(255, 255, 255));
                                textAreaDescription.setBorder(oldAreaBorder);
                                boolDescription = true;
                            }
                        }
                    });
        
        buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                checkFields(textFieldName, textFieldSupervisor, textAreaDescription);
                if (boolName && boolSupervisor && boolDescription) {
                UniversityProject project = new UniversityProject();
                project.setName(textFieldName.getText());
                project.setDescription(textAreaDescription.getText());
                project.setSupervisor(textFieldSupervisor.getText());
                projects.add(project);
                frame.refreshData();
                dialogProject.dispose();
                }
            }
        });
        dialogProject.add(panelProject);
        dialogProject.pack();
        dialogProject.setLocationRelativeTo(null);
        dialogProject.setResizable(false);
        dialogProject.setModal(true);
        dialogProject.setVisible(true);
        //Image img = ImageIO.read(getClass().getResource("./src/project/*.png"));
        //dialogProject.setIconImage(img);
    } 

    public void editProject(final UniversityProject project, final MainFrame frame, final ProjectJPanels panel){     
        final JDialog dialogProject = new JDialog();
        dialogProject.setTitle("Editing "+project.getName());
        final JPanel panelProject = new JPanel();
        JLabel labelName = new JLabel("Project name:");
        JLabel labelDescription = new JLabel("Description:");
        JLabel labelSupervisor = new JLabel("Supervisor:");    
        final JTextField textFieldName = new JTextField(15);
        final JTextField textFieldSupervisor = new JTextField(10);
        final JTextArea textAreaDescription = new JTextArea(project.getDescription(),9, 34);
        JButton buttonSave = new JButton("Save project");
        
        tempTextName = project.getName();
        tempTextSupervisor = project.getSupervisor();
        tempTextDescription = project.getDescription();
        
        textAreaDescription.setWrapStyleWord(true);
        textAreaDescription.setLineWrap(true);
        textAreaDescription.setBorder(BorderFactory.createCompoundBorder(textAreaDescription.getBorder(),BorderFactory.createEmptyBorder(2, 2, 2, 2)));
        JScrollPane scrollingDescription = new JScrollPane(textAreaDescription);
        textFieldName.setBorder(BorderFactory.createCompoundBorder(textFieldName.getBorder(),BorderFactory.createEmptyBorder(2, 2, 2, 2)));
        textFieldName.setDocument(new TextLimit(50));
        textFieldSupervisor.setBorder(BorderFactory.createCompoundBorder(textFieldSupervisor.getBorder(),BorderFactory.createEmptyBorder(2, 2, 2, 2))); 
        textFieldSupervisor.setDocument(new TextLimit(30));
        buttonSave.setPreferredSize(new Dimension(382, 30));
        
        textFieldName.setText(tempTextName);
        textFieldSupervisor.setText(tempTextSupervisor);
        textAreaDescription.setText(tempTextDescription);
        
        SpringLayout spring = new SpringLayout();
        panelProject.setLayout(spring);
        panelProject.setPreferredSize(new Dimension(480, 240));
        panelProject.add(labelName);
        panelProject.add(textFieldName);
        panelProject.add(labelDescription);
        panelProject.add(scrollingDescription);
        panelProject.add(labelSupervisor);
        panelProject.add(textFieldSupervisor);
        panelProject.add(buttonSave);
        panelProject.setVisible(true);

        spring.putConstraint(SpringLayout.WEST, labelName, 10, SpringLayout.WEST, panelProject);
        spring.putConstraint(SpringLayout.VERTICAL_CENTER, labelName, 0, SpringLayout.VERTICAL_CENTER, textFieldName);
        spring.putConstraint(SpringLayout.WEST, textFieldName, 6, SpringLayout.EAST, labelName);
        spring.putConstraint(SpringLayout.NORTH, textFieldName, 10, SpringLayout.NORTH, panelProject);
        spring.putConstraint(SpringLayout.WEST, labelDescription, 0, SpringLayout.WEST, labelName);
        spring.putConstraint(SpringLayout.NORTH, labelDescription, 0, SpringLayout.NORTH, scrollingDescription);
        spring.putConstraint(SpringLayout.WEST, scrollingDescription, 0, SpringLayout.WEST, textFieldName);
        spring.putConstraint(SpringLayout.NORTH, scrollingDescription, 10, SpringLayout.SOUTH, textFieldName);
        spring.putConstraint(SpringLayout.EAST, textFieldSupervisor, 0, SpringLayout.EAST, scrollingDescription);
        spring.putConstraint(SpringLayout.NORTH, textFieldSupervisor, 10, SpringLayout.NORTH, panelProject);
        spring.putConstraint(SpringLayout.EAST, labelSupervisor, -6, SpringLayout.WEST, textFieldSupervisor);
        spring.putConstraint(SpringLayout.VERTICAL_CENTER, labelSupervisor, 0, SpringLayout.VERTICAL_CENTER, textFieldSupervisor);
        spring.putConstraint(SpringLayout.EAST, buttonSave, 0, SpringLayout.EAST, scrollingDescription);
        spring.putConstraint(SpringLayout.NORTH, buttonSave, 10, SpringLayout.SOUTH, scrollingDescription);
        
        boolName = boolSupervisor = boolDescription = true;
        
        Border redLine = BorderFactory.createLineBorder(Color.red);
        Border spacing = BorderFactory.createEmptyBorder(2, 2, 2, 2);
        compound = BorderFactory.createCompoundBorder(redLine, spacing);
        oldFieldBorder = textFieldName.getBorder();
        oldAreaBorder = textAreaDescription.getBorder();
        
                textFieldName.addFocusListener(new FocusListener() {
                       @Override
                       public void focusGained(FocusEvent e) {
                           textFieldName.setText(tempTextName);
                } 

                        @Override
                        public void focusLost(FocusEvent e) {
                            tempTextName = textFieldName.getText();
                            if (textFieldName.getText().length() < 4) {
                                textFieldName.setBackground(new Color(255, 180, 180));
                                textFieldName.setBorder(compound);
                                textFieldName.setText("At least 4 characters");
                                boolName = false;
                            }
                            else {
                                textFieldName.setBackground(new Color(255, 255, 255));
                                textFieldName.setBorder(oldFieldBorder);
                                boolName = true;
                            }
                        }
                    });
                
                textFieldSupervisor.addFocusListener(new FocusListener() {
                       @Override
                       public void focusGained(FocusEvent e) {
                           textFieldSupervisor.setText(tempTextSupervisor);
                } 

                        @Override
                        public void focusLost(FocusEvent e) {
                            tempTextSupervisor = textFieldSupervisor.getText();
                            if (textFieldSupervisor.getText().length() < 4) {
                                textFieldSupervisor.setBackground(new Color(255, 180, 180));
                                textFieldSupervisor.setBorder(compound);
                                textFieldSupervisor.setText("At least 4 characters");
                                boolSupervisor = false;
                            }
                            else {
                                textFieldSupervisor.setBackground(new Color(255, 255, 255));
                                textFieldSupervisor.setBorder(oldFieldBorder);
                                boolSupervisor = true;
                            }
                        }
                    });
                
                textAreaDescription.addFocusListener(new FocusListener() {
                       @Override
                       public void focusGained(FocusEvent e) {
                           textAreaDescription.setText(tempTextDescription);
                } 

                        @Override
                        public void focusLost(FocusEvent e) {
                            tempTextDescription = textAreaDescription.getText();
                            if (textAreaDescription.getText().length() < 100) {
                                textAreaDescription.setBackground(new Color(255, 180, 180));
                                textAreaDescription.setBorder(compound);
                                textAreaDescription.setText("The description must consist out of 100 characters at least");
                                boolDescription = false;
                            }
                            else {
                                textAreaDescription.setBackground(new Color(255, 255, 255));
                                textAreaDescription.setBorder(oldAreaBorder);
                                boolDescription = true;
                            }
                        }
                    });

                boolName = boolSupervisor = boolDescription = true;
                
        buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                checkFields(textFieldName, textFieldSupervisor, textAreaDescription);
                if (boolName && boolSupervisor && boolDescription) {
                    project.setName(textFieldName.getText());
                    project.setSupervisor(textFieldSupervisor.getText());
                    project.setDescription(textAreaDescription.getText());
                    panel.refreshData();
                    dialogProject.dispose();
                }
            }
        });
        dialogProject.add(panelProject);
        dialogProject.pack();
        dialogProject.setLocationRelativeTo(null);
        dialogProject.setResizable(false);
        dialogProject.setModal(true);
        dialogProject.setVisible(true);
        //Image img = ImageIO.read(getClass().getResource("./src/project/*.png"));
        //dialogProject.setIconImage(img);
    }
        public void removeProject(final ArrayList<UniversityProject> projects, final MainFrame mainPanel){
            if(projects.size() > 0) {
                final JDialog dialog = new JDialog();
                dialog.setSize(360, 130);
                dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                dialog.setTitle("Remove project");
                Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
                dialog.setLocation(dim.width / 2 - dialog.getSize().width / 2, dim.height / 2 - dialog.getSize().height / 2);

                JPanel panel = new JPanel();
                SpringLayout layout = new SpringLayout();
                panel.setLayout(layout);

                JLabel projectLabel = new JLabel("Select project:");

                String[] projectNames = new String[projects.size()];
                for (int i = 0; i < projectNames.length; i++) {
                    projectNames[i] = projects.get(i).getName();
                }

                final JComboBox projectList = new JComboBox(projectNames);
                projectList.setSelectedIndex(0);
                projectList.setPreferredSize(new Dimension(230, 25));

                JButton button = new JButton("Remove");
                button.setPreferredSize(new Dimension(230, 30));
                new NavigationAndButtons().removeButton(button, projects, projectList, mainPanel, dialog);

                panel.add(projectLabel);
                panel.add(projectList);
                panel.add(button);

                layout.putConstraint(SpringLayout.NORTH, projectLabel, 13, SpringLayout.NORTH, panel);
                layout.putConstraint(SpringLayout.WEST, projectLabel, 10, SpringLayout.WEST, panel);
                layout.putConstraint(SpringLayout.NORTH, projectList, 10, SpringLayout.NORTH, panel);
                layout.putConstraint(SpringLayout.WEST, projectList, 100, SpringLayout.WEST, projectLabel);
                layout.putConstraint(SpringLayout.NORTH, button, 35, SpringLayout.NORTH, projectLabel);
                layout.putConstraint(SpringLayout.WEST, button, 100, SpringLayout.WEST, projectLabel);

                dialog.add(panel);
                dialog.setLocationRelativeTo(null);
                dialog.setResizable(false);
                dialog.setModal(true);
                dialog.setVisible(true);
            }
            else {
                JDialog dialog = new JDialog();
                JOptionPane.showMessageDialog(dialog,
                        "There are no projects",
                        "Remove project",
                        JOptionPane.ERROR_MESSAGE);

            }
    }
        
        void checkFields(JTextField textFieldName, JTextField textFieldSupervisor, JTextArea textAreaDescription){
        if(boolName == null){
            tempTextName = textFieldName.getText();
            textFieldName.setBackground(new Color(255, 180, 180));
            textFieldName.setBorder(compound);
            textFieldName.setText("At least 4 characters");
        }
        if(boolSupervisor == null){
            tempTextSupervisor = textFieldSupervisor.getText();
            textFieldSupervisor.setBackground(new Color(255, 180, 180));
            textFieldSupervisor.setBorder(compound);
            textFieldSupervisor.setText("At least 4 characters");
        }
        if(boolDescription == null){
            tempTextDescription = textAreaDescription.getText();
            textAreaDescription.setBackground(new Color(255, 180, 180));
            textAreaDescription.setBorder(compound);
            textAreaDescription.setText("The description must consist out of 20 characters at least");
        }
    }
}

