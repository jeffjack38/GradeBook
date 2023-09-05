/**
 * @author jackaden - jacka

 * CIS175 - Fall 2023
 * 8/31/2023
 */
import java.util.ArrayList;
import java.util.Scanner;

class GradeBook {
    private String testName;
    private ArrayList<Integer> scores;
    private ArrayList<String> letterGrades;

    // Default constructor
    public GradeBook() {
        testName = "";
        scores = new ArrayList<>();
        letterGrades = new ArrayList<>();
    }

    // Parameterized constructor
    public GradeBook(String testName, ArrayList<Integer> scores) {
        this.testName = testName;
        this.scores = scores;
        letterGrades = new ArrayList<>();
        setLetterGrades();
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public ArrayList<Integer> getScores() {
        return scores;
    }

    public void setScores(ArrayList<Integer> scores) {
        this.scores = scores;
    }

    public ArrayList<String> getLetterGrades() {
        return letterGrades;
    }

    public void setLetterGrades() {
        for (int score : scores) {
            if (score >= 90) {
                letterGrades.add("A");
            } else if (score >= 80) {
                letterGrades.add("B");
            } else if (score >= 70) {
                letterGrades.add("C");
            } else if (score >= 60) {
                letterGrades.add("D");
            } else {
                letterGrades.add("F");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // prompt for test name
        System.out.print("Enter a test name: ");
        String testName = scanner.next();
        // prompt for number of scores
        System.out.print("How many scores would you like to enter? ");
        int numScores = scanner.nextInt();
        //create an arraylist to hold the scores
        ArrayList<Integer> scores = new ArrayList<>();
        // iterate to enter a score until reached number of scores from user input
        for (int i = 0; i < numScores; i++) {
        	// prompt user for the scores to hold in arraylist
            System.out.print("Enter a score: ");
            scores.add(scanner.nextInt());
        }
        // call GradeBook object
        GradeBook gradeBook = new GradeBook(testName, scores);
        // create variable that will get letter grade values from GradeBook
        ArrayList<String> letterGrades = gradeBook.getLetterGrades();
        // print score and letter grade
        System.out.println("Score -------- Grade");
        for (int i = 0; i < numScores; i++) {
            System.out.println(scores.get(i) + " -------- " + letterGrades.get(i));
        }
    }
}