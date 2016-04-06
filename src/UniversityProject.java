import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class UniversityProject extends Project {

    ArrayList<Student> students = new ArrayList<>();

    public ArrayList<Student> getStudent() {
        return students;
    }

    public void setStudent(ArrayList<Student> student) {
        this.students = student;
    }

    public int getStudentsCount() {
        return students.size();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(int index) {
        students.remove(index);
    }

    public UniversityProject getStartingInput1() {
        UniversityProject firstProject = new UniversityProject();
        firstProject.setName("BLOG site");
        firstProject.setDescription("Individuals or their groups can have their blogs. Blog messages are represented by showing the newest material at the top, old messages are in archives (special catalogues). Blog messages (or diary blocks) can contain text and pictures. Readers can leave comments and get answers. All users are registered, thus, the system should be able to show a list of blogs, the content of a particular blog, expand the comments, enable conversations, and search on different criteria, e.g. user name, date, some keyword (phrase).");
        firstProject.setSupervisor("M. Ellis");
        Student student1 = new Student();
        student1.setFirstName("Richard");
        student1.setLastName("Gates");
        student1.setPosition("Web Developer");
        firstProject.addStudent(student1);
        return firstProject;
    }

    public UniversityProject getStartingInput2() {
        UniversityProject secondProject = new UniversityProject();
        secondProject.setName("Version Control System");
        secondProject.setDescription("Common reports and programs or information blocks are modified by several users as the latest version of any material should be accessible for all project (group) members. The system should be able to show the last version and all the previous versions, and to recover to some previous version if the last version is broken. The system should show what was changed in each version, who made the modification, who worked and committed most frequently.");
        secondProject.setSupervisor("S. Miller");
        /* will add more*/
        return secondProject;
    }

    public UniversityProject getStartingInput3() {
        UniversityProject thirdProject = new UniversityProject();
        thirdProject.setName("E-Shop of Clothes and Accessories");
        thirdProject.setDescription("Some brands have shops in the shopping centers and e-shops. Thus, things can be bought online using cards and at the shop using cash. Also, the number of clothes and accessories is limited. If someone buys a pair of trousers of some type and size, it might be that another person would not get it. But the system should inform where to search for the necessary thing, another shop, another city, etc. Clothes have a lot of properties, e.g. size, color, type, model. If the use does not get what is needed the system should suggest to try another model of the same size (if this particle is at the shop, of course).");
        thirdProject.setSupervisor("C. McGregor");
        return thirdProject;
    }

    public JPanel showProject(UniversityProject project) {
        JPanel panel = new JPanel();

        JLabel nameLabel = new JLabel();
        nameLabel.setText(project.getName().toUpperCase());
        nameLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));

        JLabel descriptionLabel = new JLabel();
        String shortDescription = project.getDescription().substring(0, 100) + "...";
        descriptionLabel.setText(shortDescription);

        JLabel supervisorLabel = new JLabel();
        String supervisor = "Supervisor: " + project.getSupervisor();
        supervisorLabel.setText(supervisor);

        JLabel membersLabel = new JLabel();
        String members = "Students count: " + project.getStudentsCount();
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

    public JPanel showProjectButtons() {
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
