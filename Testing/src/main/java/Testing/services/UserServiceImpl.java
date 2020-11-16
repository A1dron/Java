package Testing.services;

import Testing.repositories.UserAccessServiceImpl;
import Testing.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserAccessServiceImpl userAccessService;

    @Override
    public boolean authorization(User user) {
        if (userAccessService.authorizationUser(user)) {
            return true;
        }
        return false;
    }

    @Override
    public User registration(User user) {
        return userAccessService.registrationUser(user);
    }

    @Override
    public void logout() {

    }
}
