package project.model;

import project.ProgramDate;

public class Task {

    private String name;
    private String description;
    private int status = 0;
    private int deadlineYear, deadlineMonth, deadlineDay;
    private boolean wasTaskEdited = false;

    public void checkStatus(ProgramDate date) {
        int programYear = date.getProgramYear();
        int programMonth = date.getProgramMonth();
        int programDay = date.getProgramDay();

        if(!wasTaskEdited) {
            if(programYear > deadlineYear) {
                setStatus(-1);
            } else if(programYear == deadlineYear && programMonth > deadlineMonth) {
                setStatus(-1);
            } else if(programYear == deadlineYear && programMonth == deadlineMonth && programDay > deadlineDay) {
                setStatus(-1);
            }
        }
    }

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

    public String getStatus() {
        if(status == 0) {
            return "In progress";
        }
        else if(status == 1) {
            return "Finished";
        }
        else {
            return "Failed";
        }
    }

    public void setStatus(int status) {
        this.status = status;
        wasTaskEdited = true;
    }

    public int getDeadlineYear() {
        return deadlineYear;
    }

    public void setDeadlineYear(int deadlineYear) {
        this.deadlineYear = deadlineYear;
    }

    public int getDeadlineMonth() {
        return deadlineMonth;
    }

    public void setDeadlineMonth(int deadlineMonth) {
        this.deadlineMonth = deadlineMonth;
    }

    public int getDeadlineDay() {
        return deadlineDay;
    }

    public void setDeadlineDay(int deadlineDay) {
        this.deadlineDay = deadlineDay;
    }
}
