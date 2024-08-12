package Util;

/* This class creates an ArrayList called student and stores students information. It also contains multiple methods to calculate the average, median, max letter grade,
min letter grade, max score, and min score. Additional methods allow the program to print the letter-grade and the full name of the student given the PID. Another method
allows the user to find and update the grade of the student given the PID.
 */

import java.util.*;

public class Gradebook
{
    // Declare a new  private arrayList of type Student
    private ArrayList<Student> listOfStudents;

    // Create a new ArrayList of type Student using Gradebook constructor. ArrayList will be used to store students information. ArrayList called listOfStudents.
    public Gradebook()
    {
        listOfStudents = new ArrayList<Student>();
    }

    /* Method used to add a Student object to the ArrayList listOfStudents. listOfStudents is an ArrayList of type Student.
       After calling this method, the listOfStudents ArrayList will have the newly added student.
     */
    public void addStudent (Student student)
    {
        listOfStudents.add(student);
    }

    /* This method calculates the average for each student in the ArrayList. A double accumulator variable called sum is created and set to zero.
       An enhanced for loop is used to go through the listOfStudents ArrayList. Variable s is of type Student and is used to reference each Student
       object during each iteration. s.getGrade() - this statement uses the getGrade() method from the Student class. This method returns a field called
       grade of type Grade. s.getGrade().getScore() - after getGrade() method is called, then getScore() is called.  getScore() method is part of the grade
       class and returns an integer value called score. After scores are summed up, they are divided by the number of students in the ArrayList.
     */
    public double calculateAvg()
    {
        double sum = 0;
        for(Student s: listOfStudents)
            sum += s.getGrade().getScore();
        return sum / listOfStudents.size();
    }

    /* This method is used to return the average letter grade. A new double variable called avg is created and assigned the value from the calculateAvg() method.
       A new grade object is created and the avg variable is cast to an integer. The getLetterGrade() method is called on the new Grade object to get the the letter grade associated with the score.
     */
    public String calculateAvgLetter()
    {
        double avg = calculateAvg();
        return new Grade((int) avg).getLetterGrade();
    }

    /* This method calculates the median for the list of scores. An integer called i is initialized to zero - this will be used as the index in the array.
       An integer called n is declared the same size of the ArrayList. A new 1D array called scores is created with size n. An enhanced for-loop is used to go
       through the ArrayList - the scores for each student are saved in the 1D array. The scores are then sorted into ascending order using the Arrays.sort() method -
       this method is part of the built-in Arrays class.
     */
    public float calculateMedian()
    {
        int i = 0, n = listOfStudents.size();
        int[] scores = new int[n];
        for(Student s: listOfStudents)
            scores[i++] = s.getGrade().getScore();
        Arrays.sort(scores);
        if (n % 2 == 0)
            return (scores[n / 2] + scores[n / 2 - 1]) / 2.0f; // For even-sized array
        else
            return scores[n / 2]; // For odd-sized array
    }

    /* This method is used to calculate the median letter grade. A new float variable called median is created and assigned the value returned from the calculateMedian() method.
        A new grade object is created and the median variable is cast to an integer. The getLetterGrade() method is called on the new Grade object to get the the letter grade associated with the score.
     */
    public String calculateMedianLetter()
    {
        float median = calculateMedian();
        return new Grade((int) median).getLetterGrade();
    }

    /* This method is used to get the minimum score from the list of students. First, an int variable called minScore is created. It is assigned to the following: the getGrade() method is called
       on the first element in the listOfStudents ArrayList. This returns a grade object. The getScore() method is then called - this returns an integer value called score. An enhanced for-loop
       is used to iterate through the lists of students. A new int variable called currentScore is created which holds the score of the student in the ArrayList. An if statement is used that updates
       minScore with currentScore if currentScore is less than minScore. After going through all students in the ArrayList, the minScore is returned.
     */
    public int getMinScore()
    {
        int minScore = listOfStudents.get(0).getGrade().getScore();
        for (Student student : listOfStudents) {
            int currentScore = student.getGrade().getScore();
            if (currentScore < minScore)
            {
                minScore = currentScore;
            }
        }
        return minScore;
    }

    /* This method is used to get the minimum letter grade. An int variable called minScore is created and assigned a value from the getMinScore() method. A new Grade object is created
       using the constructor - minScore is passed as a parameter. getLetterGrade() method is then called for this object and a String with the letter grade is returned.
     */
    public String getMinLetterGrade()
    {
        int minScore = getMinScore();
        return new Grade(minScore).getLetterGrade();
    }

    /* This method is used to get the maximum score from the list of students. First, an int variable called minScore is created. It is assigned to the following: the getGrade() method is called
       on the first element in the listOfStudents ArrayList. This returns a grade object. The getScore() method is then called - this returns an integer value called score. An enhanced for-loop
       is used to iterate through the lists of students. A new int variable called currentScore is created which holds the score of the student in the ArrayList. An if statement is used that updates
       minScore with currentScore if currentScore is greater than minScore. After going through all students in the ArrayList, the maxScore is returned.
     */
    public int getMaxScore()
    {
        int maxScore = listOfStudents.get(0).getGrade().getScore();
        for (Student student : listOfStudents)
        {
            int currentScore = student.getGrade().getScore();
            if (currentScore > maxScore)
            {
                maxScore = currentScore;
            }
        }
        return maxScore;
    }

    /* This method is used to get the maximum letter grade. An int variable called maxScore is created and assigned a value from the getMaxScore() method. A new Grade object is created
       using the constructor - maxScore is passed as a parameter. getLetterGrade() method is then called for this object and a String with the letter grade is returned.
     */
    public String getMaxLetterGrade()
    {
        int maxScore = getMaxScore();
        return new Grade(maxScore).getLetterGrade();
    }

    /* This method is used to return the letter grade given the Student's PID. An enhanced for loop is used to iterate through the ArrayList called listOfStudents. The getPID() method is called.
       If PID returned from the method is equal to the PID entered by the user, the letter grade for that student is returned. If not, "Student not found!" is returned.
     */
    public String getLetterByPID(int pid)
    {
        for (Student student : listOfStudents)
        {
            if (student.getPid() == pid)
            {
                return student.getGrade().getLetterGrade();
            }
        }
        return "Student not found!";
    }

    /* This method is used to return the first and last name given the Student's PID. An enhanced for loop is used to iterate through the ArrayList called listOfStudents. The getPID() method is called.
       If PID returned from the method is equal to the PID entered by the user, the first and last name for that student is returned. If not, "Student not found!" is returned.
     */
    public String getNameByPID(int pid)
    {
        for (Student student : listOfStudents)
        {
            if (student.getPid() == pid)
            {
                return student.getFirstName() + " " + student.getLastName();
            }
        }
        return "Student not found!";
    }

    /* This method is used to change the grade of a student given a PID and a new grade. An enhanced for loop is used to iterate through the ArrayList called listOfStudents. The getPID() method is called.
        If PID returned from the method is equal to the PID entered by the user, the setGrade method is called for that particular student in the ArrayList. A new Grade object is created with the parametric
        variable newGrade and this object is then itself passed in the setGrade method. Nothing is returned due to void method type. If PID returned from the getPID() method is not equal to PID entered
        by the user, "Student not found!" is returned.
     */
    public void changeGradeByPID(int pid, int newGrade)
    {
        for (Student student : listOfStudents)
        {
            if (student.getPid() == pid)
            {
                student.setGrade(new Grade(newGrade));
                return;
            }
        }
        System.out.println("Student not found!");
    }

    /* Method to print all students with their scores. In addition, the first name, last name, and pid are displayed. An enhanced for-loop is used
       to iterate through the ArrayList listOfStudents
     */
    public void printAllStudents()
    {
        for(Student s: listOfStudents)
            System.out.printf("%s\t%s\t%d\t%d\n", s.getFirstName(), s.getLastName(), s.getPid(), s.getGrade().getScore());
    }

    /* Method to print all students with their letter grades. In addition, the first name, last name, and pid are displayed. An enhanced for-loop is used
       to iterate through the ArrayList listOfStudents
     */
    public void printAllStudentsLetters()
    {
        System.out.println("First Name\tLast Name\tPID\tLetter Grade");
        for (Student s : listOfStudents)
        {
            System.out.printf("%s\t%s\t%d\t%s\n", s.getFirstName(), s.getLastName(), s.getPid(), s.getGrade().getLetterGrade());
        }
    }
}
