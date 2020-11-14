package Testing.entity;

import org.apache.ibatis.annotations.Many;

import javax.persistence.*;
import java.util.List;

public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "test")
    @SequenceGenerator(name="test", sequenceName = "seq_test")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "questions")
    @ManyToMany(mappedBy = "test")
    private List<Question> questions;

    public Test(String name, List<Question> questions) {
        this.name = name;
        this.questions = questions;
    }


//    public void startTest() {
//        for (Question question : questions) {
//            question.isPassed();
//        }
//    }
}
