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

    public TypeQuestion getTypeQuestion() {
        return typeQuestion;
    }

    public void setTypeQuestion(TypeQuestion typeQuestion) {
        this.typeQuestion = typeQuestion;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public List<String> getAnswer() {
        return answer;
    }

    public void setAnswer(List<String> answer) {
        this.answer = answer;
    }

    public boolean isPassed() {
        return isPassed;
    }

    public void setPassed(boolean passed) {
        isPassed = passed;
    }

    private String question;
    private TypeQuestion typeQuestion;
    private String author;
    private Difficulty difficulty;
    private List<String> answer;
    private boolean isPassed;

    public Question(String question, TypeQuestion typeQuestion, String author, Difficulty difficulty, List<String> answer){
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
