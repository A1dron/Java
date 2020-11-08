package Testing.services;

import Testing.repositories.UserRepository;
import Testing.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository db;

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
