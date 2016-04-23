package project.view;

import project.model.Student;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import javax.swing.border.Border;
import project.ProgramDate;


public class StudentActionDialogs{
    private String tempFirstName, tempLastName, tempId, tempPosition, tempCourseName;
    private Border compound, oldFieldBorder, oldAreaBorder;
    private JSpinner spinnerCourseGroup, spinnerCourseStartYear, spinnerCourseStartMonth,spinnerCourseStartDay,
                     spinnerCourseEndYear, spinnerCourseEndMonth, spinnerCourseEndDay, spinnerBirthYear, spinnerBirthMonth, spinnerBirthDay;
    private Boolean boolFirstName, boolLastName, boolId, boolPosition, boolCourseName, boolCourseGroup, boolCourseStartYear,
                    boolCourseStartMonth, boolCourseStartDay, boolCourseEndYear, boolCourseEndMonth, boolCourseEndDay, boolBirthYear,
                    boolBirthMonth, boolBirthDay;
    private ProgramDate date;
    
    public void addStudent(final ArrayList<Student> students, final ProjectJPanels mainPanel){
        date = mainPanel.date;
        final JDialog dialogStudent = new JDialog();
        dialogStudent.setTitle("Adding a student");
        JPanel panelStudent = new JPanel();
        JLabel labelFirstName = new JLabel("First Name:");
        JLabel labelLastName = new JLabel("Last Name:");
        JLabel labelId = new JLabel("Student Id:");
        JLabel labelPosition = new JLabel("Project role:");
        JLabel labelCourseName = new JLabel("Course name:");
        JLabel labelCourseGroup = new JLabel("Course group:");
        JLabel labelCourseStartYear = new JLabel("Course start date: Year");
        JLabel labelCourseStartMonth = new JLabel("Month");
        JLabel labelCourseStartDay = new JLabel("Day");
        JLabel labelCourseEndYear = new JLabel("Course end date:   Year");
        JLabel labelCourseEndMonth = new JLabel("Month");
        JLabel labelCourseEndDay = new JLabel("Day");
        JLabel labelBirthYear = new JLabel("Birth date:                Year");
        JLabel labelBirthMonth = new JLabel("Month");
        JLabel labelBirthDay = new JLabel("Day");
        final JTextField textFieldFirstName = new JTextField(12);
        final JTextField textFieldLastName = new JTextField(12);
        final JTextField textFieldId = new JTextField(12);
        final JTextField textFieldPosition = new JTextField(12);
        final JTextField textFieldCourseName = new JTextField(20);
        JButton buttonSave = new JButton("Add student");
        
        SpinnerNumberModel modelCourseGroup = new SpinnerNumberModel(0, 0, 99, 1);
        SpinnerNumberModel modelCourseStartYear = new SpinnerNumberModel(date.getProgramYear(), 1950, date.getProgramYear() + 100, 1);
        SpinnerNumberModel modelCourseStartMonth = new SpinnerNumberModel(date.getProgramMonth()+1, 1, 12, 1);
        SpinnerNumberModel modelCourseStartDay = new SpinnerNumberModel(date.getProgramDay(), 1, 31, 1);
        SpinnerNumberModel modelCourseEndYear = new SpinnerNumberModel(date.getProgramYear(), 1950, date.getProgramYear() + 100, 1);
        SpinnerNumberModel modelCourseEndMonth = new SpinnerNumberModel(date.getProgramMonth()+1, 1, 12, 1);
        SpinnerNumberModel modelCourseEndDay = new SpinnerNumberModel(date.getProgramDay(), 1, 31, 1);
        SpinnerNumberModel modelBirthYear = new SpinnerNumberModel(date.getProgramYear(), 1800, date.getProgramYear(), 1);
        SpinnerNumberModel modelBirthMonth = new SpinnerNumberModel(date.getProgramMonth()+1, 1, 12, 1);
        SpinnerNumberModel modelBirthDay = new SpinnerNumberModel(date.getProgramDay(), 1, 31, 1);
        
        spinnerCourseGroup = new JSpinner(modelCourseGroup);
        spinnerCourseStartYear = new JSpinner(modelCourseStartYear);
        spinnerCourseStartMonth = new JSpinner(modelCourseStartMonth);
        spinnerCourseStartDay = new JSpinner(modelCourseStartDay);
        spinnerCourseEndYear = new JSpinner(modelCourseEndYear);
        spinnerCourseEndMonth = new JSpinner(modelCourseEndMonth);
        spinnerCourseEndDay = new JSpinner(modelCourseEndDay);
        spinnerBirthYear = new JSpinner(modelBirthYear);
        spinnerBirthMonth = new JSpinner(modelBirthMonth);
        spinnerBirthDay = new JSpinner(modelBirthDay);
        
        customSpinner(spinnerCourseGroup);
        customSpinner(spinnerBirthYear);
        customSpinner(spinnerBirthMonth);
        customSpinner(spinnerBirthDay);
        customSpinner(spinnerCourseStartYear);
        customSpinner(spinnerCourseStartMonth);
        customSpinner(spinnerCourseStartDay);
        customSpinner(spinnerCourseEndYear);
        customSpinner(spinnerCourseEndMonth);
        customSpinner(spinnerCourseEndDay);
        
        textFieldFirstName.setBorder(BorderFactory.createCompoundBorder(textFieldFirstName.getBorder(),BorderFactory.createEmptyBorder(2, 2, 2, 2)));
        textFieldFirstName.setDocument(new TextLimit(30));
        textFieldLastName.setBorder(BorderFactory.createCompoundBorder(textFieldLastName.getBorder(),BorderFactory.createEmptyBorder(2, 2, 2, 2)));
        textFieldLastName.setDocument(new TextLimit(30));
        textFieldId.setBorder(BorderFactory.createCompoundBorder(textFieldId.getBorder(),BorderFactory.createEmptyBorder(2, 2, 2, 2)));
        textFieldId.setDocument(new TextLimit(30));
        textFieldPosition.setBorder(BorderFactory.createCompoundBorder(textFieldPosition.getBorder(),BorderFactory.createEmptyBorder(2, 2, 2, 2)));
        textFieldPosition.setDocument(new TextLimit(30));
        textFieldCourseName.setBorder(BorderFactory.createCompoundBorder(textFieldCourseName.getBorder(),BorderFactory.createEmptyBorder(2, 2, 2, 2)));
        textFieldCourseName.setDocument(new TextLimit(60));
        buttonSave.setPreferredSize(new Dimension(365, 30));
        
        SpringLayout spring = new SpringLayout();
        panelStudent.setLayout(spring);
        panelStudent.setPreferredSize(new Dimension(480, 280));
        panelStudent.add(labelFirstName);
        panelStudent.add(labelLastName);
        panelStudent.add(labelId);
        panelStudent.add(labelPosition);
        panelStudent.add(labelCourseName);
        panelStudent.add(labelCourseGroup);
        panelStudent.add(labelBirthYear);
        panelStudent.add(labelBirthMonth);
        panelStudent.add(labelBirthDay);
        panelStudent.add(labelCourseStartYear);
        panelStudent.add(labelCourseStartMonth);
        panelStudent.add(labelCourseStartDay);
        panelStudent.add(labelCourseEndYear);
        panelStudent.add(labelCourseEndMonth);
        panelStudent.add(labelCourseEndDay);
        panelStudent.add(textFieldFirstName);
        panelStudent.add(textFieldLastName);
        panelStudent.add(textFieldId);
        panelStudent.add(textFieldPosition);
        panelStudent.add(textFieldCourseName);
        panelStudent.add(spinnerBirthYear);
        panelStudent.add(spinnerBirthMonth);
        panelStudent.add(spinnerBirthDay);
        panelStudent.add(spinnerCourseGroup);
        panelStudent.add(spinnerCourseStartYear);
        panelStudent.add(spinnerCourseStartMonth);
        panelStudent.add(spinnerCourseStartDay);
        panelStudent.add(spinnerCourseEndYear);
        panelStudent.add(spinnerCourseEndMonth);
        panelStudent.add(spinnerCourseEndDay);
        panelStudent.add(buttonSave);
        panelStudent.setVisible(true);

        spring.putConstraint(SpringLayout.WEST, labelFirstName, 10, SpringLayout.WEST, panelStudent);
        spring.putConstraint(SpringLayout.VERTICAL_CENTER, labelFirstName, 0, SpringLayout.VERTICAL_CENTER, textFieldFirstName);
        spring.putConstraint(SpringLayout.WEST, textFieldFirstName, 20, SpringLayout.EAST, labelFirstName);
        spring.putConstraint(SpringLayout.NORTH, textFieldFirstName, 10, SpringLayout.NORTH, panelStudent);
        spring.putConstraint(SpringLayout.EAST, labelLastName, -10, SpringLayout.WEST, textFieldLastName);
        spring.putConstraint(SpringLayout.VERTICAL_CENTER, labelLastName, 0, SpringLayout.VERTICAL_CENTER, textFieldLastName);
        spring.putConstraint(SpringLayout.EAST, textFieldLastName, -10, SpringLayout.EAST, panelStudent);
        spring.putConstraint(SpringLayout.NORTH, textFieldLastName, 10, SpringLayout.NORTH, panelStudent);
        spring.putConstraint(SpringLayout.WEST, labelBirthYear, 10, SpringLayout.WEST, panelStudent);
        spring.putConstraint(SpringLayout.VERTICAL_CENTER, labelBirthYear, 0, SpringLayout.VERTICAL_CENTER, spinnerBirthYear);
        spring.putConstraint(SpringLayout.WEST, spinnerBirthYear, 0, SpringLayout.WEST, spinnerCourseStartYear);
        spring.putConstraint(SpringLayout.NORTH, spinnerBirthYear, 10, SpringLayout.SOUTH, textFieldFirstName);
        spring.putConstraint(SpringLayout.WEST, labelBirthMonth, 10, SpringLayout.EAST, spinnerBirthYear);
        spring.putConstraint(SpringLayout.VERTICAL_CENTER, labelBirthMonth, 0, SpringLayout.VERTICAL_CENTER, spinnerBirthYear);
        spring.putConstraint(SpringLayout.WEST, spinnerBirthMonth, 10, SpringLayout.EAST, labelBirthMonth);
        spring.putConstraint(SpringLayout.VERTICAL_CENTER, spinnerBirthMonth, 0, SpringLayout.VERTICAL_CENTER, spinnerBirthYear);
        spring.putConstraint(SpringLayout.WEST, labelBirthDay, 10, SpringLayout.EAST, spinnerBirthMonth);
        spring.putConstraint(SpringLayout.VERTICAL_CENTER, labelBirthDay, 0, SpringLayout.VERTICAL_CENTER, spinnerBirthYear);
        spring.putConstraint(SpringLayout.WEST, spinnerBirthDay, 10, SpringLayout.EAST, labelBirthDay);
        spring.putConstraint(SpringLayout.VERTICAL_CENTER, spinnerBirthDay, 0, SpringLayout.VERTICAL_CENTER, spinnerBirthYear);
        spring.putConstraint(SpringLayout.WEST, labelCourseName, 10, SpringLayout.WEST, panelStudent);
        spring.putConstraint(SpringLayout.VERTICAL_CENTER, labelCourseName, 0, SpringLayout.VERTICAL_CENTER, textFieldCourseName);
        spring.putConstraint(SpringLayout.WEST, textFieldCourseName, 0, SpringLayout.WEST, textFieldFirstName);
        spring.putConstraint(SpringLayout.NORTH, textFieldCourseName, 10, SpringLayout.SOUTH, textFieldId);
        spring.putConstraint(SpringLayout.EAST, labelCourseGroup, -10, SpringLayout.WEST, spinnerCourseGroup);
        spring.putConstraint(SpringLayout.VERTICAL_CENTER, labelCourseGroup, 0, SpringLayout.VERTICAL_CENTER, spinnerCourseGroup);
        spring.putConstraint(SpringLayout.EAST, spinnerCourseGroup, -10, SpringLayout.EAST, panelStudent);
        spring.putConstraint(SpringLayout.VERTICAL_CENTER, spinnerCourseGroup, 0, SpringLayout.VERTICAL_CENTER, textFieldCourseName);
        spring.putConstraint(SpringLayout.WEST, labelId, 10, SpringLayout.WEST, panelStudent);
        spring.putConstraint(SpringLayout.VERTICAL_CENTER, labelId, 0, SpringLayout.VERTICAL_CENTER, textFieldId);
        spring.putConstraint(SpringLayout.WEST, textFieldId, 0, SpringLayout.WEST, textFieldFirstName);
        spring.putConstraint(SpringLayout.NORTH, textFieldId, 10, SpringLayout.SOUTH, textFieldPosition);
        spring.putConstraint(SpringLayout.WEST, labelPosition, 10, SpringLayout.WEST, panelStudent);
        spring.putConstraint(SpringLayout.VERTICAL_CENTER, labelPosition, 0, SpringLayout.VERTICAL_CENTER, textFieldPosition);
        spring.putConstraint(SpringLayout.WEST, textFieldPosition, 0, SpringLayout.WEST, textFieldFirstName);
        spring.putConstraint(SpringLayout.NORTH, textFieldPosition, 10, SpringLayout.SOUTH, spinnerBirthYear);
        spring.putConstraint(SpringLayout.WEST, labelCourseStartYear, 10, SpringLayout.WEST, panelStudent);
        spring.putConstraint(SpringLayout.VERTICAL_CENTER, labelCourseStartYear, 0, SpringLayout.VERTICAL_CENTER, spinnerCourseStartYear);
        spring.putConstraint(SpringLayout.WEST, spinnerCourseStartYear, 10, SpringLayout.EAST, labelCourseStartYear);
        spring.putConstraint(SpringLayout.NORTH, spinnerCourseStartYear, 10, SpringLayout.SOUTH, spinnerCourseEndYear);
        spring.putConstraint(SpringLayout.WEST, labelCourseStartMonth, 10, SpringLayout.EAST, spinnerCourseStartYear);
        spring.putConstraint(SpringLayout.VERTICAL_CENTER, labelCourseStartMonth, 0, SpringLayout.VERTICAL_CENTER, spinnerCourseStartYear);
        spring.putConstraint(SpringLayout.WEST, spinnerCourseStartMonth, 10, SpringLayout.EAST, labelCourseStartMonth);
        spring.putConstraint(SpringLayout.VERTICAL_CENTER, spinnerCourseStartMonth, 0, SpringLayout.VERTICAL_CENTER, spinnerCourseStartYear);
        spring.putConstraint(SpringLayout.WEST, labelCourseStartDay, 10, SpringLayout.EAST, spinnerCourseStartMonth);
        spring.putConstraint(SpringLayout.VERTICAL_CENTER, labelCourseStartDay, 0, SpringLayout.VERTICAL_CENTER, spinnerCourseStartYear);
        spring.putConstraint(SpringLayout.WEST, spinnerCourseStartDay, 10, SpringLayout.EAST, labelCourseStartDay);
        spring.putConstraint(SpringLayout.VERTICAL_CENTER, spinnerCourseStartDay, 0, SpringLayout.VERTICAL_CENTER, spinnerCourseStartYear);
        spring.putConstraint(SpringLayout.WEST, labelCourseEndYear, 10, SpringLayout.WEST, panelStudent);
        spring.putConstraint(SpringLayout.VERTICAL_CENTER, labelCourseEndYear, 0, SpringLayout.VERTICAL_CENTER, spinnerCourseEndYear);
        spring.putConstraint(SpringLayout.WEST, spinnerCourseEndYear, 0, SpringLayout.WEST, spinnerCourseStartYear);
        spring.putConstraint(SpringLayout.NORTH, spinnerCourseEndYear, 10, SpringLayout.SOUTH, textFieldCourseName);
        spring.putConstraint(SpringLayout.WEST, labelCourseEndMonth, 10, SpringLayout.EAST, spinnerCourseEndYear);
        spring.putConstraint(SpringLayout.VERTICAL_CENTER, labelCourseEndMonth, 0, SpringLayout.VERTICAL_CENTER, spinnerCourseEndYear);
        spring.putConstraint(SpringLayout.WEST, spinnerCourseEndMonth, 10, SpringLayout.EAST, labelCourseEndMonth);
        spring.putConstraint(SpringLayout.VERTICAL_CENTER, spinnerCourseEndMonth, 0, SpringLayout.VERTICAL_CENTER, spinnerCourseEndYear);
        spring.putConstraint(SpringLayout.WEST, labelCourseEndDay, 10, SpringLayout.EAST, spinnerCourseEndMonth);
        spring.putConstraint(SpringLayout.VERTICAL_CENTER, labelCourseEndDay, 0, SpringLayout.VERTICAL_CENTER, spinnerCourseEndYear);
        spring.putConstraint(SpringLayout.WEST, spinnerCourseEndDay, 10, SpringLayout.EAST, labelCourseEndDay);
        spring.putConstraint(SpringLayout.VERTICAL_CENTER, spinnerCourseEndDay, 0, SpringLayout.VERTICAL_CENTER, spinnerCourseEndYear);
        spring.putConstraint(SpringLayout.HORIZONTAL_CENTER, buttonSave, 0, SpringLayout.HORIZONTAL_CENTER, panelStudent);
        spring.putConstraint(SpringLayout.SOUTH, buttonSave, -10, SpringLayout.SOUTH, panelStudent);
        
        
        Border redLine = BorderFactory.createLineBorder(Color.red);
        Border spacing = BorderFactory.createEmptyBorder(2, 2, 2, 2);
        compound = BorderFactory.createCompoundBorder(redLine, spacing);
        oldFieldBorder = textFieldFirstName.getBorder();
        
                textFieldFirstName.addFocusListener(new FocusListener() {
                       @Override
                       public void focusGained(FocusEvent e) {
                           textFieldFirstName.setText(tempFirstName);
                } 
                        @Override
                        public void focusLost(FocusEvent e) {
                            tempFirstName = textFieldFirstName.getText();
                            if (textFieldFirstName.getText().length() < 4) {
                                textFieldFirstName.setBackground(new Color(255, 180, 180));
                                textFieldFirstName.setBorder(compound);
                                textFieldFirstName.setText("At least 4 characters");
                                boolFirstName = false;
                            }
                            else {
                                textFieldFirstName.setBackground(new Color(255, 255, 255));
                                textFieldFirstName.setBorder(oldFieldBorder);
                                boolFirstName = true;
                            }
                        }
                    });
                
                textFieldLastName.addFocusListener(new FocusListener() {
                       @Override
                       public void focusGained(FocusEvent e) {
                           textFieldLastName.setText(tempLastName);
                } 
                        @Override
                        public void focusLost(FocusEvent e) {
                            tempLastName = textFieldLastName.getText();
                            if (textFieldLastName.getText().length() < 4) {
                                textFieldLastName.setBackground(new Color(255, 180, 180));
                                textFieldLastName.setBorder(compound);
                                textFieldLastName.setText("At least 4 characters");
                                boolLastName = false;
                            }
                            else {
                                textFieldLastName.setBackground(new Color(255, 255, 255));
                                textFieldLastName.setBorder(oldFieldBorder);
                                boolLastName = true;
                            }
                        }
                    });
                
                textFieldPosition.addFocusListener(new FocusListener() {
                       @Override
                       public void focusGained(FocusEvent e) {
                           textFieldPosition.setText(tempPosition);
                } 
                        @Override
                        public void focusLost(FocusEvent e) {
                            tempPosition = textFieldPosition.getText();
                            if (textFieldPosition.getText().length() < 4) {
                                textFieldPosition.setBackground(new Color(255, 180, 180));
                                textFieldPosition.setBorder(compound);
                                textFieldPosition.setText("At least 4 characters");
                                boolPosition = false;
                            }
                            else {
                                textFieldPosition.setBackground(new Color(255, 255, 255));
                                textFieldPosition.setBorder(oldFieldBorder);
                                boolPosition = true;
                            }
                        }
                    });
                
                textFieldId.addFocusListener(new FocusListener() {
                       @Override
                       public void focusGained(FocusEvent e) {
                           textFieldId.setText(tempId);
                } 
                        @Override
                        public void focusLost(FocusEvent e) {
                            tempId = textFieldId.getText();
                            if (textFieldId.getText().length() < 4) {
                                textFieldId.setBackground(new Color(255, 180, 180));
                                textFieldId.setBorder(compound);
                                textFieldId.setText("At least 4 characters");
                                boolId = false;
                            }
                            else {
                                textFieldId.setBackground(new Color(255, 255, 255));
                                textFieldId.setBorder(oldFieldBorder);
                                boolId = true;
                            }
                        }
                    });
                
                textFieldCourseName.addFocusListener(new FocusListener() {
                       @Override
                       public void focusGained(FocusEvent e) {
                           textFieldCourseName.setText(tempCourseName);
                } 
                        @Override
                        public void focusLost(FocusEvent e) {
                            tempCourseName = textFieldCourseName.getText();
                            if (textFieldCourseName.getText().length() < 4) {
                                textFieldCourseName.setBackground(new Color(255, 180, 180));
                                textFieldCourseName.setBorder(compound);
                                textFieldCourseName.setText("At least 4 characters");
                                boolCourseName = false;
                            }
                            else {
                                textFieldCourseName.setBackground(new Color(255, 255, 255));
                                textFieldCourseName.setBorder(oldFieldBorder);
                                boolCourseName = true;
                            }
                        }
                    });
                
                boolCourseStartYear = boolCourseStartMonth = boolCourseStartDay = boolCourseEndYear =
                boolCourseEndMonth = boolCourseEndDay = boolBirthYear = boolBirthMonth = boolBirthDay = true;
                boolCourseGroup = false;
                
                JSpinner.DefaultEditor editorCourseGroup = (JSpinner.DefaultEditor)spinnerCourseGroup.getEditor();
                JTextField textFieldCourseGroup = editorCourseGroup.getTextField();
                JSpinner.DefaultEditor editorBirthYear = (JSpinner.DefaultEditor)spinnerBirthYear.getEditor();
                JTextField textFieldBirthYear = editorBirthYear.getTextField();
                JSpinner.DefaultEditor editorBirthMonth = (JSpinner.DefaultEditor)spinnerBirthMonth.getEditor();
                JTextField textFieldBirthMonth = editorBirthMonth.getTextField();
                JSpinner.DefaultEditor editorBirthDay = (JSpinner.DefaultEditor)spinnerBirthDay.getEditor();
                JTextField textFieldBirthDay = editorBirthDay.getTextField();
                JSpinner.DefaultEditor editorCourseStartYear = (JSpinner.DefaultEditor)spinnerCourseStartYear.getEditor();
                JTextField textFieldCourseStartYear = editorCourseStartYear.getTextField();
                JSpinner.DefaultEditor editorCourseStartMonth = (JSpinner.DefaultEditor)spinnerCourseStartMonth.getEditor();
                JTextField textFieldCourseStartMonth = editorCourseStartMonth.getTextField();
                JSpinner.DefaultEditor editorCourseStartDay = (JSpinner.DefaultEditor)spinnerCourseStartDay.getEditor();
                JTextField textFieldCourseStartDay = editorCourseStartDay.getTextField();
                JSpinner.DefaultEditor editorCourseEndYear = (JSpinner.DefaultEditor)spinnerCourseEndYear.getEditor();
                JTextField textFieldCourseEndYear = editorCourseEndYear.getTextField();
                JSpinner.DefaultEditor editorCourseEndMonth = (JSpinner.DefaultEditor)spinnerCourseEndMonth.getEditor();
                JTextField textFieldCourseEndMonth = editorCourseEndMonth.getTextField();
                JSpinner.DefaultEditor editorCourseEndDay = (JSpinner.DefaultEditor)spinnerCourseEndDay.getEditor();
                JTextField textFieldCourseEndDay = editorCourseEndDay.getTextField();
                
                
                textFieldCourseGroup.addFocusListener(new FocusAdapter() {
                       @Override
                       public void focusGained(FocusEvent e) {
                } 
                        @Override
                        public void focusLost(FocusEvent e) {
                            if ((Integer)spinnerCourseGroup.getValue() == 0) {
                                spinnerRed(spinnerCourseGroup);
                                boolCourseGroup = false;
                            }
                            else {
                                spinnerOld(spinnerCourseGroup);
                                boolCourseGroup = true;
                            }
                        }
                    });
                
                textFieldBirthYear.addFocusListener(new FocusAdapter() {
                       @Override
                       public void focusGained(FocusEvent e) {
                } 
                        @Override
                        public void focusLost(FocusEvent e) {
                            if ((Integer)spinnerBirthYear.getValue() > (Integer)spinnerCourseStartYear.getValue() || (Integer)spinnerBirthYear.getValue() > (Integer)spinnerCourseEndYear.getValue()){
                                spinnerRed(spinnerBirthYear);
                                boolBirthYear = false;
                            }
                            else {
                                spinnerOld(spinnerBirthYear);
                                boolBirthYear = true;
                            }
                        }
                    });
                
                textFieldBirthMonth.addFocusListener(new FocusAdapter() {
                       @Override
                       public void focusGained(FocusEvent e) {
                } 
                        @Override
                        public void focusLost(FocusEvent e) {
                            if (((Integer)spinnerBirthYear.getValue() > (Integer)spinnerCourseStartYear.getValue() || (Integer)spinnerBirthYear.getValue() > (Integer)spinnerCourseEndYear.getValue()) ||
                               ((Integer)spinnerBirthYear.getValue() >= (Integer)spinnerCourseStartYear.getValue() && (Integer)spinnerBirthMonth.getValue() > (Integer)spinnerCourseStartMonth.getValue()) ||
                               ((Integer)spinnerBirthYear.getValue() >= (Integer)spinnerCourseEndYear.getValue() && (Integer)spinnerBirthMonth.getValue() > (Integer)spinnerCourseEndMonth.getValue())) {
                                spinnerRed(spinnerBirthMonth);
                                boolBirthMonth = false;
                            }
                            else {
                                spinnerOld(spinnerBirthMonth);
                                boolBirthMonth = true;
                            }
                        }
                    });
                
                textFieldBirthDay.addFocusListener(new FocusAdapter() {
                       @Override
                       public void focusGained(FocusEvent e) {
                } 
                        @Override
                        public void focusLost(FocusEvent e) {
                            if ((((Integer)spinnerBirthYear.getValue() > (Integer)spinnerCourseStartYear.getValue() || (Integer)spinnerBirthYear.getValue() > (Integer)spinnerCourseEndYear.getValue()) ||
                               ((Integer)spinnerBirthYear.getValue() >= (Integer)spinnerCourseStartYear.getValue() && (Integer)spinnerBirthMonth.getValue() > (Integer)spinnerCourseStartMonth.getValue()) ||
                               ((Integer)spinnerBirthYear.getValue() >= (Integer)spinnerCourseEndYear.getValue() && (Integer)spinnerBirthMonth.getValue() > (Integer)spinnerCourseEndMonth.getValue())) ||
                               ((Integer)spinnerBirthYear.getValue() >= (Integer)spinnerCourseStartYear.getValue() && (Integer)spinnerBirthMonth.getValue() >= (Integer)spinnerCourseStartMonth.getValue() && (Integer)spinnerBirthDay.getValue() > (Integer)spinnerCourseStartDay.getValue()) ||
                               ((Integer)spinnerBirthYear.getValue() >= (Integer)spinnerCourseEndYear.getValue() && (Integer)spinnerBirthMonth.getValue() >= (Integer)spinnerCourseEndMonth.getValue() && (Integer)spinnerBirthDay.getValue() > (Integer)spinnerCourseEndDay.getValue())) {
                                spinnerRed(spinnerBirthDay);
                                boolBirthDay = false;
                            }
                            else {
                                spinnerOld(spinnerBirthDay);
                                boolBirthDay = true;
                            }
                        }
                    });
                
                textFieldCourseStartYear.addFocusListener(new FocusAdapter() {
                       @Override
                       public void focusGained(FocusEvent e) {
                } 
                        @Override
                        public void focusLost(FocusEvent e) {
                            if ((Integer)spinnerBirthYear.getValue() > (Integer)spinnerCourseStartYear.getValue() || (Integer)spinnerCourseStartYear.getValue() > (Integer)spinnerCourseEndYear.getValue()) {
                                spinnerRed(spinnerCourseStartYear);
                                boolCourseStartYear = false;
                            }
                            else {
                                spinnerOld(spinnerCourseStartYear);
                                boolCourseStartYear = true;
                            }
                        }
                    });
                
                textFieldCourseStartMonth.addFocusListener(new FocusAdapter() {
                       @Override
                       public void focusGained(FocusEvent e) {
                } 
                        @Override
                        public void focusLost(FocusEvent e) {
                            if (((Integer)spinnerBirthYear.getValue() > (Integer)spinnerCourseStartYear.getValue() || (Integer)spinnerCourseStartYear.getValue() > (Integer)spinnerCourseEndYear.getValue()) ||
                               ((Integer)spinnerBirthYear.getValue() >= (Integer)spinnerCourseStartYear.getValue() && (Integer)spinnerBirthMonth.getValue() > (Integer)spinnerCourseStartMonth.getValue()) ||
                               ((Integer)spinnerCourseStartYear.getValue() >= (Integer)spinnerCourseEndYear.getValue() && (Integer)spinnerCourseStartMonth.getValue() > (Integer)spinnerCourseEndMonth.getValue())) {
                                spinnerRed(spinnerCourseStartMonth);
                                boolCourseStartMonth = false;
                            }
                            else {
                                spinnerOld(spinnerCourseStartMonth);
                                boolCourseStartMonth = true;
                            }
                        }
                    });
                
                textFieldCourseStartDay.addFocusListener(new FocusAdapter() {
                       @Override
                       public void focusGained(FocusEvent e) {
                } 
                        @Override
                        public void focusLost(FocusEvent e) {
                            if ((((Integer)spinnerBirthYear.getValue() > (Integer)spinnerCourseStartYear.getValue() || (Integer)spinnerCourseStartYear.getValue() > (Integer)spinnerCourseEndYear.getValue()) ||
                               ((Integer)spinnerBirthYear.getValue() >= (Integer)spinnerCourseStartYear.getValue() && (Integer)spinnerBirthMonth.getValue() > (Integer)spinnerCourseStartMonth.getValue()) ||
                               ((Integer)spinnerCourseStartYear.getValue() >= (Integer)spinnerCourseEndYear.getValue() && (Integer)spinnerCourseStartMonth.getValue() > (Integer)spinnerCourseEndMonth.getValue())) ||
                               ((Integer)spinnerBirthYear.getValue() >= (Integer)spinnerCourseStartYear.getValue() && (Integer)spinnerBirthMonth.getValue() >= (Integer)spinnerCourseStartMonth.getValue() && (Integer)spinnerBirthDay.getValue() > (Integer)spinnerCourseStartDay.getValue()) ||
                               ((Integer)spinnerCourseStartYear.getValue() >= (Integer)spinnerCourseEndYear.getValue() && (Integer)spinnerCourseStartMonth.getValue() >= (Integer)spinnerCourseEndMonth.getValue() && (Integer)spinnerCourseStartDay.getValue() > (Integer)spinnerCourseEndDay.getValue())) {
                                spinnerRed(spinnerCourseStartDay);
                                boolCourseStartDay = false;
                            }
                            else {
                                spinnerOld(spinnerCourseStartDay);
                                boolCourseStartDay = true;
                            }
                        }
                    });
                
                textFieldCourseEndYear.addFocusListener(new FocusAdapter() {
                       @Override
                       public void focusGained(FocusEvent e) {
                } 
                        @Override
                        public void focusLost(FocusEvent e) {
                            if ((Integer)spinnerBirthYear.getValue() > (Integer)spinnerCourseEndYear.getValue() || (Integer)spinnerCourseStartYear.getValue() > (Integer)spinnerCourseEndYear.getValue()) {
                                spinnerRed(spinnerCourseEndYear);
                                boolCourseEndYear = false;
                            }
                            else {
                                spinnerOld(spinnerCourseEndYear);
                                boolCourseEndYear = true;
                            }
                        }
                    });
                
                textFieldCourseEndMonth.addFocusListener(new FocusAdapter() {
                       @Override
                       public void focusGained(FocusEvent e) {
                } 
                        @Override
                        public void focusLost(FocusEvent e) {
                            if (((Integer)spinnerBirthYear.getValue() > (Integer)spinnerCourseEndYear.getValue() || (Integer)spinnerCourseStartYear.getValue() > (Integer)spinnerCourseEndYear.getValue()) ||
                               ((Integer)spinnerBirthYear.getValue() >= (Integer)spinnerCourseEndYear.getValue() && (Integer)spinnerBirthMonth.getValue() > (Integer)spinnerCourseEndMonth.getValue()) ||
                               ((Integer)spinnerCourseStartYear.getValue() >= (Integer)spinnerCourseEndYear.getValue() && (Integer)spinnerCourseStartMonth.getValue() > (Integer)spinnerCourseEndMonth.getValue())) {
                                spinnerRed(spinnerCourseEndMonth);
                                boolCourseEndMonth = false;
                            }
                            else {
                                spinnerOld(spinnerCourseEndMonth);
                                boolCourseEndMonth = true;
                            }
                        }
                    });
                
                textFieldCourseEndDay.addFocusListener(new FocusAdapter() {
                       @Override
                       public void focusGained(FocusEvent e) {
                } 
                        @Override
                        public void focusLost(FocusEvent e) {
                            if ((((Integer)spinnerBirthYear.getValue() > (Integer)spinnerCourseEndYear.getValue() || (Integer)spinnerCourseStartYear.getValue() > (Integer)spinnerCourseEndYear.getValue()) ||
                               ((Integer)spinnerBirthYear.getValue() >= (Integer)spinnerCourseEndYear.getValue() && (Integer)spinnerBirthMonth.getValue() > (Integer)spinnerCourseEndMonth.getValue()) ||
                               ((Integer)spinnerCourseStartYear.getValue() >= (Integer)spinnerCourseEndYear.getValue() && (Integer)spinnerCourseStartMonth.getValue() > (Integer)spinnerCourseEndMonth.getValue())) ||
                               ((Integer)spinnerBirthYear.getValue() >= (Integer)spinnerCourseEndYear.getValue() && (Integer)spinnerBirthMonth.getValue() >= (Integer)spinnerCourseEndMonth.getValue() && (Integer)spinnerBirthDay.getValue() > (Integer)spinnerCourseEndDay.getValue()) ||
                               ((Integer)spinnerCourseStartYear.getValue() >= (Integer)spinnerCourseEndYear.getValue() && (Integer)spinnerCourseStartMonth.getValue() >= (Integer)spinnerCourseEndMonth.getValue() && (Integer)spinnerCourseStartDay.getValue() > (Integer)spinnerCourseEndDay.getValue())) {
                                spinnerRed(spinnerCourseEndDay);
                                boolCourseEndDay = false;
                            }
                            else {
                                spinnerOld(spinnerCourseEndDay);
                                boolCourseEndDay = true;
                            }
                        }
                    });
        
        buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                checkFields(textFieldFirstName, textFieldLastName, textFieldPosition, textFieldId, textFieldCourseName);
                checkSpinners();
                if(boolCourseGroup && boolCourseStartYear && boolCourseStartMonth && boolCourseStartDay && boolCourseEndYear &&
                   boolCourseEndMonth && boolCourseEndDay && boolBirthYear && boolBirthMonth && boolBirthDay && boolFirstName &&
                   boolLastName && boolPosition && boolId && boolCourseName){
                Student student = new Student();
                student.setFirstName(textFieldFirstName.getText());
                student.setLastName(textFieldLastName.getText());
                student.setPosition(textFieldPosition.getText());
                student.setCourseName(textFieldCourseName.getText());
                student.setId(textFieldId.getText());
                student.setGroup((Integer)spinnerCourseGroup.getValue());
                student.setBirthYear((Integer)spinnerBirthYear.getValue());
                student.setBirthMonth((Integer)spinnerBirthMonth.getValue());
                student.setBirthDay((Integer)spinnerBirthDay.getValue());
                student.setCourseStartYear((Integer)spinnerCourseStartYear.getValue());
                student.setCourseStartMonth((Integer)spinnerCourseStartMonth.getValue());
                student.setCourseStartDay((Integer)spinnerCourseStartDay.getValue());
                student.setCourseEndYear((Integer)spinnerCourseEndYear.getValue());
                student.setCourseEndMonth((Integer)spinnerCourseEndMonth.getValue());
                student.setCourseEndDay((Integer)spinnerCourseEndDay.getValue());
                students.add(student);
                mainPanel.refreshData();
                dialogStudent.dispose();
                }
            }
        });
        dialogStudent.add(panelStudent);
        dialogStudent.pack();
        dialogStudent.setLocationRelativeTo(null);
        dialogStudent.setResizable(false);
        dialogStudent.setModal(true);
        dialogStudent.setVisible(true);
        //Image img = ImageIO.read(getClass().getResource("./src/project/*.png"));
        //dialogProject.setIconImage(img);
    } 

    public void editStudent(final Student student, MainFrame mainPanel, final StudentJPanels panel){
        date = mainPanel.date;
        final JDialog dialogStudent = new JDialog();
        dialogStudent.setTitle("Editing "+student.getFirstName()+" "+student.getLastName());
        JPanel panelStudent = new JPanel();
        JLabel labelFirstName = new JLabel("First Name:");
        JLabel labelLastName = new JLabel("Last Name:");
        JLabel labelId = new JLabel("Student Id:");
        JLabel labelPosition = new JLabel("Project role:");
        JLabel labelCourseName = new JLabel("Course name:");
        JLabel labelCourseGroup = new JLabel("Course group:");
        JLabel labelCourseStartYear = new JLabel("Course start date: Year");
        JLabel labelCourseStartMonth = new JLabel("Month");
        JLabel labelCourseStartDay = new JLabel("Day");
        JLabel labelCourseEndYear = new JLabel("Course end date:   Year");
        JLabel labelCourseEndMonth = new JLabel("Month");
        JLabel labelCourseEndDay = new JLabel("Day");
        JLabel labelBirthYear = new JLabel("Birth date:                Year");
        JLabel labelBirthMonth = new JLabel("Month");
        JLabel labelBirthDay = new JLabel("Day");
        final JTextField textFieldFirstName = new JTextField(12);
        final JTextField textFieldLastName = new JTextField(12);
        final JTextField textFieldId = new JTextField(12);
        final JTextField textFieldPosition = new JTextField(12);
        final JTextField textFieldCourseName = new JTextField(20);
        JButton buttonSave = new JButton("Save student");
        
        tempFirstName = student.getFirstName();
        tempLastName = student.getLastName();
        tempId = student.getId();
        tempPosition = student.getPosition();
        tempCourseName = student.getCourseName();
        
        SpinnerNumberModel modelCourseGroup = new SpinnerNumberModel(student.getGroup(), 0, 99, 1);
        SpinnerNumberModel modelCourseStartYear = new SpinnerNumberModel(student.getCourseStartYear(), 1950, date.getProgramYear() + 100, 1);
        SpinnerNumberModel modelCourseStartMonth = new SpinnerNumberModel(student.getCourseStartMonth()+1, 1, 12, 1);
        SpinnerNumberModel modelCourseStartDay = new SpinnerNumberModel(student.getCourseStartDay(), 1, 31, 1);
        SpinnerNumberModel modelCourseEndYear = new SpinnerNumberModel(student.getCourseEndYear(), 1950, date.getProgramYear() + 100, 1);
        SpinnerNumberModel modelCourseEndMonth = new SpinnerNumberModel(student.getCourseEndMonth()+1, 1, 12, 1);
        SpinnerNumberModel modelCourseEndDay = new SpinnerNumberModel(student.getCourseEndDay(), 1, 31, 1);
        SpinnerNumberModel modelBirthYear = new SpinnerNumberModel(student.getBirthYear(), 1800, date.getProgramYear(), 1);
        SpinnerNumberModel modelBirthMonth = new SpinnerNumberModel(student.getBirthMonth()+1, 1, 12, 1);
        SpinnerNumberModel modelBirthDay = new SpinnerNumberModel(student.getBirthDay(), 1, 31, 1);
        
        spinnerCourseGroup = new JSpinner(modelCourseGroup);
        spinnerCourseStartYear = new JSpinner(modelCourseStartYear);
        spinnerCourseStartMonth = new JSpinner(modelCourseStartMonth);
        spinnerCourseStartDay = new JSpinner(modelCourseStartDay);
        spinnerCourseEndYear = new JSpinner(modelCourseEndYear);
        spinnerCourseEndMonth = new JSpinner(modelCourseEndMonth);
        spinnerCourseEndDay = new JSpinner(modelCourseEndDay);
        spinnerBirthYear = new JSpinner(modelBirthYear);
        spinnerBirthMonth = new JSpinner(modelBirthMonth);
        spinnerBirthDay = new JSpinner(modelBirthDay);
        
        customSpinner(spinnerCourseGroup);
        customSpinner(spinnerBirthYear);
        customSpinner(spinnerBirthMonth);
        customSpinner(spinnerBirthDay);
        customSpinner(spinnerCourseStartYear);
        customSpinner(spinnerCourseStartMonth);
        customSpinner(spinnerCourseStartDay);
        customSpinner(spinnerCourseEndYear);
        customSpinner(spinnerCourseEndMonth);
        customSpinner(spinnerCourseEndDay);
        
        textFieldFirstName.setBorder(BorderFactory.createCompoundBorder(textFieldFirstName.getBorder(),BorderFactory.createEmptyBorder(2, 2, 2, 2)));
        textFieldFirstName.setDocument(new TextLimit(30));
        textFieldLastName.setBorder(BorderFactory.createCompoundBorder(textFieldLastName.getBorder(),BorderFactory.createEmptyBorder(2, 2, 2, 2)));
        textFieldLastName.setDocument(new TextLimit(30));
        textFieldId.setBorder(BorderFactory.createCompoundBorder(textFieldId.getBorder(),BorderFactory.createEmptyBorder(2, 2, 2, 2)));
        textFieldId.setDocument(new TextLimit(30));
        textFieldPosition.setBorder(BorderFactory.createCompoundBorder(textFieldPosition.getBorder(),BorderFactory.createEmptyBorder(2, 2, 2, 2)));
        textFieldPosition.setDocument(new TextLimit(30));
        textFieldCourseName.setBorder(BorderFactory.createCompoundBorder(textFieldCourseName.getBorder(),BorderFactory.createEmptyBorder(2, 2, 2, 2)));
        textFieldCourseName.setDocument(new TextLimit(60));
        buttonSave.setPreferredSize(new Dimension(365, 30));
        
        textFieldFirstName.setText(tempFirstName);
        textFieldLastName.setText(tempLastName);
        textFieldId.setText(tempId);
        textFieldPosition.setText(tempPosition);
        textFieldCourseName.setText(tempCourseName);
        
        SpringLayout spring = new SpringLayout();
        panelStudent.setLayout(spring);
        panelStudent.setPreferredSize(new Dimension(480, 280));
        panelStudent.add(labelFirstName);
        panelStudent.add(labelLastName);
        panelStudent.add(labelId);
        panelStudent.add(labelPosition);
        panelStudent.add(labelCourseName);
        panelStudent.add(labelCourseGroup);
        panelStudent.add(labelBirthYear);
        panelStudent.add(labelBirthMonth);
        panelStudent.add(labelBirthDay);
        panelStudent.add(labelCourseStartYear);
        panelStudent.add(labelCourseStartMonth);
        panelStudent.add(labelCourseStartDay);
        panelStudent.add(labelCourseEndYear);
        panelStudent.add(labelCourseEndMonth);
        panelStudent.add(labelCourseEndDay);
        panelStudent.add(textFieldFirstName);
        panelStudent.add(textFieldLastName);
        panelStudent.add(textFieldId);
        panelStudent.add(textFieldPosition);
        panelStudent.add(textFieldCourseName);
        panelStudent.add(spinnerBirthYear);
        panelStudent.add(spinnerBirthMonth);
        panelStudent.add(spinnerBirthDay);
        panelStudent.add(spinnerCourseGroup);
        panelStudent.add(spinnerCourseStartYear);
        panelStudent.add(spinnerCourseStartMonth);
        panelStudent.add(spinnerCourseStartDay);
        panelStudent.add(spinnerCourseEndYear);
        panelStudent.add(spinnerCourseEndMonth);
        panelStudent.add(spinnerCourseEndDay);
        panelStudent.add(buttonSave);
        panelStudent.setVisible(true);

        spring.putConstraint(SpringLayout.WEST, labelFirstName, 10, SpringLayout.WEST, panelStudent);
        spring.putConstraint(SpringLayout.VERTICAL_CENTER, labelFirstName, 0, SpringLayout.VERTICAL_CENTER, textFieldFirstName);
        spring.putConstraint(SpringLayout.WEST, textFieldFirstName, 20, SpringLayout.EAST, labelFirstName);
        spring.putConstraint(SpringLayout.NORTH, textFieldFirstName, 10, SpringLayout.NORTH, panelStudent);
        spring.putConstraint(SpringLayout.EAST, labelLastName, -10, SpringLayout.WEST, textFieldLastName);
        spring.putConstraint(SpringLayout.VERTICAL_CENTER, labelLastName, 0, SpringLayout.VERTICAL_CENTER, textFieldLastName);
        spring.putConstraint(SpringLayout.EAST, textFieldLastName, -10, SpringLayout.EAST, panelStudent);
        spring.putConstraint(SpringLayout.NORTH, textFieldLastName, 10, SpringLayout.NORTH, panelStudent);
        spring.putConstraint(SpringLayout.WEST, labelBirthYear, 10, SpringLayout.WEST, panelStudent);
        spring.putConstraint(SpringLayout.VERTICAL_CENTER, labelBirthYear, 0, SpringLayout.VERTICAL_CENTER, spinnerBirthYear);
        spring.putConstraint(SpringLayout.WEST, spinnerBirthYear, 0, SpringLayout.WEST, spinnerCourseStartYear);
        spring.putConstraint(SpringLayout.NORTH, spinnerBirthYear, 10, SpringLayout.SOUTH, textFieldFirstName);
        spring.putConstraint(SpringLayout.WEST, labelBirthMonth, 10, SpringLayout.EAST, spinnerBirthYear);
        spring.putConstraint(SpringLayout.VERTICAL_CENTER, labelBirthMonth, 0, SpringLayout.VERTICAL_CENTER, spinnerBirthYear);
        spring.putConstraint(SpringLayout.WEST, spinnerBirthMonth, 10, SpringLayout.EAST, labelBirthMonth);
        spring.putConstraint(SpringLayout.VERTICAL_CENTER, spinnerBirthMonth, 0, SpringLayout.VERTICAL_CENTER, spinnerBirthYear);
        spring.putConstraint(SpringLayout.WEST, labelBirthDay, 10, SpringLayout.EAST, spinnerBirthMonth);
        spring.putConstraint(SpringLayout.VERTICAL_CENTER, labelBirthDay, 0, SpringLayout.VERTICAL_CENTER, spinnerBirthYear);
        spring.putConstraint(SpringLayout.WEST, spinnerBirthDay, 10, SpringLayout.EAST, labelBirthDay);
        spring.putConstraint(SpringLayout.VERTICAL_CENTER, spinnerBirthDay, 0, SpringLayout.VERTICAL_CENTER, spinnerBirthYear);
        spring.putConstraint(SpringLayout.WEST, labelCourseName, 10, SpringLayout.WEST, panelStudent);
        spring.putConstraint(SpringLayout.VERTICAL_CENTER, labelCourseName, 0, SpringLayout.VERTICAL_CENTER, textFieldCourseName);
        spring.putConstraint(SpringLayout.WEST, textFieldCourseName, 0, SpringLayout.WEST, textFieldFirstName);
        spring.putConstraint(SpringLayout.NORTH, textFieldCourseName, 10, SpringLayout.SOUTH, textFieldId);
        spring.putConstraint(SpringLayout.EAST, labelCourseGroup, -10, SpringLayout.WEST, spinnerCourseGroup);
        spring.putConstraint(SpringLayout.VERTICAL_CENTER, labelCourseGroup, 0, SpringLayout.VERTICAL_CENTER, spinnerCourseGroup);
        spring.putConstraint(SpringLayout.EAST, spinnerCourseGroup, -10, SpringLayout.EAST, panelStudent);
        spring.putConstraint(SpringLayout.VERTICAL_CENTER, spinnerCourseGroup, 0, SpringLayout.VERTICAL_CENTER, textFieldCourseName);
        spring.putConstraint(SpringLayout.WEST, labelId, 10, SpringLayout.WEST, panelStudent);
        spring.putConstraint(SpringLayout.VERTICAL_CENTER, labelId, 0, SpringLayout.VERTICAL_CENTER, textFieldId);
        spring.putConstraint(SpringLayout.WEST, textFieldId, 0, SpringLayout.WEST, textFieldFirstName);
        spring.putConstraint(SpringLayout.NORTH, textFieldId, 10, SpringLayout.SOUTH, textFieldPosition);
        spring.putConstraint(SpringLayout.WEST, labelPosition, 10, SpringLayout.WEST, panelStudent);
        spring.putConstraint(SpringLayout.VERTICAL_CENTER, labelPosition, 0, SpringLayout.VERTICAL_CENTER, textFieldPosition);
        spring.putConstraint(SpringLayout.WEST, textFieldPosition, 0, SpringLayout.WEST, textFieldFirstName);
        spring.putConstraint(SpringLayout.NORTH, textFieldPosition, 10, SpringLayout.SOUTH, spinnerBirthYear);
        spring.putConstraint(SpringLayout.WEST, labelCourseStartYear, 10, SpringLayout.WEST, panelStudent);
        spring.putConstraint(SpringLayout.VERTICAL_CENTER, labelCourseStartYear, 0, SpringLayout.VERTICAL_CENTER, spinnerCourseStartYear);
        spring.putConstraint(SpringLayout.WEST, spinnerCourseStartYear, 10, SpringLayout.EAST, labelCourseStartYear);
        spring.putConstraint(SpringLayout.NORTH, spinnerCourseStartYear, 10, SpringLayout.SOUTH, spinnerCourseEndYear);
        spring.putConstraint(SpringLayout.WEST, labelCourseStartMonth, 10, SpringLayout.EAST, spinnerCourseStartYear);
        spring.putConstraint(SpringLayout.VERTICAL_CENTER, labelCourseStartMonth, 0, SpringLayout.VERTICAL_CENTER, spinnerCourseStartYear);
        spring.putConstraint(SpringLayout.WEST, spinnerCourseStartMonth, 10, SpringLayout.EAST, labelCourseStartMonth);
        spring.putConstraint(SpringLayout.VERTICAL_CENTER, spinnerCourseStartMonth, 0, SpringLayout.VERTICAL_CENTER, spinnerCourseStartYear);
        spring.putConstraint(SpringLayout.WEST, labelCourseStartDay, 10, SpringLayout.EAST, spinnerCourseStartMonth);
        spring.putConstraint(SpringLayout.VERTICAL_CENTER, labelCourseStartDay, 0, SpringLayout.VERTICAL_CENTER, spinnerCourseStartYear);
        spring.putConstraint(SpringLayout.WEST, spinnerCourseStartDay, 10, SpringLayout.EAST, labelCourseStartDay);
        spring.putConstraint(SpringLayout.VERTICAL_CENTER, spinnerCourseStartDay, 0, SpringLayout.VERTICAL_CENTER, spinnerCourseStartYear);
        spring.putConstraint(SpringLayout.WEST, labelCourseEndYear, 10, SpringLayout.WEST, panelStudent);
        spring.putConstraint(SpringLayout.VERTICAL_CENTER, labelCourseEndYear, 0, SpringLayout.VERTICAL_CENTER, spinnerCourseEndYear);
        spring.putConstraint(SpringLayout.WEST, spinnerCourseEndYear, 0, SpringLayout.WEST, spinnerCourseStartYear);
        spring.putConstraint(SpringLayout.NORTH, spinnerCourseEndYear, 10, SpringLayout.SOUTH, textFieldCourseName);
        spring.putConstraint(SpringLayout.WEST, labelCourseEndMonth, 10, SpringLayout.EAST, spinnerCourseEndYear);
        spring.putConstraint(SpringLayout.VERTICAL_CENTER, labelCourseEndMonth, 0, SpringLayout.VERTICAL_CENTER, spinnerCourseEndYear);
        spring.putConstraint(SpringLayout.WEST, spinnerCourseEndMonth, 10, SpringLayout.EAST, labelCourseEndMonth);
        spring.putConstraint(SpringLayout.VERTICAL_CENTER, spinnerCourseEndMonth, 0, SpringLayout.VERTICAL_CENTER, spinnerCourseEndYear);
        spring.putConstraint(SpringLayout.WEST, labelCourseEndDay, 10, SpringLayout.EAST, spinnerCourseEndMonth);
        spring.putConstraint(SpringLayout.VERTICAL_CENTER, labelCourseEndDay, 0, SpringLayout.VERTICAL_CENTER, spinnerCourseEndYear);
        spring.putConstraint(SpringLayout.WEST, spinnerCourseEndDay, 10, SpringLayout.EAST, labelCourseEndDay);
        spring.putConstraint(SpringLayout.VERTICAL_CENTER, spinnerCourseEndDay, 0, SpringLayout.VERTICAL_CENTER, spinnerCourseEndYear);
        spring.putConstraint(SpringLayout.HORIZONTAL_CENTER, buttonSave, 0, SpringLayout.HORIZONTAL_CENTER, panelStudent);
        spring.putConstraint(SpringLayout.SOUTH, buttonSave, -10, SpringLayout.SOUTH, panelStudent);
        
        
        Border redLine = BorderFactory.createLineBorder(Color.red);
        Border spacing = BorderFactory.createEmptyBorder(2, 2, 2, 2);
        compound = BorderFactory.createCompoundBorder(redLine, spacing);
        oldFieldBorder = textFieldFirstName.getBorder();
        
                textFieldFirstName.addFocusListener(new FocusListener() {
                       @Override
                       public void focusGained(FocusEvent e) {
                           textFieldFirstName.setText(tempFirstName);
                } 
                        @Override
                        public void focusLost(FocusEvent e) {
                            tempFirstName = textFieldFirstName.getText();
                            if (textFieldFirstName.getText().length() < 4) {
                                textFieldFirstName.setBackground(new Color(255, 180, 180));
                                textFieldFirstName.setBorder(compound);
                                textFieldFirstName.setText("At least 4 characters");
                                boolFirstName = false;
                            }
                            else {
                                textFieldFirstName.setBackground(new Color(255, 255, 255));
                                textFieldFirstName.setBorder(oldFieldBorder);
                                boolFirstName = true;
                            }
                        }
                    });
                
                textFieldLastName.addFocusListener(new FocusListener() {
                       @Override
                       public void focusGained(FocusEvent e) {
                           textFieldLastName.setText(tempLastName);
                } 
                        @Override
                        public void focusLost(FocusEvent e) {
                            tempLastName = textFieldLastName.getText();
                            if (textFieldLastName.getText().length() < 4) {
                                textFieldLastName.setBackground(new Color(255, 180, 180));
                                textFieldLastName.setBorder(compound);
                                textFieldLastName.setText("At least 4 characters");
                                boolLastName = false;
                            }
                            else {
                                textFieldLastName.setBackground(new Color(255, 255, 255));
                                textFieldLastName.setBorder(oldFieldBorder);
                                boolLastName = true;
                            }
                        }
                    });
                
                textFieldPosition.addFocusListener(new FocusListener() {
                       @Override
                       public void focusGained(FocusEvent e) {
                           textFieldPosition.setText(tempPosition);
                } 
                        @Override
                        public void focusLost(FocusEvent e) {
                            tempPosition = textFieldPosition.getText();
                            if (textFieldPosition.getText().length() < 4) {
                                textFieldPosition.setBackground(new Color(255, 180, 180));
                                textFieldPosition.setBorder(compound);
                                textFieldPosition.setText("At least 4 characters");
                                boolPosition = false;
                            }
                            else {
                                textFieldPosition.setBackground(new Color(255, 255, 255));
                                textFieldPosition.setBorder(oldFieldBorder);
                                boolPosition = true;
                            }
                        }
                    });
                
                textFieldId.addFocusListener(new FocusListener() {
                       @Override
                       public void focusGained(FocusEvent e) {
                           textFieldId.setText(tempId);
                } 
                        @Override
                        public void focusLost(FocusEvent e) {
                            tempId = textFieldId.getText();
                            if (textFieldId.getText().length() < 4) {
                                textFieldId.setBackground(new Color(255, 180, 180));
                                textFieldId.setBorder(compound);
                                textFieldId.setText("At least 4 characters");
                                boolId = false;
                            }
                            else {
                                textFieldId.setBackground(new Color(255, 255, 255));
                                textFieldId.setBorder(oldFieldBorder);
                                boolId = true;
                            }
                        }
                    });
                
                textFieldCourseName.addFocusListener(new FocusListener() {
                       @Override
                       public void focusGained(FocusEvent e) {
                           textFieldCourseName.setText(tempCourseName);
                } 
                        @Override
                        public void focusLost(FocusEvent e) {
                            tempCourseName = textFieldCourseName.getText();
                            if (textFieldCourseName.getText().length() < 4) {
                                textFieldCourseName.setBackground(new Color(255, 180, 180));
                                textFieldCourseName.setBorder(compound);
                                textFieldCourseName.setText("At least 4 characters");
                                boolCourseName = false;
                            }
                            else {
                                textFieldCourseName.setBackground(new Color(255, 255, 255));
                                textFieldCourseName.setBorder(oldFieldBorder);
                                boolCourseName = true;
                            }
                        }
                    });
                
                boolFirstName = boolLastName = boolPosition = boolCourseName = boolId = boolCourseStartYear = boolCourseStartMonth = boolCourseStartDay = boolCourseEndYear =
                boolCourseEndMonth = boolCourseEndDay = boolBirthYear = boolBirthMonth = boolBirthDay = boolCourseGroup = true;
                
                
                JSpinner.DefaultEditor editorCourseGroup = (JSpinner.DefaultEditor)spinnerCourseGroup.getEditor();
                JTextField textFieldCourseGroup = editorCourseGroup.getTextField();
                JSpinner.DefaultEditor editorBirthYear = (JSpinner.DefaultEditor)spinnerBirthYear.getEditor();
                JTextField textFieldBirthYear = editorBirthYear.getTextField();
                JSpinner.DefaultEditor editorBirthMonth = (JSpinner.DefaultEditor)spinnerBirthMonth.getEditor();
                JTextField textFieldBirthMonth = editorBirthMonth.getTextField();
                JSpinner.DefaultEditor editorBirthDay = (JSpinner.DefaultEditor)spinnerBirthDay.getEditor();
                JTextField textFieldBirthDay = editorBirthDay.getTextField();
                JSpinner.DefaultEditor editorCourseStartYear = (JSpinner.DefaultEditor)spinnerCourseStartYear.getEditor();
                JTextField textFieldCourseStartYear = editorCourseStartYear.getTextField();
                JSpinner.DefaultEditor editorCourseStartMonth = (JSpinner.DefaultEditor)spinnerCourseStartMonth.getEditor();
                JTextField textFieldCourseStartMonth = editorCourseStartMonth.getTextField();
                JSpinner.DefaultEditor editorCourseStartDay = (JSpinner.DefaultEditor)spinnerCourseStartDay.getEditor();
                JTextField textFieldCourseStartDay = editorCourseStartDay.getTextField();
                JSpinner.DefaultEditor editorCourseEndYear = (JSpinner.DefaultEditor)spinnerCourseEndYear.getEditor();
                JTextField textFieldCourseEndYear = editorCourseEndYear.getTextField();
                JSpinner.DefaultEditor editorCourseEndMonth = (JSpinner.DefaultEditor)spinnerCourseEndMonth.getEditor();
                JTextField textFieldCourseEndMonth = editorCourseEndMonth.getTextField();
                JSpinner.DefaultEditor editorCourseEndDay = (JSpinner.DefaultEditor)spinnerCourseEndDay.getEditor();
                JTextField textFieldCourseEndDay = editorCourseEndDay.getTextField();
                
                
                textFieldCourseGroup.addFocusListener(new FocusAdapter() {
                       @Override
                       public void focusGained(FocusEvent e) {
                } 
                        @Override
                        public void focusLost(FocusEvent e) {
                            if ((Integer)spinnerCourseGroup.getValue() == 0) {
                                spinnerRed(spinnerCourseGroup);
                                boolCourseGroup = false;
                            }
                            else {
                                spinnerOld(spinnerCourseGroup);
                                boolCourseGroup = true;
                            }
                        }
                    });
                
                textFieldBirthYear.addFocusListener(new FocusAdapter() {
                       @Override
                       public void focusGained(FocusEvent e) {
                } 
                        @Override
                        public void focusLost(FocusEvent e) {
                            if ((Integer)spinnerBirthYear.getValue() > (Integer)spinnerCourseStartYear.getValue() || (Integer)spinnerBirthYear.getValue() > (Integer)spinnerCourseEndYear.getValue()){
                                spinnerRed(spinnerBirthYear);
                                boolBirthYear = false;
                            }
                            else {
                                spinnerOld(spinnerBirthYear);
                                boolBirthYear = true;
                            }
                        }
                    });
                
                textFieldBirthMonth.addFocusListener(new FocusAdapter() {
                       @Override
                       public void focusGained(FocusEvent e) {
                } 
                        @Override
                        public void focusLost(FocusEvent e) {
                            if (((Integer)spinnerBirthYear.getValue() > (Integer)spinnerCourseStartYear.getValue() || (Integer)spinnerBirthYear.getValue() > (Integer)spinnerCourseEndYear.getValue()) ||
                               ((Integer)spinnerBirthYear.getValue() >= (Integer)spinnerCourseStartYear.getValue() && (Integer)spinnerBirthMonth.getValue() > (Integer)spinnerCourseStartMonth.getValue()) ||
                               ((Integer)spinnerBirthYear.getValue() >= (Integer)spinnerCourseEndYear.getValue() && (Integer)spinnerBirthMonth.getValue() > (Integer)spinnerCourseEndMonth.getValue())) {
                                spinnerRed(spinnerBirthMonth);
                                boolBirthMonth = false;
                            }
                            else {
                                spinnerOld(spinnerBirthMonth);
                                boolBirthMonth = true;
                            }
                        }
                    });
                
                textFieldBirthDay.addFocusListener(new FocusAdapter() {
                       @Override
                       public void focusGained(FocusEvent e) {
                } 
                        @Override
                        public void focusLost(FocusEvent e) {
                            if ((((Integer)spinnerBirthYear.getValue() > (Integer)spinnerCourseStartYear.getValue() || (Integer)spinnerBirthYear.getValue() > (Integer)spinnerCourseEndYear.getValue()) ||
                               ((Integer)spinnerBirthYear.getValue() >= (Integer)spinnerCourseStartYear.getValue() && (Integer)spinnerBirthMonth.getValue() > (Integer)spinnerCourseStartMonth.getValue()) ||
                               ((Integer)spinnerBirthYear.getValue() >= (Integer)spinnerCourseEndYear.getValue() && (Integer)spinnerBirthMonth.getValue() > (Integer)spinnerCourseEndMonth.getValue())) ||
                               ((Integer)spinnerBirthYear.getValue() >= (Integer)spinnerCourseStartYear.getValue() && (Integer)spinnerBirthMonth.getValue() >= (Integer)spinnerCourseStartMonth.getValue() && (Integer)spinnerBirthDay.getValue() > (Integer)spinnerCourseStartDay.getValue()) ||
                               ((Integer)spinnerBirthYear.getValue() >= (Integer)spinnerCourseEndYear.getValue() && (Integer)spinnerBirthMonth.getValue() >= (Integer)spinnerCourseEndMonth.getValue() && (Integer)spinnerBirthDay.getValue() > (Integer)spinnerCourseEndDay.getValue())) {
                                spinnerRed(spinnerBirthDay);
                                boolBirthDay = false;
                            }
                            else {
                                spinnerOld(spinnerBirthDay);
                                boolBirthDay = true;
                            }
                        }
                    });
                
                textFieldCourseStartYear.addFocusListener(new FocusAdapter() {
                       @Override
                       public void focusGained(FocusEvent e) {
                } 
                        @Override
                        public void focusLost(FocusEvent e) {
                            if ((Integer)spinnerBirthYear.getValue() > (Integer)spinnerCourseStartYear.getValue() || (Integer)spinnerCourseStartYear.getValue() > (Integer)spinnerCourseEndYear.getValue()) {
                                spinnerRed(spinnerCourseStartYear);
                                boolCourseStartYear = false;
                            }
                            else {
                                spinnerOld(spinnerCourseStartYear);
                                boolCourseStartYear = true;
                            }
                        }
                    });
                
                textFieldCourseStartMonth.addFocusListener(new FocusAdapter() {
                       @Override
                       public void focusGained(FocusEvent e) {
                } 
                        @Override
                        public void focusLost(FocusEvent e) {
                            if (((Integer)spinnerBirthYear.getValue() > (Integer)spinnerCourseStartYear.getValue() || (Integer)spinnerCourseStartYear.getValue() > (Integer)spinnerCourseEndYear.getValue()) ||
                               ((Integer)spinnerBirthYear.getValue() >= (Integer)spinnerCourseStartYear.getValue() && (Integer)spinnerBirthMonth.getValue() > (Integer)spinnerCourseStartMonth.getValue()) ||
                               ((Integer)spinnerCourseStartYear.getValue() >= (Integer)spinnerCourseEndYear.getValue() && (Integer)spinnerCourseStartMonth.getValue() > (Integer)spinnerCourseEndMonth.getValue())) {
                                spinnerRed(spinnerCourseStartMonth);
                                boolCourseStartMonth = false;
                            }
                            else {
                                spinnerOld(spinnerCourseStartMonth);
                                boolCourseStartMonth = true;
                            }
                        }
                    });
                
                textFieldCourseStartDay.addFocusListener(new FocusAdapter() {
                       @Override
                       public void focusGained(FocusEvent e) {
                } 
                        @Override
                        public void focusLost(FocusEvent e) {
                            if ((((Integer)spinnerBirthYear.getValue() > (Integer)spinnerCourseStartYear.getValue() || (Integer)spinnerCourseStartYear.getValue() > (Integer)spinnerCourseEndYear.getValue()) ||
                               ((Integer)spinnerBirthYear.getValue() >= (Integer)spinnerCourseStartYear.getValue() && (Integer)spinnerBirthMonth.getValue() > (Integer)spinnerCourseStartMonth.getValue()) ||
                               ((Integer)spinnerCourseStartYear.getValue() >= (Integer)spinnerCourseEndYear.getValue() && (Integer)spinnerCourseStartMonth.getValue() > (Integer)spinnerCourseEndMonth.getValue())) ||
                               ((Integer)spinnerBirthYear.getValue() >= (Integer)spinnerCourseStartYear.getValue() && (Integer)spinnerBirthMonth.getValue() >= (Integer)spinnerCourseStartMonth.getValue() && (Integer)spinnerBirthDay.getValue() > (Integer)spinnerCourseStartDay.getValue()) ||
                               ((Integer)spinnerCourseStartYear.getValue() >= (Integer)spinnerCourseEndYear.getValue() && (Integer)spinnerCourseStartMonth.getValue() >= (Integer)spinnerCourseEndMonth.getValue() && (Integer)spinnerCourseStartDay.getValue() > (Integer)spinnerCourseEndDay.getValue())) {
                                spinnerRed(spinnerCourseStartDay);
                                boolCourseStartDay = false;
                            }
                            else {
                                spinnerOld(spinnerCourseStartDay);
                                boolCourseStartDay = true;
                            }
                        }
                    });
                
                textFieldCourseEndYear.addFocusListener(new FocusAdapter() {
                       @Override
                       public void focusGained(FocusEvent e) {
                } 
                        @Override
                        public void focusLost(FocusEvent e) {
                            if ((Integer)spinnerBirthYear.getValue() > (Integer)spinnerCourseEndYear.getValue() || (Integer)spinnerCourseStartYear.getValue() > (Integer)spinnerCourseEndYear.getValue()) {
                                spinnerRed(spinnerCourseEndYear);
                                boolCourseEndYear = false;
                            }
                            else {
                                spinnerOld(spinnerCourseEndYear);
                                boolCourseEndYear = true;
                            }
                        }
                    });
                
                textFieldCourseEndMonth.addFocusListener(new FocusAdapter() {
                       @Override
                       public void focusGained(FocusEvent e) {
                } 
                        @Override
                        public void focusLost(FocusEvent e) {
                            if (((Integer)spinnerBirthYear.getValue() > (Integer)spinnerCourseEndYear.getValue() || (Integer)spinnerCourseStartYear.getValue() > (Integer)spinnerCourseEndYear.getValue()) ||
                               ((Integer)spinnerBirthYear.getValue() >= (Integer)spinnerCourseEndYear.getValue() && (Integer)spinnerBirthMonth.getValue() > (Integer)spinnerCourseEndMonth.getValue()) ||
                               ((Integer)spinnerCourseStartYear.getValue() >= (Integer)spinnerCourseEndYear.getValue() && (Integer)spinnerCourseStartMonth.getValue() > (Integer)spinnerCourseEndMonth.getValue())) {
                                spinnerRed(spinnerCourseEndMonth);
                                boolCourseEndMonth = false;
                            }
                            else {
                                spinnerOld(spinnerCourseEndMonth);
                                boolCourseEndMonth = true;
                            }
                        }
                    });
                
                textFieldCourseEndDay.addFocusListener(new FocusAdapter() {
                       @Override
                       public void focusGained(FocusEvent e) {
                } 
                        @Override
                        public void focusLost(FocusEvent e) {
                            if ((((Integer)spinnerBirthYear.getValue() > (Integer)spinnerCourseEndYear.getValue() || (Integer)spinnerCourseStartYear.getValue() > (Integer)spinnerCourseEndYear.getValue()) ||
                               ((Integer)spinnerBirthYear.getValue() >= (Integer)spinnerCourseEndYear.getValue() && (Integer)spinnerBirthMonth.getValue() > (Integer)spinnerCourseEndMonth.getValue()) ||
                               ((Integer)spinnerCourseStartYear.getValue() >= (Integer)spinnerCourseEndYear.getValue() && (Integer)spinnerCourseStartMonth.getValue() > (Integer)spinnerCourseEndMonth.getValue())) ||
                               ((Integer)spinnerBirthYear.getValue() >= (Integer)spinnerCourseEndYear.getValue() && (Integer)spinnerBirthMonth.getValue() >= (Integer)spinnerCourseEndMonth.getValue() && (Integer)spinnerBirthDay.getValue() > (Integer)spinnerCourseEndDay.getValue()) ||
                               ((Integer)spinnerCourseStartYear.getValue() >= (Integer)spinnerCourseEndYear.getValue() && (Integer)spinnerCourseStartMonth.getValue() >= (Integer)spinnerCourseEndMonth.getValue() && (Integer)spinnerCourseStartDay.getValue() > (Integer)spinnerCourseEndDay.getValue())) {
                                spinnerRed(spinnerCourseEndDay);
                                boolCourseEndDay = false;
                            }
                            else {
                                spinnerOld(spinnerCourseEndDay);
                                boolCourseEndDay = true;
                            }
                        }
                    });
        
        buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                checkFields(textFieldFirstName, textFieldLastName, textFieldPosition, textFieldId, textFieldCourseName);
                checkSpinners();
                if(boolCourseGroup && boolCourseStartYear && boolCourseStartMonth && boolCourseStartDay && boolCourseEndYear &&
                   boolCourseEndMonth && boolCourseEndDay && boolBirthYear && boolBirthMonth && boolBirthDay && boolFirstName &&
                   boolLastName && boolPosition && boolId && boolCourseName){
                student.setFirstName(textFieldFirstName.getText());
                student.setLastName(textFieldLastName.getText());
                student.setPosition(textFieldPosition.getText());
                student.setCourseName(textFieldCourseName.getText());
                student.setId(textFieldId.getText());
                student.setGroup((Integer)spinnerCourseGroup.getValue());
                student.setBirthYear((Integer)spinnerBirthYear.getValue());
                student.setBirthMonth((Integer)spinnerBirthMonth.getValue());
                student.setBirthDay((Integer)spinnerBirthDay.getValue());
                student.setCourseStartYear((Integer)spinnerCourseStartYear.getValue());
                student.setCourseStartMonth((Integer)spinnerCourseStartMonth.getValue());
                student.setCourseStartDay((Integer)spinnerCourseStartDay.getValue());
                student.setCourseEndYear((Integer)spinnerCourseEndYear.getValue());
                student.setCourseEndMonth((Integer)spinnerCourseEndMonth.getValue());
                student.setCourseEndDay((Integer)spinnerCourseEndDay.getValue());
                panel.refreshData();
                dialogStudent.dispose();
                }
            }
        });
        dialogStudent.add(panelStudent);
        dialogStudent.pack();
        dialogStudent.setLocationRelativeTo(null);
        dialogStudent.setResizable(false);
        dialogStudent.setModal(true);
        dialogStudent.setVisible(true);
        //Image img = ImageIO.read(getClass().getResource("./src/project/*.png"));
        //dialogProject.setIconImage(img);
    } 
    
    public void removeStudent(final ArrayList<Student> students, final ProjectJPanels mainPanel) {
        if(students.size() > 0) {
            final JDialog dialog = new JDialog();
            dialog.setSize(300, 130);
            dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            dialog.setTitle("Remove student");
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            dialog.setLocation(dim.width / 2 - dialog.getSize().width / 2, dim.height / 2 - dialog.getSize().height / 2);

            JPanel panel = new JPanel();
            SpringLayout layout = new SpringLayout();
            panel.setLayout(layout);

            JLabel studentLabel = new JLabel("Select student:");

            String[] studentNames = new String[students.size()];
            for (int i = 0; i < studentNames.length; i++) {
                studentNames[i] = students.get(i).getFirstNameLetterAndLastName();
            }

            final JComboBox studentList = new JComboBox(studentNames);
            studentList.setSelectedIndex(0);
            studentList.setPreferredSize(new Dimension(150, 25));

            JButton button = new JButton("Remove");
            button.setPreferredSize(new Dimension(150, 30));
            new NavigationAndButtons().removeButton(button, students, studentList, mainPanel, dialog);

            panel.add(studentLabel);
            panel.add(studentList);
            panel.add(button);

            layout.putConstraint(SpringLayout.NORTH, studentLabel, 13, SpringLayout.NORTH, panel);
            layout.putConstraint(SpringLayout.WEST, studentLabel, 10, SpringLayout.WEST, panel);
            layout.putConstraint(SpringLayout.NORTH, studentList, 10, SpringLayout.NORTH, panel);
            layout.putConstraint(SpringLayout.WEST, studentList, 100, SpringLayout.WEST, studentLabel);
            layout.putConstraint(SpringLayout.NORTH, button, 35, SpringLayout.NORTH, studentLabel);
            layout.putConstraint(SpringLayout.WEST, button, 100, SpringLayout.WEST, studentLabel);

            dialog.add(panel);
            dialog.setLocationRelativeTo(null);
            dialog.setResizable(false);
            dialog.setModal(true);
            dialog.setVisible(true);
        }
        else {
            JDialog dialog = new JDialog();
            JOptionPane.showMessageDialog(dialog,
                    "This project has no students",
                    "Remove student",
                    JOptionPane.ERROR_MESSAGE);

        }
    }
    
    void customSpinner(JSpinner spinner){
        Font boldFont = new Font("Calibri", Font.BOLD, 13);
        spinner.setEditor(new JSpinner.NumberEditor(spinner,"#"));
        JComponent boxSpinner = spinner.getEditor();
        JFormattedTextField textFieldSpinner = ((JSpinner.DefaultEditor)boxSpinner).getTextField();
        textFieldSpinner.setColumns(3);
        textFieldSpinner.setFont(boldFont);
        textFieldSpinner.setHorizontalAlignment(JTextField.CENTER);
    }
    
    void spinnerRed(JSpinner spinner){
        JComponent boxSpinner = spinner.getEditor();
        JFormattedTextField textFieldSpinner = ((JSpinner.DefaultEditor)boxSpinner).getTextField();
        textFieldSpinner.setBackground(new Color(255, 180, 180));
    }
    
    void spinnerOld(JSpinner spinner){
        JComponent boxSpinner = spinner.getEditor();
        JFormattedTextField textFieldSpinner = ((JSpinner.DefaultEditor)boxSpinner).getTextField();
        textFieldSpinner.setBackground(new Color(255, 255, 255));
    }
    
    void checkFields(JTextField textFieldFirstName, JTextField textFieldLastName, JTextField textFieldPosition, 
                    JTextField textFieldId, JTextField textFieldCourseName){
        if(boolFirstName == null){
            tempFirstName = textFieldFirstName.getText();
            textFieldFirstName.setBackground(new Color(255, 180, 180));
            textFieldFirstName.setBorder(compound);
            textFieldFirstName.setText("At least 4 characters");
        }
        if(boolLastName == null){
            tempLastName = textFieldLastName.getText();
            textFieldLastName.setBackground(new Color(255, 180, 180));
            textFieldLastName.setBorder(compound);
            textFieldLastName.setText("At least 4 characters");
        }
        if(boolPosition == null){
            tempPosition = textFieldPosition.getText();
            textFieldPosition.setBackground(new Color(255, 180, 180));
            textFieldPosition.setBorder(compound);
            textFieldPosition.setText("At least 4 characters");
        }
        if(boolId == null){
            tempId = textFieldId.getText();
            textFieldId.setBackground(new Color(255, 180, 180));
            textFieldId.setBorder(compound);
            textFieldId.setText("At least 4 characters");
        }
        if(boolCourseName == null){
            tempCourseName = textFieldCourseName.getText();
            textFieldCourseName.setBackground(new Color(255, 180, 180));
            textFieldCourseName.setBorder(compound);
            textFieldCourseName.setText("At least 4 characters");
        }
    }
    
    void checkSpinners(){
        if(!boolCourseGroup){
            spinnerRed(spinnerCourseGroup);
        }
        if(!boolBirthYear){
            spinnerRed(spinnerBirthYear);
        }
        if(!boolBirthMonth){
            spinnerRed(spinnerBirthMonth);
        }
        if(!boolBirthDay){
            spinnerRed(spinnerBirthDay);
        }
        if(!boolCourseStartYear){
            spinnerRed(spinnerCourseStartYear);
        }
        if(!boolCourseStartMonth){
            spinnerRed(spinnerCourseStartMonth);
        }
        if(!boolCourseStartDay){
            spinnerRed(spinnerCourseStartDay);
        }
        if(!boolCourseEndYear){
            spinnerRed(spinnerCourseEndYear);
        }
        if(!boolCourseEndMonth){
            spinnerRed(spinnerCourseEndMonth);
        }
        if(!boolCourseEndDay){
            spinnerRed(spinnerCourseEndDay);
        }
    }
}
