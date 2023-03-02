package Quiz;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Scanner;

public class QuizMain {


    public static void main (String[] args) throws IOException, ParseException {
        // Prompt user to select an option
        System.out.println("Select 1 for Adding a question\nSelect 2 for taking a quiz.");
        System.out.println("1. Add Quiz\n2. Start Quiz\nYour Option:");

        // Read user's option
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();

        // Execute the selected option
        switch (option) {
            case 1:
                // If user selected option 1, execute the "createQuiz" method from "CreateQuiz" class
                CreateQuiz.createQuiz();
                System.out.println("Thank you for adding a question to our database!");
                break;
            case 2:
                // If user selected option 2, execute the "startQuiz" method from "StartQuiz" class
                StartQuiz.startQuiz();
                System.out.println("Thank you for taking the quiz!");
                break;
            default:
                // If user entered an invalid option, display an error message
                System.out.println("Invalid Option");
        }

        // Close the scanner
        sc.close();
    }
}



