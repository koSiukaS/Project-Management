package project.model;

import project.ProgramDate;

import java.util.ArrayList;

public class Student {

    private String firstName;
    private String lastName;
    private String position;
    private int birthYear, birthMonth, birthDay;
    private String id;
    private ArrayList<Task> tasks = new ArrayList<>();
    private int courseStartYear, courseStartMonth, courseStartDay;
    private int courseEndYear, courseEndMonth, courseEndDay;
    private int group;
    private int course;
    private String courseName;

    public String countCourseYears(ProgramDate date) {
        int years;
        int programYear = date.getProgramYear();
        int programMonth = date.getProgramMonth();
        int programDay = date.getProgramDay();
        if(programYear < courseStartYear) {
            return "Not yet attending";
        } else if(programYear > courseEndYear || (programYear == courseEndYear && programMonth > courseEndMonth) || (programYear == courseEndYear && programMonth == courseEndMonth && programDay >= courseEndDay)) {
            return "Finished";
        } else {
            years = programYear - courseStartYear;
            if(programMonth < 9 && years == 0) {
                return "Not yet attending";
            } else if(programMonth < 9){
                years--;
            }
            return String.valueOf(years + 1);
        }
    }
    
    public void setCourseStartDay(int courseStartDay) {
        this.courseStartDay = courseStartDay;
    }

    public String getCourseName(){
	return courseName;
    }
	
    public void setCourseName(String name){
	courseName = name;
    }
    
    public int getCourseStartYear(){
        return courseStartYear;
    }
    
    public void setCourseStartYear(int year){
        courseStartYear = year;
    }
    
    public int getCourseStartMonth(){
        return courseStartMonth;
    }
    
    public void setCourseStartMonth(int month){
        courseStartMonth = month;
    }
    
    public int getCourseStartDay(){
        return courseStartDay;
    }

    public int getCourseEndYear() {
        return courseEndYear;
    }

    public void setCourseEndYear(int courseEndYear) {
        this.courseEndYear = courseEndYear;
    }

    public int getCourseEndMonth() {
        return courseEndMonth;
    }

    public void setCourseEndMonth(int courseEndMonth) {
        this.courseEndMonth = courseEndMonth;
    }

    public int getCourseEndDay() {
        return courseEndDay;
    }

    public void setCourseEndDay(int courseEndDay) {
        this.courseEndDay = courseEndDay;
    }

    public void setDay(int day){
        courseStartDay = day;
    }
    
    public int getGroup(){
        return group;
    }
    
    public void setGroup(int group){
        this.group = group;
    }
    
    public int getCourse(){
        return course;
    }
    
    public void setCourse(int course){
        this.course = course;
    }

    public void markFailedTasks(ProgramDate date) {
        for(Task task : tasks) {
            task.checkStatus(date);
        }
    }

    public int countFinishedTasks() {
        int number = 0;
        for(Task task : tasks) {
            if(task.getStatus().equals("Finished")) {
                number++;
            }
        }
        return number;
    }

    public int countPendingTasks() {
        int number = 0;
        for(Task task : tasks) {
            if(task.getStatus().equals("In progress")) {
                number++;
            }
        }
        return number;
    }

    public int countFailedTasks() {
        int number = 0;
        for(Task task : tasks) {
            if(task.getStatus().equals("Failed")) {
                number++;
            }
        }
        return number;
    }

    /**
     * Calculates age
     *
     * @param date  current program date
     * @return      member's age or "Unborn" if program's date is lower than member's birth date
     */
    public String countYears(ProgramDate date) {
        int years;
        int programYear = date.getProgramYear();
        int programMonth = date.getProgramMonth();
        int programDay = date.getProgramDay();
        if(programYear < birthYear) {
            return "Unborn";
        } else {
            years = programYear - birthYear;
            if(programMonth - birthMonth >= 0) {
                if(programDay - birthDay < 0) {
                    years--;
                }
            } else {
                years--;
            }
            return String.valueOf(years);
        }
    }

    public String getFirstNameLetterAndLastName() {
        return (firstName.charAt(0) + ". " + lastName);
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public int getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(int birthMonth) {
        this.birthMonth = birthMonth;
    }

    public int getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(int birthDay) {
        this.birthDay = birthDay;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void addTask(Task task){
        tasks.add(task);
    }

    public void removeTask(int task){
        tasks.remove(task);
    }
}
