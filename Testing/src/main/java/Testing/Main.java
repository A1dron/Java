package Testing;

import Testing.entity.Difficulty;
import Testing.entity.Question;
import Testing.entity.TypeQuestion;
import Testing.services.QuestionService;
import Testing.services.QuestionServiceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final QuestionService questionService = QuestionServiceImpl.getInstance();

    public static void main(String[] args) throws IOException {
        questionService.loadFromJSON("src/main/java/Testing/questions");
    }
}
