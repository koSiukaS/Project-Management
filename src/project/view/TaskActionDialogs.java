package project.view;

import project.model.Task;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.swing.border.Border;
import javax.swing.text.JTextComponent;

public class TaskActionDialogs extends BaseActionDialogs{
    private String tempTextName, tempTextDescription;
    private AtomicBoolean boolName = new AtomicBoolean();
    private AtomicBoolean boolDescription = new AtomicBoolean();
    private JSpinner spinnerETAYear, spinnerETAMonth,spinnerETADay;
    private JTextField textFieldName;
    private JButton buttonSave;
    private JDialog dialogTask;
    private int startYear, startMonth, startDay;
    
    public void addTask(final ArrayList<Task> tasks, final StudentJPanels panel, MainFrame frame){
        startYear = frame.getDate().getProgramYear();
        startMonth = frame.getDate().getProgramMonth();
        startDay = frame.getDate().getProgramDay();
        createDialogTask(frame);
        dialogTask.setTitle("Adding a task");
        createActionListeners();
        buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                checkFields();
                if (boolName.get() && boolDescription.get()) {
                Task task = new Task();
                task.setName(textFieldName.getText());
                task.setDescription(textAreaDescription.getText());
                task.setDeadlineYear((Integer)spinnerETAYear.getValue());
                task.setDeadlineMonth((Integer)spinnerETAMonth.getValue());
                task.setDeadlineDay((Integer)spinnerETADay.getValue());
                tasks.add(task);
                panel.refreshData();
                dialogTask.dispose();
                }
            }
        });
        dialogTask.pack();
        dialogTask.setLocationRelativeTo(null);
        dialogTask.setResizable(false);
        dialogTask.setModal(true);
        dialogTask.setVisible(true);
    }
    
    public void editTask(final Task task, final MainFrame frame, final TaskJPanels panel){
        startYear = task.getDeadlineYear();
        startMonth = task.getDeadlineMonth();
        startDay = task.getDeadlineDay();
        
        createDialogTask(frame);
        dialogTask.setTitle("Editing " + task.getName());
        
        tempTextName = task.getName();
        tempTextDescription = task.getDescription();
        
        textFieldName.setText(tempTextName);
        textAreaDescription.setText(tempTextDescription);
        
        boolName.set(true);
        boolDescription.set(true);
        
        createActionListeners();
        
        buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                checkFields();
                if (boolName.get() && boolDescription.get()) {
                task.setName(textFieldName.getText());
                task.setDescription(textAreaDescription.getText());
                task.setDeadlineYear((Integer)spinnerETAYear.getValue());
                task.setDeadlineMonth((Integer)spinnerETAMonth.getValue());
                task.setDeadlineDay((Integer)spinnerETADay.getValue());
                panel.refreshData();
                dialogTask.dispose();
                }
            }
        });
        dialogTask.pack();
        dialogTask.setLocationRelativeTo(null);
        dialogTask.setResizable(false);
        dialogTask.setModal(true);
        dialogTask.setVisible(true);
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
    
    private void createDialogTask(MainFrame frame){
        dialogTask = new JDialog();
        JPanel panelTask = new JPanel();
        JLabel labelName = new JLabel("Task name:");
        JLabel labelDescription = new JLabel("Description:");  
        JLabel labelETA = new JLabel("Task ETA:");
        JLabel labelETAYear = new JLabel("Year");
        JLabel labelETAMonth = new JLabel("Month");
        JLabel labelETADay = new JLabel("Day");
        textFieldName = new JTextField(34);
        textAreaDescription = new JTextArea(7, 34);
        buttonSave = new JButton("Add task");
        
        SpinnerNumberModel modelETAYear = new SpinnerNumberModel(startYear, frame.getDate().getProgramYear(), frame.getDate().getProgramYear() + 100, 1);
        SpinnerNumberModel modelETAMonth = new SpinnerNumberModel(startMonth, 1, 12, 1);
        SpinnerNumberModel modelETADay = new SpinnerNumberModel(startDay, 1, 31, 1);
        
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
        textFieldName.setDocument(new BaseActionDialogs(50));
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
        dialogTask.add(panelTask);
    } 
    
    private void createActionListeners(){
    createSingleFocusListener(textFieldName, tempTextName, boolName);
    createSingleFocusListener(textAreaDescription, tempTextDescription, boolDescription);
}
    
    private void createSingleFocusListener(final JTextComponent textField, final String tempText, final AtomicBoolean bool) {
        textField.addFocusListener(new FocusListener() {
            String temp = tempText;
            
            @Override
            public void focusGained(FocusEvent e) {
                textField.setText(temp);
                bool.set(true);
            }

            @Override
            public void focusLost(FocusEvent e) {
                temp = textField.getText();
                if (textField.getText().length() < 50 && textField instanceof JTextArea) {
                    errorDescription(50);
                    bool.set(false);
                } else if (textField.getText().length() < 4 && textField instanceof JTextField) {
                    error(textField);
                    bool.set(false);
                } else {
                    textField.setBackground(new Color(255, 255, 255));
                    bool.set(true);
                    if(textField instanceof JTextField) {
                        textField.setBorder(oldFieldBorder);
                    } else {
                        textField.setBorder(oldAreaBorder);
                    }
                }
            }
        });
    }
    

    
    void checkFields(){
        if(!boolName.get()){
            tempTextName = textFieldName.getText();
            error(textFieldName);
        }
        if(!boolDescription.get()){
            tempTextDescription = textAreaDescription.getText();
            errorDescription(50);
        }
    }
}
