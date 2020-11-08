package Testing.services;

import Testing.entity.Question;

import java.io.IOException;
import java.util.List;

public interface QuestionService {

    void addQuestion(Question quest) throws IOException;

    void delQuestion(String question);

    void loadFromJSON(String pathToFile) throws IOException;

    List<String> getListQuestions();

    Question questionInfo(int id);

    void updateQuestion(int id, String param, String newValue);
}
