package project.view;

import project.model.Task;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TaskActionDialogs {

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
}
