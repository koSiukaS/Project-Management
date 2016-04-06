import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;

public class MainFrame {

    private JFrame frame = new JFrame("Project Management");
    private ArrayList<UniversityProject> universityProjects = new ArrayList<>();

    public JFrame getFrame() {
        return frame;
    }

    private void addStartingInput() {
        UniversityProject project = new UniversityProject();
        universityProjects.add(project.getStartingInput1());
        universityProjects.add(project.getStartingInput2());
        universityProjects.add(project.getStartingInput3());
        universityProjects.add(project.getStartingInput1());
        universityProjects.add(project.getStartingInput2());
        universityProjects.add(project.getStartingInput1());
    }

    public void showMainFrame() {
        addStartingInput();
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
        east.add(universityProjects.get(0).showProjectButtons(), gbc);
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
        for(int i = 0; i < universityProjects.size(); i++) {
            center.add(universityProjects.get(i).showProject(universityProjects.get(i)));
        }

        JScrollPane scrollPane = new JScrollPane(center);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        /*scrollPane.setBounds(50, 30, 500, 400);
        //center.add(scrollPane);
        JPanel panel = new JPanel(null);
        panel.setPreferredSize(new Dimension(500, 400));
        panel.add(scrollPane);*/

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
        frame.add(east, BorderLayout.EAST);
        frame.add(center);
        //frame.pack();
        frame.setVisible(false);
    }

}
