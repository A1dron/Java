package Testing.repositories;

import Testing.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.*;

@Component
public class UserRepository {
    @Autowired
    DatabaseWrapper wrapper;

    public boolean isExistUser(User user) {
        Connection connection = wrapper.getConnection();
        PreparedStatement statement = null;
        ResultSet result = null;
        if (connection != null) {
            try {
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
                wrapper.close(result,statement, connection);
            }
        }
        return false;
    }

    public void regUser(User user) {
        Connection connection = wrapper.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement("insert into user(login,password,name) values(?, ?, ?)");
                statement.setString(1, user.getLogin());
                statement.setString(2, user.getPassword());
                statement.setString(3, user.getName());
                int result = statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                wrapper.close(statement, connection);
            }
        }
    }
}
