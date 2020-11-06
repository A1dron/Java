package Testing.entity;

import Testing.user.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseWrapper {
    private Connection connection = null;
    private PreparedStatement statement = null;
    private ResultSet result = null;

    public DatabaseWrapper() {
        try {
            DriverManager.registerDriver(new org.h2.Driver());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public boolean isExistUser(User user) {
        try {
            connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
            statement = connection.prepareStatement("select login, password from user where login = ? and password = ?");
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            result = statement.executeQuery();
            while (result.next()) {
                if (result.getString("login").equals(user.getLogin()) && result.getString("password").equals(user.getPassword())) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (result != null) result.close();
            } catch (Exception e) {
            }
            try {
                if (statement != null) statement.close();
            } catch (Exception e) {
            }
            try {
                if (connection != null) connection.close();
            } catch (Exception e) {
            }
        }
        return false;
    }


    public void regUser(User user) {
        try {
            //DriverManager.registerDriver(new org.h2.Driver());
            connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
            statement = connection.prepareStatement("insert into user(login,password,name) values(?, ?, ?)");
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getName());
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

    public void addQuest(Question question) {
        try {
            //DriverManager.registerDriver(new org.h2.Driver());
            connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
            statement = connection.prepareStatement("insert into question(question,type_question,author, difficulty, answer) values(?, ?, ?, ?, ?)");
            statement.setString(1, question.getQuestion());
            statement.setString(2, question.getTypeQuestion().toString());
            statement.setString(3, question.getAuthor());
            statement.setString(4, question.getDifficulty().toString());
            statement.setString(5, question.getAnswer().toString());
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

    public void delQuest(String question) {
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

    public Question getQuestion(String question) {
        Question quest= new Question();
        try {
            String typeQuestion, author, difficulty, answer;
            connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
            statement = connection.prepareStatement("select * from question where question = ?");
            statement.setString(1, question);
            result = statement.executeQuery();
            while (result.next()) {
                typeQuestion = result.getString("TYPE_QUESTION");
                author = result.getString("AUTHOR");
                difficulty = result.getString("DIFFICULTY");
                answer = result.getString("ANSWER");
                quest = new Question(question, typeQuestion, author, difficulty, answer);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (result != null) result.close();
            } catch (Exception e) {
            }
            try {
                if (statement != null) statement.close();
            } catch (Exception e) {
            }
            try {
                if (connection != null) connection.close();
            } catch (Exception e) {
            }
        }
        return quest;
    }

    public List<String> listQuestions() {
        List<String> questions = new ArrayList<String>();
        try {
            connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
            statement = connection.prepareStatement("select question from questions");
            result = statement.executeQuery();

            while (result.next()) {
                String quest = result.getString("question");
                questions.add(quest);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (result != null) result.close();
            } catch (Exception e) {
            }
            try {
                if (statement != null) statement.close();
            } catch (Exception e) {
            }
            try {
                if (connection != null) connection.close();
            } catch (Exception e) {
            }
        }
        return questions;
    }

    public void updateQuest(String question, String param, String newValue) {
        try {
            DriverManager.registerDriver(new org.h2.Driver());
            connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
            statement = connection.prepareStatement("update QUESTION set ? = ? where question = ?");
            statement.setString(1, param);
            statement.setString(2, newValue);
            statement.setString(3, question);
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

}
