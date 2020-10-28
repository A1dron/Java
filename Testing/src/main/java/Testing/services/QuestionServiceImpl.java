package Testing.services;

import Testing.entity.Difficulty;
import Testing.entity.Question;
import Testing.entity.TypeQuestion;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuestionServiceImpl implements QuestionService {

    private List<Question> questions;
    private String pathToFile;
    private ObjectMapper objectMapper = new ObjectMapper();
    private static QuestionService quest;
    static {
        quest = new QuestionServiceImpl();
    }

    public static QuestionService getInstance(){
        return quest;
    }

    public void loadFromJSON(String pathToFile) throws IOException {
        this.pathToFile = pathToFile;
        questions = objectMapper.readValue(new File(pathToFile), new TypeReference<List<Question>>() {
        });
        viewQuestions();
    }

    private QuestionServiceImpl() {

    }

    @Override
    public void addQuestion(Question quest) throws IOException {
        questions.add(quest);
        objectMapper.writeValue(new File(pathToFile), questions);
    }

    @Override
    public void delQuestion(String question) {
        questions.removeIf(i -> i.getQuestion().equals(question));
    }

    @Override
    public void printByQuest(String question) {
        for (Question quest: questions) {
            if (quest.getQuestion().equals(question)){
                System.out.println(quest);
            }
        }
    }

    @Override
    public void viewQuestions() throws IOException {
        for (Question question : questions) {
            System.out.println(question.getQuestion());
        }
    }

    @Override
    public void redactQuestionBase() {
    }
}
