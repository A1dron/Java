package Testing.services;

import Testing.entity.Question;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.List;

public class QuestionServiceImpl implements QuestionService {

    private Connection connection = null;
    private PreparedStatement statement = null;
    private ResultSet result = null;
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
        try {
            DriverManager.registerDriver(new org.h2.Driver());
            connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
            statement = connection.prepareStatement("insert into question(question,type_question,author, difficulty, answer) values(?, ?, ?, ?, ?)");
            statement.setString(1, quest.getQuestion());
            statement.setString(2, quest.getTypeQuestion().toString());
            statement.setString(3, quest.getAuthor());
            statement.setString(4, quest.getDifficulty().toString());
            statement.setString(5, quest.getAnswer().toString());
            int result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) statement.close();
            } catch (Exception e) {
            }
            try {
                if (connection != null) connection.close();
            } catch (Exception e) {
            }
        }
    }

    @Override
    public void delQuestion(String question) {

        questions.removeIf(i -> i.getQuestion().equals(question));
        try {
            DriverManager.registerDriver(new org.h2.Driver());
            connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
            statement = connection.prepareStatement("delete from question where question = ?");
            statement.setString(1, question);
            int result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) statement.close();
            } catch (Exception e) {
            }
            try {
                if (connection != null) connection.close();
            } catch (Exception e) {
            }
        }
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
