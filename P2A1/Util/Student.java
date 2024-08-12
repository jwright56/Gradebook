package Util;// This class is used to store and retrieve student information such as the student's first name, last name, and ID.


public class Student
{
    private String firstName;
    private String lastName;
    private int pid;
    private Grade grade; // grade variable of type Grade is declared.

    // Constructor used to initialize student information.
    public Student (String firstName, String lastName, int pid, Grade grade)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pid = pid;
        this.grade = grade;
    }

    // Below are getters and setters for the private variables/fields above.
    public String getFirstName()
    {
        return firstName;
    }
    public String getLastName()
    {
        return lastName;
    }
    public int getPid()
    {
        return pid;
    }
    public Grade getGrade()
    {
        return grade;
    }
    public void setGrade (Grade grade)
    {
        this.grade = grade;
    }
}
