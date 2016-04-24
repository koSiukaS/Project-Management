package project.view;

import project.model.Task;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import javax.swing.border.Border;

public class TaskActionDialogs {
    private String tempTextName, tempTextSupervisor, tempTextDescription;
    private Border compound, oldFieldBorder, oldAreaBorder;
    private Boolean boolName, boolSupervisor, boolDescription;
    private JSpinner spinnerETAYear, spinnerETAMonth,spinnerETADay;
    
    public void addTask(final ArrayList<Task> tasks, final MainFrame frame, final StudentJPanels panel){
        final JDialog dialogProject = new JDialog();
        dialogProject.setTitle("Adding a task");
        JPanel panelTask = new JPanel();
        JLabel labelName = new JLabel("Task name:");
        JLabel labelDescription = new JLabel("Description:");  
        JLabel labelETA = new JLabel("Task ETA:");
        JLabel labelETAYear = new JLabel("Year");
        JLabel labelETAMonth = new JLabel("Month");
        JLabel labelETADay = new JLabel("Day");
        final JTextField textFieldName = new JTextField(34);
        final JTextArea textAreaDescription = new JTextArea(7, 34);
        JButton buttonSave = new JButton("Add task");
        
        SpinnerNumberModel modelETAYear = new SpinnerNumberModel(frame.getDate().getProgramYear(), frame.getDate().getProgramYear(), frame.getDate().getProgramYear() + 100, 1);
        SpinnerNumberModel modelETAMonth = new SpinnerNumberModel(frame.getDate().getProgramMonth()+1, 1, 12, 1);
        SpinnerNumberModel modelETADay = new SpinnerNumberModel(frame.getDate().getProgramDay(), 1, 31, 1);
        
        spinnerETAYear = new JSpinner(modelETAYear);
        spinnerETAMonth = new JSpinner(modelETAMonth);
        spinnerETADay = new JSpinner(modelETADay);
        
        customSpinner(spinnerETAYear);
        customSpinner(spinnerETAMonth);
        customSpinner(spinnerETADay);
        
        textAreaDescription.setWrapStyleWord(true);
        textAreaDescription.setLineWrap(true);
        textAreaDescription.setBorder(BorderFactory.createCompoundBorder(textAreaDescription.getBorder(),BorderFactory.createEmptyBorder(2, 2, 2, 2)));
        JScrollPane scrollingDescription = new JScrollPane(textAreaDescription);
        textFieldName.setBorder(BorderFactory.createCompoundBorder(textFieldName.getBorder(),BorderFactory.createEmptyBorder(2, 2, 2, 2)));
        textFieldName.setDocument(new TextLimit(50));
        buttonSave.setPreferredSize(new Dimension(382, 30));
        
        SpringLayout spring = new SpringLayout();
        panelTask.setLayout(spring);
        panelTask.setPreferredSize(new Dimension(480, 240));
        panelTask.add(labelName);
        panelTask.add(textFieldName);
        panelTask.add(labelDescription);
        panelTask.add(scrollingDescription);
        panelTask.add(labelETA);
        panelTask.add(labelETAYear);
        panelTask.add(labelETAMonth);
        panelTask.add(labelETADay);
        panelTask.add(spinnerETAYear);
        panelTask.add(spinnerETAMonth);
        panelTask.add(spinnerETADay);
        panelTask.add(buttonSave);
        panelTask.setVisible(true);

        spring.putConstraint(SpringLayout.WEST, labelName, 10, SpringLayout.WEST, panelTask);
        spring.putConstraint(SpringLayout.VERTICAL_CENTER, labelName, 0, SpringLayout.VERTICAL_CENTER, textFieldName);
        spring.putConstraint(SpringLayout.EAST, textFieldName, -13, SpringLayout.EAST, panelTask);
        spring.putConstraint(SpringLayout.NORTH, textFieldName, 10, SpringLayout.NORTH, panelTask);
        spring.putConstraint(SpringLayout.WEST, labelDescription, 0, SpringLayout.WEST, labelName);
        spring.putConstraint(SpringLayout.NORTH, labelDescription, 0, SpringLayout.NORTH, scrollingDescription);
        spring.putConstraint(SpringLayout.WEST, scrollingDescription, 0, SpringLayout.WEST, textFieldName);
        spring.putConstraint(SpringLayout.NORTH, scrollingDescription, 10, SpringLayout.SOUTH, textFieldName);
        spring.putConstraint(SpringLayout.WEST, labelETA, 10, SpringLayout.WEST, panelTask);
        spring.putConstraint(SpringLayout.VERTICAL_CENTER, labelETA, 0, SpringLayout.VERTICAL_CENTER, spinnerETAYear);
        spring.putConstraint(SpringLayout.WEST, labelETAYear, 0, SpringLayout.WEST, scrollingDescription);
        spring.putConstraint(SpringLayout.VERTICAL_CENTER, labelETAYear, 0, SpringLayout.VERTICAL_CENTER, spinnerETAYear);
        spring.putConstraint(SpringLayout.WEST, spinnerETAYear, 10, SpringLayout.EAST, labelETAYear);
        spring.putConstraint(SpringLayout.NORTH, spinnerETAYear, 10, SpringLayout.SOUTH, scrollingDescription);
        spring.putConstraint(SpringLayout.WEST, labelETAMonth, 10, SpringLayout.EAST, spinnerETAYear);
        spring.putConstraint(SpringLayout.VERTICAL_CENTER, labelETAMonth, 0, SpringLayout.VERTICAL_CENTER, spinnerETAYear);
        spring.putConstraint(SpringLayout.WEST, spinnerETAMonth, 10, SpringLayout.EAST, labelETAMonth);
        spring.putConstraint(SpringLayout.VERTICAL_CENTER, spinnerETAMonth, 0, SpringLayout.VERTICAL_CENTER, spinnerETAYear);
        spring.putConstraint(SpringLayout.WEST, labelETADay, 10, SpringLayout.EAST, spinnerETAMonth);
        spring.putConstraint(SpringLayout.VERTICAL_CENTER, labelETADay, 0, SpringLayout.VERTICAL_CENTER, spinnerETAYear);
        spring.putConstraint(SpringLayout.WEST, spinnerETADay, 10, SpringLayout.EAST, labelETADay);
        spring.putConstraint(SpringLayout.VERTICAL_CENTER, spinnerETADay, 0, SpringLayout.VERTICAL_CENTER, spinnerETAYear);
        spring.putConstraint(SpringLayout.EAST, buttonSave, 0, SpringLayout.EAST, scrollingDescription);
        spring.putConstraint(SpringLayout.SOUTH, buttonSave, -10, SpringLayout.SOUTH, panelTask);
        
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
                
                textAreaDescription.addFocusListener(new FocusListener() {
                       @Override
                       public void focusGained(FocusEvent e) {
                           textAreaDescription.setText(tempTextDescription);
                } 

                        @Override
                        public void focusLost(FocusEvent e) {
                            tempTextDescription = textAreaDescription.getText();
                            if (textAreaDescription.getText().length() < 20) {
                                textAreaDescription.setBackground(new Color(255, 180, 180));
                                textAreaDescription.setBorder(compound);
                                textAreaDescription.setText("The description must consist out of 20 characters at least");
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
                checkFields(textFieldName, textAreaDescription);
                if (boolName && boolDescription) {
                Task task = new Task();
                task.setName(textFieldName.getText());
                task.setDescription(textAreaDescription.getText());
                task.setDeadlineYear((Integer)spinnerETAYear.getValue());
                task.setDeadlineMonth((Integer)spinnerETAMonth.getValue());
                task.setDeadlineDay((Integer)spinnerETADay.getValue());
                tasks.add(task);
                panel.refreshData();
                dialogProject.dispose();
                }
            }
        });
        dialogProject.add(panelTask);
        dialogProject.pack();
        dialogProject.setLocationRelativeTo(null);
        dialogProject.setResizable(false);
        dialogProject.setModal(true);
        dialogProject.setVisible(true);
        //Image img = ImageIO.read(getClass().getResource("./src/project/*.png"));
        //dialogProject.setIconImage(img);
    } 
    
    public void editTask(final Task task, final MainFrame frame, final TaskJPanels panel){
        final JDialog dialogProject = new JDialog();
        dialogProject.setTitle("Adding a task");
        JPanel panelTask = new JPanel();
        JLabel labelName = new JLabel("Task name:");
        JLabel labelDescription = new JLabel("Description:");  
        JLabel labelETA = new JLabel("Task ETA:");
        JLabel labelETAYear = new JLabel("Year");
        JLabel labelETAMonth = new JLabel("Month");
        JLabel labelETADay = new JLabel("Day");
        final JTextField textFieldName = new JTextField(34);
        final JTextArea textAreaDescription = new JTextArea(7, 34);
        JButton buttonSave = new JButton("Add task");
        
        tempTextName = task.getName();
        tempTextDescription = task.getDescription();
        
        SpinnerNumberModel modelETAYear = new SpinnerNumberModel(task.getDeadlineYear(), frame.getDate().getProgramYear(), frame.getDate().getProgramYear() + 100, 1);
        SpinnerNumberModel modelETAMonth = new SpinnerNumberModel(task.getDeadlineMonth(), 1, 12, 1);
        SpinnerNumberModel modelETADay = new SpinnerNumberModel(task.getDeadlineDay(), 1, 31, 1);
        
        spinnerETAYear = new JSpinner(modelETAYear);
        spinnerETAMonth = new JSpinner(modelETAMonth);
        spinnerETADay = new JSpinner(modelETADay);
        
        customSpinner(spinnerETAYear);
        customSpinner(spinnerETAMonth);
        customSpinner(spinnerETADay);
        
        textAreaDescription.setWrapStyleWord(true);
        textAreaDescription.setLineWrap(true);
        textAreaDescription.setBorder(BorderFactory.createCompoundBorder(textAreaDescription.getBorder(),BorderFactory.createEmptyBorder(2, 2, 2, 2)));
        JScrollPane scrollingDescription = new JScrollPane(textAreaDescription);
        textFieldName.setBorder(BorderFactory.createCompoundBorder(textFieldName.getBorder(),BorderFactory.createEmptyBorder(2, 2, 2, 2)));
        textFieldName.setDocument(new TextLimit(50));
        buttonSave.setPreferredSize(new Dimension(382, 30));
        
        textFieldName.setText(tempTextName);
        textAreaDescription.setText(tempTextDescription);
        
        SpringLayout spring = new SpringLayout();
        panelTask.setLayout(spring);
        panelTask.setPreferredSize(new Dimension(480, 240));
        panelTask.add(labelName);
        panelTask.add(textFieldName);
        panelTask.add(labelDescription);
        panelTask.add(scrollingDescription);
        panelTask.add(labelETA);
        panelTask.add(labelETAYear);
        panelTask.add(labelETAMonth);
        panelTask.add(labelETADay);
        panelTask.add(spinnerETAYear);
        panelTask.add(spinnerETAMonth);
        panelTask.add(spinnerETADay);
        panelTask.add(buttonSave);
        panelTask.setVisible(true);

        spring.putConstraint(SpringLayout.WEST, labelName, 10, SpringLayout.WEST, panelTask);
        spring.putConstraint(SpringLayout.VERTICAL_CENTER, labelName, 0, SpringLayout.VERTICAL_CENTER, textFieldName);
        spring.putConstraint(SpringLayout.EAST, textFieldName, -13, SpringLayout.EAST, panelTask);
        spring.putConstraint(SpringLayout.NORTH, textFieldName, 10, SpringLayout.NORTH, panelTask);
        spring.putConstraint(SpringLayout.WEST, labelDescription, 0, SpringLayout.WEST, labelName);
        spring.putConstraint(SpringLayout.NORTH, labelDescription, 0, SpringLayout.NORTH, scrollingDescription);
        spring.putConstraint(SpringLayout.WEST, scrollingDescription, 0, SpringLayout.WEST, textFieldName);
        spring.putConstraint(SpringLayout.NORTH, scrollingDescription, 10, SpringLayout.SOUTH, textFieldName);
        spring.putConstraint(SpringLayout.WEST, labelETA, 10, SpringLayout.WEST, panelTask);
        spring.putConstraint(SpringLayout.VERTICAL_CENTER, labelETA, 0, SpringLayout.VERTICAL_CENTER, spinnerETAYear);
        spring.putConstraint(SpringLayout.WEST, labelETAYear, 0, SpringLayout.WEST, scrollingDescription);
        spring.putConstraint(SpringLayout.VERTICAL_CENTER, labelETAYear, 0, SpringLayout.VERTICAL_CENTER, spinnerETAYear);
        spring.putConstraint(SpringLayout.WEST, spinnerETAYear, 10, SpringLayout.EAST, labelETAYear);
        spring.putConstraint(SpringLayout.NORTH, spinnerETAYear, 10, SpringLayout.SOUTH, scrollingDescription);
        spring.putConstraint(SpringLayout.WEST, labelETAMonth, 10, SpringLayout.EAST, spinnerETAYear);
        spring.putConstraint(SpringLayout.VERTICAL_CENTER, labelETAMonth, 0, SpringLayout.VERTICAL_CENTER, spinnerETAYear);
        spring.putConstraint(SpringLayout.WEST, spinnerETAMonth, 10, SpringLayout.EAST, labelETAMonth);
        spring.putConstraint(SpringLayout.VERTICAL_CENTER, spinnerETAMonth, 0, SpringLayout.VERTICAL_CENTER, spinnerETAYear);
        spring.putConstraint(SpringLayout.WEST, labelETADay, 10, SpringLayout.EAST, spinnerETAMonth);
        spring.putConstraint(SpringLayout.VERTICAL_CENTER, labelETADay, 0, SpringLayout.VERTICAL_CENTER, spinnerETAYear);
        spring.putConstraint(SpringLayout.WEST, spinnerETADay, 10, SpringLayout.EAST, labelETADay);
        spring.putConstraint(SpringLayout.VERTICAL_CENTER, spinnerETADay, 0, SpringLayout.VERTICAL_CENTER, spinnerETAYear);
        spring.putConstraint(SpringLayout.EAST, buttonSave, 0, SpringLayout.EAST, scrollingDescription);
        spring.putConstraint(SpringLayout.SOUTH, buttonSave, -10, SpringLayout.SOUTH, panelTask);
        
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
                
                textAreaDescription.addFocusListener(new FocusListener() {
                       @Override
                       public void focusGained(FocusEvent e) {
                           textAreaDescription.setText(tempTextDescription);
                } 

                        @Override
                        public void focusLost(FocusEvent e) {
                            tempTextDescription = textAreaDescription.getText();
                            if (textAreaDescription.getText().length() < 20) {
                                textAreaDescription.setBackground(new Color(255, 180, 180));
                                textAreaDescription.setBorder(compound);
                                textAreaDescription.setText("The description must consist out of 20 characters at least");
                                boolDescription = false;
                            }
                            else {
                                textAreaDescription.setBackground(new Color(255, 255, 255));
                                textAreaDescription.setBorder(oldAreaBorder);
                                boolDescription = true;
                            }
                        }
                    });
                
                boolName = boolDescription = true;
        
        buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                checkFields(textFieldName, textAreaDescription);
                if (boolName && boolDescription) {
                task.setName(textFieldName.getText());
                task.setDescription(textAreaDescription.getText());
                task.setDeadlineYear((Integer)spinnerETAYear.getValue());
                task.setDeadlineMonth((Integer)spinnerETAMonth.getValue());
                task.setDeadlineDay((Integer)spinnerETADay.getValue());
                panel.refreshData();
                dialogProject.dispose();
                }
            }
        });
        dialogProject.add(panelTask);
        dialogProject.pack();
        dialogProject.setLocationRelativeTo(null);
        dialogProject.setResizable(false);
        dialogProject.setModal(true);
        dialogProject.setVisible(true);
        //Image img = ImageIO.read(getClass().getResource("./src/project/*.png"));
        //dialogProject.setIconImage(img);
    } 

    public void removeTask(final ArrayList<Task> tasks, final StudentJPanels mainPanel) {
        if(tasks.size() > 0) {
            final JDialog dialog = new JDialog();
            dialog.setSize(350, 130);
            dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            dialog.setTitle("Remove task");
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            dialog.setLocation(dim.width / 2 - dialog.getSize().width / 2, dim.height / 2 - dialog.getSize().height / 2);

            JPanel panel = new JPanel();
            SpringLayout layout = new SpringLayout();
            panel.setLayout(layout);

            JLabel taskLabel = new JLabel("Select task:");

            String[] taskNames = new String[tasks.size()];
            for (int i = 0; i < taskNames.length; i++) {
                taskNames[i] = tasks.get(i).getName();
            }

            final JComboBox taskList = new JComboBox(taskNames);
            taskList.setSelectedIndex(0);
            taskList.setPreferredSize(new Dimension(200, 25));

            JButton button = new JButton("Remove");
            button.setPreferredSize(new Dimension(200, 30));
            new NavigationAndButtons().removeButton(button, tasks, taskList, mainPanel, dialog);

            panel.add(taskLabel);
            panel.add(taskList);
            panel.add(button);

            layout.putConstraint(SpringLayout.NORTH, taskLabel, 13, SpringLayout.NORTH, panel);
            layout.putConstraint(SpringLayout.WEST, taskLabel, 10, SpringLayout.WEST, panel);
            layout.putConstraint(SpringLayout.NORTH, taskList, 10, SpringLayout.NORTH, panel);
            layout.putConstraint(SpringLayout.WEST, taskList, 100, SpringLayout.WEST, taskLabel);
            layout.putConstraint(SpringLayout.NORTH, button, 35, SpringLayout.NORTH, taskLabel);
            layout.putConstraint(SpringLayout.WEST, button, 100, SpringLayout.WEST, taskLabel);

            dialog.add(panel);
            dialog.setLocationRelativeTo(null);
            dialog.setResizable(false);
            dialog.setModal(true);
            dialog.setVisible(true);
        }
        else {
            JDialog dialog = new JDialog();
            JOptionPane.showMessageDialog(dialog,
                    "This student has no tasks",
                    "Remove task",
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
    
    void checkFields(JTextField textFieldName, JTextArea textAreaDescription){
        if(boolName == null){
            tempTextName = textFieldName.getText();
            textFieldName.setBackground(new Color(255, 180, 180));
            textFieldName.setBorder(compound);
            textFieldName.setText("At least 4 characters");
        }
        if(boolDescription == null){
            tempTextDescription = textAreaDescription.getText();
            textAreaDescription.setBackground(new Color(255, 180, 180));
            textAreaDescription.setBorder(compound);
            textAreaDescription.setText("The description must consist out of 20 characters at least");
        }
    }
}
