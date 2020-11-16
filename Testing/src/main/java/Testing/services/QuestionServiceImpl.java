package Testing.services;

import Testing.entity.Question;
import Testing.repositories.QuestionAccessServiceImpl;
import Testing.repositories.QuestionRepository;
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
    private QuestionAccessServiceImpl db;

    public void loadFromJSON(String pathToFile) throws IOException {
//        this.pathToFile = pathToFile;
//        questions = objectMapper.readValue(new File(pathToFile), new TypeReference<List<Question>>() {});
    }

    @Override
    public List<String> getListQuestions() throws Exception {
        List<Question> list = db.viewListQuestions();
        List<String> questions = null;
        for (Question question: list) {
            questions.add(question.getQuestion());
        }
        return questions;
    }

    @Override
    public Question questionInfo(int id) throws Exception {
        return db.getQuestion((long)id);
    }

    @Override
    public Question updateQuestion(Long id, String question, List<String> answer) {
        return db.updateQuestion(id,question,answer);
    }

    @Override
    public void addQuestion(Question quest) throws Exception {
        db.addQuestion(quest);
    }

    @Override
    public void deleteQuestion(int id) throws Exception {

        db.deleteQuestion((long)id);
    }
}
