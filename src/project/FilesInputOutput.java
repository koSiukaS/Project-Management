package project;

import project.model.Student;
import project.model.Task;
import project.model.UniversityProject;
import project.view.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FilesInputOutput {

    /**
     * Method gets file names, reads information from each file
     * and puts that information into certain objects
     *
     * @return  ArrayList of all university projects
     * @throws IOException
     */
    public ArrayList<UniversityProject> readFiles() throws IOException{
        File directory = new File("./src/project/university/");
        File[] allFiles = directory.listFiles();
        String[] fileNames = new String[allFiles.length];
        for(int i = 0; i < allFiles.length; i++) {
            fileNames[i] = allFiles[i].getName();
        }

        int[] date;
        ArrayList<UniversityProject> projects = new ArrayList<>();
        for(int i = 0; i < fileNames.length; i++) {
            UniversityProject project = new UniversityProject();

            Student student = new Student();
            boolean firstStudent = true;

            File projectTxtFile = new File(String.format("./src/project/university/%s", fileNames[i]));
            Scanner in = new Scanner(new FileReader(projectTxtFile));
            while(in.hasNextLine()) {
                String line = in.nextLine();
                switch (line) {
                    case "":
                        break;
                    case "@":
                        if(!firstStudent) {
                            project.addStudent(student);
                            student = new Student();
                        }
                        student.setFirstName(in.nextLine());
                        student.setLastName(in.nextLine());
                        student.setPosition(in.nextLine());
                        date = stringDateToIntArray(in.nextLine());
                        student.setBirthYear(date[0]);
                        student.setBirthMonth(date[1]);
                        student.setBirthDay(date[2]);
                        student.setId(in.nextLine());
                        student.setCourseName(in.nextLine());
                        student.setGroup(Integer.parseInt(in.nextLine()));
                        date = stringDateToIntArray(in.nextLine());
                        student.setCourseStartYear(date[0]);
                        student.setCourseStartMonth(date[1]);
                        student.setCourseStartDay(date[2]);
                        date = stringDateToIntArray(in.nextLine());
                        student.setCourseEndYear(date[0]);
                        student.setCourseEndMonth(date[1]);
                        student.setCourseEndDay(date[2]);
                        firstStudent = false;
                        break;
                    case "#":
                        Task task = new Task();
                        task.setName(in.nextLine());
                        task.setDescription(in.nextLine());
                        date = stringDateToIntArray(in.nextLine());
                        task.setDeadlineYear(date[0]);
                        task.setDeadlineMonth(date[1]);
                        task.setDeadlineDay(date[2]);;
                        student.addTask(task);
                        break;
                    default:
                        project.setName(line);
                        project.setDescription(in.nextLine());
                        project.setSupervisor(in.nextLine());
                        break;
                }
            }
            if(!firstStudent) {
                project.addStudent(student);
            }
            projects.add(project);
            in.close();
        }

        return projects;
    }

    private void writeFiles(ArrayList<UniversityProject> projects) throws IOException{
        File directory = new File("./src/project/university/");
        File[] allFiles = directory.listFiles();

        for(int i = 0; i < allFiles.length; i++) {
            allFiles[i].delete();
        }

        for(int i = 0; i < projects.size(); i++) {
            File file = new File(String.format("./src/project/university/project%d.txt", i));
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));

            writer.write(projects.get(i).getName() + "\n");
            writer.write(projects.get(i).getDescription() + "\n");
            writer.write(projects.get(i).getSupervisor() + "\n");

            ArrayList<Student> students = projects.get(i).getStudents();

            for(int j = 0; j < students.size(); j++) {
                writer.write("@\n");
                writer.write(students.get(j).getFirstName() + "\n");
                writer.write(students.get(j).getLastName() + "\n");
                writer.write(students.get(j).getPosition() + "\n");
                writer.write(String.format("%d %s %s\n", students.get(j).getBirthYear(), checkDate(students.get(j).getBirthMonth()), checkDate(students.get(j).getBirthDay())));
                writer.write(students.get(j).getId() + "\n");
                writer.write(students.get(j).getCourseName() + "\n");
                writer.write(students.get(j).getGroup() + "\n");
                writer.write(String.format("%d %s %s\n", students.get(j).getCourseStartYear(), checkDate(students.get(j).getCourseStartMonth()), checkDate(students.get(j).getCourseStartDay())));
                writer.write(String.format("%d %s %s\n", students.get(j).getCourseEndYear(), checkDate(students.get(j).getCourseEndMonth()), checkDate(students.get(j).getCourseEndDay())));

                ArrayList<Task> tasks = students.get(j).getTasks();
                for(int k = 0; k < tasks.size(); k++) {
                    writer.write("#\n");
                    writer.write(tasks.get(k).getName() + "\n");
                    writer.write(tasks.get(k).getDescription() + "\n");
                    writer.write(String.format("%d %s %s\n", tasks.get(k).getDeadlineYear(), checkDate(tasks.get(k).getDeadlineMonth()), checkDate(tasks.get(k).getDeadlineDay())));
                }
            }
            writer.close();
        }
    }

    /**
     * Gets a single line of date and converts it into int[] array
     *
     * @param dateLine  line of a date in this format "YYYY MM DD"
     * @return          int[0] = year;<br>
     *                  int[1] = month;<br>
     *                  int[2] = day;<br>
     */
    private int[] stringDateToIntArray(String dateLine) {
        int[] date = new int[3];
        date[0] = Integer.parseInt(dateLine.substring(0, 4));
        date[1] = Integer.parseInt(dateLine.substring(5, 7));
        date[2] = Integer.parseInt(dateLine.substring(8, 10));
        return date;
    }

    private String checkDate(int date) {
        if(date > 9) {
            return String.valueOf(date);
        }
        else {
            return ("0" + String.valueOf(date));
        }
    }

    public void createAndShowExit(final MainFrame frame) {
        JDialog dialog = new JDialog();
        dialog.setSize(300, 140);
        dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        dialog.setTitle("Just before you exit...");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        dialog.setLocation(dim.width/2-dialog.getSize().width/2, dim.height/2-dialog.getSize().height/2);

        JPanel panel = new JPanel();
        SpringLayout layout = new SpringLayout();
        panel.setLayout(layout);

        JLabel question = new JLabel("Would you like to save changes?");
        question.setFont(new Font("Times New Roman", Font.BOLD, 18));
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, question, 0, SpringLayout.HORIZONTAL_CENTER, panel);
        layout.putConstraint(SpringLayout.NORTH, question, 10, SpringLayout.NORTH, panel);

        JButton yesButton = new JButton("Yes");
        yesButton.setPreferredSize(new Dimension(60, 30));
        yesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    writeFiles(frame.getUniversityProjects());
                } catch (IOException event) {
                    System.err.println("Couldn't write files");
                }
                System.exit(0);
            }
        });
        layout.putConstraint(SpringLayout.NORTH, yesButton, 40, SpringLayout.NORTH, question);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, yesButton, -35, SpringLayout.HORIZONTAL_CENTER, panel);

        JButton noButton = new JButton("No");
        noButton.setPreferredSize(new Dimension(60, 30));
        noButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        layout.putConstraint(SpringLayout.NORTH, noButton, 40, SpringLayout.NORTH, question);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, noButton, 35, SpringLayout.HORIZONTAL_CENTER, panel);

        panel.add(question);
        panel.add(yesButton);
        panel.add(noButton);

        dialog.add(panel);
        dialog.setLocationRelativeTo(null);
        dialog.setResizable(false);
        dialog.setModal(true);
        dialog.setVisible(true);
    }
}
