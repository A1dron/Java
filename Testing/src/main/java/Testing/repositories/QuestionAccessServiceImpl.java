package Testing.repositories;

import Testing.entity.Question;
import org.apache.ibatis.annotations.Case;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collections;
import java.util.List;

public class QuestionAccessServiceImpl {
    @Autowired
    QuestionRepository repository;
    @PersistenceContext
    private EntityManager em;

    public void addQuestion(Question question){
        repository.save(question);
    }

    public void deleteQuestion(Long id){
        repository.delete(id);
    }

    public Question getQuestion(Long id) throws Exception {
        List<Question> questions = (List<Question>)repository.findAllById(Collections.singleton(id));
        for (Question question: questions) {
            return question;
        }
        throw new Exception("No the question");
    }

    public List<Question> viewListQuestions(){
        List<Question> questions = (List<Question>)repository.findAll();
        return questions;
    }

    public Question updateQuestion(Long id, String question, List<String> answer){
        Question updateQuestion = em.find(Question.class, id);
        updateQuestion.setQuestion(question);
        updateQuestion.setAnswer(answer);
        return updateQuestion;
    }
}
