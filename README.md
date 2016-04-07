# model.Project-Management
model.Task: During any project (student or enterprise) activities are planned and tracked in order to evaluate the effectiveness of the work. Each project member gets tasks and also plans own tasks, predicts the time to finish the task, and notifies about the status of the task at some points.   The system should present all projects of the company (student group), present the timeline, tasks and their status of one project, and show effectiveness of the particular project member.


I will update this list everyday, will add what is done by everyone, what is needed to be done.
After you make your tasks, just pull request to this github repo.
## To do for 04-01 (Friday):
###### Žygis:
* GUI concept (Main.java) - continuing work

=====
###### Dainius:
* model.Project.java:
 * showAddMember method (GUI):
    * it should have every member variable field
    * on "add" button adds it to model.Project object
* Make input data (model.Project names, tasks, student first, last names, birth dates, etc.) in .xls/.csv different sheets (tons of data)

=====
###### Aivaras:
* model.Member.java:
 * showAddTask method (GUI):
    * textField name
    * textField description
    * deadline data (similiar to model.Time.java style)
    * save/add button which adds model.Task to model.Member object.

# Done
###### Žygis:
* Base classes (starting project structure)
 * model.Member.java
 * model.Project.java
 * model.Task.java
 * model.Time.java
* model.Time.java GUI and functionality

=====
###### Dainius:
* model.Project.java:
 * method addMember (dynamic, so you must increase array size each time you add member or use ArrayList)
 * method deleteMember

=====
###### Aivaras:
* model.Student.java (structure)
* model.Member.java
 * method addTask
 * method deleteTask
