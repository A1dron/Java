package Testing.entity;

import Testing.enums.Difficulty;
import Testing.enums.TypeQuestion;

import javax.persistence.*;
import java.util.List;

@Entity
public class Question {

    public Question() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "questions")
    @SequenceGenerator(name="questions", sequenceName = "seq_questions")
    private Long id;

    @Column(name = "question")
    private String question;
    @Enumerated(EnumType.STRING)
    private TypeQuestion typeQuestion;
    @ManyToOne
    @Column(name = "author")
    private String author;
    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;
    @Column(name = "answer")
    private List<String> answer;
    //private boolean isPassed;


    @ManyToMany
    @JoinTable(name ="test_to_question",
    joinColumns = {
            @JoinColumn(name = "questId")},
    inverseJoinColumns = {
            @JoinColumn (name = "testId")})
    private List<Test> test;

    public Question(String question, TypeQuestion typeQuestion, String author, Difficulty difficulty, List<String> answer){
        this.question = question;
        this.typeQuestion = typeQuestion;
        this.author = author;
        this.difficulty = difficulty;
        this.answer = answer;
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

//    public boolean isPassed() {
//        return isPassed;
//    }

//    public void setPassed(boolean passed) {
//        isPassed = passed;
//    }


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

}
