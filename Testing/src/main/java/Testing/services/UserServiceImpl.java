package Testing.services;

import java.sql.*;

public class UserServiceImpl implements UserService {

    private Connection connection = null;
    private PreparedStatement statement = null;
    private ResultSet result = null;
    private static UserServiceImpl instance;

    private UserServiceImpl() {

    }

    public static UserServiceImpl getInstance() {
        if (instance == null) {
            instance = new UserServiceImpl();
        }
        return instance;
    }

    @Override
    public boolean authorization(String login, String password) {
        try {
            DriverManager.registerDriver(new org.h2.Driver());
            connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
            statement = connection.prepareStatement("select login, password from user where login = ? and password = ?");
            statement.setString(1,login);
            statement.setString(2,password);
            result = statement.executeQuery();
            while (result.next()) {
                if (result.getString("login").equals(login) && result.getString("password").equals(password)) {
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

    @Override
    public void registration(String name, String login, String password) {
        try {
            DriverManager.registerDriver(new org.h2.Driver());
            connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
            statement = connection.prepareStatement("insert into user(login,password,name) values('?, ?, ?)");
            statement.setString(1,login);
            statement.setString(2,password);
            statement.setString(3,name);
            int result = statement.executeUpdate();
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
    }

    @Override
    public void logout() {

    }
}
