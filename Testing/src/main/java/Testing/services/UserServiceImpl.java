package Testing.services;

import Testing.entity.DatabaseWrapper;
import Testing.user.User;
import org.springframework.stereotype.Component;

import java.sql.*;
@Component
public class UserServiceImpl implements UserService {


    private static UserServiceImpl instance;
    private DatabaseWrapper db = new DatabaseWrapper();

    private UserServiceImpl() {

    }

    public static UserServiceImpl getInstance() {
        if (instance == null) {
            instance = new UserServiceImpl();
        }
        return instance;
    }

    @Override
    public boolean authorization(User user) {

        if (db.isExistUser(user)) {
            return true;
        }

        return false;
    }

    @Override
    public void registration(User user) {
        db.regUser(user);
    }

    @Override
    public void logout() {

    }
}
