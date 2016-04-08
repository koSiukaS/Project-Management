package view;

import model.UniversityProject;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainFrame {

    private JFrame frame = new JFrame("Project Management");
    private ArrayList<UniversityProject> universityProjects = new ArrayList<>();
    private ProgramDate date;

    public MainFrame(ArrayList<UniversityProject> universityProjects, ProgramDate date) {
        this.universityProjects = universityProjects;
        this.date = date;
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(860, 500);
        frame.setResizable(false);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
    }

    public JFrame getFrame() {
        return frame;
    }

    public void showMainFrame() {
        JPanel east = showMenu(new ProjectsWindow().createProjectButtons());
        JPanel center = showProjectsList();//new ProjectWindow().createAndShowFullProjectPanel(universityProjects.get(3));

        frame.add(east, BorderLayout.EAST);
        frame.add(center);
        frame.setVisible(false);
    }

    private JPanel showProjectsList() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));

        JPanel intermediatePanel = new JPanel();
        intermediatePanel.setLayout(new BoxLayout(intermediatePanel, BoxLayout.PAGE_AXIS));
        for(int i = 0; i < universityProjects.size(); i++) {
            intermediatePanel.add(new ProjectsWindow().createProjectPanel(universityProjects.get(i), frame));
            intermediatePanel.add(new JSeparator(SwingConstants.HORIZONTAL));
        }

        JScrollPane scrollPane = new JScrollPane(intermediatePanel);
        //scrollPane.setPreferredSize(new Dimension(715, 450));
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.black));

        JPanel namePanel = new JPanel();
        namePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel nameLabel = new JLabel("Projects", SwingConstants.LEFT);
        nameLabel.setFont(new Font("Times New Roman", Font.BOLD, 35));
        namePanel.add(nameLabel);

        mainPanel.add(namePanel);
        mainPanel.add(scrollPane);
        return mainPanel;
    }

    private JPanel showMenu(JPanel panel) {
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.weighty = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(panel, gbc);
        mainPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.black),
                "Menu",
                TitledBorder.LEADING,
                TitledBorder.CENTER,
                new Font("Times New Roman", Font.BOLD, 20),
                Color.BLACK));
        gbc.gridy++;
        gbc.insets = new Insets(250, 0, 0, 0);
        mainPanel.add(showTime(), gbc);
        return mainPanel;
    }

    private JPanel showTime() {
        JPanel panel = new JPanel(new GridLayout(3, 1, 0, 0));
        JButton button = new JButton("Change date");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                date.time(frame);
                System.out.println(String.format("old date: %d/%d/%d", date.getProgramYear(), date.getProgramMonth(), date.getProgramDay()));
            }
        });
        panel.add(new JLabel("Date:"));
        panel.add(new JLabel(String.format("%d/%d/%d", date.getProgramYear(), date.getProgramMonth(), date.getProgramDay())));
        panel.add(button);
        return panel;
    }
}
