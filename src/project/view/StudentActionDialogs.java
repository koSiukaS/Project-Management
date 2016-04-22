package project.view;

import project.model.Student;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class StudentActionDialogs {

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
}
