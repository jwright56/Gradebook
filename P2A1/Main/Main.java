package Main;

import Util.Grade;
import Util.Student;
import Util.Gradebook;

import java.util.Scanner;

public class Main {

    /* The method below creates takes a String parameter and returns it as an integer. A new String array is created called parts. The parts array is split into
       an array of substrings and separated by empty whitespace. The resulting substrings are stored in the parts array. The if statement verifies that there at least
       two elements in the parts array and therefore has the correct format. A new String variable called pidString is created and set equal to parts[1]. If the length of the string
       is 7 (PID has 7 digits). The pidString is returned as an integer using the Integer.parseInt() method.
     */
    private static int parsePid(String command) {
        String[] parts = command.split(" ");
        if (parts.length >= 2) {
            String pidString = parts[1];
            if (pidString.length() == 7) {
                return Integer.parseInt(pidString);
            }
        }
        return -1; // If the parametric variable is not in the correct format, -1 is returned when this method is called.
    }

    public static void main(String[] args) {
        // Welcome message displayed - prompts user to enter the information.
        System.out.println("Welcome to my grade book!");
        System.out.println("Please enter the information of the first student using the following format:");
        System.out.println("\"firstName lastName PID grade\"");
        System.out.println("Press Enter when you are done.");

        Scanner keyboard = new Scanner(System.in); // New scanner object created for keyboard input.
        Gradebook gradebook = new Gradebook(); // New Gradebook object created. Will be used to store student information.

        String userInput = keyboard.nextLine(); // userInput variable is created to hold input from the keyboard.

        // A new string array called studentInfo is created.
        String[] studentInfo;

        // Create a boolean variable called flag and set it to true. Create a while-loop that executes as long as flag is true.
        boolean flag = true;

        // Create while-loop
        while (flag == true) {

            /* Assign the string array studentInfo the value from splitting the userInput. Array will be composed of substrings from user input
               separated by whitespace (eg. first word, first element; second word, second element...)
             */
            studentInfo = userInput.split("\\s+");


            // If there are four elements in the studentInfo array, code is executed.
            if (studentInfo.length == 4)
            {
                /* StudentInfo[0] and StudentInfo[1] hold the names of the first and last names. The if statements below
                   ensure that the names begin with a capital letter, have no whitespace characters, and have only alphabetical characters.
                 */
                if (studentInfo[0].matches("^[A-Z][a-zA-Z]*$") && studentInfo[1].matches("^[A-Z][a-zA-Z]*$"))
                {
                    String firstName = studentInfo[0];
                    String lastName = studentInfo[1];

                    int pid;
                    int grade;

                    /* StudentInfo[2] represents the student PID and studentInfo[3] represents the grade. The if statement below
                       ensures that the PID and grade contains only digits.
                     */
                    if (studentInfo[2].matches("\\d+") && studentInfo[3].matches("\\d+"))
                    {
                        pid = Integer.parseInt(studentInfo[2]);
                        grade = Integer.parseInt(studentInfo[3]);

                        if (grade >= 0 && grade <= 100 && String.valueOf(pid).length() == 7)
                        {
                            Grade studentGrade = new Grade(grade);
                            Student student = new Student(firstName, lastName, pid, studentGrade);
                            gradebook.addStudent(student);

                            System.out.println("\nPlease enter the information of the next student using the same format.");
                            System.out.println("If there are no more students, please enter the keyword \"Done\".");
                            System.out.println("Press Enter when you are done.");

                            userInput = keyboard.nextLine();
                            if (userInput.equalsIgnoreCase("Done"))
                            {
                                flag = false;
                            }
                        }
                        // Error message if grade is negative or greater than 100. Also displays if PID is not 7 digits.
                        else
                        {
                                System.out.println("Invalid input. Please enter valid data using correct format: firstName lastName PID grade. " +
                                        "Grade must be between 0 and 100 and pid must be a seven digit number.");
                                userInput = keyboard.nextLine();
                        }
                    }
                    // Error message if user enters PID and grade in an invalid format. PID and grade must be made up of only strings.
                    else
                    {
                        System.out.println("Invalid input. Please enter valid data using correct format: firstName lastName PID grade. PID and grade strings must contain only digits.");
                        userInput = keyboard.nextLine();
                    }
                }
                // Error message if user enters first and last names with an invalid format. First and last name must start with a capital letter,
                // contain only alphabetical characters, and not include any white space characters
                else
                {
                    System.out.println("Invalid input. Please enter valid data using correct format: firstName lastName PID grade. First and last name" +
                            " must start with a capital letter, contain only alphabetical characters, and not include any white space characters.");
                    userInput = keyboard.nextLine();
                }
            }
            // Error message that displays if user enters 5 strings of input or more separated by 4 or more whitespace characters.
            else
            {
                System.out.println("Invalid input. Please enter student information using the following format:");
                System.out.println("firstName lastName PID grade");
                userInput = keyboard.nextLine();
            }
        } // End of while loop

        // The code below is the program handling phase.

        // Below are command instructions for the user.
        System.out.println("\nBelow are the command instructions: \n");
        System.out.println("To display the minimum score for the students, type in \"min score\"");
        System.out.println("To display the minimum letter grade for the students, type in \"min letter\"");
        System.out.println("To display the maximum score for the students, type in \"max score\"");
        System.out.println("To display the maximum letter grade for the students, type in \"max letter\"");
        System.out.println("To display the letter grade of a student when given the pid, type in \"letter XXXXXXX\"." +
                "The Xs represent the seven digit pid the user enters.");
        System.out.println("To display the name of a student when given the pid, type in \"name XXXXXXX\"." +
                "The Xs represent the seven digit pid the user enters.");
        System.out.println("To change the grade of a student when given the pid, type in \"change XXXXXXX YY\"." +
                "The Xs represent the seven digit pid the user enters. The YY represents the new grade entered by the user.");
        System.out.println("To display the average score for all the students, type in \"average score\"");
        System.out.println("To display the average letter grade for all the students, type in \"average letter\"");
        System.out.println("To display the median score for all the students, type in \"median score\"");
        System.out.println("To display the median letter grade for all the students, type in \"median letter\"");
        System.out.println("To display a list of all the students in the form of a tab-separated table containing four columns with labels " +
                "first name, last name, pid, and score, type in \"tab scores\"");
        System.out.println("To display a list of all the students in the form of a tab-separated table containing four columns with labels " +
                "first name, last name, pid, and letter-grades, type in \"tab letters\"");
        System.out.println("To quit the program, type in \"quit\"");

        System.out.println("\nPlease enter a new command:");
        String command = keyboard.nextLine();

        // This if statement states that if the user typed in quit and assigned it to the command variable, then the program is finished. The while loop below won't execute.
        if (command.equalsIgnoreCase("quit"))
        {
            System.out.println("Exiting the program.");
        }

        // While loop executes as long as the command does not equal quit.
        while (!command.equalsIgnoreCase("quit"))
        {
            /* If statement below states that if the command starts with "letter ", then the parsePid method is called to extract the pid.
               The pid is then stored to the newly created integer variable called pid. A print statement then displays the letter grade for the specified pid.
             */
            if (command.startsWith("letter "))
            {
                int pid = parsePid(command);
                System.out.println("Letter Grade for PID " + pid + ": " + gradebook.getLetterByPID(pid));
            }

            /* Else if statement below states that if the command starts with "name ", then the parsePid method is called to extract the pid.
               The pid is then stored to the newly created integer variable called pid. A print statement then displays the full name for the specified pid.
             */
            else if (command.startsWith("name "))
            {
                int pid = parsePid(command);
                System.out.println("Full Name for PID " + pid + ": " + gradebook.getNameByPID(pid));
            }

            /* Else if statement below states that if the command starts with "change ", the user entered a command to change the grade of the student.
               A new String array called parts is created - the command is split into an array of substrings separated by whitespace. "Change" makes up
               parts[0], "XXXXXXX" (user PID) makes up parts [1], and "YY" (Letter Grade) makes up parts [2]. The first condition in the if statement checks to see if there are
               three elements in the parts array. The second checks to see if the first element in the parts array is equal "change". The third checks to see if the second element in the
               parts array has a length of 7. The fourth checks if the third element in the parts array has a length of 2. A new int variable, PID, is declared and assigned the value entered by the user
               using the Integer.parseInt() method. A new int variable called newGrade is declared and assigned the value entered by the user using the Integer.parseInt() method. The changeGradeByPID method is called
               on the gradebook object to change the grade for the student. The new grade is then displayed. If the user entered change as the first word but then entered an invalid format for the pid of new grade,
               an error message is displayed.
             */
            else if (command.startsWith("change"))
            {
                String[] parts = command.split(" ");
                if (parts.length == 3 && parts[0].equals("change") && parts[1].length() == 7 && parts[2].length() == 2)
                {
                    int pid = Integer.parseInt(parts[1].substring(0, 7));
                    int newGrade = Integer.parseInt(parts[2].substring(0, 2));
                    gradebook.changeGradeByPID(pid, newGrade);
                    System.out.println("Grade for PID " + pid + " changed to " + newGrade);
                }
                else
                {
                    System.out.println("Invalid change command format. Enter in the following format: change XXXXXXX YY. Xs represent PID and YY represent the grade you wish to input/new grade.");
                }
            }

            // Command used to retrieve average letter grade by calling the calculateAvgLetter() method.
            else if (command.equalsIgnoreCase("average letter"))
            {
                System.out.println("Average Letter Grade: " + gradebook.calculateAvgLetter());
            }

            // Command used to retrieve average letter grade by calling the calculateAvg() method.
            else if (command.equalsIgnoreCase("average score")) {
                System.out.println("Average score: " + gradebook.calculateAvg());
            }

            // Command used to retrieve median letter by calling the calculateMedianLetter() method.
            else if (command.equalsIgnoreCase("median letter")) {
                System.out.println("Median Letter Grade: " + gradebook.calculateMedianLetter());
            }

            // Command used to retrieve median score by calling the calculateMedian() method.
            else if (command.equalsIgnoreCase("median score")) {
                System.out.println("Median Score: " + gradebook.calculateMedian());
            }

            // Command used to retrieve the minimum score by calling the getMinScore() method.
            else if (command.equalsIgnoreCase("min score")) {
                System.out.println("Minimum Score: " + gradebook.getMinScore());
            }

            // Command used to retrieve the minimum letter grade by calling the getMinLetterGrade() method.
            else if (command.equalsIgnoreCase("min letter")) {
                System.out.println("Minimum Score: " + gradebook.getMinLetterGrade());
            }

            // Command used to retrieve the maximum score by calling the getMaxScore() method.
            else if (command.equalsIgnoreCase("max score")) {
                System.out.println("Minimum Score: " + gradebook.getMaxScore());
            }

            // Command used to retrieve the maximum letter grade by calling the getMaxLetterGrade() method.
            else if (command.equalsIgnoreCase("max letter"))
            {
                System.out.println("Minimum Score: " + gradebook.getMaxLetterGrade());
            }

            // Command used to print the list of all students in the form of a tab-separated table containing four columns with labels first name, last name, PID, and score.
            else if (command.equalsIgnoreCase("tab scores"))
            {
                gradebook.printAllStudents();
            }

            // Command used to the list of all students in the form of a tab separated table containing four columns with labels first name, last name, PID, and letter-grades.
            else if (command.equalsIgnoreCase("tab letters"))
            {
                gradebook.printAllStudentsLetters();
            }

            // If none of the statements above are used as the command statement, the statement below prints.
            else {
                System.out.println("Invalid command. Please enter a valid command or 'quit' to exit.");
            }

            // Statement below prompts the user to enter a new command or enter quit if the user wants to end the program. By entering quit, user will exit while loop.
            System.out.println("Please enter a new command. Enter 'quit' if you want to exit the program.");
            command = keyboard.nextLine();
        }
        // Close the keyboard to prevent leaks or unexpected behavior. Closing the scanner object at the end of the program is good practice.
        keyboard.close();

    } // End of main method

}