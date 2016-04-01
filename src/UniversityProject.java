import java.util.ArrayList;

public class UniversityProject extends Project {

    ArrayList<Student> student = new ArrayList<>();

    public ArrayList<Student> getStudent() {
        return student;
    }

    public void setStudent(ArrayList<Student> student) {
        this.student = student;
    }
}
