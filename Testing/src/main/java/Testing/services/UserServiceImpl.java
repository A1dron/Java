package Testing.services;

import Testing.DataBaseWrapper.DatabaseWrapperUser;
import Testing.user.User;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {


    private static UserServiceImpl instance;
    private DatabaseWrapperUser db = new DatabaseWrapperUser();

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
