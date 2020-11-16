package Testing.services;

import Testing.entity.Question;

import java.io.IOException;
import java.util.List;

public interface QuestionService {

    Question addQuestion(Question quest);

    void deleteQuestion(int id);

    void loadFromJSON(String pathToFile);

    List<String> getListQuestions();

    Question questionInfo(int id);

    Question updateQuestion(Long id, String question, List<String> answer);
}
