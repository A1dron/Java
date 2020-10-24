package Testing.Entity;

public class Test {
    private Question[] questions;

    public Test(Question[] questions) {
        this.questions = questions;
    }


    public void startTest() {
        for (Question question : questions) {
            question.answerIsTrue();
        }
    }
}
