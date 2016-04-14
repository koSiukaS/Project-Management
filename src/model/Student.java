package model;

import view.ProgramDate;

public class Student extends Member {
    private int courseStartYear, courseStartMonth, courseStartDay;
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
        } else {
            years = programYear - courseStartYear + 1;
            if(programMonth - courseStartMonth >= 0) {
                if(programDay - courseStartDay < 0) {
                    years--;
                }
            } else {
                years--;
            }
            return String.valueOf(years);
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
}
