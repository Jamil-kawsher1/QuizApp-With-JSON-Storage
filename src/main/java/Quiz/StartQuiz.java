package Quiz;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class StartQuiz {
    public static void startQuiz () throws IOException, ParseException {
        System.out.println("Welcome to the Quiz App!");
        int NUM_QUESTIONS = 5;
        int MARKS_PER_QUESTION = 1;
        // Print instructions to the user
        System.out.println("\nYou will be asked " + NUM_QUESTIONS + " questions, each worth " + MARKS_PER_QUESTION + " mark.");
        System.out.println("To answer a question, enter the letter corresponding to the correct option.");
        System.out.println("Let's get started!\n");

        // Load the quiz questions from a JSON file
        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader("./src/main/resources/Questions.json"));

        // Initialize the user's score
        int score = 0;

        // Ask each question
        for (int i = 0; i < NUM_QUESTIONS; i++) {
            Scanner scanner = new Scanner(System.in);

            // Choose a random question from the list
            int min = 0;
            int max = jsonArray.size();
            int randomIndex = (int) (Math.random() * (max - min) + min);
            JSONObject questionObj = (JSONObject) jsonArray.get(randomIndex);

            // Extract the question data from the JSON object
            String question = (String) questionObj.get("Question");
            String optionA = (String) questionObj.get("Option a");
            String optionB = (String) questionObj.get("Option b");
            String optionC = (String) questionObj.get("Option c");
            String optionD = (String) questionObj.get("Option d");
            String answer = (String) questionObj.get("Answer");

            // Print the question and options
            System.out.println((i + 1) + ". " + question);
            System.out.println("a. " + optionA);
            System.out.println("b. " + optionB);
            System.out.println("c. " + optionC);
            System.out.println("d. " + optionD);

            // Prompt the user for their answer
            System.out.println("\nEnter your answer (a/b/c/d):");
            String userAnswer = scanner.nextLine().trim().toLowerCase();

            // Check the user's answer and update their score
            if (userAnswer.equals(answer.toLowerCase())) {
                System.out.println("Correct!");
                score += MARKS_PER_QUESTION;
            } else {
                System.out.println("Incorrect. The correct answer was: " + answer);
            }
        }

        // Print the user's final score
        System.out.println("\nYour final score is: " + score + "/" + (NUM_QUESTIONS * MARKS_PER_QUESTION));
    }

}
