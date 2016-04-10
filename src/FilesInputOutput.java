import model.Student;
import model.Task;
import model.UniversityProject;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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
        File directory = new File("./src/resources/university/");
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

            File projectTxtFile = new File(String.format("./src/resources/university/%s", fileNames[i]));
            Scanner in = new Scanner(new FileReader(projectTxtFile));
            while(in.hasNextLine()) {
                String line = in.nextLine();
                switch (line) {
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
        }

        return projects;
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
}
