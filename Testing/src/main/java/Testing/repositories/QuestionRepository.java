package Testing.repositories;

import Testing.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class QuestionRepository {

    @Autowired
    DatabaseWrapper wrapper;

    public void addQuest(Question question) {
        Connection connection = wrapper.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement("insert into question(question," +
                        "type_question,author, difficulty, answer) values(?, ?, ?, ?, ?)");
                statement.setString(1, question.getQuestion());
                statement.setString(2, question.getTypeQuestion());
                statement.setString(3, question.getAuthor());
                statement.setString(4, question.getDifficulty());
                statement.setString(5, question.getAnswer());
                int result = statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                wrapper.close(statement, connection);
            }
        }
    }

    public void delQuest(String question) {
        Connection connection = wrapper.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement("delete from question where question = ?");
                statement.setString(1, question);
                int result = statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                wrapper.close(statement, connection);
            }
        }
    }

    public Question getQuestion(int id) {
        Question quest = new Question();
        Connection connection = wrapper.getConnection();
        PreparedStatement statement = null;
        ResultSet result = null;
        if (connection != null) {
            try {
                String typeQuestion, author, difficulty, answer, question;
                statement = connection.prepareStatement("select * from question where id = ?");
                statement.setInt(1, id);
                result = statement.executeQuery();
                while (result.next()) {
                    question = result.getString("QUESTION");
                    typeQuestion = result.getString("TYPE_QUESTION");
                    author = result.getString("AUTHOR");
                    difficulty = result.getString("DIFFICULTY");
                    answer = result.getString("ANSWER");
                    quest = new Question(question, typeQuestion, author, difficulty, answer);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                wrapper.close(result, statement, connection);
            }
            return quest;
        }
        return null;
    }

    public List<String> listQuestions() {
        List<String> questions = new ArrayList<String>();
        Connection connection = wrapper.getConnection();
        PreparedStatement statement = null;
        ResultSet result = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement("select question from questions.json");
                result = statement.executeQuery();

                while (result.next()) {
                    String quest = result.getString("question");
                    questions.add(quest);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                wrapper.close(result, statement, connection);
            }
            return questions;
        }
        return null;
    }

    public void updateQuest(int id, String param, String newValue) {
        Connection connection = wrapper.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement("update QUESTION set ? = ? where question = ?");
                statement.setString(1, param);
                statement.setString(2, newValue);
                statement.setInt(3, id);
                int result = statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                wrapper.close(statement, connection);
            }
        }
    }
}
