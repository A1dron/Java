package Testing.services;

import Testing.entity.Question;

import java.io.IOException;
import java.util.List;

public interface QuestionService {

    void addQuestion(Question quest) throws IOException;

    void delQuestion(String question);

    void printByQuest(String question);

    void loadFromJSON(String pathToFile) throws IOException;

    void viewQuestions() throws IOException;

    void redactQuestion(String question, String param, String newValue);
}
