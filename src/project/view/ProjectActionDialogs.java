package project.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import project.model.UniversityProject;

class JTextFieldLimit extends PlainDocument {
  private int limit;
  JTextFieldLimit(int limit) {
    super();
    this.limit = limit;
  }

  JTextFieldLimit(int limit, boolean upper) {
    super();
    this.limit = limit;
  }

  public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
    if (str == null)
      return;

    if ((getLength() + str.length()) <= limit) {
      super.insertString(offset, str, attr);
    }
  }
}

public class ProjectActionDialogs{
    
    public void addProject(final ArrayList<UniversityProject> projects, final MainFrame frame){
        final JDialog dialogProject = new JDialog();
        dialogProject.setTitle("Adding a project");
        JPanel panelProject = new JPanel();
        JLabel labelName = new JLabel("Project name:");
        JLabel labelDescription = new JLabel("Description:");
        JLabel labelSupervisor = new JLabel("Supervisor:");    
        final JTextField textFieldName = new JTextField(15);
        final JTextField textFieldSupervisor = new JTextField(10);
        final JTextArea textAreaDescription = new JTextArea(8, 32);
        JButton buttonSave = new JButton("Add project");
        
        textAreaDescription.setWrapStyleWord(true);
        textAreaDescription.setLineWrap(true);
        textAreaDescription.setBorder(BorderFactory.createCompoundBorder(textAreaDescription.getBorder(),BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        JScrollPane scrollingDescription = new JScrollPane(textAreaDescription);
        textFieldName.setBorder(BorderFactory.createCompoundBorder(textFieldName.getBorder(),BorderFactory.createEmptyBorder(2, 2, 2, 2)));
        textFieldName.setDocument(new JTextFieldLimit(50));
        textFieldSupervisor.setBorder(BorderFactory.createCompoundBorder(textFieldSupervisor.getBorder(),BorderFactory.createEmptyBorder(2, 2, 2, 2))); 
        textFieldSupervisor.setDocument(new JTextFieldLimit(30));
        buttonSave.setPreferredSize(new Dimension(365, 30));
        
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
        
        dialogProject.add(panelProject);
        dialogProject.setResizable(false);
        dialogProject.setVisible(true);
        dialogProject.pack();
        dialogProject.setLocationRelativeTo(null);

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
        
        buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (textFieldName.getText().length() < 4) {
                    textFieldName.setText("at least 4 characters");
                    textFieldName.addFocusListener(new FocusListener() {
                       @Override
                       public void focusGained(FocusEvent e) {
                    textFieldName.setText("");
                } 

                        @Override
                        public void focusLost(FocusEvent e) {
                        }
                    });
                }
                else if (textFieldSupervisor.getText().length() < 4) {
                    textFieldSupervisor.setText("At least 4 characters");
                    textFieldSupervisor.addFocusListener(new FocusListener() {
                       @Override
                       public void focusGained(FocusEvent e) {
                    textFieldSupervisor.setText("");
                } 

                        @Override
                        public void focusLost(FocusEvent e) {
                        }
                    });
                }
                else{
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
    } 

    public void Edit(UniversityProject project){     
        final JDialog dialogProject = new JDialog();
        dialogProject.setTitle("Editing "+project.getName());
        JPanel panelProject = new JPanel();
        JLabel labelName = new JLabel("Project name:");
        JLabel labelDescription = new JLabel("Description:");
        JLabel labelSupervisor = new JLabel("Supervisor:");    
        final JTextField textFieldName = new JTextField((project.getName()),15);
        final JTextField textFieldSupervisor = new JTextField((project.getDescription()),10);
        final JTextArea textAreaDescription = new JTextArea((project.getSupervisor()),8, 32);
        JButton buttonSave = new JButton("Save project");
        
        textAreaDescription.setWrapStyleWord(true);
        textAreaDescription.setLineWrap(true);
        textAreaDescription.setBorder(BorderFactory.createCompoundBorder(textAreaDescription.getBorder(),BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        textAreaDescription.setFont(new Font("", Font.BOLD, 12));
        JScrollPane scrollingDescription = new JScrollPane(textAreaDescription);
        textFieldName.setBorder(BorderFactory.createCompoundBorder(textFieldName.getBorder(),BorderFactory.createEmptyBorder(2, 2, 2, 2)));
        textFieldName.setDocument(new JTextFieldLimit(50));
        textFieldSupervisor.setBorder(BorderFactory.createCompoundBorder(textFieldSupervisor.getBorder(),BorderFactory.createEmptyBorder(2, 2, 2, 2))); 
        textFieldSupervisor.setDocument(new JTextFieldLimit(30));
        buttonSave.setPreferredSize(new Dimension(440, 30));
        
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
        
        dialogProject.add(panelProject);
        dialogProject.setResizable(false);
        dialogProject.setVisible(true);
        dialogProject.pack();
        dialogProject.setLocationRelativeTo(null);

        spring.putConstraint(SpringLayout.WEST, labelName, 10, SpringLayout.WEST, panelProject);
        spring.putConstraint(SpringLayout.VERTICAL_CENTER, labelName, 0, SpringLayout.VERTICAL_CENTER, textFieldName);
        spring.putConstraint(SpringLayout.WEST, textFieldName, 6, SpringLayout.EAST, labelName);
        spring.putConstraint(SpringLayout.NORTH, textFieldName, 10, SpringLayout.NORTH, panelProject);
        spring.putConstraint(SpringLayout.EAST, labelDescription, -6, SpringLayout.WEST, scrollingDescription);
        spring.putConstraint(SpringLayout.NORTH, labelDescription, 0, SpringLayout.NORTH, scrollingDescription);
        spring.putConstraint(SpringLayout.WEST, scrollingDescription, 0, SpringLayout.WEST, textFieldName);
        spring.putConstraint(SpringLayout.NORTH, scrollingDescription, 10, SpringLayout.SOUTH, textFieldName);
        spring.putConstraint(SpringLayout.EAST, textFieldSupervisor, 0, SpringLayout.EAST, scrollingDescription);
        spring.putConstraint(SpringLayout.NORTH, textFieldSupervisor, 10, SpringLayout.NORTH, panelProject);
        spring.putConstraint(SpringLayout.EAST, labelSupervisor, -6, SpringLayout.WEST, textFieldSupervisor);
        spring.putConstraint(SpringLayout.VERTICAL_CENTER, labelSupervisor, 0, SpringLayout.VERTICAL_CENTER, textFieldSupervisor);
        spring.putConstraint(SpringLayout.EAST, buttonSave, 0, SpringLayout.EAST, scrollingDescription);
        spring.putConstraint(SpringLayout.NORTH, buttonSave, 10, SpringLayout.SOUTH, scrollingDescription);


        buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (textFieldName.getText().length() < 4) {
                    textFieldName.setText("at least 4 characters");
                    textFieldName.addFocusListener(new FocusListener() {
                       @Override
                       public void focusGained(FocusEvent e) {
                    textFieldName.setText("");
                } 
                        @Override
                        public void focusLost(FocusEvent e) {
                        }
                    });
                }
                else if (textFieldSupervisor.getText().length() < 4) {
                    textFieldSupervisor.setText("At least 4 characters");
                    textFieldSupervisor.addFocusListener(new FocusListener() {
                       @Override
                       public void focusGained(FocusEvent e) {
                    textFieldSupervisor.setText("");
                } 
                        @Override
                        public void focusLost(FocusEvent e) {
                        }
                    });
                }
                else{
            dialogProject.dispose();
                }
            }
        });
    }
        public void Remove(){
    }
}

