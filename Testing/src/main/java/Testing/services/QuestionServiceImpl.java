package Testing.services;

import Testing.entity.Question;
import Testing.repositories.QuestionAccessServiceImpl;
import Testing.repositories.QuestionRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class QuestionServiceImpl implements QuestionService {

    private String pathToFile;

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private QuestionAccessServiceImpl db;

    public void loadFromJSON(String pathToFile){
//        this.pathToFile = pathToFile;
//        questions = objectMapper.readValue(new File(pathToFile), new TypeReference<List<Question>>() {});
    }

    @Override
    public List<String> getListQuestions(){
        return db.viewListQuestions().stream().map(Question::getQuestion).collect(Collectors.toList());
    }

    @Override
    public Question questionInfo(int id) {
        return db.getQuestion((long)id);
    }

    @Override
    public Question updateQuestion(Long id, String question, List<String> answer) {
        return db.updateQuestion(id,question,answer);
    }

    @Override
    public Question addQuestion(Question quest) {
        db.addQuestion(quest);
        return quest;
    }

    @Override
    public void deleteQuestion(int id){
        db.deleteQuestion((long)id);
    }
}
