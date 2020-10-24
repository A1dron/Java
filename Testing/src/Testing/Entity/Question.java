package Testing.Entity;

import Testing.Types.Difficulty;
import Testing.Types.TypeQuestion;

public class Question {

    private String Question;
    private TypeQuestion typeQuestion;
    private String author;
    private Difficulty difficulty;
    private String[] answer;
    private boolean isPassed;

    public Question(String Question, TypeQuestion typeQuestion, String author, Difficulty difficulty, String[] answer){
        this.Question = Question;
        this.typeQuestion = typeQuestion;
        this.author = author;
        this.difficulty = difficulty;
        this.answer = answer;
    }

    public boolean answerIsTrue(){
        return true;
    }
}
