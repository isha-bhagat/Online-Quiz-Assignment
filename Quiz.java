import java.util.ArrayList;
import java.util.Scanner;

public class Quiz {
    private ArrayList<Question> questions;
    private int score;

    public Quiz() {
        questions = new ArrayList<>();
        score = 0;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        for (Question question : questions) {
            System.out.println(question.getQuestionText());
            String[] options = question.getOptions();
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + ": " + options[i]);
            }
            System.out.print("Your answer: ");
            int answer = getUserInput(scanner, options.length);
            if (question.isCorrectAnswer(answer - 1)) {
                score++;
                System.out.println("Correct!");
            } else {
                System.out.println("Incorrect. The correct answer was: " + options[question.getCorrectAnswerIndex()]);
            }
            System.out.println();
        }
        System.out.println("Your final score is: " + score + "/" + questions.size());
        scanner.close();
    }

    private int getUserInput(Scanner scanner, int numOptions) {
        int input;
        while (true) {
            try {
                input = Integer.parseInt(scanner.nextLine());
                if (input >= 1 && input <= numOptions) {
                    break;
                } else {
                    System.out.print("Please enter a valid option (1-" + numOptions + "): ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number (1-" + numOptions + "): ");
            }
        }
        return input;
    }
}
