package Testing.repositories;

import Testing.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;

public class QuestionAccessServiceImpl {
    @Autowired
    QuestionRepository repository;

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


    public void updateQuestion(int id, String param, String newValue) throws Exception {

    }
}
