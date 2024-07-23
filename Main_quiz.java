public class Main_quiz {
    public static void main(String[] args) {
        Quiz quiz = new Quiz();

        String[] options1 = { "Java", "Python", "C++", "JavaScript" };
        Question q1 = new Question("Which programming language is this quiz written in?", options1, 0);

        String[] options2 = { "1995", "2000", "2010", "1990" };
        Question q2 = new Question("When was Java first released?", options2, 0);

        quiz.addQuestion(q1);
        quiz.addQuestion(q2);

        quiz.start();
    }
}
