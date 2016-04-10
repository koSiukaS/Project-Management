package model;

import java.util.ArrayList;

public class UniversityProject extends Project {

    private ArrayList<Student> students = new ArrayList<>();

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
