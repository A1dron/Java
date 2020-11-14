package Testing.services;

import Testing.entity.Question;

import java.io.IOException;
import java.util.List;

public interface QuestionService {

    void addQuestion(Question quest) throws Exception;

    void deleteQuestion(int id) throws Exception;

    void loadFromJSON(String pathToFile) throws IOException;

    List<String> getListQuestions() throws Exception;

    Question questionInfo(int id) throws Exception;

    void updateQuestion(int id, String param, String newValue) throws Exception;
}
