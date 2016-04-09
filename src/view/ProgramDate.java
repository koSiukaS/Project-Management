package view;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class ProgramDate {

    /**
     * Today's date chosen as initial date
     */
    private int programYear;
    private int programMonth;
    private int programDay;
    private String inYear = Integer.toString(Calendar.getInstance().get(Calendar.YEAR));
    private String inMonth = Integer.toString(Calendar.getInstance().get(Calendar.MONTH) + 1);
    private String inDay = Integer.toString(Calendar.getInstance().get(Calendar.DAY_OF_MONTH));

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
        JLabel year = new JLabel("Year");
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
        });

        f.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.black),
                "Date",
                TitledBorder.CENTER,
                TitledBorder.CENTER,
                new Font("Times New Roman", Font.BOLD, 20),
                Color.BLACK));

        frame.setUndecorated(true);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
        System.out.println(dim.width/2-frame.getSize().width/2);
        System.out.println(dim.height/2-frame.getSize().height/2);
    }

    public void changeTime(final MainFrame mainFrame) {
        createChangeTimeGUI();
        f.add(save);
        removeSaveActionListener(save);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setProgramYear(Integer.parseInt(inYear));
                setProgramMonth(Integer.parseInt(inMonth));
                setProgramDay(Integer.parseInt(inDay));
                frame.dispose();
                mainFrame.refresh();
                mainFrame.getFrame().setVisible(true);
            }
        });
        frame.add(f);
        frame.pack();
        frame.setVisible(true);
    }

    public void changeTime(final ProjectJPanels panel) {
        createChangeTimeGUI();
        f.add(save);
        removeSaveActionListener(save);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setProgramYear(Integer.parseInt(inYear));
                setProgramMonth(Integer.parseInt(inMonth));
                setProgramDay(Integer.parseInt(inDay));
                frame.dispose();
                panel.refreshData();
            }
        });
        frame.add(f);
        frame.pack();
        frame.setVisible(true);
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
