package model;

import view.ProgramDate;

import java.util.*;

public class Member {

    private String firstName;
    private String lastName;
    private String position;
    private int birthYear, birthMonth, birthDay;
    private String id;
    private ArrayList<Task> tasks = new ArrayList<Task>();

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
