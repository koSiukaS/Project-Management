package project;

import project.view.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class ProgramDate {

    private int programYear;
    private int programMonth;
    private int programDay;
    private JSpinner spinnerYear;
    private JSpinner spinnerMonth;
    private JSpinner spinnerDay;

    private JDialog frame;
    private JPanel f;
    private JButton save = new JButton("Save");

    /**
     * Creates a GUI in which date will be changed
     */
    private void createChangeTimeGUI(){
        frame = new JDialog();
        frame.setTitle("Change date");
        f = new JPanel(new FlowLayout());

        if(programYear == 0) {
            programYear = Calendar.getInstance().get(Calendar.YEAR);
            programMonth = Calendar.getInstance().get(Calendar.MONTH)+1;
            programDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        }

        SpinnerNumberModel modelYears = new SpinnerNumberModel(programYear, 1950, Calendar.getInstance().get(Calendar.YEAR) + 100, 1);
        SpinnerNumberModel modelMonths = new SpinnerNumberModel(programMonth, 1, 12, 1);
        SpinnerNumberModel modelDays = new SpinnerNumberModel(programDay, 1, 31, 1);

        spinnerYear = new JSpinner(modelYears);
        spinnerMonth = new JSpinner(modelMonths);
        spinnerDay = new JSpinner(modelDays);

        Font boldFont = new Font("Calibri", Font.BOLD, 13);

        spinnerYear.setEditor(new JSpinner.NumberEditor(spinnerYear,"#"));
        JComponent boxYear = spinnerYear.getEditor();
        JFormattedTextField textFieldYear = ((JSpinner.DefaultEditor)boxYear).getTextField();
        textFieldYear.setColumns(3);
        textFieldYear.setFont(boldFont);
        textFieldYear.setHorizontalAlignment(JTextField.CENTER);
        JComponent boxMonth = spinnerMonth.getEditor();
        JFormattedTextField textFieldMonth = ((JSpinner.DefaultEditor)boxMonth).getTextField();
        textFieldMonth.setColumns(2);
        textFieldMonth.setFont(boldFont);
        textFieldMonth.setHorizontalAlignment(JTextField.CENTER);
        JComponent boxDay = spinnerDay.getEditor();
        JFormattedTextField textFieldDay = ((JSpinner.DefaultEditor)boxDay).getTextField();
        textFieldDay.setColumns(2);
        textFieldDay.setFont(boldFont);
        textFieldDay.setHorizontalAlignment(JTextField.CENTER);

        f.setPreferredSize(new Dimension(400,40));
        f.add(new JLabel("Year"));
        f.add(spinnerYear);
        f.add(new JLabel("Month"));
        f.add(spinnerMonth);
        f.add(new JLabel("Day"));
        f.add(spinnerDay);

        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        //frame.setLocation(new Point(GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint()));
    }

    /**
     * changeTime method invokes createChangeTimeGUI method, this way graphics are created. <br>
     * After saving the new date, frame disposes. <br>
     * Next time new frame will be created and old actionListeners will be deleted
     * because this method is overloaded and different params results in different functionality
     *
     * @param mainFrame main GUI's frame
     */
    public void changeTime(final MainFrame mainFrame) {
        createChangeTimeGUI();
        f.add(save);
        removeSaveActionListener(save);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setProgramYear((Integer)spinnerYear.getValue());
                setProgramMonth((Integer)spinnerMonth.getValue());
                setProgramDay((Integer)spinnerDay.getValue());
                frame.dispose();
                mainFrame.refreshData();
                mainFrame.getFrame().setVisible(true);
            }
        });
        frame.add(f);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setModal(true);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    /**
     * changeTime method invokes createChangeTimeGUI method, this way graphics are created. <br>
     * After saving the new date, frame disposes. <br>
     * Next time new frame will be created and old actionListeners will be deleted
     * because this method is overloaded and different params results in different functionality
     *
     * @param panel object which JPanels will be refreshed after date change
     */
    public void changeTime(final BaseClass panel) {
        createChangeTimeGUI();
        f.add(save);
        removeSaveActionListener(save);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setProgramYear((Integer) spinnerYear.getValue());
                setProgramMonth((Integer) spinnerMonth.getValue());
                setProgramDay((Integer) spinnerDay.getValue());
                frame.dispose();
                panel.refreshData();
            }
        });
        frame.add(f);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setModal(true);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    /**
     * Method which removes all actionListeners for specific button
     *
     * @param save  button which actionListeners will be removed
     */
    private void removeSaveActionListener(JButton save) {
        ActionListener[] list = save.getActionListeners();
        for(int i = 0; i < list.length; i++) {
            save.removeActionListener(list[i]);
        }
    }

    public int getProgramYear() {
        return programYear;
    }

    public void setProgramYear(int programYear) {
        this.programYear = programYear;
    }

    public int getProgramMonth() {
        return programMonth;
    }

    public void setProgramMonth(int programMonth) {
        this.programMonth = programMonth;
    }

    public int getProgramDay() {
        return programDay;
    }

    public void setProgramDay(int programDay) {
        this.programDay = programDay;
    }
}
