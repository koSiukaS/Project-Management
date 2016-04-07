package model;

public class Student extends Member {
    private int courseStartYear, courseStartMonth, courseStartDay;
    private int group;
    private int course;
    private String courseName;

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
