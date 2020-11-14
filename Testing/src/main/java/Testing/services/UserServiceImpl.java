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
    public boolean authorization(User user) throws Exception {
        if (userAccessService.authorizationUser(user)) {
            return true;
        }
        return false;
    }

    @Override
    public void registration(User user) throws Exception {
        userAccessService.registrationUser(user);
    }

    @Override
    public void logout() {

    }
}
