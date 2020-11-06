package Testing.entity;

import java.util.List;

public class Question {

    public Question() {
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getTypeQuestion() {
        return typeQuestion;
    }

    public void setTypeQuestion(String typeQuestion) {
        this.typeQuestion = typeQuestion;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isPassed() {
        return isPassed;
    }

    public void setPassed(boolean passed) {
        isPassed = passed;
    }

    private String question;
    private String typeQuestion;
    private String author;
    private String difficulty;
    private String answer;
    private boolean isPassed;

    public Question(String question, String typeQuestion, String author, String difficulty, String answer){
        this.question = question;
        this.typeQuestion = typeQuestion;
        this.author = author;
        this.difficulty = difficulty;
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Question{" +
                "question='" + question + '\'' +
                ", typeQuestion=" + typeQuestion +
                ", author='" + author + '\'' +
                ", difficulty=" + difficulty +
                ", answer=" + answer +
                '}';
    }

    public boolean answerIsTrue(){
        return true;
    }
}
