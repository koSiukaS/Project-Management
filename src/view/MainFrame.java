package view;

import model.UniversityProject;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;

public class MainFrame {

    private JFrame frame = new JFrame("Project Management");
    private ArrayList<UniversityProject> universityProjects = new ArrayList<>();

    public MainFrame(ArrayList<UniversityProject> universityProjects) {
        this.universityProjects = universityProjects;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void showMainFrame() {
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(860, 500);
        frame.setResizable(false);

        JPanel east = showProjectButtons();
        JPanel center = showProjectsList();

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
        frame.add(east, BorderLayout.EAST);
        frame.add(center);
        frame.setVisible(false);
    }

    private JPanel showProjectsList() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));

        JPanel intermediatePanel = new JPanel();
        intermediatePanel.setLayout(new BoxLayout(intermediatePanel, BoxLayout.PAGE_AXIS));
        System.out.println(universityProjects.size());
        for(int i = 0; i < universityProjects.size(); i++) {
            intermediatePanel.add(new ProjectWindow().createProjectPanel(universityProjects.get(i)));
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

    private JPanel showProjectButtons() {
        JPanel projectButtons = new ProjectWindow().createProjectButtons();

        JPanel east = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.weighty = 1;
        east.add(projectButtons, gbc);
        east.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.black),
                "Menu",
                TitledBorder.LEADING,
                TitledBorder.CENTER,
                new Font("Times New Roman", Font.BOLD, 20),
                Color.BLACK));

        return east;
    }

}
