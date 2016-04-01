import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class MainFrame {

    private JFrame frame = new JFrame("Project Management");

    public JFrame getFrame() {
        return frame;
    }

    public void showMainFrame() {
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(860, 500);
        frame.setResizable(false);

        /**
         * menu and it's buttons
         */
        JPanel east = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.weighty = 1;
        east.add(showProjectButtons(), gbc);
        east.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.black),
                "Menu",
                TitledBorder.LEADING,
                TitledBorder.CENTER,
                new Font("Times New Roman", Font.BOLD, 20),
                Color.BLACK));

        /**
         * panel in which data will be shown
         */
        JPanel center = new JPanel();

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
        frame.add(east, BorderLayout.EAST);
        //frame.add(center);
        //frame.pack();
        frame.setVisible(false);
    }

    private JPanel showProjects(Project project) {
        JPanel panel = new JPanel();

        JLabel nameLabel = new JLabel();
        //nameLabel.setText(project.getName().toUpperCase());
        nameLabel.setText("nameLabel tekstas");
        nameLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));

        JLabel descriptionLabel = new JLabel();
        //String shortDescription = project.getDescription().substring(0, 100) + "...";
        String shortDescription = "dasdasfasfasfkjfkfkfhfakkfajafkjjjjjjjjjjjjjjjjjddskhhhhhhhhhhhhhhhhhhhhhh";
        descriptionLabel.setText(shortDescription);

        JLabel supervisorLabel = new JLabel();
        String supervisor = "Supervisor: ";// + project.getSupervisor();
        supervisorLabel.setText(supervisor);

        JLabel membersLabel = new JLabel();
        String members = "Members count: " + "5";//project.getMembersCount();
        membersLabel.setText(members);

        JButton detailsButton = new JButton("Details");

        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        panel.setSize(500, 100);
        layout.setAutoCreateContainerGaps(true);
        layout.setAutoCreateGaps(true);
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(nameLabel)
                .addComponent(descriptionLabel)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(supervisorLabel)
                        .addComponent(detailsButton))
                .addComponent(membersLabel)
        );
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(nameLabel)
                        .addComponent(descriptionLabel)
                        .addComponent(supervisorLabel)
                        .addComponent(membersLabel))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(detailsButton))
        );

        return panel;
    }

    private JPanel showProjectButtons() {
        JPanel buttonPanel = new JPanel(new GridLayout(3, 1, 0, 3));
        JButton addProject = new JButton("Add project");
        JButton editProject = new JButton("Edit project");
        JButton removeProject = new JButton("Remove project");
        buttonPanel.add(addProject);
        buttonPanel.add(editProject);
        buttonPanel.add(removeProject);
        return buttonPanel;
    }
}
