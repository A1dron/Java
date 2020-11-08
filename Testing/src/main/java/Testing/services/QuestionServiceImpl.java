package Testing.services;

import Testing.repositories.QuestionRepository;
import Testing.entity.Question;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class QuestionServiceImpl implements QuestionService {

    private String pathToFile;

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private QuestionRepository db;

    public void loadFromJSON(String pathToFile) throws IOException {
//        this.pathToFile = pathToFile;
//        questions = objectMapper.readValue(new File(pathToFile), new TypeReference<List<Question>>() {});
    }

    @Override
    public List<String> getListQuestions() {
        return db.listQuestions();
    }

    @Override
    public Question questionInfo(int id) {
        return db.getQuestion(id);
    }

    @Override
    public void addQuestion(Question quest) throws IOException {
        db.addQuest(quest);
    }

    @Override
    public void delQuestion(String question) {

        db.delQuest(question);
    }


    @Override
    public void updateQuestion(int id, String param, String newValue) {
        db.updateQuest(id, param, newValue);
    }
}
