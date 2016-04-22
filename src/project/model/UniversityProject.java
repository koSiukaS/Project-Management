package project.model;

import java.util.ArrayList;

public class UniversityProject {

    private String name;
    private String description;
    private String supervisor;
    private ArrayList<Student> students = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
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
}
