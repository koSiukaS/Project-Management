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
import java.util.concurrent.atomic.AtomicBoolean;
import javax.swing.border.Border;
import javax.swing.text.JTextComponent;
import project.ProgramDate;


public class StudentActionDialogs extends BaseActionDialogs{
	private int bYear, bMonth, bDay, startYear, startMonth, startDay, endYear, endMonth, endDay, courseGroup;
	private String tempFirstName, tempLastName, tempId, tempPosition, tempCourseName;
    private JTextField textFieldFirstName, textFieldLastName, textFieldCourseName, textFieldId, textFieldPosition, textFieldBirthYear, textFieldBirthMonth,
						textFieldBirthDay, textFieldCourseStartYear, textFieldCourseStartMonth, textFieldCourseStartDay, textFieldCourseEndYear, 
						textFieldCourseEndMonth, textFieldCourseEndDay, textFieldCourseGroup;
    private JButton buttonSave;
	private JDialog dialogStudent;
    private JSpinner spinnerCourseGroup, spinnerCourseStartYear, spinnerCourseStartMonth,spinnerCourseStartDay,
			spinnerCourseEndYear, spinnerCourseEndMonth, spinnerCourseEndDay, spinnerBirthYear, spinnerBirthMonth, spinnerBirthDay;
    private AtomicBoolean boolFirstName = new AtomicBoolean();
    private AtomicBoolean boolLastName = new AtomicBoolean();
    private AtomicBoolean boolId = new AtomicBoolean();
    private AtomicBoolean boolPosition = new AtomicBoolean();
    private AtomicBoolean boolCourseName = new AtomicBoolean();
    private AtomicBoolean boolCourseGroup = new AtomicBoolean();
    private AtomicBoolean boolCourseStartYear = new AtomicBoolean();
    private AtomicBoolean boolCourseStartMonth = new AtomicBoolean();
    private AtomicBoolean boolCourseStartDay = new AtomicBoolean();
    private AtomicBoolean boolCourseEndYear = new AtomicBoolean();
    private AtomicBoolean boolCourseEndMonth = new AtomicBoolean();
    private AtomicBoolean boolCourseEndDay = new AtomicBoolean();
    private AtomicBoolean boolBirthYear = new AtomicBoolean();
    private AtomicBoolean boolBirthMonth = new AtomicBoolean();
    private AtomicBoolean boolBirthDay= new AtomicBoolean();
    
    public void addStudent(final ArrayList<Student> students, final ProjectJPanels mainPanel){
		bYear = mainPanel.date.getProgramYear();
        bMonth = mainPanel.date.getProgramMonth();
        bDay = mainPanel.date.getProgramDay();
		startYear = mainPanel.date.getProgramYear();
        startMonth = mainPanel.date.getProgramMonth();
        startDay = mainPanel.date.getProgramDay();
		endYear = mainPanel.date.getProgramYear();
        endMonth = mainPanel.date.getProgramMonth();
        endDay = mainPanel.date.getProgramDay();
		courseGroup = 0;
		
		createDialogStudent(mainPanel);
		dialogStudent.setTitle("Adding a student");
		
		createFocusListeners();
		
        buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
				checkInfo();
                if(boolCourseGroup.get() && boolCourseStartYear.get() && boolCourseStartMonth.get() && boolCourseStartDay.get() && boolCourseEndYear.get() &&
                   boolCourseEndMonth.get() && boolCourseEndDay.get()&& boolBirthYear.get() && boolBirthMonth.get() && boolBirthDay.get() && boolFirstName.get() &&
                   boolLastName.get() && boolPosition.get() && boolId.get() && boolCourseName.get()){
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
        dialogStudent.pack();
        dialogStudent.setLocationRelativeTo(null);
        dialogStudent.setResizable(false);
        dialogStudent.setModal(true);
        dialogStudent.setVisible(true);
    } 

    public void editStudent(final Student student, ProjectJPanels mainPanel, final StudentJPanels panel){
		bYear = student.getBirthYear();
        bMonth = student.getBirthMonth();
        bDay = student.getBirthDay();
		startYear = student.getCourseStartYear();
        startMonth = student.getCourseStartMonth();
        startDay = student.getCourseStartDay();
		endYear = student.getCourseEndYear();
        endMonth = student.getCourseEndMonth();
        endDay = student.getCourseEndDay();
		courseGroup = student.getGroup();
		
		createDialogStudent(mainPanel);
		dialogStudent.setTitle("Editing " + student.getFirstName() + student.getLastName());
		
		tempFirstName = student.getFirstName();
        tempLastName = student.getLastName();
        tempId = student.getId();
        tempPosition = student.getPosition();
        tempCourseName = student.getCourseName();
		
		textFieldFirstName.setText(tempFirstName);
        textFieldLastName.setText(tempLastName);
        textFieldId.setText(tempId);
        textFieldPosition.setText(tempPosition);
        textFieldCourseName.setText(tempCourseName);
		
		boolFirstName.set(true);
		boolLastName.set(true);
		boolId.set(true);
		boolPosition.set(true);
		boolCourseName.set(true);
		boolCourseGroup.set(true);
		
		createFocusListeners();
		
		buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                checkInfo();
                if(boolCourseGroup.get() && boolCourseStartYear.get() && boolCourseStartMonth.get() && boolCourseStartDay.get() && boolCourseEndYear.get() &&
                   boolCourseEndMonth.get() && boolCourseEndDay.get()&& boolBirthYear.get() && boolBirthMonth.get() && boolBirthDay.get() && boolFirstName.get() &&
                   boolLastName.get() && boolPosition.get() && boolId.get() && boolCourseName.get()){
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
        dialogStudent.pack();
        dialogStudent.setLocationRelativeTo(null);
        dialogStudent.setResizable(false);
        dialogStudent.setModal(true);
        dialogStudent.setVisible(true);
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
	
	public void createDialogStudent(ProjectJPanels mainPanel){
        dialogStudent = new JDialog();
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
        textFieldFirstName = new JTextField(12);
        textFieldLastName = new JTextField(12);
        textFieldId = new JTextField(12);
        textFieldPosition = new JTextField(12);
        textFieldCourseName = new JTextField(20);
        buttonSave = new JButton("Add student");
        
        SpinnerNumberModel modelCourseGroup = new SpinnerNumberModel(courseGroup, 0, 99, 1);
        SpinnerNumberModel modelCourseStartYear = new SpinnerNumberModel(startYear, 1950, startYear + 100, 1);
        SpinnerNumberModel modelCourseStartMonth = new SpinnerNumberModel(startMonth, 1, 12, 1);
        SpinnerNumberModel modelCourseStartDay = new SpinnerNumberModel(startMonth, 1, 31, 1);
        SpinnerNumberModel modelCourseEndYear = new SpinnerNumberModel(endYear, 1950, endYear + 100, 1);
        SpinnerNumberModel modelCourseEndMonth = new SpinnerNumberModel(endMonth, 1, 12, 1);
        SpinnerNumberModel modelCourseEndDay = new SpinnerNumberModel(endDay, 1, 31, 1);
        SpinnerNumberModel modelBirthYear = new SpinnerNumberModel(bYear, 1800, bYear, 1);
        SpinnerNumberModel modelBirthMonth = new SpinnerNumberModel(bMonth, 1, 12, 1);
        SpinnerNumberModel modelBirthDay = new SpinnerNumberModel(bDay, 1, 31, 1);
        
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
        textFieldFirstName.setDocument(new BaseActionDialogs(30));
        textFieldLastName.setBorder(BorderFactory.createCompoundBorder(textFieldLastName.getBorder(),BorderFactory.createEmptyBorder(2, 2, 2, 2)));
        textFieldLastName.setDocument(new BaseActionDialogs(30));
        textFieldId.setBorder(BorderFactory.createCompoundBorder(textFieldId.getBorder(),BorderFactory.createEmptyBorder(2, 2, 2, 2)));
        textFieldId.setDocument(new BaseActionDialogs(30));
        textFieldPosition.setBorder(BorderFactory.createCompoundBorder(textFieldPosition.getBorder(),BorderFactory.createEmptyBorder(2, 2, 2, 2)));
        textFieldPosition.setDocument(new BaseActionDialogs(30));
        textFieldCourseName.setBorder(BorderFactory.createCompoundBorder(textFieldCourseName.getBorder(),BorderFactory.createEmptyBorder(2, 2, 2, 2)));
        textFieldCourseName.setDocument(new BaseActionDialogs(60));
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
                        
				boolCourseStartYear.set(true);
				boolCourseStartMonth.set(true);
				boolCourseStartDay.set(true);
				boolCourseEndYear .set(true);
                boolCourseEndMonth.set(true);
				boolCourseEndDay.set(true);
				boolBirthYear.set(true);
				boolBirthMonth.set(true);
				boolBirthDay.set(true);
                boolCourseGroup.set(false);
                
                JSpinner.DefaultEditor editorCourseGroup = (JSpinner.DefaultEditor)spinnerCourseGroup.getEditor();
                textFieldCourseGroup = editorCourseGroup.getTextField();
                JSpinner.DefaultEditor editorBirthYear = (JSpinner.DefaultEditor)spinnerBirthYear.getEditor();
                textFieldBirthYear = editorBirthYear.getTextField();
                JSpinner.DefaultEditor editorBirthMonth = (JSpinner.DefaultEditor)spinnerBirthMonth.getEditor();
				textFieldBirthMonth = editorBirthMonth.getTextField();
                JSpinner.DefaultEditor editorBirthDay = (JSpinner.DefaultEditor)spinnerBirthDay.getEditor();
                textFieldBirthDay = editorBirthDay.getTextField();
                JSpinner.DefaultEditor editorCourseStartYear = (JSpinner.DefaultEditor)spinnerCourseStartYear.getEditor();
                textFieldCourseStartYear = editorCourseStartYear.getTextField();
                JSpinner.DefaultEditor editorCourseStartMonth = (JSpinner.DefaultEditor)spinnerCourseStartMonth.getEditor();
                textFieldCourseStartMonth = editorCourseStartMonth.getTextField();
                JSpinner.DefaultEditor editorCourseStartDay = (JSpinner.DefaultEditor)spinnerCourseStartDay.getEditor();
                textFieldCourseStartDay = editorCourseStartDay.getTextField();
                JSpinner.DefaultEditor editorCourseEndYear = (JSpinner.DefaultEditor)spinnerCourseEndYear.getEditor();
                textFieldCourseEndYear = editorCourseEndYear.getTextField();
                JSpinner.DefaultEditor editorCourseEndMonth = (JSpinner.DefaultEditor)spinnerCourseEndMonth.getEditor();
                textFieldCourseEndMonth = editorCourseEndMonth.getTextField();
                JSpinner.DefaultEditor editorCourseEndDay = (JSpinner.DefaultEditor)spinnerCourseEndDay.getEditor();
                textFieldCourseEndDay = editorCourseEndDay.getTextField();
                
                
                textFieldCourseGroup.addFocusListener(new FocusAdapter() {
                   @Override
                   public void focusGained(FocusEvent e) {
                    }
                    @Override
                    public void focusLost(FocusEvent e) {
                        if ((Integer)spinnerCourseGroup.getValue() == 0) {
                            spinnerRed(spinnerCourseGroup);
                            boolCourseGroup.set(false);
                        }
                        else {
                            spinnerOld(spinnerCourseGroup);
                            boolCourseGroup.set(true);
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
                                boolBirthYear.set(false);
                            }
                            else {
                                spinnerOld(spinnerBirthYear);
                                boolBirthYear.set(true);
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
                                boolBirthMonth.set(false);
                            }
                            else {
                                spinnerOld(spinnerBirthMonth);
                                boolBirthMonth.set(true);
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
                                boolBirthDay.set(false);
                            }
                            else {
                                spinnerOld(spinnerBirthDay);
                                boolBirthDay.set(true);
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
                                boolCourseStartYear.set(false);
                            }
                            else {
                                spinnerOld(spinnerCourseStartYear);
                                boolCourseStartYear.set(true);
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
                                boolCourseStartMonth.set(false);
                            }
                            else {
                                spinnerOld(spinnerCourseStartMonth);
                                boolCourseStartMonth.set(true);
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
                                boolCourseStartDay.set(false);
                            }
                            else {
                                spinnerOld(spinnerCourseStartDay);
                                boolCourseStartDay.set(true);
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
                                boolCourseEndYear.set(false);
                            }
                            else {
                                spinnerOld(spinnerCourseEndYear);
                                boolCourseEndYear.set(true);
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
                                boolCourseEndMonth.set(false);
                            }
                            else {
                                spinnerOld(spinnerCourseEndMonth);
                                boolCourseEndMonth.set(true);
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
                                boolCourseEndDay.set(false);
                            }
                            else {
                                spinnerOld(spinnerCourseEndDay);
                                boolCourseEndDay.set(true);
                            }
                        }
                    });
				
				dialogStudent.add(panelStudent);
	}
	
    private void createFocusListeners(){
    createSingleFocusListener(textFieldFirstName, tempFirstName, boolFirstName);
    createSingleFocusListener(textFieldLastName, tempLastName, boolLastName);
	createSingleFocusListener(textFieldCourseName, tempCourseName, boolCourseName);
	createSingleFocusListener(textFieldPosition, tempPosition, boolPosition);
	createSingleFocusListener(textFieldId, tempId, boolId);
}
	private void createSpinnerListeners(){
		createSingleSpinnerListener(textFieldBirthYear, textFieldBirthMonth, textFieldBirthDay, 
									boolBirthYear, boolBirthMonth, boolBirthDay,
									spinnerBirthYear, spinnerBirthMonth, spinnerBirthDay,
									spinnerCourseStartYear, spinnerCourseStartMonth, spinnerCourseStartDay,
									spinnerCourseEndYear, spinnerCourseEndMonth, spinnerCourseEndDay);
		createSingleSpinnerListener(textFieldCourseStartYear, textFieldCourseStartMonth, textFieldCourseStartDay, 
									boolCourseStartYear, boolCourseStartMonth, boolCourseStartDay,
									spinnerBirthYear, spinnerBirthMonth, spinnerBirthDay,
									spinnerCourseStartYear, spinnerCourseStartMonth, spinnerCourseStartDay,
									spinnerCourseEndYear, spinnerCourseEndMonth, spinnerCourseEndDay);
		createSingleSpinnerListener(textFieldBirthYear, textFieldBirthMonth, textFieldBirthDay, 
									boolBirthYear, boolBirthMonth, boolBirthDay,
									spinnerBirthYear, spinnerBirthMonth, spinnerBirthDay,
									spinnerCourseStartYear, spinnerCourseStartMonth, spinnerCourseStartDay,
									spinnerCourseEndYear, spinnerCourseEndMonth, spinnerCourseEndDay);
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
	
	private void createSingleSpinnerListener(JTextField textFieldYear, JTextField textFieldMonth, JTextField textFieldDay,
									final AtomicBoolean boolYear, final AtomicBoolean boolMonth, final AtomicBoolean boolDay, 
									final JSpinner spinnerAYear, final JSpinner spinnerAMonth, final JSpinner spinnerADay, 
									final JSpinner spinnerBYear, final JSpinner spinnerBMonth, final JSpinner spinnerBDay,
									final JSpinner spinnerCYear, final JSpinner spinnerCMonth, final JSpinner spinnerCDay){
		textFieldYear.addFocusListener(new FocusAdapter() {
                       @Override
                       public void focusGained(FocusEvent e) {
                } 
                        @Override
                        public void focusLost(FocusEvent e) {
                            if ((Integer)spinnerAYear.getValue() > (Integer)spinnerBYear.getValue() || (Integer)spinnerAYear.getValue() > (Integer)spinnerCYear.getValue()){
                                spinnerRed(spinnerAYear);
                                boolYear.set(false);
                            }
                            else {
                                spinnerOld(spinnerAYear);
                                boolYear.set(true);
                            }
                        }
                    });
                
                textFieldMonth.addFocusListener(new FocusAdapter() {
                       @Override
                       public void focusGained(FocusEvent e) {
                } 
                        @Override
                        public void focusLost(FocusEvent e) {
                            if (((Integer)spinnerAYear.getValue() > (Integer)spinnerBYear.getValue() || (Integer)spinnerAYear.getValue() > (Integer)spinnerCYear.getValue()) ||
                               ((Integer)spinnerAYear.getValue() >= (Integer)spinnerBYear.getValue() && (Integer)spinnerAMonth.getValue() > (Integer)spinnerBMonth.getValue()) ||
                               ((Integer)spinnerAYear.getValue() >= (Integer)spinnerCYear.getValue() && (Integer)spinnerAMonth.getValue() > (Integer)spinnerCMonth.getValue())) {
								spinnerRed(spinnerAMonth);               
								boolMonth.set(false);
                            }
                            else {
                                spinnerOld(spinnerAMonth);
                                boolMonth.set(true);
                            }
                        }
                    });
                
                textFieldDay.addFocusListener(new FocusAdapter() {
                       @Override
                       public void focusGained(FocusEvent e) {
                } 
                        @Override
                        public void focusLost(FocusEvent e) {
                            if ((((Integer)spinnerAYear.getValue() > (Integer)spinnerBYear.getValue() || (Integer)spinnerAYear.getValue() > (Integer)spinnerCYear.getValue()) ||
                               ((Integer)spinnerAYear.getValue() >= (Integer)spinnerBYear.getValue() && (Integer)spinnerAMonth.getValue() > (Integer)spinnerBMonth.getValue()) ||
                               ((Integer)spinnerAYear.getValue() >= (Integer)spinnerCYear.getValue() && (Integer)spinnerAMonth.getValue() > (Integer)spinnerCMonth.getValue())) ||
                               ((Integer)spinnerAYear.getValue() >= (Integer)spinnerBYear.getValue() && (Integer)spinnerAMonth.getValue() >= (Integer)spinnerBMonth.getValue() && (Integer)spinnerADay.getValue() > (Integer)spinnerBDay.getValue()) ||
                               ((Integer)spinnerAYear.getValue() >= (Integer)spinnerCYear.getValue() && (Integer)spinnerAMonth.getValue() >= (Integer)spinnerCMonth.getValue() && (Integer)spinnerADay.getValue() > (Integer)spinnerCDay.getValue())) {
                                spinnerRed(spinnerADay);
                                boolDay.set(false);
                            }
                            else {
                                spinnerOld(spinnerADay);
                                boolDay.set(true);
                            }
                        }
                    });
	}
    
    private void spinnerRed(JSpinner spinner){
        JComponent boxSpinner = spinner.getEditor();
        JFormattedTextField textFieldSpinner = ((JSpinner.DefaultEditor)boxSpinner).getTextField();
        textFieldSpinner.setBackground(new Color(255, 180, 180));
    }
    
    private void spinnerOld(JSpinner spinner){
        JComponent boxSpinner = spinner.getEditor();
        JFormattedTextField textFieldSpinner = ((JSpinner.DefaultEditor)boxSpinner).getTextField();
        textFieldSpinner.setBackground(new Color(255, 255, 255));
    }
    
    private void checkInfo(){
		if(!boolFirstName.get()){
            tempFirstName = textFieldFirstName.getText();
            error(textFieldFirstName);
        }
        if(!boolLastName.get()){
            tempLastName = textFieldLastName.getText();
            error(textFieldLastName);
        }
        if(!boolPosition.get()){
            tempPosition = textFieldPosition.getText();
            error(textFieldPosition);
        }
        if(!boolId.get()){
            tempId = textFieldId.getText();
            error(textFieldId);
        }
        if(!boolCourseName.get()){
            tempCourseName = textFieldCourseName.getText();
            error(textFieldCourseName);
        }
        if(!boolCourseGroup.get()){
            spinnerRed(spinnerCourseGroup);
        }
        if(!boolBirthYear.get()){
            spinnerRed(spinnerBirthYear);
        }
        if(!boolBirthMonth.get()){
            spinnerRed(spinnerBirthMonth);
        }
        if(!boolBirthDay.get()){
            spinnerRed(spinnerBirthDay);
        }
        if(!boolCourseStartYear.get()){
            spinnerRed(spinnerCourseStartYear);
        }
        if(!boolCourseStartMonth.get()){
            spinnerRed(spinnerCourseStartMonth);
        }
        if(!boolCourseStartDay.get()){
            spinnerRed(spinnerCourseStartDay);
        }
        if(!boolCourseEndYear.get()){
            spinnerRed(spinnerCourseEndYear);
        }
        if(!boolCourseEndMonth.get()){
            spinnerRed(spinnerCourseEndMonth);
        }
        if(!boolCourseEndDay.get()){
            spinnerRed(spinnerCourseEndDay);
        }
    }
}
