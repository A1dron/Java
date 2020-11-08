package Testing.entity;

import java.util.List;

public class Test {
    private List<Question> questions;

    public Test(List<Question> questions) {
        this.questions = questions;
    }


    public void startTest() {
        for (Question question : questions) {
            question.isPassed();
        }
    }
}
