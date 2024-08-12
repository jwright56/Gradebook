package Util;
/* This class is used to get/set an integer called score. It is also used to retrieve the letter grade.
Grade objects are able to have multiple operations on them - including getting the letter grade.
 */

public class Grade {
    private int score;
    private String letterGrade;

    // Getter method to return score.
    public int getScore()
    {
        return score;
    }

    // Constructor - score field is initialized and letterGrade field is initialized by calling the getLetterGrade() method.
    public Grade (int score)
    {
        this.score = score;
        this.letterGrade = getLetterGrade();
    }

    public String getLetterGrade()
    {
        if (score < 0 || score > 100)
        {
            letterGrade = "Unable to get letter grade - score invalid.";
        }
        else if (score < 60) {
            letterGrade = "F";
        } else if (score < 70) {
            letterGrade = "D";
        } else if (score < 77) {
            letterGrade = "C";
        } else if (score < 80) {
            letterGrade = "C+";
        } else if (score < 83) {
            letterGrade = "B-";
        } else if (score < 87) {
            letterGrade = "B";
        } else if (score < 90) {
            letterGrade = "B+";
        } else if (score < 95) {
            letterGrade = "A-";
        } else {
            letterGrade = "A";
        }
        return letterGrade;
    }
}
