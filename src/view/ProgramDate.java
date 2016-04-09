package view;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.awt.GraphicsEnvironment.*;
public class ProgramDate {

    /**
     * Today's date chosen as initial date
     */
    private int programYear;
    private int programMonth;
    private int programDay;
    //private String inYear = Integer.toString(Calendar.getInstance().get(Calendar.YEAR));
    //private String inMonth = Integer.toString(Calendar.getInstance().get(Calendar.MONTH) + 1);
    //private String inDay = Integer.toString(Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
    private JSpinner spinnerYear;
    private JSpinner spinnerMonth;
    private JSpinner spinnerDay;

    private JFrame frame;
    private JPanel f;
    private JButton save = new JButton("Save");

    public void createChangeTimeGUI(){
        frame = new JFrame("Date");
        f = new JPanel(new FlowLayout());
        /**
         * Years list starting from this year(2016),
         * ending - 1970;
         * saved in allYears[]
         */
        /*JLabel year = new JLabel("Year");
        f.add(year);
        int yearCount = Calendar.getInstance().get(Calendar.YEAR) - 1970;
        String allYears[] = new String[yearCount+1];
        for (int i = 0;i <= yearCount; i++) {
            allYears[i] = Integer.toString(1970 + yearCount - i);
        }
        JComboBox yearList = new JComboBox(allYears);
        yearList.setSelectedIndex(0);
        f.add(yearList);
        yearList.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JComboBox cb = (JComboBox)e.getSource();
                inYear = (String)cb.getSelectedItem();
            }
        });

        JLabel month = new JLabel("Month");
        f.add(month);
        String allMonths[] = new String[12];
        for (int i = 1; i <= 12; i++) {
            allMonths[i-1] = Integer.toString(i);
        }
        JComboBox monthList = new JComboBox(allMonths);
        monthList.setSelectedIndex(Calendar.getInstance().get(Calendar.MONTH));
        f.add(monthList);
        monthList.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JComboBox cc = (JComboBox)e.getSource();
                inMonth = (String)cc.getSelectedItem();
            }
        });

        JLabel day = new JLabel("Day");
        f.add(day);
        String allDays[] = new String[31];
        for (int i = 1; i <= 31; i++) {
            allDays[i-1] = Integer.toString(i);
        }
        JComboBox dayList = new JComboBox(allDays);
        dayList.setSelectedIndex(Calendar.getInstance().get(Calendar.DAY_OF_MONTH) - 1);
        f.add(dayList);
        dayList.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JComboBox cd = (JComboBox)e.getSource();
                inDay = (String)cd.getSelectedItem();
            }
        });*/
        if(programYear == 0) {
        programYear = Calendar.getInstance().get(Calendar.YEAR);
        programMonth = Calendar.getInstance().get(Calendar.MONTH)+1;
        programDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        }
        
        SpinnerNumberModel modelYears = new SpinnerNumberModel(programYear, 1970, Calendar.getInstance().get(Calendar.YEAR) + 100, 1);
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
        
        f.add(new JLabel("Year"));
        f.add(spinnerYear);
        f.add(new JLabel("Month"));
        f.add(spinnerMonth);
        f.add(new JLabel("Day"));
        f.add(spinnerDay);

        f.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.black),
                "Date",
                TitledBorder.CENTER,
                TitledBorder.CENTER,
                new Font("Times New Roman", Font.BOLD, 20),
                Color.BLACK));
        
        frame.setPreferredSize(new Dimension(400, 80));
        frame.setUndecorated(true);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocation(new Point(GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint()));
       /* Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
        System.out.println(dim.width/2-frame.getSize().width/2);
        System.out.println(dim.height/2-frame.getSize().height/2);*/
    }

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
                mainFrame.refresh();
                mainFrame.getFrame().setVisible(true);
            }
        });
        frame.add(f);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    public void changeTime(final ProjectJPanels panel) {
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
                panel.refreshData();
            }
        });
        frame.add(f);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

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
