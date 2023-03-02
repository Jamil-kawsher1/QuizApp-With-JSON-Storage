package Quiz;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CreateQuiz {
    public static void createQuiz() throws IOException, ParseException {
        try {
            // Initialize variables
            char choiceInput = 'y';
            Scanner scanner = new Scanner(System.in);
            JSONParser jsonParser = new JSONParser();

            do {
                // Read in the existing JSON array from the file
                JSONArray quizList = (JSONArray) jsonParser.parse(new FileReader("./src/main/resources/Questions.json"));

                // Create a new JSON object for the new quiz
                JSONObject newQuiz = new JSONObject();

                // Prompt the user for input and add the quiz information to the new JSON object
                System.out.println("Please add a question:");
                System.out.println("Question:");
                newQuiz.put("Question", scanner.nextLine());
                System.out.println("Input options:");
                System.out.println("Option a:");
                newQuiz.put("Option a", scanner.nextLine());
                System.out.println("Option b:");
                newQuiz.put("Option b", scanner.nextLine());
                System.out.println("Option c:");
                newQuiz.put("Option c", scanner.nextLine());
                System.out.println("Option d:");
                newQuiz.put("Option d", scanner.nextLine());
                System.out.println("Please input the correct answer:");
                newQuiz.put("Answer", scanner.nextLine());

                // Add the new JSON object to the existing JSON array
                quizList.add(newQuiz);

                // Write the updated JSON array back to the file
                FileWriter fileWriter = new FileWriter("./src/main/resources/Questions.json");
                fileWriter.write(quizList.toJSONString());
                fileWriter.flush();

                // Prompt the user for more input
                System.out.println("Quiz saved at the database. Do you want to add more? (y/n)");
                choiceInput = scanner.next().charAt(0);
                scanner.nextLine(); // consume the newline character
            }
            while (choiceInput == 'y');

            scanner.close(); // close the scanner
        }
        catch (IOException | ParseException e){
            System.out.println("An exception occurred: " + e.getMessage());
        }
    }
}
